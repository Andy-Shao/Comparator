package database.struct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleTable implements Table<OracleColumn> {
	private volatile String name;
	private volatile List<OracleColumn> orderlyColumns = new ArrayList<OracleColumn>();
	private final Map<String, OracleColumn> columnMap = new HashMap<String, OracleColumn>();

	@Override
	public String name() {
		return this.name;
	}

	@Override
	public Map<String, Object> otherInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addColumn(OracleColumn column) {
		this.columnMap.put(column.name(), column);
		this.orderlyColumns.add(column);
		Collections.sort(this.orderlyColumns);
	}

	@Override
	public OracleColumn column(int location) {
		return this.orderlyColumns.get(location);
	}

	@Override
	public OracleColumn column(String name) {
		return this.columnMap.get(name);
	}

	@Override
	public int size() {
		return this.orderlyColumns.size();
	}

	@Override
	public OracleColumn removeColumn(int location) {
		OracleColumn column = this.orderlyColumns.remove(location);
		this.columnMap.remove(column.name());
		return column;
	}

	@Override
	public OracleColumn removeColumn(String name) {
		OracleColumn column = this.columnMap.remove(name);
		this.orderlyColumns.remove(column.location());
		return column;
	}

	@Override
	public String toString() {
		return "OracleTable [name=" + name + ", orderlyColumns=" + orderlyColumns + ", columnMap=" + columnMap + "]";
	}

}
