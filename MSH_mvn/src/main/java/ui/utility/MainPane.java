package ui.utility;

import javafx.scene.layout.HBox;

public class MainPane {
	
	private static HBox mainPane;
	
	private MainPane(){
		
	}
	
	public static HBox getInstance(){
		if(mainPane == null){
			mainPane = new HBox(5);
			mainPane.setStyle("-fx-background-color:whitesmoke;");
		}
		return mainPane;
	}
}
