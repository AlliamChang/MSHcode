package ui.websiteStuff;

import java.util.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.application.*;
import ui.utility.*;
import tools.CostType;
import tools.Date;
import tools.PeopleType;

public class ModifyRunner extends Application{
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.show();
	}
	
	public static void main(String[] args){
		List<String> stuffName=new ArrayList();
		stuffName.add("zhr");
		List<String> stuffId=new ArrayList();
		stuffId.add("111");
		String name="double11";
		String city="南京市";
		String area="栖霞区";
		Date startTime=new Date("2016/11/11",true);
		Date endTime=new Date("2016/11/12",true);
		String cost="100.00";
		CostType costType=CostType.RMB;
		PeopleType people=PeopleType.VIP;
		new ModifyStrategyPane(stuffName,stuffId,name,city,area,startTime,endTime,cost,costType,people,null);
		launch(args);
	}
        
}
