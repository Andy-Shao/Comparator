package comparator.analyse;

import java.io.IOException;
import comparator.Item;

public class AnalyseDifferentResultAttributeVisitor<T extends Item<?>> implements DifferentResultVisitor<T> {

	@Override
	public void visit(DifferentElement<T> differentElement) throws IOException {
		System.out.println("Different File.");
		System.out.println("SIZE: " + differentElement.getValue().size());
	}

	@Override
	public void visit(OnlyFileAHasElement<T> onlyFileAHasElement) throws IOException {
		System.out.println("OnlyFileAHas File.");
		System.out.println("SIZE: " + onlyFileAHasElement.getValue().size());
	}

	@Override
	public void visit(OnlyFileBHasElement<T> onlFileBHasElement) throws IOException {
		System.out.println("OnlyFileBHas File.");
		System.out.println("SIZE: " + onlFileBHasElement.getValue().size());
	}
}
