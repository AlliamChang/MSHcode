package runner;

import ui.customer.*;
import ui.utility.MainPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerRunner extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		//new PersonInfoPane();
		//new EvaluatePane();
		//new CreditRecordPane(null);
		//new MyOrderPane();
		//new ReservePane();
		new HotelSearchPane();
		launch(args);
	}

}
