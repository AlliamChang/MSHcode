package ui.utility;

import java.util.concurrent.ExecutionException;

import bl.user_bl.UserBLServiceImpl;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import ui.customer.CustomerPaneController;

public class MainPane extends StackPane{
	
	private static MainPane mainPane;
	public static final double MINWIDTH = 655,MINHEIGHT = 610;
	private HBox bottomPane;
	private Stage stage;
	private AnchorPane frontPane;
	private ProgressIndicator p1;
	private boolean isLogin;
	private boolean isLoad = true;
	private int id;
	
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
        frontPane.setVisible(false);
        this.getChildren().add(frontPane);
	}
	
	public static MainPane getInstance(){
		if(mainPane == null){
			mainPane = new MainPane();
			mainPane.setStyle("-fx-background-color:white;");
		}
		return mainPane;
	}
	
	public void login(int id){
		isLogin = true;
		this.id = id;
	}
	
	public boolean isLogin(){
		return isLogin;
	}
	
	public void setStage(Stage stage){
		this.stage = stage;
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void logout(){
		isLogin = false;
		id = -1;
		this.setNavigationBar(new MyNavigationBar());
		CustomerPaneController.getInstance().createHotelSearchPane();
		new UserBLServiceImpl().logout(id);
	}
	
	public void setNavigationBar(MyNavigationBar bar){
		if(mainPane.bottomPane.getChildren().size() > 0)
			mainPane.bottomPane.getChildren().set(0, bar);
		else
			mainPane.bottomPane.getChildren().add(bar);
	}
	
	public void setRightPane(Parent rightPane){
		rightPane.setStyle(rightPane.getStyle() + ";-fx-border-color:black;");
//		rightPane.setMaxSize(655, 610);
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
