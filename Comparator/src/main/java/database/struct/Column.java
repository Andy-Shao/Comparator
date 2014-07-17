package database.struct;

import java.util.Map;

public interface Column extends Comparable<Column> {
	/**
	 * 
	 * @return
	 */
	int location();

	/**
	 * the name of {@link Column}
	 * 
	 * @return
	 */
	String name();

	/**
	 * The suitable class type of {@link Column}
	 * 
	 * @return
	 */
	Class<?> type();

	/**
	 * The other information about the {@link Column}. For different DB will has different info about {@link Column}.
	 * 
	 * @return
	 */
	Map<String, Object> otherInfo();
}
