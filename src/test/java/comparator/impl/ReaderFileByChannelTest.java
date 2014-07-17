package comparator.impl;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import comparator.Md5LineMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:comparator/impl/readerFileByChannelTest.xml")
public class ReaderFileByChannelTest {

	@Autowired
	@Qualifier("readerFileByChannel")
	private volatile Iterator<Md5LineMessage> iterator;

	@Ignore
	@Test
	public void foreach() throws IOException{
//		Collection<Md5LineMessage> md5LineMessages = new ArrayList<Md5LineMessage>();
		while(this.iterator.hasNext()){
//			System.out.println(this.iterator.next().getLine());
			this.iterator.next();
//			md5LineMessages.add(this.iterator.next());
		}
//		System.out.println(md5LineMessages.size());
	}
	
	@Test
	public void getMsge(){
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byteBuffer.put("Some message".getBytes());
		byte[] bs = ReaderFileByChannel.getMsg(byteBuffer);
		System.out.println(new String(bs));
	}
}
