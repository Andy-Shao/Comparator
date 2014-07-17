package database.load;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowCallbackHandler;

import andy.shao.util.ArrayTools;
import andy.shao.util.StringTools;

import database.sql.SqlProcess;
import database.struct.Column;
import database.struct.Table;
import database.struct.TableFactory;

public class LoadData {
	private static final Log LOG = LogFactory.getLog(LoadData.class);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		LOG.info("Load data is starting.");
		LOG.info("input file is " + args[0]);
		LOG.info("output file is " + args[1]);
		LOG.info("xml config is " + args[2]);
		String[] contextPathes = new String[] { "classpath:jdbc/config/jdbcTemplate.xml", "classpath:init.xml", "classpath:database/load/ExchangeData.xml" };
		contextPathes = ArrayTools.mergeArray(String[].class, contextPathes, StringTools.split(args[2], "#"));
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(contextPathes);
		JdbcOperations jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcOperations.class);
		final ExchangeData<String> loadData = applicationContext.getBean("loadData", ExchangeData.class);
		TableFactory<Table<Column>, InputStream> tableFactory = applicationContext.getBean("tableFactory", TableFactory.class);
		SqlProcess sqlProcess = applicationContext.getBean("SqlProcess", SqlProcess.class);

		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(args[0]);
			outputStream = new FileOutputStream(args[1]);

			final Table<Column> table = tableFactory.buildTable(inputStream);
			inputStream.close();
			inputStream = new FileInputStream(args[0]);
			String sql = sqlProcess.process(readSql(inputStream));

			final PrintWriter printWriter = new PrintWriter(outputStream);
			try {
				jdbcTemplate.query(sql, new RowCallbackHandler() {
					@Override
					public void processRow(ResultSet rs) throws SQLException {
						printWriter.println(loadData.loader(table, rs));
					}
				});
			} finally {
				if (printWriter != null) printWriter.close();
			}
		} finally {
			if (inputStream != null) inputStream.close();
			if (outputStream != null) outputStream.close();
		}
		LOG.info("Load data is finished.");
	}

	static String readSql(InputStream inputStream) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		try {
			// build table
			for (String line; (line = reader.readLine()) != null;) {
				line = line.trim();
				if (line.length() == 0) continue;
				if (line.equalsIgnoreCase("##END!!")) break;
			}

			// build sql
			StringBuilder sql = new StringBuilder();
			for (String line; (line = reader.readLine()) != null;) {
				line = line.trim();
				if (line.length() == 0) continue;
				if (line.equalsIgnoreCase("##END!!")) break;

				sql.append(line).append("\n");
			}
			return sql.toString();
		} finally {
			reader.close();
		}
	}
}
