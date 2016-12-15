package runner;

import java.rmi.Naming;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.RemoteHelper;
import ui.hotelStuff.control.HotelPaneController;
import ui.utility.MainPane;

public class HotelStuffRunner extends Application{

	private RemoteHelper remoteHelper;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args){
		new HotelStuffRunner().linkToServer();
		HotelPaneController.getInstance().hotelStuffLogin(1, "七天连锁", null);
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
