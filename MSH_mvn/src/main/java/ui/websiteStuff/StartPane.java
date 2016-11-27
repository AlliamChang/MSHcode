package ui.websiteStuff;

import java.util.Arrays;
import javafx.scene.text.*;


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
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",15);
	
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
	private static StartPane startPane;
	
	private OrderVO order;
	private String stuffName;
	private long stuffId;
	private long orderNumber;
	private long userId;
	private String userName;
	private String startTime;
	private String endTime;
	
	public StartPane(String stuffName,long stuffId,long orderNumber,long userId,
			String userName,String startTime,String endTime){
		super();
		this.stuffName=stuffName;
		this.stuffId=stuffId;
		this.orderNumber=orderNumber;
		this.userId=userId;
		this.userName=userName;
		this.startTime=startTime;
		this.endTime=endTime;
			
		this.start();
	}
	
	
	
	
	
	private void start(){
		this.setMinSize(MINWIDTH, MINHEIGHT);
		
		
		this.startLabel=new Label("未执行订单列表");
		startLabel.setFont(startFont);
		
		
		this.numberLabel=new Label("订单编号");
		numberLabel.setFont(normalFont);
		
		this.idLabel=new Label("用户ID");
		idLabel.setFont(normalFont);
		
		this.nameLabel=new Label("用户姓名");
		nameLabel.setFont(normalFont);
		
		this.startTimeLabel=new Label("订单生成时间");
		startTimeLabel.setFont(normalFont);
		
		this.endTimeLabel=new Label("订单需被执行时间");
		endTimeLabel.setFont(normalFont);
		
		numberText=new Text();
		numberText.setFont(normalFont);
		UndoneOrderInfo.setNumber(orderNumber, numberText);
		
		idText=new Text();
		idText.setFont(normalFont);
		UndoneOrderInfo.setId(userId, idText);
		
		nameText=new Text();
		nameText.setFont(normalFont);
		UndoneOrderInfo.setName(userName, nameText);
		
		startTimeText=new Text();
		startTimeText.setFont(normalFont);
		UndoneOrderInfo.setStartTime(startTime, startTimeText);
		
		endTimeText=new Text();
		endTimeText.setFont(normalFont);
	    UndoneOrderInfo.setEndTime(endTime, endTimeText);
	
	
		
		
		this.add(startLabel, 1, 1);
		this.add(numberLabel, 1, 2);
		this.add(idLabel, 2, 2);
		this.add(nameLabel, 3, 2);
		this.add(startTimeLabel, 4, 2);
		this.add(endTimeLabel, 5, 2);
		this.add(numberText, 1, 3);
		this.add(idText, 2, 3);
		this.add(nameText, 3, 3);
		this.add(startTimeText, 4, 3);
		this.add(endTimeText, 5, 3);
	}
	
	
	

}
