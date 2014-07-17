package andy.shao.util;

/**
 * 
 * @author ws83149
 *
 */
public final class StringTools {
	private StringTools() {
		throw new AssertionError("No StringTools instances for you!");
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmptyOrNull(String str) {
		return str == null || str.isEmpty();
	}

	public static String replaceAll(String str, String key, String padding) {
		while (str.indexOf(key) != -1)
			str = replaceFirst(str, key, padding);
		return str;
	}

	public static String replaceFirst(String str, String key, String padding) {
		return replace(str, key, padding, str.indexOf(key));
	}

	public static String replaceLast(String str, String key, String padding) {
		return replace(str, key, padding, str.lastIndexOf(key));
	}

	public static String replace(String str, String key, String padding, int index) {
		String result;

		if (index == -1) result = str;
		else if (index == 0) result = padding + str.substring(key.length());
		else if (index + 1 >= str.length()) result = str.substring(0, index) + padding;
		else result = str.substring(0, index) + padding + str.substring(index + key.length());

		return result;
	}

	public static String fixString(String str, int maxLength) {
		if (str.length() <= maxLength) return str;
		return str.substring(0, maxLength);
	}

	/**
	 * more efficient
	 * 
	 * @param str
	 * @param separator
	 * @return
	 */
	public static String[] split(String str, String separator) {
		String[] result = new String[0];
		for (int index; (index = str.indexOf(separator)) != -1;) {
			result = ArrayTools.mergeArray(String[].class, result, new String[] { str.substring(0, index) });
			str = str.substring(index + separator.length());
		}
		if (str.length() != 0) result = ArrayTools.mergeArray(String[].class, result, new String[] { str });

		return result;
	}
}
