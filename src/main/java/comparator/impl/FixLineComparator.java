package comparator.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import andy.shao.util.Objects;

import comparator.Md5LineMessage;

public class FixLineComparator implements Comparator<Md5LineMessage> {
	private volatile List<Region> regionOne;
	private volatile List<Region> regionTwo;

	public FixLineComparator(List<Region> regionOne, List<Region> regionTwo) {
		this.regionOne = regionOne;
		this.regionTwo = regionTwo;
	}

	public FixLineComparator() {
	}

	@Override
	public int compare(Md5LineMessage one, Md5LineMessage two) {
		String keyOne = buildKey(one.getStuff(), this.regionOne);
		String keyTwo = buildKey(two.getStuff(), this.regionTwo);

		return keyOne.compareTo(keyTwo);
	}

	protected static String buildKey(String line, List<Region> regions) {
		StringBuilder result = new StringBuilder();

		for (Region region : regions)
			result.append(line.substring(region.start(), region.end()));

		return result.toString();
	}

	public static interface Region {
		/**
		 * be included.
		 * 
		 * @return
		 */
		int start();

		/**
		 * excluded.
		 * 
		 * @return
		 */
		int end();
	}

	public static class DefaultRegion implements Region {
		private volatile int start;
		private volatile int end;

		public DefaultRegion(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int start() {
			return this.start;
		}

		@Override
		public int end() {
			return this.end;
		}

		@Override
		public String toString() {
			return "DefaultRegion [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.start, this.end);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof DefaultRegion) {
				DefaultRegion that = (DefaultRegion) obj;
				return Objects.equals(this.start, that.start) && Objects.equals(this.end, that.end);
			}

			return false;
		}
	}

	protected static List<Region> pasing(String regionInfos) {
		List<Region> list = new ArrayList<FixLineComparator.Region>();

		String[] pharses = regionInfos.split(";");
		for (String pharse : pharses) {
			final String[] items = pharse.split(",");
			Region region = new DefaultRegion(Integer.valueOf(items[0]), Integer.valueOf(items[1]));
			list.add(region);
		}

		return list;
	}

	public void setRegionOne(List<Region> regionOne) {
		this.regionOne = regionOne;
	}

	public void setRegionOneStr(String regionOne) {
		this.regionOne = pasing(regionOne);
	}

	public void setRegionTwo(List<Region> regionTwo) {
		this.regionTwo = regionTwo;
	}

	public void setRegionTwoStr(String regionTwo) {
		this.regionTwo = pasing(regionTwo);
	}
}
