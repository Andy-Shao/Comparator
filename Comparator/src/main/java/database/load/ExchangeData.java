package database.load;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.struct.Column;
import database.struct.Table;

public interface ExchangeData<E> {

	E loader(Table<? extends Column> table, ResultSet rs) throws SQLException;
}
