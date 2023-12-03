package c209_L12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RadioButtonDemo extends Application {
	private HBox pane = new HBox();
	private Label labelColor = new Label();
	private RadioButton radioRed = new RadioButton("Red");
	private RadioButton radioBlue = new RadioButton("Blue");

	public void start(Stage primaryStage) {
		labelColor.setText("I love RP!");
		
		ToggleGroup group = new ToggleGroup();
		radioRed.setToggleGroup(group);
		radioBlue.setToggleGroup(group);

		radioRed.setUserData("#FF0000");
		radioBlue.setUserData("#0000FF");
		
		EventHandler<ActionEvent> handleRadio = (ActionEvent e) -> doChangeColour(e);
		radioRed.setOnAction(handleRadio);
		radioBlue.setOnAction(handleRadio);
		pane.setSpacing(10);
		pane.setAlignment(Pos.TOP_CENTER);
		pane.setPadding(new Insets(10));
		pane.getChildren().addAll(radioRed,radioBlue);
		pane.getChildren().add(labelColor);		
		
		Scene mainScene = new Scene(pane);

		primaryStage.setTitle("RadioButton Demo");
		primaryStage.setWidth(300);
		primaryStage.setHeight(80);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public void doChangeColour(ActionEvent e) {
		RadioButton rd = (RadioButton)e.getSource();
		labelColor.setBackground(new Background(new 
				BackgroundFill(
						Color.web(rd.getUserData().toString()), 
						new CornerRadii(5.0), new Insets(-5.0))));
	}
}
