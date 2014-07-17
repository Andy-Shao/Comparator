package andy.shao.util;

/**
 * Some method which could easier get hashCode.
 * 
 * <p style="color:orange;">
 * At least JDK1.5
 * </p>
 * 
 * @author ws83149
 * 
 */
public final class HashCodes {
	private HashCodes() {
		throw new AssertionError("No HashCodes instances for you!");
	}

	/**
	 * Returns a hash code value for the byte.
	 * 
	 * @param t
	 *            The target which is got hashCode
	 * @return the hashCode of {@value t}
	 */
	public static int hashCode(byte t) {
		return (int) t;
	}

	/**
	 * Returns a hash code value for the boolean.
	 * 
	 * @param t
	 *            The target which is got hashCode
	 * @return the hashCode of {@value t}
	 */
	public static int hashCode(boolean t) {
		return t ? 1231 : 1237;
	}

	/**
	 * Returns a hash code value for the char.
	 * 
	 * @param t
	 *            The target which is got hashCode
	 * @return the hashCode of {@value t}
	 */
	public static int hashCode(char t) {
		return (int) t;
	}

	/**
	 * Returns a hash code value for the double.
	 * 
	 * @param t
	 *            The target which is got hashCode
	 * @return the hashCode of {@value t}
	 */
	public static int hashCode(double t) {
		return hashCode((long) t);
	}

	/**
	 * Returns a hash code value for the float.
	 * 
	 * @param t
	 *            The target which is got hashCode
	 * @return the hashCode of {@value t}
	 */
	public static int hashCode(float t) {
		return Float.floatToIntBits(t);
	}

	/**
	 * Returns a hash code value for the int.
	 * 
	 * @param t
	 *            The target which is got hashCode
	 * @return the hashCode of {@value t}
	 */
	public static int hashCode(int t) {
		return t;
	}

	/**
	 * Returns a hash code value for the long.
	 * 
	 * @param t
	 *            The target which is got hashCode
	 * @return the hashCode of {@value t}
	 */
	public static int hashCode(long t) {
		return (int) (t ^ (t >>> 32));
	}

	/**
	 * Returns a hash code value for the short.
	 * 
	 * @param t
	 *            The target which is got hashCode
	 * @return the hashCode of {@value t}
	 */
	public static int hashCode(short t) {
		return (int) t;
	}

	/**
	 * Returns a hash code value for the object
	 * 
	 * @param t
	 *            The target which is got hashCode
	 * @return the hashCode of {@value t}
	 */
	public static <T> int hashCode(T t) {
		return Objects.hashCode(t);
	}
}
