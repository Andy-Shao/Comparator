package comparator.analyse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import comparator.DifferentResult;
import comparator.Item;
import comparator.DifferentResult.LineCouple;

public class PrintDifferentResultVisitor<T extends Item<?>> implements DifferentResultVisitor<T> {

	@Override
	public void visit(DifferentElement<T> differentElement) throws IOException {
		List<LineCouple<T>> different = differentElement.getValue();
		long lineNum = 0;
		for (DifferentResult.LineCouple<T> lineCouple : different) {
			System.out.println("!=!=!=!=!=");
			System.out.println("lineNum is: " + (++lineNum));
			System.out.println(lineCouple.getFileA().getStuff());
			System.out.println(lineCouple.getFileB().getStuff());
			System.out.println("!=!=!=!=!=");
		}
	}

	@Override
	public void visit(OnlyFileAHasElement<T> onlyFileAHasElement) throws IOException {
		processOnlyFileHas(onlyFileAHasElement.getValue(), onlyFileAHasElement.getOtherValues());
	}

	@Override
	public void visit(OnlyFileBHasElement<T> onlFileBHasElement) throws IOException {
		processOnlyFileHas(onlFileBHasElement.getValue(), onlFileBHasElement.getOtherValues());
	}
	
	protected static <T extends Item<?>> void processOnlyFileHas(List<T> onlyHas, Map<String, Object> otherValue) throws FileNotFoundException {
		for (T item : onlyHas)
			System.out.println(item.getStuff());
	}
}
