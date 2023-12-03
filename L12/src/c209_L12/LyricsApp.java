package c209_L12;

import java.text.MessageFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import javafx.stage.Stage;

public class LyricsApp extends Application {

	private GridPane pane = new GridPane();
	private ImageView imgVCow = new ImageView("file:cow.png");
	private ImageView imgVDuck = new ImageView("file:duck.png");
	private TextArea txtAreaLyrics = new TextArea();
	private RadioButton radioCow = new RadioButton();
	private RadioButton radioDuck = new RadioButton();
	private CheckBox checkBoxCow = new CheckBox();
	private CheckBox checkBoxDuck = new CheckBox();
	private ToggleGroup group = new ToggleGroup();

	private static final int MAX_WIDTH = 5000;
	private static final int MAX_HEIGHT = 3000;
	private static final String TEMPLATE = 			
			"Old MACDONALD had a farm\n" + 
	        "E-I-E-I-O\n" + 
	        "And on his farm he had a {0} \n" + 
            "E-I-E-I-O\n" + 
	        "With a {1} {1} here\n" +
	        "And a {1} {1} there\n" + 
            "Here a {1} , there a {1}\n" + 
	        "Everywhere a {1} {1} \n" +
	        "Old MacDonald had a farm\n" + 
	        "E-I-E-I-O\n" +
	        "-------------------------------------------\n";
	    

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		// P12 - TODO Task 1 - Complete the start method
		ImageView imgVCow = new ImageView("file:cow.png");
		
		txtAreaLyrics.setPrefColumnCount(10);
		txtAreaLyrics.setPrefRowCount(10);
		txtAreaLyrics.setText(retrieveLyrics("cow"));

		checkBoxCow.setSelected(true);

		EventHandler<ActionEvent> handleRadio = (ActionEvent e) -> doChangeAnimal(e);
		checkBoxCow.setOnAction(handleRadio);
		checkBoxDuck.setOnAction(handleRadio);

		checkBoxCow.setText("cow");
		checkBoxCow.setUserData("cow");

		checkBoxDuck.setText("Duck");
		checkBoxDuck.setUserData("Duck");

		HBox rdPane = new HBox();
		rdPane.setPadding(new Insets(10, 0, 10, 10));
		rdPane.setSpacing(10);
		rdPane.setAlignment(Pos.CENTER);
		rdPane.getChildren().addAll(checkBoxCow, checkBoxDuck);

		txtAreaLyrics.setMaxSize(MAX_WIDTH, MAX_HEIGHT);

		for (int i = 0; i < 3; i++) {
			RowConstraints rc = new RowConstraints();
			if (i == 1)
				rc.setMinHeight(150);
			if (i == 2)
				rc.setVgrow(Priority.ALWAYS);
			pane.getRowConstraints().add(rc);
		}
		imgVDuck.setVisible(false);
		HBox imgVPane = new HBox();
		imgVPane.setAlignment(Pos.CENTER);
		imgVPane.setSpacing(10);
		imgVPane.getChildren().addAll(imgVCow, imgVDuck);

		pane.add(rdPane, 0, 0);
		pane.add(imgVPane, 0, 1);
		pane.add(txtAreaLyrics, 0, 2);
		GridPane.setMargin(txtAreaLyrics, new Insets(10));
		pane.setAlignment(Pos.TOP_CENTER);

		Scene mainScene = new Scene(pane);
		
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Lyrics App");
		primaryStage.setWidth(250);
		primaryStage.setHeight(450);
		primaryStage.show();
	}

	public String retrieveLyrics(String animal) {

		String animalSound = null;

		if (animal.equalsIgnoreCase("cow")) {
			animalSound = "MOO";
		} else {
			animalSound = "QUACK";
		}

		String lyrics = MessageFormat.format(TEMPLATE, animal.toUpperCase(), animalSound);
		

		return lyrics;
	}

	public void doChangeAnimal(ActionEvent e) {
		String lyrics = "";
		lyrics += checkBoxCow.isSelected() ? retrieveLyrics(checkBoxCow.getUserData().toString()) : "";
		lyrics += checkBoxDuck.isSelected() ? retrieveLyrics(checkBoxDuck.getUserData().toString()) : "";

		imgVCow.setVisible(checkBoxCow.isSelected());
		imgVDuck.setVisible(checkBoxDuck.isSelected());
		txtAreaLyrics.setText(lyrics);
	}
}





















