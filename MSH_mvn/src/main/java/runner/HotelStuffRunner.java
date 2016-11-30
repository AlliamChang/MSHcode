package runner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.hotelStuff.HotelPaneController;
import ui.utility.MainPane;

public class HotelStuffRunner extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args){
		HotelPaneController.getInstance().hotelStuffLogin(1000, "七天", null);
		launch(args);
	}
}
