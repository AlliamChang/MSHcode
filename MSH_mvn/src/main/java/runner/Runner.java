package runner;

import java.rmi.Naming;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import rmi.RemoteHelper;
import ui.*;
import ui.customer.HotelSearchPane;
import ui.hotelStuff.OrderListPane;
import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
public class Runner extends Application {
	private RemoteHelper remoteHelper;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.setTitle("  酒店管理系统 - MSH");
		primaryStage.getIcons().add(new Image(getClass().getResource("/image/icon.png").toExternalForm()));
		primaryStage.setResizable(false);
		MainPane.getInstance().setNavigationBar(new MyNavigationBar());
		MainPane.getInstance().setRightPane(HotelSearchPane.getInstance());
		primaryStage.show();
	}
	
	public static void main(String []args){
		new Runner().linkToServer();
		launch(args);
		MainPane.getInstance().logout();
	}

	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://172.26.91.91:8888/RemoteImpl"));
			System.out.println("linked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
