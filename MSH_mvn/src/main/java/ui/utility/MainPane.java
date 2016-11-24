package ui.utility;

import javafx.scene.layout.HBox;

public class MainPane extends HBox{
	
	private static MainPane mainPane;
	
	private MainPane(){
		super(5);
	}
	
	public static HBox getInstance(){
		if(mainPane == null){
			mainPane = new MainPane();
			mainPane.setStyle("-fx-background-color:whitesmoke;");
		}
		return mainPane;
	}
}
