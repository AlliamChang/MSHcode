package runner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.websiteStuff.*;
import ui.utility.MainPane;

public class WebStuffRunner extends Application{
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.show();
	}
	
	public static void main(String[] args){
		WebsitePaneController.getInstance().init();
		launch(args);
	}

}
