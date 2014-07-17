package database.sql;

public interface SqlProcess {
	public static final SqlProcess DO_NOTHING = new SqlProcess() {
		@Override
		public String process(String sqlStr) {
			return sqlStr;
		}
	};

	String process(String sqlStr);
}
