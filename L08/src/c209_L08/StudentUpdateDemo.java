package c209_L08;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentUpdateDemo {

	public static void main(String[] args) {
		try {
			String jdbcURL = "jdbc:mysql://localhost/demodb";
			String dbUsername = "root";
			String dbPassword = "";

			DBUtil.init(jdbcURL, dbUsername, dbPassword);

			System.out.println("UPDATING STUDENT GPA");
			Helper.line(40, "-");
			double gpa = 0.0;

			String name = Helper.readString("Enter name > ");
			String sql = "SELECT gpa FROM student WHERE name='" + name + "'";
			ResultSet rs = DBUtil.getTable(sql);

			if (rs.next()) {
				gpa = rs.getDouble("gpa");
			}

			System.out.println("Name: " + name);
			System.out.println("Current GPA: " + gpa);
			double newGpa = Helper.readDouble("Enter new GPA > ");

			String updateSQL = "UPDATE student SET gpa=" + newGpa + " WHERE name='" + name + "'";
			int rowsAffected = DBUtil.execSQL(updateSQL);

			if (rowsAffected == 1) {
				System.out.println("Student gpa updated!");
			} else {
				System.out.println("Update failed!");
			}

			DBUtil.close();

		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
		}
	}

}
