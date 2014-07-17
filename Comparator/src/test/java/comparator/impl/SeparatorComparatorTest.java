package comparator.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import comparator.Md5LineMessage;
import comparator.action.PublicKey;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:init.xml", "classpath:comparator/impl/separatorComparator.xml" })
public class SeparatorComparatorTest {
	
	@Autowired
	@Qualifier("comparator")
	private SeparatorComparator separatorComparator;
	private static final String MESSAGE_ONE = "GB|24474|43166965001||1625||1000242191|USD|||||1000101733|24474||5059068688||EUR|2017-06-20 00:00:00-000||2||0|0.000000|||||0.000000|975RETAL|||2017-06-20 00:00:00-000||2013-12-20 00:00:00-000|1000415|0.000000|2014-01-10 00:00:00-000|036|0369||||||5059068688||0.000000|0.000000|1000415|0||0|||64788K9A9|||0.000000|0.000000|||1177600|1177604|||||||0.000000||CREC3497168|N||0||0.000000|METFNL|20267|SNG||N|N||2014-09-22 00:00:00-000|TRD||IC||||0.000000|||||ICEECNAL|F|||||0.000000|||0.000000||||||0.000000|||N|0.000000|0.000000|975|PURVIS (CDS)|0.000000|0.000000|||0.000000|IntlFixedInc|N|DI8CFE|0.400000|1||||150699:14973350C|36";
	private static final String MESSAGE_TWO = "GB|24474|12203800300||1625|B|1000242191|USD|||||1000035889|24474||3652286000||USD|2014-12-20 00:00:00-000||2||0|0.000000|||||0.000000|CDSIND|||2014-12-20 00:00:00-000||2010-06-21 00:00:00-000|1000415|0.000000|2010-07-21 00:00:00-000|036|0369||||||3652286000||0.000000|0.000000|1000415|0||0|VALEO|27679|9189949E6|||0.000000|0.000000|USD||9552400|9552409|||||||0.000000||C97H13044|N||0||0.000000|VLOF|27679|SNG|27679|N|C||2014-09-22 00:00:00-000|TRD||TP||||0.000000|||||STC4226|C|||||0.000000|||0.000000||||||0.000000|||N|0.000000|0.000000|97I|NICOLAE (CDS)|0.000000|0.000000|||0.000000|LFIA|N|9AAA47|0.400000|1||||150699:2440376CGTC|36";
	
	@BeforeClass
	public static void beforeClass(){
		PublicKey.BANKING_BOOK_OUTPUT.setProperties(PublicKey.OUTPUT_PATH.getenv());
		PublicKey.TRADING_BOOK_OUTPUT.setProperties(PublicKey.OUTPUT_PATH.getenv());
	}

	@Test
	public void comparator() {
		this.separatorComparator.compare(new Md5LineMessage(MESSAGE_ONE), new Md5LineMessage(MESSAGE_TWO));
	}
}
