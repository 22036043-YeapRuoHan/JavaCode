package c209_L12;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class GridPaneDemo extends Application {

	private GridPane pane = new GridPane();
	private Button button1 = new Button();
	private Button button2 = new Button();
	private Button button3 = new Button();
	private Button button4 = new Button();
	private Button button5 = new Button();

	private static final int MAX_WIDTH = 5000;
	private static final int MAX_HEIGHT = 3000;

	public void start(Stage primaryStage) {
		for (int i=0; i < 2; i++) {
			ColumnConstraints cc = new ColumnConstraints();
			cc.setPercentWidth(50);
			pane.getColumnConstraints().add(cc);
		}

		for (int i=0; i < 3; i++) {
			RowConstraints rc = new RowConstraints();
			rc.setPercentHeight(100/3);
			pane.getRowConstraints().add(rc);
		}
		
		button1.setText("Button 1");		
		button2.setText("Button 2");
		button3.setText("Button 3");
		button4.setText("Long-Named Button 4");
		button5.setText("5");
		
		button1.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
		button2.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
		button3.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
		button4.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
		button5.setMaxSize(MAX_WIDTH, MAX_HEIGHT);
		
		pane.add(button1,0,0);
		pane.add(button2,1,0);
		pane.add(button3,0,1);
		pane.add(button4,1,1);
		pane.add(button5,0,2);

		Scene mainScene = new Scene(pane);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("GridPane Demo");
		primaryStage.setWidth(500);
		primaryStage.setHeight(300);
		primaryStage.show();
	}
}
