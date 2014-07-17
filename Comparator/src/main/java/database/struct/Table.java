package database.struct;

import java.util.Map;

public interface Table<E extends Column> {

	String name();

	Map<String, Object> otherInfo();

	void addColumn(E column);

	E removeColumn(int location);

	E removeColumn(String name);

	/**
	 * 
	 * @param location
	 * @return
	 * @throws IndexOutOfBoundsException
	 *         if the location is out of range (location < 0 || location >= size())
	 */
	E column(int location);

	/**
	 * 
	 * @param name
	 * @return if never include the name then return null.
	 */
	E column(String name);

	/**
	 * 
	 * @return if hasn't any column then return 0
	 */
	int size();
}
