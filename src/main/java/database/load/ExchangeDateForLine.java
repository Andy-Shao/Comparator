package database.load;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.struct.Column;
import database.struct.Columns;
import database.struct.Table;

public class ExchangeDateForLine implements ExchangeData<String> {
	private volatile String separator = "|";

	@Override
	public String loader(Table<? extends Column> table, ResultSet rs) throws SQLException {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < table.size(); i++) {
			result.append(Columns.getColumnValue(table.column(i), rs)).append(separator);
		}
		result.delete(result.length() - this.separator.length(), result.length());
		return result.toString();
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}
}
