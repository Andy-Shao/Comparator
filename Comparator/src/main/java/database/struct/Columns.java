package database.struct;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public final class Columns {
	private Columns() {
		throw new AssertionError("No Columns instances for you!");
	}

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss-SSS");

	public static String formatInt(int i) {
		return String.valueOf(i);
	}
	
	public static String formatBigDecimal(BigDecimal i){
		return i.toString();
	}
	
	public static String formatShort(short s){
		return String.valueOf(s);
	}
	
	public static String formatBoolean(boolean b){
		return String.valueOf(b);
	}
	
	public static String formatFloat(float f) {
		return String.format("%f", f);
	}

	public static String formatDouble(double d) {
		return String.format("%d", d);
	}

	public static String formatString(String str) {
		return str.trim();
	}
	
	public static String formatURL(java.net.URL url){
		return url.toString();
	}

	public static String formatDate(java.util.Date date) {
		return formatDate(date, DATE_FORMAT);
	}

	public static String formatDate(java.util.Date date, DateFormat dateFormat) {
		return dateFormat.format(date);
	}

	public static String getColumnValue(Column column, ResultSet rs) throws SQLException {
		if (column.type().isAssignableFrom(int.class)) return formatInt(rs.getInt(column.name()));
		else if (column.type().isAssignableFrom(short.class)) return formatShort(rs.getShort(column.name()));
		else if (column.type().isAssignableFrom(float.class)) return formatFloat(rs.getFloat(column.name()));
		else if (column.type().isAssignableFrom(double.class)) return formatDouble(rs.getDouble(column.name()));
		else if (column.type().isAssignableFrom(String.class)) return rs.getString(column.name()) == null ? "" : formatString(rs.getString(column.name()));
		else if (column.type().isAssignableFrom(boolean.class)) return formatBoolean(rs.getBoolean(column.name()));
		else if (column.type().isAssignableFrom(Date.class)) return rs.getDate(column.name()) == null ? "" : formatDate(rs.getDate(column.name()));
		else if (column.type().isAssignableFrom(java.sql.Timestamp.class)) return rs.getTimestamp(column.name()) == null ? "" : formatDate(rs
				.getTimestamp(column.name()));
		else if (column.type().isAssignableFrom(java.sql.Time.class)) return rs.getTime(column.name()) == null ? "" : formatDate(rs.getTime(column.name()));
		else if (column.type().isAssignableFrom(java.net.URL.class)) return rs.getURL(column.name()) == null ? "" : formatURL(rs.getURL(column.name()));
		else if (column.type().isAssignableFrom(BigDecimal.class)) return formatBigDecimal(rs.getBigDecimal(column.name()));
		return "";
	}
}
