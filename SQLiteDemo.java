package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet; 

public class SQLiteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl = "jdbc:sqlite:/C:\\SQLite\\sqlite-tools-win32-x86-3390000\\sqlite-tools-win32-x86-3390000\\usersdb.db";
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT * FROM MOVIES";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				String lead_actor = result.getString("lead_actor");
				String actress = result.getString("actress");
				String director = result.getString("director");
				String year_of_release = result.getString("year_of_release");
				
				System.out.println(lead_actor+" | "+actress+" | "+director+" | "+year_of_release);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Connection to SQLite database");
			e.printStackTrace();
		}

	}

}
