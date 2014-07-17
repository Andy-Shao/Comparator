package database.struct;

public interface TableFactory<T extends Table<?>, I> {

	T buildTable(I input) throws Exception;
}
