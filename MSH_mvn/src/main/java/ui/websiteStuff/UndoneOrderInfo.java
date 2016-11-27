package ui.websiteStuff;

import javafx.scene.text.*;

public class UndoneOrderInfo {
	private static final Font FONT=new Font("方正幼圆",15);
	
	
	public static Text setNumber(long orderNumber,Text numberText){
		numberText.setText(String.valueOf(orderNumber));
		numberText.setFont(FONT);
		return numberText;
	}
	
	public static Text setId(long userId,Text idText){
		idText.setText(String.valueOf(userId));
		idText.setFont(FONT);
		return idText;
	}
	
	public static Text setName(String userName,Text nameText){
		nameText.setText(userName);
		nameText.setFont(FONT);
		return nameText;
	}
	
	public static Text setStartTime(String startTime,Text startTimeText){
		startTimeText.setText(startTime);
		startTimeText.setFont(FONT);
		return startTimeText;
	}
	
	public static Text setEndTime(String endTime,Text endTimeText){
		endTimeText.setText(endTime);
		endTimeText.setFont(FONT);
		return endTimeText;
	}
	
	

}
