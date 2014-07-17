package comparator.action;

public enum PublicKey {
	INPUT_PATH, OUTPUT_PATH, EXPORT_DETAIL("export.detail"), LOG_PATH, LINE_NUM("lineNum"), DIFFERENT("different"), 
	ONLY_FILE_A_HAS("onlyFileAHas"), ONLY_FILE_B_HAS("onlyFileBHas"), ONLY_SHOW_DIFFERENT("onlyShowDifferent"), 
	SEPARATOR_CHAR, INSTANCE("instance"), BANKING_BOOK_OUTPUT, TRADING_BOOK_OUTPUT;

	private volatile String toString;

	private PublicKey(String toString) {
		this.toString = toString;
	}

	private PublicKey() {
	}

	@Override
	public String toString() {
		return this.toString == null ? super.toString() : this.toString;
	}

	public String getProperties() {
		return System.getProperty(this.toString());
	}

	public String setProperties(String value) {
		return System.setProperty(this.toString(), value);
	}

	public boolean constainKey() {
		return this.getProperties() != null;
	}

	public String getenv() {
		return System.getenv(this.toString());
	}

	public boolean constainKeyInEnv() {
		return this.getenv() != null;
	}
}