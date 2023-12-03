package c209_L11;

import java.sql.ResultSet;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 22036043, Aug 1, 2023 2:21:59 PM
 * 
 * 
 * @author 22036043
 *
 */
public class RunSingapore extends Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		Button btnRegister = new Button();
		Button btnFind = new Button();
		btnRegister.setPrefWidth(160);
		btnFind.setPrefWidth(160);
		btnRegister.setText("Register Particpant");
		btnFind.setText("Find Participant");
		
		EventHandler<ActionEvent> registerHandler = (ActionEvent e) -> (new ParticipantRegistration()).start(new Stage());
		EventHandler<ActionEvent> findHandler = (ActionEvent e) -> (new ParticipantFinder()).start(new Stage());
		btnRegister.setOnAction(registerHandler);
		btnFind.setOnAction(findHandler);
		
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5, 5, 5, 5));
		pane.setSpacing(10);
		pane.getChildren().addAll(btnRegister, btnFind);
		
		Scene mainScene = new Scene(pane);
		
		primaryStage.setTitle("Run Singapore");
		primaryStage.setWidth(300);
		primaryStage.setHeight(120);
		primaryStage.setScene(mainScene);
		primaryStage.show();

	}

}
