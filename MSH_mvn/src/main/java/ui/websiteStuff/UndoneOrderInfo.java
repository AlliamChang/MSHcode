package ui.websiteStuff;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import vo.OrderVO;

import java.util.*;

public class UndoneOrderInfo {
	private static final String FONT_STYLE="-fx-font-size:15;";
	
	public Text numberText;
	public Text idText;
	public Text nameText;
	public Text startTimeText;
	public Text endTimeText;
	private Label startLabel;
	private Label numberLabel;
	private Label idLabel;
	private Label nameLabel;
	private Label startTimeLabel;
	private Label endTimeLabel;
	private ScrollPane sp;
	private OrderVO order;
	
	private long orderNumber;
	private long userId;
	private String userName;
	private String startTime;
	private String endTime;
	
	public UndoneOrderInfo(long orderNumber,long userId,
			String userName,String startTime,String endTime){
		
		this.orderNumber=orderNumber;
		this.userId = userId;
		this.userName = userName;
		this.startTime=startTime;
		this.endTime=endTime;
		
		
		numberText=new Text();
		numberText.setStyle(FONT_STYLE);
		
		idText=new Text();
		idText.setStyle(FONT_STYLE);
		
		nameText=new Text();
		nameText.setStyle(FONT_STYLE);
		
		startTimeText=new Text();
		startTimeText.setStyle(FONT_STYLE);
		
		endTimeText=new Text();
		endTimeText.setStyle(FONT_STYLE);
	}
	
	private void start(){
		
	}
	
	public void setNumber(){
		numberText.setText(String.valueOf(orderNumber));
	}
	
	public void setId(){
		idText.setText(String.valueOf(userId));
	}
	
	public void setName(){
		nameText.setText(userName);
	}
	
	public void setStartTime(){
		startTimeText.setText(startTime);
	}
	
	public void setEndTime(){
		endTimeText.setText(endTime);
	}
	
	

}
