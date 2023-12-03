package c209_L09;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class SimpleLabelDemo extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		Label label = new Label();
		label.setText("I love C209!");
		label.setPrefWidth(300);		
		label.setAlignment(Pos.CENTER);

		FlowPane pane = new FlowPane();
		pane.getChildren().add(label);
		
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


