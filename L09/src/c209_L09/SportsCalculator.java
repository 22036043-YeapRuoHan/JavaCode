package c209_L09;

import java.util.regex.Pattern;

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

public class SportsCalculator extends Application {

	private Button buttonCalculate = new Button();
	private Button buttonReset = new Button();
	private FlowPane pane = new FlowPane();

	private TextField textfieldName = new TextField();
	private TextField textfieldGender = new TextField();
	private TextField textfieldAge = new TextField();
	private TextField textfieldRHR = new TextField();
	private TextField textfieldMHR = new TextField();
	private TextField textfieldTHR = new TextField();
	private TextField textfieldV02Max = new TextField();

	private Label labelInName = new Label();
	private Label labelInGender = new Label();
	private Label labelInAge = new Label();
	private Label labelInRHR = new Label();

	private Label labelMHR = new Label();
	private Label labelTHR = new Label();
	private Label labelV02Max = new Label();

	private Label labelFeedback = new Label();

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		// TODO P10 - Task 1: Set the number of columns required for the textfields
		textfieldName.setPrefColumnCount(20);
		textfieldGender.setPrefColumnCount(20);
		textfieldAge.setPrefColumnCount(20);
		textfieldRHR.setPrefColumnCount(20);
		textfieldMHR.setPrefColumnCount(20);
		textfieldTHR.setPrefColumnCount(20);
		textfieldV02Max.setPrefColumnCount(20);

		// TODO P10 - Task 2: Set the maximum heart rate, training heart rate, v02max
		// text fields to be non-editable.
		textfieldMHR.setEditable(false);
		textfieldTHR.setEditable(false);
		textfieldV02Max.setEditable(false);

		// TODO P10 - Task 3: Set the text for the labels
		labelInName.setText("Enter Name: ");
		labelInGender.setText("Enter Gender: ");
		labelInAge.setText("Enter Age: ");
		labelInRHR.setText("Enter RHR: ");
		labelMHR.setText("Maximum Heart Rate: ");
		labelTHR.setText("Training Heart Rate: ");
		labelV02Max.setText("V02Max: ");

		// TODO P10 - Task 4: Set the text for the button and register a listener object
		// for the ActionEvent. You should use lambda expressions.
		buttonCalculate.setText("Calculate");
		EventHandler<ActionEvent> handleCalculate = (ActionEvent e) -> doCalculate();
		buttonCalculate.setOnAction(handleCalculate);

		buttonReset.setText("Reset");
		buttonReset.setOnAction((ActionEvent e) -> doReset());

		// TODO P10 - Task 5: Add all the controls to the pane and align all controls in
		// the pane to be top center.
		pane.setAlignment(Pos.TOP_CENTER);
		pane.getChildren().addAll(labelInName, textfieldName);
		pane.getChildren().addAll(labelInGender, textfieldGender);
		pane.getChildren().addAll(labelInAge, textfieldAge);
		pane.getChildren().addAll(labelInRHR, textfieldRHR);
		pane.getChildren().addAll(labelMHR, textfieldMHR);
		pane.getChildren().addAll(labelTHR, textfieldTHR);
		pane.getChildren().addAll(labelV02Max, textfieldV02Max);
		pane.getChildren().addAll(buttonCalculate, buttonReset, labelFeedback);

		// TODO P10 - Task 6: Create the mainScene
		Scene mainScene = new Scene(pane);

		// TODO P10 - Task 7: Set the title and size of the frame
		primaryStage.setTitle("Sports Calculator");
		primaryStage.setWidth(275);
		primaryStage.setHeight(400);

		// TODO P10 - Task 8: Set mainScene as the root scene of primaryStage
		primaryStage.setScene(mainScene);

		// TODO P10 - Task 9: Show primaryStage
		primaryStage.show();
	}

	public void doCalculate() {
		// TODO P10 - Task 10: Calculate and display the maximum heart rate, training
		// heart rate, and v02max.
		String name = textfieldName.getText();
		String gender = textfieldGender.getText();
		String age = textfieldAge.getText();
		String rhr = textfieldRHR.getText();

		String patternNoSpace = "\\s*";
		String patternAge = "\\d{1,3}";
		String patternRhr = "\\d{2,3}";
		if (Pattern.matches(patternNoSpace, name) || Pattern.matches(patternNoSpace, gender)
				|| Pattern.matches(patternNoSpace, age) || Pattern.matches(patternNoSpace, rhr))
			labelFeedback.setText("please fill in everything!");
		else if (!Pattern.matches(patternAge, age))
			labelFeedback.setText("Age is invalid.");
		else if (!Pattern.matches(patternRhr, rhr)) {
			labelFeedback.setText("RHR is invalid.");
		}

		else {
			int mHR = 220 - Integer.valueOf(textfieldAge.getText());
			double tHR = 0.8 * mHR;
			double v02Max = (15 * mHR) / Integer.valueOf(textfieldRHR.getText());
			textfieldMHR.setText(String.valueOf(mHR));
			textfieldTHR.setText(String.valueOf(tHR));
			textfieldV02Max.setText(String.valueOf(v02Max));
		}

	}

	public void doReset() {
		textfieldName.setText("");
		textfieldGender.setText("");
		textfieldAge.setText("");
		textfieldRHR.setText("");
		textfieldMHR.setText("");
		textfieldTHR.setText("");
		textfieldV02Max.setText("");
	}
}
