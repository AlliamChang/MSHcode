package runner;

import tools.UserType;
import ui.webAdmin.AddUserPane;
import ui.webAdmin.InitialPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebAdminRunner extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(new AddUserPane(UserType.MARKETER), 700, 600));
		primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
	
}
