package ui.websiteStuff;

import javafx.application.*;
import java.util.*;
import javafx.scene.*;
import javafx.stage.*;
import tools.OrderState;
import tools.Date;
import ui.utility.MainPane;
import ui.websiteStuff.*;
import vo.*;

public class DealRunner extends Application{
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.show();
	}
	
	public static void main(String[] args){
		List<OrderVO> order=new ArrayList<OrderVO>();
		String[] a=new String[1];
		a[0]="1";
		String[] b=new String[1];
		b[0]="2";
		OrderVO o1=new OrderVO(100,"u","h","rs",8,a,b,9,new Date("2016/11/11",false),
			    OrderState.EXECUTED,true,new Date("2016/11/12",false));
		OrderVO o2=new OrderVO(102,"u","h","rs",4,a,b,1,new Date("2016/1/11",false),
			    OrderState.EXECUTED,true,new Date("2016/1/12",false));
		order.add(o1);
		order.add(o2);
		new DealPane(order);
		launch(args);
	}

}
