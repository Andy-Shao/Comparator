package comparator;

import java.util.List;

public interface ComformityResult<T extends Item<?>> extends ComparatorResult {

	List<T> sames();
}
