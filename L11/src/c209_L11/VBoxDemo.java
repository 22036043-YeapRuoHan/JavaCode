package c209_L11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxDemo extends Application {

	private VBox pane = new VBox();
	private Button button1 = new Button();
	private Button button2 = new Button();
	private Button button3 = new Button();
	private Button button4 = new Button();
	private Button button5 = new Button();

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(10,10,10,10));
		pane.setSpacing(10);
		
		button1.setText("Button 1");
		button2.setText("Button 2");
		button3.setText("Button 3");
		button4.setText("Long-Named Button 4");
		button5.setText("5");
		pane.getChildren().addAll(button1, button2, button3, button4, button5);

		Scene mainScene = new Scene(pane);

		primaryStage.setTitle("VBox Demo");
		primaryStage.setWidth(100);
		primaryStage.setHeight(250);
		primaryStage.setScene(mainScene);
		primaryStage.show();		
	}
}


