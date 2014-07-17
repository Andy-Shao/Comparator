package comparator;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

import andy.shao.util.Objects;

/**
 * Unsafe for multiply Thread.
 * 
 * @author ws83149
 * 
 */
@SuppressWarnings("serial")
public class Md5LineMessage implements LineMessage<String>, Serializable {
	private String line;
	private String md5Codes;
	private volatile long lineNumber;
	private static final long DEFAULT_LINE_NUMBER = -1L;

	public Md5LineMessage(String line) {
		this(line, DEFAULT_LINE_NUMBER);
	}

	public Md5LineMessage(String line, long lineNumber) {
		this(line, lineNumber, bytes2String(getMD5(line.getBytes())));
	}

	public Md5LineMessage(String line, long lineNumber, String md5Codes) {
		this.setLine(line);
		this.setLineNumber(lineNumber);
		this.setMd5Codes(md5Codes);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.md5Codes);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Md5LineMessage) {
			Md5LineMessage that = (Md5LineMessage) obj;
			return Objects.equals(this.md5Codes, that.md5Codes);
		}

		return false;
	}

	@Override
	public String toString() {
		return "Md5LineMessage [line=" + line + ", md5Codes=" + md5Codes + ", lineNumber=" + lineNumber + "]";
	}

	public static String bytes2String(byte[] tmp) {
		String s = null;
		char str[] = new char[tmp.length * 2];
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		for (int i = 0, k = 0; i < tmp.length; i++) {
			byte byte0 = tmp[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		s = new String(str);

		return s;
	}

	public static byte[] getMD5(byte[] source) {
		byte[] result = null;

		java.security.MessageDigest md;
		try {
			md = java.security.MessageDigest.getInstance("MD5");
			result = md.digest(source);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String getStuff() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getMd5Codes() {
		return md5Codes;
	}

	public void setMd5Codes(String md5Codes) {
		this.md5Codes = md5Codes;
	}

	@Override
	public long getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(long lineNumber) {
		this.lineNumber = lineNumber;
	}
}
