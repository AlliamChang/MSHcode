package runner;

import ui.utility.MainPane;
import ui.webAdmin.*;

import java.rmi.Naming;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.RemoteHelper;

public class WebAdminRunner extends Application{
	private RemoteHelper remoteHelper;

	@Override
	public void start(Stage primaryStage) throws Exception {
//		primaryStage.setScene(new Scene(new UserInfoPane(
//				new UserVO("NJU_ZXF", "123456", "郑晓峰", "男", "15056781234", UserType.CUSTOMER, 0, 1000)), 655, 610){
//		primaryStage.setScene(new Scene(new BrowseHotelPane(), 655, 610){
//		primaryStage.setScene(new Scene(new AddHotelPane(), 655, 610){
//		primaryStage.setScene(new Scene(new ModifyUserInfoPane(
//				new UserVO("NJU_ZXF", "123456", "郑晓峰", "男", "15056781234", UserType.CUSTOMER, 0, 1000)), 655, 610){
//			{
//				this.getStylesheets().add(getClass().getResource("/css/root.css").toExternalForm());
//			}
//		});
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		WebAdminController.getInstance().init();
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args){
		new WebAdminRunner().linkToServer();
		launch(args);
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
