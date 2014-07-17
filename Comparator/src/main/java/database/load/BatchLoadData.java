package database.load;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowCallbackHandler;

import database.sql.SqlProcess;
import database.struct.Column;
import database.struct.Table;
import database.struct.TableFactory;

import andy.shao.util.ArrayTools;
import andy.shao.util.StringTools;

public class BatchLoadData {
	private static final Log LOG = LogFactory.getLog(BatchLoadData.class);

	@SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
		LOG.info("Load datas is starting.");
		LOG.info("xml config is " + args[0]);
		String[] contextPathes = new String[] { "classpath:jdbc/config/jdbcTemplate.xml", "classpath:init.xml", "classpath:database/load/ExchangeData.xml" };
		contextPathes = ArrayTools.mergeArray(String[].class, contextPathes, StringTools.split(args[0], "#"));
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(contextPathes);
		JdbcOperations jdbcTemplate = applicationContext.getBean("jdbcTemplate", JdbcOperations.class);
		final ExchangeData<String> loadData = applicationContext.getBean("loadData", ExchangeData.class);
		TableFactory<Table<Column>, InputStream> tableFactory = applicationContext.getBean("tableFactory", TableFactory.class);
		SqlProcess sqlProcess = applicationContext.getBean("SqlProcess", SqlProcess.class);
		Map<String, String> filePathes = applicationContext.getBean("filePathes", Map.class);
		
		for(Map.Entry<String, String> entry : filePathes.entrySet()){
			LOG.info("start load data.");
			String inputFilePath = entry.getKey();
			String outputFilePath = entry.getValue();
			LOG.info("input file is " + inputFilePath);
			LOG.info("output file is " + outputFilePath);
			
			InputStream inputStream = null;
			OutputStream outputStream = null;
			try {
				inputStream = new FileInputStream(inputFilePath);
				outputStream = new FileOutputStream(outputFilePath);

				final Table<Column> table = tableFactory.buildTable(inputStream);
				inputStream.close();
				inputStream = new FileInputStream(inputFilePath);
				String sql = sqlProcess.process(LoadData.readSql(inputStream));

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
			LOG.info("finish load data.");
		}
		LOG.info("Load datas is finished.");
    }
}
