package c209_L07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBDemoRemote {

	public static void main(String[] args) {
		System.out.println("DB test...");
		try {
			String connectionString = "jdbc:mysql://localhost:3306/demodb";
			String userid = "root";
			String password = "";

			System.out.println();
			String output = String.format("%-5s %-8s %-5s\n", "S/No", "ID", "Name");
			output += String.format("%-5s %-8s %-5s\n", "====", "==", "====");

			Connection conn = DriverManager.getConnection(connectionString, userid, password);

			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT id,name FROM Person");

			int ctr = 1;
			while (rs.next()) {
				String user = rs.getString("name");
				int id = rs.getInt("id");
				output += String.format("%-5d %-8d %-5s \n", ctr, id, user);
				ctr++;
			}
			System.out.println(output);

			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException se) {
			System.out.println("Error: " + se.getMessage());
		}
	}
}
