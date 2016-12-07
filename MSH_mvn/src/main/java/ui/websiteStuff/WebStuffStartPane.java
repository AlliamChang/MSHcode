package ui.websiteStuff;

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

public class WebStuffStartPane extends GridPane{
	
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",15);
	private final List<String> naviInfo=Arrays.asList("管理营销策略","修改营销策略"
			,"添加营销策略","处理异常订单","用户信用充值");
	
	private MyNavigationBar navi;
	private Label startLabel;
	private Label numberLabel;
	private Label idLabel;
	private Label nameLabel;
	private Label startTimeLabel;
	private Label endTimeLabel;
	private ScrollPane sp;
	/*private Text numberText;
	private Text idText;
	private Text nameText;
	private Text startTimeText;
	private Text endTimeText;*/
	private List<String> stuff;
	
	private List<OrderVO> order;

	private long orderNumber;
	private long userId;
	private String userName;
	private String startTime;
	private String endTime;
	
	public WebStuffStartPane(/*List<String> stuffName,List<String> stuffId,long orderNumber,long userId,
			String userName,String startTime,String endTime,Image scul*/
			List<String> stuff,List<OrderVO> order){
		super();
		this.order=order;
		this.stuff=stuff;
		/*this.stuffName=stuffName;
		this.stuffId=stuffId;
		this.orderNumber=orderNumber;
		this.userId=userId;
		this.userName=userName;
		this.startTime=startTime;
		this.endTime=endTime;*/
		
		this.start();
	}
	
	/*private void init(Image scul){
		navi = new MyNavigationBar(scul,stuff,naviInfo);
		MainPane.getInstance().setNavigationBar(navi);
		MainPane.getInstance().setRightPane(this);
		
	}*/
	
	
	
	private void start(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setGridLinesVisible(false);
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getColumnConstraints().add(new ColumnConstraints(40));
		this.getColumnConstraints().add(new ColumnConstraints(100));
		this.getColumnConstraints().add(new ColumnConstraints(100));
		this.getColumnConstraints().add(new ColumnConstraints(100));
		this.getColumnConstraints().add(new ColumnConstraints(100));
		this.getColumnConstraints().add(new ColumnConstraints(120));//行列间距
		
		this.startLabel=new Label("未执行订单列表");
		startLabel.setFont(startFont);
		this.setHalignment(startLabel,HPos.LEFT);
		this.setValignment(startLabel, VPos.CENTER);
		
		this.numberLabel=new Label("订单编号");
		numberLabel.setFont(normalFont);
		this.setHalignment(numberLabel, HPos.CENTER);
		this.setValignment(numberLabel, VPos.CENTER);
		
		this.idLabel=new Label("用户ID");
		idLabel.setFont(normalFont);
		this.setHalignment(idLabel, HPos.CENTER);
		this.setValignment(idLabel, VPos.CENTER);
		
		this.nameLabel=new Label("用户姓名");
		nameLabel.setFont(normalFont);
		this.setHalignment(nameLabel, HPos.CENTER);
		this.setValignment(nameLabel, VPos.CENTER);
		
		this.startTimeLabel=new Label("订单生成时间");
		startTimeLabel.setFont(normalFont);
		this.setHalignment(startTimeLabel, HPos.CENTER);
		this.setValignment(startTimeLabel, VPos.CENTER);
		
		this.endTimeLabel=new Label("订单到期时间");
		endTimeLabel.setFont(normalFont);
		this.setHalignment(endTimeLabel, HPos.CENTER);
		this.setValignment(endTimeLabel, VPos.CENTER);
		
		/*numberText=new Text();
		numberText.setFont(normalFont);
		UndoneOrderInfo.setNumber(orderNumber, numberText);
		this.setHalignment(numberText, HPos.CENTER);
		this.setValignment(numberText, VPos.TOP);
		
		idText=new Text();
		idText.setFont(normalFont);
		UndoneOrderInfo.setId(userId, idText);
		this.setHalignment(idText, HPos.CENTER);
		this.setValignment(idText, VPos.TOP);
		
		nameText=new Text();
		nameText.setFont(normalFont);
		UndoneOrderInfo.setName(userName, nameText);
		UndoneOrderInfo.setName("2", nameText);
		UndoneOrderInfo.setName("2", nameText);
		nameText.setText("3");
		this.setHalignment(nameText, HPos.CENTER);
		this.setValignment(nameText, VPos.TOP);
		
		startTimeText=new Text();
		startTimeText.setFont(normalFont);
		UndoneOrderInfo.setStartTime(startTime, startTimeText);
		this.setHalignment(startTimeText, HPos.CENTER);
		this.setValignment(startTimeText, VPos.TOP);
		
		endTimeText=new Text();
		endTimeText.setFont(normalFont);
	    UndoneOrderInfo.setEndTime(endTime, endTimeText);
	    this.setHalignment(endTimeText, HPos.CENTER);
		this.setValignment(endTimeText, VPos.TOP);*/
		
		for(int i=0;i<order.size();i++){
			Text numberText=new Text();
			numberText.setFont(normalFont);
			this.setHalignment(numberText, HPos.CENTER);
			this.setValignment(numberText, VPos.CENTER);
			numberText.setText(String.valueOf(order.get(i).getId()));
			this.add(numberText, 1, i+3);
			Text idText=new Text();
			idText.setFont(normalFont);
			this.setHalignment(idText, HPos.CENTER);
			this.setValignment(idText, VPos.CENTER);
			idText.setText(String.valueOf("用户ID"));
			this.add(idText, 2, i+3);
			Text nameText=new Text();
			nameText.setFont(normalFont);
			this.setHalignment(nameText, HPos.CENTER);
			this.setValignment(nameText, VPos.CENTER);
			nameText.setText(String.valueOf("用户姓名"));
			this.add(nameText, 3, i+3);
			Text startTimeText=new Text();
			startTimeText.setFont(normalFont);
			this.setHalignment(startTimeText, HPos.CENTER);
			this.setValignment(startTimeText, VPos.CENTER);
			startTimeText.setText(order.get(i).getPreCheckin().getDate());
			this.add(startTimeText, 4, i+3);
			Text endTimeText=new Text();
			endTimeText.setFont(normalFont);
			this.setHalignment(endTimeText, HPos.CENTER);
			this.setValignment(endTimeText, VPos.CENTER);
			endTimeText.setText(order.get(i).getCheckin().getDate());
			this.add(endTimeText, 5, i+3);
		}
		
	    this.add(startLabel, 1, 1, 5, 1);
		this.add(numberLabel, 1, 2);
		this.add(idLabel, 2, 2);
		this.add(nameLabel, 3, 2);
		this.add(startTimeLabel, 4, 2);
		this.add(endTimeLabel, 5, 2);
		/*this.add(numberText, 1, 3);
		this.add(idText, 2, 3);
		this.add(nameText, 3, 3);
		this.add(startTimeText, 4, 3);
		this.add(endTimeText, 5, 3);*/
	}
	
	
	

}
