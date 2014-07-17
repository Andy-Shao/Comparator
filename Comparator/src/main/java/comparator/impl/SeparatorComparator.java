package comparator.impl;

import java.util.Arrays;
import java.util.Comparator;

import comparator.Md5LineMessage;

public class SeparatorComparator implements Comparator<Md5LineMessage> {
	private volatile String separator = "|";
	private volatile int[] oneLocations = new int[0];
	private volatile int[] twoLocations = new int[0];

	@Override
	public int compare(Md5LineMessage md5line1, Md5LineMessage md5line2) {
		String line1 = buildKey(md5line1, separator, oneLocations);
		String line2 = buildKey(md5line2, separator, twoLocations);
		return line1.compareTo(line2);
	}

	static String buildKey(Md5LineMessage md5line, String separator, int... locations) {
		String line = md5line.getStuff();
		StringBuilder builder = new StringBuilder();
		int index = 0;
		for (int location : locations) {
			int end = 0;
			if ((end = line.indexOf(separator)) == -1) break;
			if (location == index) {
				builder.append(line.substring(0, end));
			}
			line = line.substring(end + separator.length());
			index++;
		}
		return builder.toString();
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public void setOneLocations(int[] oneLocations) {
		Arrays.sort(oneLocations);
		this.oneLocations = oneLocations;
	}

	public void setTwoLocations(int[] twoLocations) {
		Arrays.sort(twoLocations);
		this.twoLocations = twoLocations;
	}

}
