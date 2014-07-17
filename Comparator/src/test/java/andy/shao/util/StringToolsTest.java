package andy.shao.util;

import org.junit.Test;

import andy.shao.util.StringTools;

public class StringToolsTest {

	@Test
	public void split(){
		String line = "US,159,13701161,,1605,S,47511,EUR,2014-04-07 18:23:40-403,,,,,,1008477309,159,,1008477309,,EUR,2014-04-02 00:00:00-000,,2,,,0.000000,";
		System.out.println("===============");
		for(String li : StringTools.split(line, ","))
			System.out.println(li);
		System.out.println("===============");
	}
	
	
	@Test
	public void baseTest(){
		boolean bi = "timestamp (6)".startsWith("TIMESTAMP");
		System.out.println(bi);
	}
}
