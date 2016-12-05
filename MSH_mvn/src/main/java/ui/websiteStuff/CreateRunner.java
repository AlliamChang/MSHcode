package ui.websiteStuff;

import java.util.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import ui.utility.*;
import tools.CostType;
import tools.Date;
import tools.PeopleType;

public class CreateRunner extends Application{
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.show();
	}
	
	public static void main(String[] args){
		new CreateStrategyPane();
		launch(args);
	}

}
