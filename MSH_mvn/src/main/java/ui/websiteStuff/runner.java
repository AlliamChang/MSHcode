package ui.websiteStuff;

import javafx.application.*;
import java.util.*;
import javafx.scene.*;
import javafx.stage.*;
import tools.Date;
import tools.OrderState;
import ui.utility.MainPane;
import ui.websiteStuff.*;
import vo.OrderVO;

public class runner extends Application{
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.show();
	}
	
	public static void main(String[] args){
		List<String> stuffName=new ArrayList<String>();
		stuffName.add("zhr");
		stuffName.add("100");
		List<String> stuffId=new ArrayList<String>();
		stuffId.add("开始");
		String[] a=new String[1];
		a[0]="1";
		String[] b=new String[1];
		b[0]="2";
		OrderVO o1=new OrderVO(100,"u","h","rs",8,a,b,9,new Date("2016/11/11",false),
			    OrderState.EXECUTED,true,new Date("2016/11/12",false));
		List<OrderVO> order=Arrays.asList(o1);
		new WebStuffStartPane(stuffName,order);
		launch(args);
	}

}
