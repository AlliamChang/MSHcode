package runner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import ui.*;
public class Runner extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primary.setScene(new Scene(parent.createparent(),800,600,Color.BLACK));
		 primary.setResizable(false);
		primary.show();
	}
	
	public static void main(String []args){
		launch(args);
	}

}
