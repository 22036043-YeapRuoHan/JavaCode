package c209_L12;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ImageViewDemo extends Application {

	public void start(Stage primaryStage) {
		FlowPane pane = new FlowPane();
		ImageView imgV = new ImageView("file:duck.png");
	
		pane.setAlignment(Pos.CENTER);
		pane.getChildren().add(imgV);

		Scene mainScene = new Scene(pane);
		
		primaryStage.setTitle("ImageView Demo");
		primaryStage.setWidth(300);
		primaryStage.setHeight(200);
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}
}


