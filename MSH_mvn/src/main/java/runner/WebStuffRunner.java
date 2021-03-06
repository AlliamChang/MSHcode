package runner;

import java.rmi.Naming;
import ui.utility.MainPane;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.RemoteHelper;

import ui.websiteStuff.*;

public class WebStuffRunner extends Application{
	private static RemoteHelper remoteHelper;
	
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		MarketingPaneController.getInstance().init(123,"zhr");
		primaryStage.show();
	}
	
	public static void main(String[] args){
		linkToServer();
		
		launch(args);
	}
	
	public static void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://127.0.0.1:8888/RemoteImpl"));
			System.out.println("linked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
