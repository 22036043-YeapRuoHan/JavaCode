package c209_L11;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainStage extends Application {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button btnDemo1 = new Button();
		Button btnDemo2 = new Button();
		Button btnDemo3 = new Button();
		Button btnDemo4 = new Button();

		btnDemo1.setPrefWidth(160);
		btnDemo2.setPrefWidth(160);
		btnDemo3.setPrefWidth(160);
		btnDemo4.setPrefWidth(160);
	
		btnDemo1.setText("Text Area Demo");
		btnDemo2.setText("VBox Demo");
		btnDemo3.setText("HBox Demo");
		btnDemo4.setText("Border Pane Demo");

		EventHandler<ActionEvent> demoHandler1 = (ActionEvent e) -> (new TextAreaDemo()).start(new Stage());
		EventHandler<ActionEvent> demoHandler2 = (ActionEvent e) -> (new VBoxDemo()).start(new Stage());
		EventHandler<ActionEvent> demoHandler3 = (ActionEvent e) -> (new HBoxDemo()).start(new Stage());
		EventHandler<ActionEvent> demoHandler4 = (ActionEvent e) -> (new BorderPaneDemo()).start(new Stage());
		
		btnDemo1.setOnAction(demoHandler1);
		btnDemo2.setOnAction(demoHandler2);
		btnDemo3.setOnAction(demoHandler3);
		btnDemo4.setOnAction(demoHandler4);
		
		VBox pane = new VBox();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(5,5,5,5));
		pane.setSpacing(10);
		pane.getChildren().addAll(btnDemo1, btnDemo2, btnDemo3, btnDemo4);
		
		Scene mainScene = new Scene(pane);
		
		primaryStage.setTitle("P11 Main Window");
		primaryStage.setWidth(200);
		primaryStage.setHeight(200);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
}
