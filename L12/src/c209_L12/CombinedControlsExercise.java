package c209_L12;


import java.text.MessageFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CombinedControlsExercise extends Application {
	private RadioButton hobby1 = new RadioButton("Swimming");
	private RadioButton hobby2 = new RadioButton("Running");
	private RadioButton hobby3 = new RadioButton("Reading");
	private TextArea activityArea = new TextArea();
	private static final String TEMPLATE = "I like {0}. I {1} everyday!\n{0} is very fun!";

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		// P12 - TODO Task 1: Create a toggle group and set the radio buttons to
		// the group
		ToggleGroup grp = new ToggleGroup();
		hobby1.setToggleGroup(grp);
		hobby2.setToggleGroup(grp);
		hobby3.setToggleGroup(grp);
		
		// P12 - TODO Task 2: Set the user data of the three radio buttons to
		// swim, run and read respectively
		hobby1.setUserData("swim");
		hobby2.setUserData("run");
		hobby3.setUserData("read");
		
		// P12 - TODO Task 3: Add action listeners to each radio button. When
		// selected, doChooseHobby method should be triggered.
		EventHandler<ActionEvent> handleHobby =(e) -> doChooseHobby(e);
		hobby1.setOnAction(handleHobby);
		hobby2.setOnAction(handleHobby);
		hobby3.setOnAction(handleHobby);


		
		// P12 - TODO Task 4: Prepare a HBox and add the radio buttons in
		HBox hobbiesPane = new HBox();
		hobbiesPane.setAlignment(Pos.CENTER);
		hobbiesPane.setPadding(new Insets(10));
		hobbiesPane.setSpacing(10);
		hobbiesPane.getChildren().addAll(hobby1,hobby2,hobby3);

		// P12 - TODO Task 5: Configure the TextArea to be 5 rows and 25 columns,
		// set the max width and height to a large number so that TextArea can scale
		
		activityArea.setPrefColumnCount(25);
		activityArea.setPrefRowCount(5);
		activityArea.setMaxHeight(3000);
		activityArea.setMaxWidth(3000);
	  //activityArea.setMaxSize(3000,3000);
		
		// P12 - TODO Task 6: Prepare a VBox and add the HBox and the TextArea to the pane.
		
		VBox pane = new VBox();
		pane.setAlignment(Pos.TOP_CENTER);
		pane.getChildren().addAll(hobbiesPane,activityArea);

		// P12 - TODO Task 7: Prepare a scene with the VBox as the root node and set the 
		// scene as the main scene of the primaryStage
		
		Scene mainScene = new Scene(pane);
		primaryStage.setScene(mainScene);
		
		primaryStage.setTitle("Combined Controls Exercise");
		primaryStage.setWidth(300);
		primaryStage.setHeight(200);
		primaryStage.show();
	}

	public void doChooseHobby(ActionEvent e) {
		// P12 - TODO Task 8: Prepare a radio button variable and assign the event source to it
		// you need to cast it to radio button
		RadioButton rd =(RadioButton)e.getSource();
		


		
		// P12 - TODO Task 9: Prepare the output using MessageFormat using the text and user data
		// of radio button

		String output = MessageFormat.format(TEMPLATE,rd.getText(),rd.getUserData());


		// P12 - TODO Task 10: Set output to the TextArea.
		
		activityArea.setText(output);


	}

}
