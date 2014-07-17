package comparator.analyse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparator.Item;
import comparator.DifferentResult.LineCouple;

public class DifferentElement<T extends Item<?>> implements DifferentResultVisitable<T>{
	private volatile List<LineCouple<T>> value;
    private Map<String, Object> otherValues;
	
	public DifferentElement(List<LineCouple<T>> lineCouples) {
		this(lineCouples, new HashMap<String, Object>());
    }
	
	public DifferentElement(List<LineCouple<T>> lineCouples, Map<String, Object> map) {
		this.value = lineCouples;
		this.otherValues = map;
    }

	@Override
    public void accept(DifferentResultVisitor<T> visitor) throws IOException {
		visitor.visit(this);
    }

	public List<LineCouple<T>> getValue() {
    	return value;
    }

	public Map<String, Object> getOtherValues() {
    	return otherValues;
    }

	public void setValue(List<LineCouple<T>> value) {
    	this.value = value;
    }
}
