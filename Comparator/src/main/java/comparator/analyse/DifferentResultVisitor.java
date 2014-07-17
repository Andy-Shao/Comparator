package comparator.analyse;

import java.io.IOException;

import comparator.Item;

public interface DifferentResultVisitor<T extends Item<?>> {
	void visit(DifferentElement<T> differentElement) throws IOException;
	void visit(OnlyFileAHasElement<T> onlyFileAHasElement) throws IOException;
	void visit(OnlyFileBHasElement<T> onlFileBHasElement) throws IOException;
}
