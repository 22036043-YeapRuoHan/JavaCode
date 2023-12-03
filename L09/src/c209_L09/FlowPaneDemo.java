package c209_L09;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FlowPaneDemo extends Application {

	private FlowPane pane = new FlowPane();
	private Button button1 = new Button();
	private Button button2 = new Button();
	private Button button3 = new Button();
	private Button button4 = new Button();
	private Button button5 = new Button();

	public static void main(String[] args) {
		launch(args);
	}
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		button1.setText("Button 1");
		pane.getChildren().add(button1);

		button2.setText("Button 2");
		pane.getChildren().add(button2);

		button3.setText("Button 3");
		pane.getChildren().add(button3);

		button4.setText("Long-Named Button 4");
		pane.getChildren().add(button4);

		button5.setText("5");
		pane.getChildren().add(button5);

		Scene mainScene = new Scene(pane);
		primaryStage.setTitle("FlowPane Demo");
		primaryStage.setWidth(500);
		primaryStage.setHeight(100);
		primaryStage.setScene(mainScene);
		primaryStage.show();
		
	}
}
