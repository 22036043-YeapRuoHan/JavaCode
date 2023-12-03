package c209_L08;
public class StudentInsertDemo {

	public static void main(String[] args) {
	
		String jdbcURL = "jdbc:mysql://localhost/demodb";
		String dbUsername = "root";
		String dbPassword = "";

		DBUtil.init(jdbcURL, dbUsername, dbPassword);

		System.out.println("ADDING STUDENT");
		Helper.line(40, "-");
		String name = Helper.readString("Enter name > ");
		String diploma = Helper.readString("Enter diploma > ");
		double gpa = Helper.readDouble("Enter gpa > ");

		String sql = "INSERT INTO student(name, dip, gpa) " 
					+ "VALUES ('" + name + "', '" + diploma + "', " + gpa + ")";
		int rowsAffected = DBUtil.execSQL(sql);

		if (rowsAffected == 1) {
			System.out.println("Student added!");
		} else {
			System.out.println("Insert failed!");
		}

		DBUtil.close();
	}
}
