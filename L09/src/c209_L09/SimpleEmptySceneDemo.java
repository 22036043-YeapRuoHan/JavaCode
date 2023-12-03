package c209_L09;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SimpleEmptySceneDemo extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		FlowPane pane = new FlowPane();
		Scene mainScene = new Scene(pane);
		mainScene.setFill(Color.RED);
		
		primaryStage.setTitle("A Simple Empty Scene");
		primaryStage.setWidth(300);
		primaryStage.setHeight(200);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
}



