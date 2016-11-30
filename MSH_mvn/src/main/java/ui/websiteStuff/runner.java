package ui.websiteStuff;

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import ui.utility.MainPane;
import ui.websiteStuff.*;

public class runner extends Application{
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.show();
	}
	
	public static void main(String[] args){
		new WebStuffStartPane("1",1,1,1,"1","1","1",null);
		launch(args);
	}

}
