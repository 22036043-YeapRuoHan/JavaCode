package c209_L08;

public class StudentDeleteDemo {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:mysql://localhost/demodb";
		String dbUsername = "root";
		String dbPassword = "";

		DBUtil.init(jdbcURL, dbUsername, dbPassword);

		System.out.println("DELETING STUDENT");
		Helper.line(40, "-");

		String name = Helper.readString("Enter name > ");

		String deleteSQL = "DELETE FROM student WHERE name='" + name + "'";
		int rowsAffected = DBUtil.execSQL(deleteSQL);

		if (rowsAffected == 1) {
			System.out.println("Student deleted!");
		} else {
			System.out.println("Delete failed!");
		}

		DBUtil.close();
	}

}
