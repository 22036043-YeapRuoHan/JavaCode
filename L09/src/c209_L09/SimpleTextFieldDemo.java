package c209_L09;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class SimpleTextFieldDemo extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		TextField textField = new TextField();
		textField.setPrefColumnCount(20);
		
		FlowPane pane = new FlowPane();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.getChildren().add(textField);
		
		Scene mainScene = new Scene(pane);
	
		primaryStage.setTitle("A Simple Frame");
		primaryStage.setWidth(300);
		primaryStage.setHeight(200);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}

