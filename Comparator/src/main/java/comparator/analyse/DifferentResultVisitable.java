package comparator.analyse;

import java.io.IOException;

import comparator.Item;

public interface DifferentResultVisitable<T extends Item<?>> {
	public void accept(DifferentResultVisitor<T> visitor) throws IOException;
}
