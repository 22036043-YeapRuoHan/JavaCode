package c209_L09;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class SimpleHelloDemo extends Application {

	private FlowPane pane = new FlowPane();
	private TextField textfield = new TextField();
	private Label label = new Label();
	private Button button = new Button();
	private Label labelOutput = new Label();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {
		textfield.setPrefColumnCount(10);

		label.setText("Enter your name: ");

		button.setText("Say Hello");
			
		EventHandler<ActionEvent> handleHello = (ActionEvent e) -> doSayHello();
		button.setOnAction(handleHello);

		pane.setAlignment(Pos.TOP_CENTER);
		pane.getChildren().addAll(label,textfield,button,labelOutput);		
		Scene mainScene = new Scene(pane);
	
		primaryStage.setTitle("Hello");
		primaryStage.setWidth(350);
		primaryStage.setHeight(100);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public void doSayHello() {
		labelOutput.setText("Hello " + textfield.getText() + "!");
	}
}



