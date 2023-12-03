package c209_L09;

import javafx.application.Application;
import javafx.stage.Stage;

public class SimpleStageDemo extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {		
		primaryStage.setTitle("A Simple Frame");
		primaryStage.setWidth(300);
		primaryStage.setHeight(200);
		primaryStage.show();
	}
}

