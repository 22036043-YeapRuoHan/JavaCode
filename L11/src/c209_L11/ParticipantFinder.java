package c209_L11;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ParticipantFinder extends Application {
	private BorderPane pane = new BorderPane();
	private HBox topHPane = new HBox();
	private VBox topVPane = new VBox();
	private HBox bottomPane = new HBox();

	private Label labelNric = new Label("NRIC: ");
	private TextField textfieldNRIC = new TextField();

	private TextArea textareaParticipant = new TextArea();

	private Button buttonFind = new Button();
	private Button buttonReset = new Button();
	private Button buttonDelete = new Button();

	private static final String NRIC_PATTERN = "[STGF][0-9]{7}[A-Z]";

	// P11 TODO Task 1: Fill in the database details.
	private static final String JDBC_URL = "jdbc:mysql://localhost/demodb";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		textareaParticipant.setPrefColumnCount(20);
		textareaParticipant.setPrefRowCount(5);

		// P11 TODO Task 2: Write the code to complete the start method

		buttonFind.setText("Find");
		buttonReset.setText("Reset");
		buttonReset.setDisable(true);
		buttonDelete.setText("Delete");
		buttonDelete.setDisable(true);

		EventHandler<ActionEvent> handleFind = (ActionEvent e) -> doFindParticipant();
		EventHandler<ActionEvent> handleDelete = (ActionEvent e) -> doDeleteParticipant();
		EventHandler<ActionEvent> handleReset = (ActionEvent e) -> doResetParticipant();

		buttonFind.setOnAction(handleFind);
		buttonDelete.setOnAction(handleDelete);
		buttonReset.setOnAction(handleReset);
		textareaParticipant.setPrefColumnCount(26);
		textareaParticipant.setPrefRowCount(5);
		textareaParticipant.setEditable(false);

		topHPane.getChildren().addAll(labelNric, textfieldNRIC, buttonFind);
		topHPane.setPadding(new Insets(10, 10, 10, 10));
		topHPane.setSpacing(10);
		topHPane.setAlignment(Pos.CENTER);

		bottomPane.getChildren().addAll(buttonDelete, buttonReset);
		bottomPane.setPadding(new Insets(10, 10, 10, 10));
		bottomPane.setSpacing(10);
		bottomPane.setAlignment(Pos.CENTER);

		pane.setTop(topHPane);
		pane.setCenter(textareaParticipant);
		pane.setBottom(bottomPane);

		Scene mainScene = new Scene(pane);

		primaryStage.setTitle("Participant Finder");
		primaryStage.setWidth(300);
		primaryStage.setHeight(200);
		primaryStage.setScene(mainScene);
		primaryStage.show();

	}

	private void doFindParticipant() {
		// P11 TODO Task 3: Write the code to find a participant based on the
		// NRIC the user enters.
		try {
			DBUtil.init(JDBC_URL, DB_USERNAME, DB_PASSWORD);
			String nric = textfieldNRIC.getText();
			boolean isValid = Pattern.matches(NRIC_PATTERN, nric);
			if (isValid) {
				String sql = "SELECT * FROM participant WHERE nric='" + nric + "'";
				ResultSet rs = DBUtil.getTable(sql);
				String output = "";

				if (rs.next()) {
					String name = rs.getString("name");
					int mobile = rs.getInt("mobile_number");
					output += String.format("NRIC: %s \nName: %s \nMobile: %d", nric, name, mobile);

					buttonFind.setDisable(true);
					buttonDelete.setDisable(false);
					buttonReset.setDisable(false);

				} else {
					output = "No such participant";

				}
				textareaParticipant.setText(output);

			} else {
				textareaParticipant.setText("The NRIC you entered is not valid.");
			}
		} catch (SQLException se) {

			se.printStackTrace();

		}

		DBUtil.close();
	}

	private void doDeleteParticipant() {
		// P11 TODO Task 4: Write the code to delete a record in table
		// participant.
		DBUtil.init(JDBC_URL, DB_USERNAME, DB_PASSWORD);
		String nric = textfieldNRIC.getText();
		String deleteSQL = "DELETE FROM participant WHERE nric='" + nric + "'";
		int rowsAffected = DBUtil.execSQL(deleteSQL);
		if (rowsAffected == 1) {
			System.out.println("Pariticpant deleted!");
			textareaParticipant.setText("pariticpant deleted!");
			textfieldNRIC.setText("");

			buttonFind.setDisable(false);
			buttonDelete.setDisable(true);
			buttonReset.setDisable(true);
		} else {
			System.out.println("Delete failed!");
		}
		DBUtil.close();

	}

	private void doResetParticipant() {
		// P11 TODO Task 5: Write the code to reset the ParticpantFinder
		// application.
		textareaParticipant.setText("");
		textfieldNRIC.setText("");
		buttonFind.setDisable(false);
		buttonDelete.setDisable(true);
		buttonReset.setDisable(true);

	}
}
