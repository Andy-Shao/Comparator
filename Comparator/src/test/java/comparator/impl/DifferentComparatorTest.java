package comparator.impl;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import comparator.DifferentResult;
import comparator.Md5LineMessage;
import comparator.MessageComparator;
import comparator.action.DifferentComparator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:comparator/impl/differentComparatorTest.xml")
public class DifferentComparatorTest {

	@Autowired
	@Qualifier("messageComparator")
	private MessageComparator<DifferentResult<Md5LineMessage>, Iterator<Md5LineMessage>, Iterator<Md5LineMessage>> messageComparator;
	
	@Autowired
	@Qualifier("readerFileA")
	private Iterator<Md5LineMessage> iteratorA;
	
	@Autowired
	@Qualifier("readerFileB")
	private Iterator<Md5LineMessage> iteratorB;
	
	@Test
	public void test() throws IOException {
		DifferentResult<Md5LineMessage> differentResult = this.messageComparator.compare(this.iteratorA, this.iteratorB);
		
		System.out.println("onlyFileAHas size: " + differentResult.onlyFileAHas().size());
		System.out.println("onlyFileBHas Size: " + differentResult.onlyFileBHas().size());
		System.out.println("different size: " + differentResult.differences().size());
		
		DifferentComparator.wirteObject(differentResult.onlyFileAHas(), "onlyFileAHas.dat");
		DifferentComparator.wirteObject(differentResult.onlyFileBHas(), "onlyFileBHas.dat");
		DifferentComparator.wirteObject(differentResult.differences(), "different.dat");
		new File("onlyFileAHas.dat").deleteOnExit();
		new File("onlyFileBHas.dat").deleteOnExit();
		new File("different.dat").deleteOnExit(); 
		
//		{
//			PrintWriter printWriter = new PrintWriter("onlyFileAHas.log");
//			try{
//				printWriter.println("<<<<<");
//				for(Md5LineMessage md5LineMessage : differentResult.onlyFileAHas())
//					printWriter.println(md5LineMessage);
//				printWriter.println("<<<<<");
//			}finally{
//				if(printWriter!=null) printWriter.close();
//			}
//		}
//		
//		{
//			PrintWriter printWriter = new PrintWriter("onlyFileBHas.log");
//			try{
//				printWriter.println(">>>>>>>");
//				for(Md5LineMessage md5LineMessage : differentResult.onlyFileBHas())
//					printWriter.println(md5LineMessage);
//				printWriter.println(">>>>>>>");
//			}finally{
//				if(printWriter!=null) printWriter.close();
//			}
//		}
//		
//		{
//			PrintWriter printWriter = new PrintWriter("different");
//			try{
//				for(DifferentResult.LineCouple<Md5LineMessage> lineCouple : differentResult.differences()){
//					printWriter.println("!=!=!=!=");
//					printWriter.println(lineCouple.getFileA());
//					printWriter.println(lineCouple.getFileB());
//					printWriter.println("!=!=!=!=");
//				}
//			}finally{
//				if(printWriter!=null) printWriter.close();
//			}
//		}
	}
	
}
