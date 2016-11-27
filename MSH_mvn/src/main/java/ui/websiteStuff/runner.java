package ui.websiteStuff;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import ui.websiteStuff.*;

public class runner extends Application{
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(new StartPane("1",1,1,1,"1","1","1"),800,600));
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
