package comparator.analyse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import comparator.Item;

public class OnlyFileBHasElement<T extends Item<?>> implements DifferentResultVisitable<T> {
	private volatile List<T> value;
    private Map<String, Object> otherValues;
	
	public OnlyFileBHasElement(List<T> list) {
		this(list, new HashMap<String, Object>());
    }
	
	public OnlyFileBHasElement(List<T> list, Map<String, Object> map) {
		this.value = list;
		this.otherValues = map;
    }

	@Override
	public void accept(DifferentResultVisitor<T> visitor) throws IOException {
		visitor.visit(this);
	}

	public List<T> getValue() {
    	return value;
    }

	public Map<String, Object> getOtherValues() {
    	return otherValues;
    }

	public void setValue(List<T> value) {
    	this.value = value;
    }
}
