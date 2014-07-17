package comparator.action;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import org.junit.Test;

public class AnalyseDifferentResultLineTest {
	
	@Test
	public void testMain() throws IOException, ClassNotFoundException, URISyntaxException{
		PublicKey.SEPARATOR_CHAR.setProperties(",");
		PublicKey.BANKING_BOOK_OUTPUT.setProperties(PublicKey.OUTPUT_PATH.getenv());
		PublicKey.TRADING_BOOK_OUTPUT.setProperties(PublicKey.OUTPUT_PATH.getenv());
		URL url = Thread.currentThread().getContextClassLoader().getResource("comparator/action/different.dat");
		File file = new File(url.toURI());
	    AnalyseDifferentResult.main(new String[]{file.getCanonicalPath(), "different", "classpath:comparator/analyse/analyseDifferentResultLineVisitor.xml"});
	}
}
