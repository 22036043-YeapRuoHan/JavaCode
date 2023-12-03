package c209_L08;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContestRegistration {
	private static final String Nric_Parttern = "[STGF][0-9]{7}[A-Z]";
	private static final String Mobile_Parttern = "[89][0-9]{7}";
	public static void main(String[] args) {
		ContestRegistration register = new ContestRegistration();
		register.start();
	}

	private void start() {

		String jdbcURL = "jdbc:mysql://localhost/demodb";
		String dbUsername = "root";
		String dbPassword = "";

		DBUtil.init(jdbcURL, dbUsername, dbPassword);

		int option = -1;

		while (option != 5) {
			menu();
			option = Helper.readInt("Enter choice > ");

			if (option == 1) {
				viewAllParticipants();
			} else if (option == 2) {
				registerParticipant();
			} else if (option == 3) {
				updateParticipantContact();
			} else if (option == 4) {
				removeParticipant();
			} else if (option == 5) {
				DBUtil.close();
				System.out.println("Good bye!");
			}
		}
	}

	private void menu() {
		Helper.line(50, "=");
		System.out.println("CONTEST REGISTRATION");
		Helper.line(50, "=");

		System.out.println("1. View all participants");
		System.out.println("2. Register");
		System.out.println("3. Update participant contact");
		System.out.println("4. Remove participant");
		System.out.println("5. Quit");

	}

	private void viewAllParticipants() {
		String sql = "SELECT nric, name, mobile_number FROM participant";
		String output = String.format("%-10s %-20s %-10s\n", "NRIC", "NAME", "MOBILE NUMBER");

		ResultSet rs = DBUtil.getTable(sql);

		try {
			while (rs.next()) {

				String nric = rs.getString("nric");
				String name = rs.getString("name");
				int mobileNum = rs.getInt("mobile_number");
				output += String.format("%-10s %-20s %-10d\n", obscure(nric), name, mobileNum);
			}

			rs.last();
			int count = rs.getRow();
			System.out.println("Total number of participants: " + count);
			System.out.println(output);

		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
		}
	}

	// obscures all characters of a String except for the first and last four
	// characters
	private String obscure(String inStr) {
		String rtnVal = "";
		if (inStr.length() <= 5) {
			rtnVal = inStr;
		} else {
			rtnVal = inStr.substring(0, 1) + String.format("%" + (inStr.length() - 5) + "s", " ").replaceAll(" ", "X")
					+ inStr.substring(inStr.length() - 4);
		}
		return rtnVal;
	}

	private void registerParticipant() {
		String name = Helper.readString("Enter name > ");
		String nric = Helper.readStringRegEx("Enter NRIC > ", Nric_Parttern);
		String mobileNumber = Helper.readStringRegEx("Enter mobile number > ",Mobile_Parttern);
	    int mobileNum = Integer.parseInt(mobileNumber);

		// TODO: L08 Run Singapore Task 1 - Write the code to add a new participant.
		String sql = "INSERT INTO participant(name, nric, mobile_number) " + "VALUES ('" + name + "', '" + nric + "', "
				+ mobileNum + ")";
		int rowsAdded = DBUtil.execSQL(sql);
		if (rowsAdded == 1) {
			System.out.println("Participant registered!");
		} else {
			System.out.println("Registration failed!");
		}

	}

	private void updateParticipantContact() {

		String nric = Helper.readStringRegEx("Enter NRIC > ",Nric_Parttern);

		Participant participant = findParticipant(nric);

		// TODO: L08 Run Singapore Task 2 - Write code to show the name, nric and
		// current mobile number of participant.
		if (participant == null) {
			System.out.println("Participant does not exist!");
		} else {

			Helper.line(60, "-");
			System.out.println("Update Participant Info");
			Helper.line(60, "-");
			System.out.println("Name: " + participant.getName());
			System.out.println("NRIC: " + participant.getNric());
			System.out.println("Current mobile number: " + participant.getMobileNum());

		}

		// TODO: L08 Run Singapore Task 3 - Write code to update the participant mobile
		// number.
		String newMobileNum = Helper.readStringRegEx("Enter new mobile number > ",Mobile_Parttern);
		int mobileNum = Integer.parseInt(newMobileNum);
		String updateSQL = "UPDATE participant SET mobile_number=" + mobileNum + " WHERE nric='" + nric + "'";
		int rowsUpdated = DBUtil.execSQL(updateSQL);

		if (rowsUpdated == 1) {
			System.out.println("Participant contact info updated!");
		} else {
			System.out.println("Update failed!");
		}

	}

	private void removeParticipant() {

		String nric = Helper.readString("Enter NRIC > ");

		Participant participant = findParticipant(nric);

		// TODO: L08 Run Singapore Task 4 - Write code to show the name of participant.
		if (participant == null) {
			System.out.println("Participant does not exist!");
		} else {
			char removed;
			removed = Helper.readChar("Are you sure you wish to remove " + participant.getName() + "(Y/N) > ");

			// TODO: L08 Run Singapore Task 5 - Write code to delete participant.
			if (removed == 'Y' | removed == 'y') {

				String deleteSQL = "DELETE FROM participant WHERE nric='" + participant.getNric() + "'";
				int rowsDeleted = DBUtil.execSQL(deleteSQL);
				if (rowsDeleted == 1) {
					System.out.println("Participant removed!");
				} else {
					System.out.println("Removal failed!");
				}
			}

		}
	}

	private Participant findParticipant(String nric) {

		String sql = "SELECT name, mobile_number FROM participant WHERE nric = '" + nric + "'";
		Participant p = null;

		ResultSet rs = DBUtil.getTable(sql);

		try {
			if (rs.next()) {
				p = new Participant(nric, rs.getString("name"), rs.getInt("mobile_number"));
			}
		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
		}
		return p;
	}
	
}
