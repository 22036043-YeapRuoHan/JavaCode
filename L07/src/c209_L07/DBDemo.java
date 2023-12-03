package c209_L07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemo {

	public static void main(String[] args) {
		System.out.println("DB test...");
		try {
			String connectionString = "jdbc:mysql://localhost:3306/demodb";
			String userid = "root";
			String password = "";

			Connection conn = DriverManager.getConnection(connectionString, userid, password);

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT name FROM person");

			int ctr = 1;
			while (rs.next()) {
				String user = rs.getString("name");
				System.out.println("User no " + ctr + ": " + user);
				ctr++;
			}

			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException se) {
			System.out.println("Error: " + se.getMessage());
		}
	}
}


