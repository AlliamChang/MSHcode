package runner;

import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.*;
import ui.hotelStuff.OrderListPane;
import ui.utility.MainPane;
public class Runner extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String []args){
		launch(args);
	}

}
