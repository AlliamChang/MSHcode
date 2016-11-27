package runner;

import tools.UserType;
import ui.webAdmin.AddHotelPane;
import ui.webAdmin.AddUserPane;
import ui.webAdmin.InitialPane;
import ui.webAdmin.UserInfoPane;
import vo.UserVO;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebAdminRunner extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
//		primaryStage.setScene(new Scene(new UserInfoPane(
//				new UserVO("NJU_ZXF", "123456", "郑晓峰", "男", "150xxxx2962", UserType.CUSTOMER, 0, 1000)), 655, 610){
		primaryStage.setScene(new Scene(new AddHotelPane(), 655, 610){
			{
				this.getStylesheets().add(getClass().getResource("/css/root.css").toExternalForm());
			}
		});
		primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
	
}
