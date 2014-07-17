package database.load;

import org.junit.Ignore;
import org.junit.Test;

public class BatchLoadDataTest {

	@Ignore
	@Test
	public void loadTest() throws Exception{
		BatchLoadData.main(new String[]{"classpath:database/load/BatchLoadDataTest.xml#classpath:datasource/oracleDataSource.xml#classpath:database/struct/OracleTableFactory.xml#classpath:database/sql/sqlProcess.xml"});
	}
}
