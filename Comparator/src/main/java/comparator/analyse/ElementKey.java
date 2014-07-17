package comparator.analyse;

import java.util.Map;

import andy.shao.util.Convert;

public enum ElementKey {
	OUTPUT_PATH;
	private String name;
	private ElementKey(String name){this.name = name;}
	private ElementKey(){}
	@Override
    public String toString() {
        return this.name==null ? super.toString() : this.name;
    }
	public <V> V get(Map<String, V> map){
		return map.get(this.toString());
	}
	public <K,V> V get(Map<K, V> map, Convert<String, K> convert){
		return map.get(convert.convert(this.toString()));
	}
	public <V> V set(Map<String, V> map, V value){
		return map.put(this.toString(), value);
	}
	public <K,V> V set(Map<K, V> map, V value, Convert<String, K> convert){
		return map.put(convert.convert(this.toString()), value);
	}
}
