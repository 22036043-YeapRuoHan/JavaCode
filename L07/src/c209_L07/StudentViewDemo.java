package c209_L07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentViewDemo {

	public static void main(String[] args) {

		try {
			String connectionString = "jdbc:mysql://localhost:3306/demodb";
			String userid = "root";
			String password = "";

			Connection conn = DriverManager.getConnection(connectionString, userid, password);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("SELECT id, name, dip, gpa FROM student");

			String output = String.format("%-5s %-20s %-10s %-10s\n", "ID", "NAME", "DIPLOMA", "GPA");

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String dip = rs.getString("dip");
				double gpa = rs.getDouble("gpa");
				output += String.format("%-5d %-20s %-10s %-10.2f\n", id, name, dip, gpa);
			}
			System.out.println(output);

			rs.close();
			statement.close();
			conn.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}
