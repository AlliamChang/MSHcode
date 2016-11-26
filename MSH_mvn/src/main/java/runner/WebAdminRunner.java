package runner;

import ui.webAdmin.AddMarketerPane;
import ui.webAdmin.InitialPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WebAdminRunner extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(new Scene(InitialPane.getInstance(), 700, 600));
		primaryStage.show();
	}

	public static void main(String[] args){
		launch(args);
	}
	
}
