package c209_L11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ParticipantRegistration extends Application {
	private VBox pane = new VBox();
	private HBox row1 = new HBox();
	private HBox row2 = new HBox();
	private HBox row3 = new HBox();
	private Label labelName = new Label("Name: ");
	private Label labelNric = new Label("NRIC: ");
	private Label labelOutput = new Label();
	private Label labelMobile = new Label("Mobile Number: ");
	private TextField textfieldName = new TextField();
	private TextField textfieldNRIC = new TextField();
	private TextField textfieldMobile = new TextField();

	private Button buttonAdd = new Button();

	private static final int LABEL_PREFWIDTH = 100;
	private static final int TEXTFIELD_COLUMNCOUNT = 15;
	
	private static final String JDBC_URL = "jdbc:mysql://localhost/demodb";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";
	

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		labelName.setPrefWidth(LABEL_PREFWIDTH);
		labelNric.setPrefWidth(LABEL_PREFWIDTH);
		labelMobile.setPrefWidth(LABEL_PREFWIDTH);
		
		textfieldName.setPrefColumnCount(TEXTFIELD_COLUMNCOUNT);
		textfieldNRIC.setPrefColumnCount(TEXTFIELD_COLUMNCOUNT);
		textfieldMobile.setPrefColumnCount(TEXTFIELD_COLUMNCOUNT);

		EventHandler<ActionEvent> handleInsert = (ActionEvent e) -> doInsertParticipant();
		
		buttonAdd.setOnAction(handleInsert);
		buttonAdd.setText("Add Participant");
		
		row1.getChildren().addAll(labelNric,textfieldNRIC);
		row2.getChildren().addAll(labelName,textfieldName);
		row3.getChildren().addAll(labelMobile,textfieldMobile);
		pane.getChildren().addAll(row1,row2,row3,buttonAdd,labelOutput);

		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(10,10,10,10));
		pane.setSpacing(10);
		Scene mainScene = new Scene(pane);
		
		primaryStage.setTitle("Add a Participant");
		primaryStage.setWidth(320);
		primaryStage.setHeight(230);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public void doInsertParticipant() {

		DBUtil.init(JDBC_URL, DB_USERNAME, DB_PASSWORD);

		String nric = textfieldNRIC.getText();
		String name = textfieldName.getText();
		int mobile = Integer.valueOf(textfieldMobile.getText());

		String insertSQL = String.format("INSERT INTO PARTICIPANT(nric, name, mobile_number) VALUES ('%s', '%s', %d)",
				nric, name, mobile);
		int rowsAffected = DBUtil.execSQL(insertSQL);

		if (rowsAffected == 1) {

			labelOutput.setText("Pariticpant added!");

		} else {
			labelOutput.setText("Insert failed!");
		}

		DBUtil.close();
	}

}