package c209_L13;

import java.sql.ResultSet;
import java.sql.SQLException;

import c209_L08.DBUtil;
import c209_L08.Participant;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

public class TableViewExample extends Application {

	private TableView<Participant> tableView = new TableView<>();
	private TextField nricField = new TextField();
	private TextField nameField = new TextField();
	private TextField mobileField = new TextField();
	private Button addBtn = new Button("Add");
	private Button deleteBtn = new Button("Delete");
	private HBox fieldsBox = new HBox();
	private HBox buttonsBox = new HBox();
	private VBox vPane = new VBox();
	private Label lbStatus = new Label("");

	// Create an ObservableList
	private ObservableList<Participant> participants = FXCollections.observableArrayList();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		String jdbcURL = "jdbc:mysql://localhost/demodb";
		String dbUsername = "root";
		String dbPassword = "";
		DBUtil.init(jdbcURL, dbUsername, dbPassword);

		loadParticipants();

		// Create columns for your TableView
		TableColumn<Participant, String> nricColumn = new TableColumn<Participant, String>("NRIC");
		nricColumn.setCellValueFactory(new PropertyValueFactory<Participant, String>("nric"));

		TableColumn<Participant, String> nameColumn = new TableColumn<Participant, String>("NAME");
		nameColumn.setCellValueFactory(new PropertyValueFactory<Participant, String>("name"));

		TableColumn<Participant, Integer> mobileColumn = new TableColumn<Participant, Integer>("MOBILE NUMBER");
		mobileColumn.setCellValueFactory(new PropertyValueFactory<Participant, Integer>("mobileNum"));

		tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);

		// Add columns to your TableView
		tableView.getColumns().add(nricColumn);
		tableView.getColumns().add(nameColumn);
		tableView.getColumns().add(mobileColumn);

		nricField.setPromptText("NRIC");
		nameField.setPromptText("Name");
		mobileField.setPromptText("Mobile");

		fieldsBox.getChildren().addAll(nricField, nameField, mobileField);
		fieldsBox.setAlignment(Pos.CENTER);
		fieldsBox.setSpacing(10);

		// Add button click-action
		addBtn.setOnAction(e -> add());

		// Delete button click-action
		deleteBtn.setOnAction(e -> delete());

		// Edit mobile number
		tableView.setEditable(true);
		mobileColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
		mobileColumn.setOnEditCommit(e -> update(e));

		buttonsBox.getChildren().addAll(addBtn, deleteBtn);
		buttonsBox.setAlignment(Pos.CENTER);
		buttonsBox.setSpacing(10);

		vPane.getChildren().addAll(tableView, fieldsBox, buttonsBox);
		vPane.setSpacing(10);
		vPane.setPadding(new Insets(10, 10, 10, 10));
		vPane.setAlignment(Pos.TOP_CENTER);

		Scene mainScene = new Scene(vPane);
		primaryStage.setTitle("Contest Registration");
		primaryStage.setWidth(600);
		primaryStage.setHeight(400);
		primaryStage.setScene(mainScene);
		primaryStage.show();

	}

	private void loadParticipants() {
		// Create some Participant objects
//		participants.add(new Participant("S1234567A","Alice",81234567));
//		participants.add(new Participant("S2345678B","Bob",82345678));
//		participants.add(new Participant("S3456789C","Charlie",87654321));

		// Retrieve Participant objects from database
		String sql = "SELECT nric, name, mobile_number FROM participant";
		ResultSet rs = DBUtil.getTable(sql);

		try {
			while (rs.next()) {
				// User getXXX methods to extract data from rs ResultSet
				String nric = rs.getString("nric");
				String name = rs.getString("name");
				int mobileNum = rs.getInt("mobile_number");

				// Create new participant
				Participant p = new Participant(nric, name, mobileNum);

				// Add new participant into pList
				participants.add(p);
			}

		} catch (SQLException e) {
			System.out.println("SQL Error: " + e.getMessage());
		}

		tableView.setItems(participants);
	}

	private void add() {

		String name = nameField.getText();
		String nric = nricField.getText();
		int mobileNumber = Integer.parseInt((mobileField.getText()));

		Participant p = new Participant(nric, name, mobileNumber);
		participants.add(p);

		String insertSql = "INSERT INTO participant(nric, name, mobile_number) VALUES('" + nric + "', '" + name + "', "
				+ mobileNumber + ")";
		int rowsAdded = DBUtil.execSQL(insertSql);

		if (rowsAdded == 1) {

			lbStatus.setText("Participant with NRIC " + nric + " registered!");

		} else {
			lbStatus.setText("Registration failed!");
		}

	}

	private void delete() {
		int row = tableView.getSelectionModel().getSelectedIndex();
		Participant remove = participants.get(row);
		if (row >= 0) {

			participants.remove(row);

			String deleteSQL = "DELETE FROM participant WHERE nric='" + remove.getNric() + "'";
			int rowsDeleted = DBUtil.execSQL(deleteSQL);

			if (rowsDeleted == 1) {
				lbStatus.setText("Applicant removed!");

			} else {
				lbStatus.setText("Removal failed!");
			}
			DBUtil.close();
		}
	}

	private void update(CellEditEvent<Participant, Integer> e) {
		Participant p = e.getRowValue();
		p.setMobileNum(e.getNewValue());

		String updateSQL = "UPDATE participant SET mobile_number = " + e.getNewValue() + " WHERE nric='" + p.getNric()
				+ "'";
		int rowsUpdated = DBUtil.execSQL(updateSQL);

		if (rowsUpdated == 1) {

			lbStatus.setText("Applicant contact info updated to " + p.getMobileNum() + "!");

		} else {
			lbStatus.setText("Updating failed!");
		}
		DBUtil.close();
	}

}
