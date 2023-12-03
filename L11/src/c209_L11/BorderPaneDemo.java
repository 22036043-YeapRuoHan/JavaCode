package c209_L11;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.Scene;

public class BorderPaneDemo extends Application {

	private BorderPane pane = new BorderPane();
	private Button button1 = new Button();
	private Button button2 = new Button();
	private Button button3 = new Button();
	private Button button4 = new Button();
	private Button button5 = new Button();
	
	private static final int MAX_WIDTH = 5000;
	private static final int MAX_HEIGHT = 3000;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		button1.setText("Button 1 (TOP)");
		button1.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
		pane.setTop(button1);

		button2.setText("Button 2 (CENTER)");
		button2.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
		pane.setCenter(button2);

		button3.setText("Button 3 (LEFT)");
		button3.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
		pane.setLeft(button3);

		button4.setText("Long-Named Button 4 (BOTTOM)");
		button4.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
		pane.setBottom(button4);

		button5.setText("5 (RIGHT)");
		button5.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
		pane.setRight(button5);
		
		BorderPane.setAlignment(button1, Pos.CENTER);
		BorderPane.setAlignment(button2, Pos.CENTER);
		BorderPane.setAlignment(button3, Pos.CENTER);
		BorderPane.setAlignment(button4, Pos.CENTER);
		BorderPane.setAlignment(button5, Pos.CENTER);

		Scene mainScene = new Scene(pane);
		primaryStage.setScene(mainScene);
		
		primaryStage.setTitle("BorderPane Demo");
		primaryStage.setWidth(500);
		primaryStage.setHeight(300);
		primaryStage.show();
	}
}
