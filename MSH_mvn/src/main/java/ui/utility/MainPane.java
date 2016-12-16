package ui.utility;

import java.util.concurrent.ExecutionException;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainPane extends StackPane{
	
	private static MainPane mainPane;
	public static final double MINWIDTH = 655,MINHEIGHT = 610;
	private HBox bottomPane;
	private AnchorPane frontPane;
	private ProgressIndicator p1;
	private boolean isLogin;
	private boolean isLoad = true;
	
	private MainPane(){
		super();
		isLogin = false;
		
		bottomPane = new HBox(5);
		this.getChildren().add(bottomPane);
		
		frontPane = new AnchorPane();
		p1 = new ProgressIndicator();
        p1.setPrefSize(50, 50);
        AnchorPane.setLeftAnchor(p1, 375.0);
        AnchorPane.setTopAnchor(p1, 275.0);
        frontPane.getChildren().add(p1);
//        frontPane.setVisible(false);
        this.getChildren().add(frontPane);
	}
	
	public static MainPane getInstance(){
		if(mainPane == null){
			mainPane = new MainPane();
			mainPane.setStyle("-fx-background-color:white;");
		}
		return mainPane;
	}
	
	public void login(){
		isLogin = true;
	}
	
	public boolean isLogin(){
		return isLogin;
	}
	
	public void logout(){
		isLogin = false;
	}
	
	public void setNavigationBar(MyNavigationBar bar){
		if(mainPane.bottomPane.getChildren().size() > 0)
			mainPane.bottomPane.getChildren().set(0, bar);
		else
			mainPane.bottomPane.getChildren().add(bar);
	}
	
	public void setRightPane(Parent rightPane){

		Task<Boolean> task = new WaitingTask();
		mainPane.frontPane.visibleProperty().bind(task.runningProperty());
		new Thread(task).start();
		
		if(mainPane.bottomPane.getChildren().size() >= 2){
			mainPane.bottomPane.getChildren().remove(1);
			mainPane.bottomPane.getChildren().add(rightPane);
		}else{
			mainPane.bottomPane.getChildren().add(rightPane);
		}
	}
	
	public void setRightPane(Task<Parent> task){
		if(mainPane.bottomPane.getChildren().size() >= 2){
			mainPane.bottomPane.getChildren().remove(1);
		}
		
		mainPane.frontPane.visibleProperty().bind(task.runningProperty());
		mainPane.p1.progressProperty().bind(task.progressProperty());

		new Thread(task).start();
		
		try {
			mainPane.bottomPane.getChildren().add(task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class WaitingTask extends Task<Boolean>{

		@Override
		protected Boolean call() throws Exception {
			for(int i = 0; i < 500; i ++){
				try{
					Thread.sleep(5);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			return mainPane.isLoad;
		}
		
	}
}
