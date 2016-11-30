package ui.utility;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;

public class MainPane extends HBox{
	
	private static MainPane mainPane;
	public static final double MINWIDTH = 655,MINHEIGHT = 610;
	
	private MainPane(){
		super(5);
	}
	
	public static MainPane getInstance(){
		if(mainPane == null){
			mainPane = new MainPane();
			mainPane.setStyle("-fx-background-color:whitesmoke;");
		}
		return mainPane;
	}
	
	public void setNavigationBar(MyNavigationBar bar){
		if(mainPane.getChildren().size() > 0)
			mainPane.getChildren().set(0, bar);
		else
			mainPane.getChildren().add(bar);
	}
	
	public void setRightPane(Parent rightPane){
		if(mainPane.getChildren().size() >= 2){
			mainPane.getChildren().remove(1);
			mainPane.getChildren().add(rightPane);
		}else{
			mainPane.getChildren().add(rightPane);
		}
	}
}
