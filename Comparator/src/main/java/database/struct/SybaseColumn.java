package database.struct;

import java.math.BigDecimal;
import java.util.Map;

public class SybaseColumn implements Column {
	private volatile int location;
	private volatile String name;
	private volatile Class<?> type;

	@Override
	public int location() {
		return this.location;
	}

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public Class<?> type() {
		return this.type;
	}

	@Override
	public Map<String, Object> otherInfo() {
		// TODO need have something about it.
		return null;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public void setTypeByStr(String type) {
		if (type.equalsIgnoreCase("date")) this.type = java.sql.Date.class;
		else if (type.equalsIgnoreCase("float")) this.type = float.class;
		else if (type.equalsIgnoreCase("double")) this.type = double.class;
		else if (type.equalsIgnoreCase("datetime")) this.type = java.sql.Timestamp.class;
		else if (type.equalsIgnoreCase("int")) this.type = int.class;
		else if (type.equalsIgnoreCase("BigDecimal")) this.type = BigDecimal.class;
		else this.type = String.class;
	}

	@Override
	public int compareTo(Column o) {
		if (!(o instanceof SybaseColumn)) throw new IllegalArgumentException("the o isn't " + SybaseColumn.class);
		SybaseColumn that = (SybaseColumn) o;
		return this.location - that.location;
	}

	@Override
	public String toString() {
		return "SybaseColumn [location=" + location + ", name=" + name + ", type=" + type + "]";
	}
}
