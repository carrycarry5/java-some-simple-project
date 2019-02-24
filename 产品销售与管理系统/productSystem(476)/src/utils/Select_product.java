package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import dao.jdbc_select;

public class Select_product {
	public static void select() throws FileNotFoundException, IOException, SQLException{
		jdbc_select.select();
	}
}
