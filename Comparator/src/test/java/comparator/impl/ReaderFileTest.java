package comparator.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import comparator.Md5LineMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:comparator/impl/readerFileTest.xml")
public class ReaderFileTest {
	
	@Autowired
	@Qualifier("readerFile")
	private volatile Iterator<Md5LineMessage> iterator;

	@Test
	public void foreach() throws IOException{
		Collection<Md5LineMessage> md5LineMessages = new ArrayList<Md5LineMessage>();
		while(this.iterator.hasNext()){
//			System.out.println(this.iterator.next().getLine());
			md5LineMessages.add(this.iterator.next());
		}
		System.out.println(md5LineMessages.size());
	}
}
