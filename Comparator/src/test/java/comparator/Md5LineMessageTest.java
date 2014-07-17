package comparator;

import org.junit.Test;

public class Md5LineMessageTest {

	@Test
	public void getMD5(){
		String line1 = "GB,132,CE128141,E,1605,S,1000242191,USD,10-APR-14 05.38.46.476000 PM,,,,09-MAR-15 12.00.00.000000 AM,,1000305134,132,,1000305134,,USD,09-MAR-15 12.00.00.000000 AM,,2,,,,,,,,0,CGINVL,C,OE91  ,11-MAR-15 12.00.00.000000 AM,,07-MAR-11 12.00.00.000000 AM,15007130,0,04-MAR-11 12.00.00.000000 AM,OE9   ,,,,,,,1000305134,,,,BSCF,,,,,,,,,,0,USD,N,,,,,,,,,,BSCF,13708140001     ,N,,,,,,,,,,A,09-MAR-15 12.00.00.000000 AM,11-MAR-15 12.00.00.000000 AM,TRD,,TP,,,,,,,,,,,,,,,,,,,,,,,,,,,,N,,,,,,,,,,,,,,,,,,,";
		String line2 = "GB,132,CE128141,E,1605,S1000242191,USD,10-APR-14 05.38.46.476000 PM,,,,09-MAR-15 12.00.00.000000 AM,,1000305134,132,,1000305134,,USD,09-MAR-15 12.00.00.000000 AM,,2,,,,,,,,0,CGINVL,C,OE91  ,11-MAR-15 12.00.00.000000 AM,,07-MAR-11 12.00.00.000000 AM,15007130,0,04-MAR-11 12.00.00.000000 AM,OE9   ,,,,,,,1000305134,,,,BSCF,,,,,,,,,,0,USD,N,,,,,,,,,,BSCF,13708140001     ,N,,,,,,,,,,A,09-MAR-15 12.00.00.000000 AM,11-MAR-15 12.00.00.000000 AM,TRD,,TP,,,,,,,,,,,,,,,,,,,,,,,,,,,,N,,,,,,,,,,,,,,,,,,,";
		System.out.println(Md5LineMessage.bytes2String(Md5LineMessage.getMD5(line1.getBytes())));
		System.out.println(Md5LineMessage.bytes2String(Md5LineMessage.getMD5(line2.getBytes())));
	}
}
