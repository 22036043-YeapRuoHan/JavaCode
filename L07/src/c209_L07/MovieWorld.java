/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * <YOUR NAME>, <CURRENT DATE AND TIME>
 */

package c209_L07;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class MovieWorld {
	private Connection conn;
	private Statement statement;
	private ResultSet rs;

	public static void main(String[] args) {

		MovieWorld mw = new MovieWorld();
		mw.start();
	}

	public void start() {

		// TODO P08 Task 1: Establish connection
		System.out.println("DB test...");
		try {
			String connectionString = "jdbc:mysql://localhost:3306/demodb";
			String userid = "root";
			String password = "";

			conn = DriverManager.getConnection(connectionString, userid, password);
			statement = conn.createStatement();

			int option = -1;

			while (option != 4) {
				menu();
				option = Helper.readInt("Enter choice > ");
				Helper.line(80, "-");

				if (option == 1) {
					viewAll();
				} else if (option == 2) {
					searchByYear();
				} else if (option == 3) {
					searchByKeyword();
				} else if (option == 4) {

					rs.close();
					statement.close();
					conn.close();

					System.out.println("Thank you for using Movie World!");
				}
			}
		} catch (SQLException se) {
			System.out.println("Error: " + se.getMessage());
		}

	}

	private void menu() {
		Helper.line(80, "=");
		System.out.println("WELCOME TO MOVIE WORLD");
		Helper.line(80, "=");
		System.out.println("1. View All Movies");
		System.out.println("2. Search for a Movie by Release Year");
		System.out.println("3. Search for a Movie by keyword");
		System.out.println("4. Quit");
	}

	private void viewAll() {

		// TODO P08 Task 2: Write code here to display all movies
		try {
			rs = statement.executeQuery("SELECT movie_id, title, release_date FROM movie");
			String output = String.format("%-10s %-40s %-15s \n", "MOVIE ID", "TITLE", "RELEASE DATE");

			while (rs.next()) {
				int id = rs.getInt("movie_id");
				String title = rs.getString("title");
				LocalDate releaseDate = rs.getDate("release_date").toLocalDate();

				output += String.format("%-10d %-40s %-15s \n", id, title, releaseDate);
			}

			System.out.println(output);
			saveToFile(output);

		}

		catch (SQLException se) {
			System.out.println("Error: " + se.getMessage());
		}

	}

	private void searchByYear() {

		// TODO P08 Task 3: Write code here to display all movies from the year
		// entered by the user.
		try {
			int year = Helper.readInt("Enter release year to search > ");
			int numReleased = 0;
			String sql = String.format("SELECT movie_id, title, release_date FROM MOVIE WHERE YEAR(release_date) = %d",
					year);
			String output = String.format("%-10s %-40s %-10s\n", "MOVIE ID", "TITLE", "RELEASE DATE");

			rs = statement.executeQuery(sql);

			while (rs.next()) {

				LocalDate releaseDate = rs.getDate("release_date").toLocalDate();
				int movieID = rs.getInt("movie_id");
				String title = rs.getString("title");
				numReleased++;
				output += String.format("%-10s %-40s %-10s\n", movieID, title, releaseDate);
			}
			output += "Total number of movies released in this year: " + numReleased;

			if (numReleased > 0) {
				Helper.line(80, "=");
				System.out.println(output);
				saveToFile(output);

			} else {
				System.out.println("NO MOVIES RELEASED IN THIS YEAR");
			}

		} catch (SQLException se) {
			System.out.println("SQL Error: " + se.getMessage());
		}
	}

	private void searchByKeyword() {

		// TODO P08 Task 4: Write code here to display all movies that contain
		// the keyword entered by the user.
		try {
			String keyword = Helper.readString("Enter keyword to search > ");
			int numFound = 0;
			String sql = "SELECT movie_id, title, release_date FROM MOVIE WHERE title LIKE '%" + keyword + "%'";
			String output = String.format("%-10s %-40s %-10s\n", "MOVIE ID", "TITLE", "RELEASE DATE");

			rs = statement.executeQuery(sql);
			while (rs.next()) {

				LocalDate releaseDate = rs.getDate("release_date").toLocalDate();

				int movieID = rs.getInt("movie_id");
				String title = rs.getString("title");
				numFound++;
				output += String.format("%-10s %-40s %-10s\n", movieID, title, releaseDate);
			}

			if (numFound > 0) {
				output += numFound + " movies containing this keyword found.";
				Helper.line(80, "=");
				System.out.println(output);
				saveToFile(output);

			} else {
				System.out.println("NO MOVIES WITH KEYWORD SEARCHED FOUND.");
			}

		} catch (SQLException se) {
			System.out.println("SQL Error: " + se.getMessage());
		}
	}

	private void saveToFile(String output) {
		char saveOption = Helper.readChar("Do you wish to save this results? (Y/N) > ");

		if (saveOption == 'Y' || saveOption == 'y') {
			System.out.println("Writing to file...");

			try {
				File file = new File("movies.txt");
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);

				bw.write(output);
				bw.close();

				System.out.println("File write successful!");

			} catch (IOException io) {
				System.out.println("There was an error writing to the file.");
			}
		}
	}
}
