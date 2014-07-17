package database.struct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SybaseTableFactory implements TableFactory<SybaseTable, InputStream> {

	public static Object[] getInfos(InputStream inputStream) throws IOException {
		final Object[] result = new Object[2];
		final Table<SybaseColumn> table = new SybaseTable();
		result[0] = table;
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		// build table
		for (String line; (line = reader.readLine()) != null;) {
			line = line.trim();
			if (line.length() == 0) continue;
			if (line.equalsIgnoreCase("##END!!")) break;

			String args[] = line.split(",");
			SybaseColumn column = new SybaseColumn();
			column.setLocation(Integer.valueOf(args[0]));
			column.setName(args[1]);
			if (args[2].indexOf("(") != -1) column.setTypeByStr(args[2].substring(0, args[2].indexOf("(")));
			else column.setTypeByStr(args[2]);
			table.addColumn(column);
		}

		// build sql
		StringBuilder sql = new StringBuilder();
		for (String line; (line = reader.readLine()) != null;) {
			line = line.trim();
			if (line.length() == 0) continue;
			if (line.equalsIgnoreCase("##END!!")) break;

			sql.append(line).append("\n");
		}
		result[1] = sql.toString();
		return result;
	}

	/**
	 * NOTE: The {@link InputStream} only can use by one time.
	 * 
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	@Override
	public SybaseTable buildTable(InputStream input) throws NumberFormatException, IOException {
		final SybaseTable table = new SybaseTable();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		try {
			// build table
			for (String line; (line = reader.readLine()) != null;) {
				line = line.trim();
				if (line.length() == 0) continue;
				if (line.equalsIgnoreCase("##END!!")) break;

				String args[] = line.split(",");
				SybaseColumn column = new SybaseColumn();
				column.setLocation(Integer.valueOf(args[0]));
				column.setName(args[1]);
				if (args[2].indexOf("(") != -1) column.setTypeByStr(args[2].substring(0, args[2].indexOf("(")));
				else column.setTypeByStr(args[2]);
				table.addColumn(column);
			}
		} finally {
			reader.close();
		}

		return table;
	}

}
