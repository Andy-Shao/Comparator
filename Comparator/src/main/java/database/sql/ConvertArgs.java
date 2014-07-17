package database.sql;

import java.util.HashMap;
import java.util.Map;

import andy.shao.util.StringTools;

public class ConvertArgs implements SqlProcess {
	private volatile SqlProcess sqlProcess = SqlProcess.DO_NOTHING;
	private volatile Map<Object, Object> properties = new HashMap<Object, Object>();

	@Override
	public String process(String sqlStr) {
		for(Map.Entry<Object, Object> entry : this.properties.entrySet()){
			sqlStr = StringTools.replaceAll(sqlStr, "${" + entry.getKey() + "}", entry.getValue().toString());
		}
		return this.sqlProcess.process(sqlStr);
	}

	public void setSqlProcess(SqlProcess sqlProcess) {
    	this.sqlProcess = sqlProcess;
    }

	public void setProperties(Map<Object, Object> properties) {
    	this.properties = properties;
    }
}
