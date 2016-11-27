package ui.websiteStuff;

import java.util.Arrays;

import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.control.*;
import javafx.scene.text.*;
import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import ui.webAdmin.InitialPane;

import java.util.*;
import tools.*;
import vo.*;

public class StartPane extends GridPane{
	
	private static final double MINWIDTH = 655,MINHEIGHT = 610;
	private static final String BORDER_STYLE = "-fx-border-color:black;";
	private static final String BACKGROUND_STYLE = "-fx-background-color:white;",
			STARTFONT_STYLE = "-fx-font-size:30;",FONT_STYLE="-fx-font-size:15;";
	
	private MyNavigationBar navi;
	private UndoneOrderInfo uoi;
	private Label startLabel;
	private Label numberLabel;
	private Label idLabel;
	private Label nameLabel;
	private Label startTimeLabel;
	private Label endTimeLabel;
	private ScrollPane sp;
	private Text numberText;
	private Text idText;
	private Text nameText;
	private Text startTimeText;
	private Text endTimeText;
	private GridPane gpane;
	private static StartPane startPane;
	
	private OrderVO order;
	private String stuffName;
	private long stuffId;
	private long orderNumber;
	private long userId;
	private String userName;
	private String startTime;
	private String endTime;
	
	public StartPane(){
		super();
		
			
		this.ShowInfo();
	}
	
	
	
	private void init(Image scul){
		navi = new MyNavigationBar(scul,Arrays.asList("ID:"+stuffId,stuffName));
		MainPane.getInstance().getChildren().addAll(navi);
		
	}
	
	private void start(){
		this.setMinSize(MINWIDTH, MINHEIGHT);
		this.setStyle(BORDER_STYLE + BACKGROUND_STYLE + FONT_STYLE);
		
		this.startLabel=new Label("未执行订单列表");
		startLabel.setStyle(BORDER_STYLE+BACKGROUND_STYLE+STARTFONT_STYLE);
		startLabel.setTranslateX(200);
		startLabel.setTranslateY(200);
		
		this.numberLabel=new Label("订单编号");
		numberLabel.setStyle(FONT_STYLE);
		
		this.idLabel=new Label("用户ID");
		idLabel.setStyle(FONT_STYLE);
		
		this.nameLabel=new Label("用户姓名");
		nameLabel.setStyle(FONT_STYLE);
		
		this.startTimeLabel=new Label("订单生成时间");
		startTimeLabel.setStyle(FONT_STYLE);
		
		this.endTimeLabel=new Label("订单需被执行时间");
		endTimeLabel.setStyle(FONT_STYLE);
		
		this.gpane=new GridPane();
	}
	
	private void ShowInfo(){
		uoi=new UndoneOrderInfo(orderNumber,userId,userName,startTime,endTime);
		uoi.setNumber();
		uoi.setId();
		uoi.setName();
		uoi.setStartTime();
		uoi.setEndTime();
		
		gpane.add(numberLabel, 1, 1);
		gpane.add(idLabel, 2, 1);
		gpane.add(nameLabel, 3, 1);
		gpane.add(startTimeLabel, 4, 1);
		gpane.add(endTimeLabel, 5, 1);
		gpane.add(uoi.numberText, 1, 2);
		gpane.add(uoi.idText, 2, 2);
		gpane.add(uoi.nameText, 3, 2);
		gpane.add(uoi.startTimeText, 4, 2);
		gpane.add(uoi.endTimeText, 5, 2);
	}
	
	
	public static StartPane getInstance(){
		if(startPane==null){
			startPane=new StartPane();
		}
		return startPane;
	}

}
