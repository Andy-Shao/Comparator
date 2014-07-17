package comparator.analyse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import andy.shao.util.ArrayTools;
import andy.shao.util.StringTools;

import comparator.Item;
import comparator.DifferentResult.LineCouple;
import comparator.action.PublicKey;

public class AnalyseDifferentResultLineVisitor<T extends Item<String>> implements DifferentResultVisitor<T> {

	@Override
	public void visit(DifferentElement<T> differentElement) throws IOException {
		List<LineCouple<T>> different = differentElement.getValue();
		if (different.size() == 0) return;
		final boolean onlyShowDifferent = PublicKey.ONLY_SHOW_DIFFERENT.constainKey();
		final int[] lineNums = getLineNums(different.size());

		for (int lineNum : lineNums) {
			LineCouple<T> lineCouple = different.get(lineNum - 1);
			String[] arguments = StringTools.split(lineCouple.getFileA().getStuff(), PublicKey.SEPARATOR_CHAR.getProperties());
			String[] arguments2 = StringTools.split(lineCouple.getFileB().getStuff(), PublicKey.SEPARATOR_CHAR.getProperties());
			ARG: for (int i = 0; i < Math.max(arguments.length, arguments2.length); i++) {
				String one = ArrayTools.getValue(arguments, i, "");
				String two = ArrayTools.getValue(arguments2, i, "");
				if (onlyShowDifferent && one.equals(two)) continue ARG;
				System.out.println(new StringBuilder().append(i + 1).append("|").append(one).append("|").append(two).append("|ln").append(lineNum));
			}
		}
	}

	@Override
	public void visit(OnlyFileAHasElement<T> onlyFileAHasElement) throws IOException {
		processOnlyFileHas(onlyFileAHasElement.getValue());
	}

	@Override
	public void visit(OnlyFileBHasElement<T> onlFileBHasElement) throws IOException {
		processOnlyFileHas(onlFileBHasElement.getValue());
	}

	protected static <T extends Item<String>> void processOnlyFileHas(List<T> onlyHas) {
		if (onlyHas.size() == 0) return;

		final int[] lineNums = getLineNums(onlyHas.size());
		for (int lineNum : lineNums) {
			String[] arguments = StringTools.split(onlyHas.get(lineNum - 1).getStuff(), PublicKey.SEPARATOR_CHAR.getProperties());
			for (int i = 0; i < arguments.length; i++)
				System.out.println(new StringBuilder().append(i + 1).append("|").append(arguments[i]).append("|ln").append(lineNum));
		}
	}

	private static final String SECTION = "-";

	static int[] getLineNums(int max) {
		int[] lineNums = new int[] { 1 };
		if (PublicKey.LINE_NUM.constainKey()) {
			String[] args = PublicKey.LINE_NUM.getProperties().split(",");
			for (int i = 0; i < args.length;) {
				if (args[i].indexOf(SECTION) != -1) {
					String[] head = new String[0];
					if (i != 0) head = ArrayTools.splitArray(args, 0, i);
					String[] tail = new String[0];
					if (i + 1 != args.length) tail = ArrayTools.splitArray(args, i + 1, args.length);

					String arg = args[i];
					Collection<String> body = new ArrayList<String>();
					if (arg.startsWith(SECTION)) {
						int index = 0;
						int end = Math.min(Integer.valueOf(arg.split(SECTION)[1]), max);
						SECTION:while (true) {
							body.add(String.valueOf(++index));
							if (index >= end) break SECTION;
						}

					} else if (arg.endsWith(SECTION)) {
						int index = Integer.valueOf(arg.split(SECTION)[0]) - 1;
						int end = max;
						SECTION:while (index <= end) {
							body.add(String.valueOf(++index));
							if (index >= end) break SECTION;
						}
					} else {
						int index = Integer.valueOf(arg.split(SECTION)[0]);
						int end = Integer.valueOf(arg.split(SECTION)[1]);
						SECTION:while (true) {
							body.add(String.valueOf(index++));
							if (index >= end) break SECTION;
						}
						body.add(String.valueOf(end));
					}
					args = ArrayTools.mergeArray(String[].class, head, body.toArray(new String[] {}), tail);
					i += body.size();
				} else i++;
			}
			lineNums = new int[args.length];
			for (int i = 0; i < lineNums.length; i++)
				lineNums[i] = Integer.valueOf(args[i]);
		}
		return lineNums;
	}
}
