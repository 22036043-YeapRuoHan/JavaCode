package c209_L08;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentViewDemo {

	public static void main(String[] args) {

		try {

			String jdbcURL = "jdbc:mysql://localhost/demodb";
			String dbUsername = "root";
			String dbPassword = "";

			DBUtil.init("jdbc:mysql://localhost/demodb", "root", "");

			String output = String.format("%-5s %-20s %-10s %-10s\n", "ID", "NAME", "DIPLOMA", "GPA");

			String sql = "SELECT id, name, dip ,gpa FROM student";
			ResultSet rs = DBUtil.getTable(sql);

			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				String diploma = rs.getString("dip");
				Double gpa = rs.getDouble("gpa");

				output += String.format("%-5d %-20s %-10s %-10.1f\n", id, name, diploma, gpa);
			}
			System.out.println(output);

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}
}