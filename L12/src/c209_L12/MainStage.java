package c209_L12;

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
	private ImageViewDemo demo1=new ImageViewDemo();
	private RadioButtonDemo demo2=new RadioButtonDemo();
	private CheckBoxDemo demo3 = new CheckBoxDemo();
	private GridPaneDemo demo4 = new GridPaneDemo();
	
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
	
		btnDemo1.setText("ImageView Demo");
		btnDemo2.setText("RadioButton Demo");
		btnDemo3.setText("CheckBox Demo");
		btnDemo4.setText("GridPane Demo");

		EventHandler<ActionEvent> demoHandler1 = (ActionEvent e) -> { demo1.start(new Stage()); btnDemo1.setOnAction(null); };
		EventHandler<ActionEvent> demoHandler2 = (ActionEvent e) -> { demo2.start(new Stage()); btnDemo2.setOnAction(null); };
		EventHandler<ActionEvent> demoHandler3 = (ActionEvent e) -> { demo3.start(new Stage()); btnDemo3.setOnAction(null); };
		EventHandler<ActionEvent> demoHandler4 = (ActionEvent e) -> { demo4.start(new Stage()); btnDemo4.setOnAction(null); };
		
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
		
		primaryStage.setTitle("P12 Main Window");
		primaryStage.setWidth(200);
		primaryStage.setHeight(200);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
}
