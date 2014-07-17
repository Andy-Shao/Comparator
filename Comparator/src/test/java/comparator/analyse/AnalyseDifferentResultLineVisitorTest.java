package comparator.analyse;

import org.junit.Assert;
import org.junit.Test;

import comparator.action.PublicKey;

public class AnalyseDifferentResultLineVisitorTest {

	@Test
	public void getLineNums(){
		PublicKey.LINE_NUM.setProperties("-5");
		int[] ints = AnalyseDifferentResultLineVisitor.getLineNums(3);
		Assert.assertArrayEquals(new int[]{1,2,3}, ints);
		PublicKey.LINE_NUM.setProperties("5-");
		ints = AnalyseDifferentResultLineVisitor.getLineNums(20);
		Assert.assertArrayEquals(new int[]{5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}, ints);
		ints = AnalyseDifferentResultLineVisitor.getLineNums(3);
		Assert.assertArrayEquals(new int[]{}, ints);
		PublicKey.LINE_NUM.setProperties("1,3,5-");
		ints = AnalyseDifferentResultLineVisitor.getLineNums(3);
		Assert.assertArrayEquals(new int[]{1,3}, ints);
	}
}
