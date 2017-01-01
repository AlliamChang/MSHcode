package runner;

import java.rmi.Naming;
import ui.utility.MainPane;
import ui.webAdmin.*;

import java.rmi.Naming;
import java.rmi.RemoteException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.RemoteHelper;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.RemoteHelper;
import ui.websiteStuff.*;
import ui.utility.MainPane;

public class testRunner extends Application{
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		//WebsitePaneController.getInstance().init(123,"zhr");
		MainPane.getInstance().setRightPane(new CreateStrategyPane());
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}
	
	

}
