package database.load;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import database.struct.OracleTableFactory;

public class LoadDataFromOracleTest {

	@Test
	public void getInfos() throws IOException{
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("database/load/TRNX_DERIV_Attribute.sql");
		Object[] objects = null;
		try{
			objects = OracleTableFactory.getInfos(inputStream);
		} finally{
			inputStream.close();
		}
		
		for(Object obj : objects)
			System.out.println(obj);
	}
}
