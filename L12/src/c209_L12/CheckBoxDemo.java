package c209_L12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxDemo extends Application {
	private CheckBox hobby1 = new CheckBox("Swimming");
	private CheckBox hobby2 = new CheckBox("Running");
	private CheckBox hobby3 = new CheckBox("Reading");
	private Label labelHobbies = new Label();

	public void start(Stage primaryStage) {
		hobby1.setPrefWidth(100);
		hobby2.setPrefWidth(100);
		hobby3.setPrefWidth(100);
		
		hobby1.setUserData("Swimming");
		hobby2.setUserData("Running");		
		hobby3.setUserData("Reading");
		
		EventHandler<ActionEvent> handleCheckBox = (ActionEvent e) -> doChooseHobby();
		hobby1.setOnAction(handleCheckBox);
		hobby2.setOnAction(handleCheckBox);
		hobby3.setOnAction(handleCheckBox);
		
		HBox checkBoxesPane = new HBox();
		checkBoxesPane.setAlignment(Pos.CENTER);
		checkBoxesPane.setSpacing(10);
		checkBoxesPane.getChildren().addAll(hobby1,hobby2,hobby3);

		labelHobbies.setAlignment(Pos.CENTER);
		
		VBox hobbiesPane = new VBox();
		hobbiesPane.setAlignment(Pos.TOP_CENTER);
		hobbiesPane.setPadding(new Insets(10));
		hobbiesPane.setSpacing(10);
		hobbiesPane.getChildren().addAll(checkBoxesPane,labelHobbies);
		
		Scene mainScene = new Scene(hobbiesPane);

		primaryStage.setScene(mainScene);
		primaryStage.setTitle("CheckBox Demo");
		primaryStage.setWidth(300);
		primaryStage.setHeight(100);
		primaryStage.show();
	}
	
	public void doChooseHobby() {
		String hobbies = "";

		hobbies += hobby1.isSelected()?hobby1.getUserData():"";
		hobbies += hobby2.isSelected()?(hobbies.isEmpty()?"":",")+hobby2.getUserData():"";		
		hobbies += hobby3.isSelected()?(hobbies.isEmpty()?"":",")+hobby3.getUserData():"";	
		
		String output = String.format("Your hobbies are: %s", hobbies);
		labelHobbies.setText(output);
	}
}

