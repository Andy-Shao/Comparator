package database.struct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SybaseTable implements Table<SybaseColumn> {
	private volatile String name;
	private volatile List<SybaseColumn> orderlyColumns = new ArrayList<SybaseColumn>();
	private final Map<String, SybaseColumn> columnMap = new HashMap<String, SybaseColumn>();

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
	public void addColumn(SybaseColumn column) {
		this.columnMap.put(column.name(), column);
		this.orderlyColumns.add(column);
		Collections.sort(this.orderlyColumns);
	}

	@Override
	public SybaseColumn column(int location) {
		return this.orderlyColumns.get(location);
	}

	@Override
	public SybaseColumn column(String name) {
		return this.columnMap.get(name);
	}

	@Override
	public int size() {
		return this.orderlyColumns.size();
	}

	@Override
	public SybaseColumn removeColumn(int location) {
		SybaseColumn column = this.orderlyColumns.remove(location);
		this.columnMap.remove(column.name());
		return column;
	}

	@Override
	public SybaseColumn removeColumn(String name) {
		SybaseColumn column = this.columnMap.remove(name);
		this.orderlyColumns.remove(column.location());
		return column;
	}

	@Override
	public String toString() {
		return "SybaseTable [name=" + name + ", orderlyColumns=" + orderlyColumns + ", columnMap=" + columnMap + "]";
	}

}
