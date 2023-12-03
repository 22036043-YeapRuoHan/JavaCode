package c209_L11;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextAreaDemo extends Application {

	private TextArea textarea = new TextArea();
	private FlowPane pane = new FlowPane();

	@Override
	public void start(Stage stage) {
		// TODO Auto-generated method stub
		textarea.setPrefColumnCount(20);
		textarea.setPrefRowCount(5);
		
		textarea.setText("Line 1\nLine 2\nLine 3");
		textarea.setEditable(false);
		pane.getChildren().add(textarea);

		pane.setAlignment(Pos.CENTER);
		Scene mainScene = new Scene(pane);
		
		stage.setTitle("TextArea Demo");
		stage.setWidth(300);
		stage.setHeight(200);
		stage.setScene(mainScene);
		stage.show();
	}
}


