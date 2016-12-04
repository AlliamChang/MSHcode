package ui.websiteStuff;

import javafx.application.*;
import java.util.*;
import ui.utility.*;
import tools.*;
import javafx.stage.*;
import javafx.scene.*;

public class StrategyListRunner extends Application{
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setScene(new Scene(MainPane.getInstance(),800,600));
		primaryStage.show();
	}
	
	public static void main(String[] args){
		List<String> stuffName=new ArrayList();
		stuffName.add("zhr");
		List<String> stuffId=new ArrayList();
		stuffId.add("1000");
		List<String> strategyName=new ArrayList();
		strategyName.add("double11");
		List<PeopleType> people=new ArrayList();
		people.add(PeopleType.VIP);
		List<String> cost=new ArrayList();
		cost.add("100.00");
		List<String> startTime=new ArrayList();
		startTime.add("2016/11/11");
		List<String> endTime=new ArrayList();
		endTime.add("2016/11/12");
		new WebsiteStrategyMainPane(stuffName,stuffId,strategyName,people,cost,startTime,endTime,null);
		launch(args);
	}

}
