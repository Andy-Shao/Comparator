package comparator.action;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:init.xml")
public class InitActionTest {
	
	@BeforeClass
	public static void beforeClass(){
		PublicKey.BANKING_BOOK_OUTPUT.setProperties(PublicKey.OUTPUT_PATH.getenv());
		PublicKey.TRADING_BOOK_OUTPUT.setProperties(PublicKey.OUTPUT_PATH.getenv());
	}

	@Test
	public void test(){}
}
