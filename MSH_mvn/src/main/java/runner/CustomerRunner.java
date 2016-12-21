package runner;

import java.rmi.Naming;

import rmi.RemoteHelper;
import ui.customer.*;
import ui.utility.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerRunner extends Application{
	private RemoteHelper remoteHelper;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		new CustomerRunner().linkToServer();
		CustomerPaneController.getInstance().CustomerLogin("angel", null);
		//MainPane.getInstance().setRightPane(new PersonInfoPane());
		//new PersonInfoPane();
		//MainPane.getInstance().getChildren().add(new PersonInfoPane());
		launch(args);
	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/RemoteImpl"));
			System.out.println("linked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
