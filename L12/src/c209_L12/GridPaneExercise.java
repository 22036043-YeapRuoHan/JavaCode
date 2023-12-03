package c209_L12;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class GridPaneExercise extends Application {
	private GridPane pane = new GridPane();

	private ImageView imgVCat1 = new ImageView("file:cat.png");
	private ImageView imgVCat2 = new ImageView("file:cat.png");
	private ImageView imgVCat3 = new ImageView("file:cat.png");
	private ImageView imgVCat4 = new ImageView("file:cat.png");

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) {

		// P12 - TODO Task 1: Set up the column constraints 
		
		for(int i=0;i<2;i++) {
			ColumnConstraints cc = new ColumnConstraints();
			cc.setPercentWidth(50);
			cc.setHalignment(HPos.CENTER);
			pane.getColumnConstraints().add(cc);
		}



		// P12 - TODO Task 2: Set up the row constraints 

		for(int i=0;i<2;i++) {
			RowConstraints rc = new RowConstraints();
			rc.setPercentHeight(50);
			rc.setValignment(VPos.CENTER);
			pane.getRowConstraints().add(rc);
		}
		
		// P12 - TODO Task 3: Add the image views to the grid pane
		// and assign them to the correct cell
		
		pane.add(imgVCat1, 0, 0);
		pane.add(imgVCat2, 1, 0);
		pane.add(imgVCat3, 0, 1,2,1);
		


		Scene mainScene = new Scene(pane);
		
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("GridPane Exercise");
		primaryStage.setWidth(500);
		primaryStage.setHeight(500);
		primaryStage.show();
	}

}
