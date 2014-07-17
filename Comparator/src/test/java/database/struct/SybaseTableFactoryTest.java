package database.struct;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class SybaseTableFactoryTest {

	@Test
	public void buildTable() throws IOException{
		InputStream inputStream = null;
		try{
			inputStream = new FileInputStream("input/trade_book/eur_transactions.tab");
			SybaseTableFactory sybaseTableFactory = new SybaseTableFactory();
			sybaseTableFactory.buildTable(inputStream);
		} finally{
			if(inputStream != null) inputStream.close();
		}
	}
}
