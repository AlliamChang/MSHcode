package ui.websiteStuff;

import javafx.scene.text.Text;
import java.util.*;

public class UndoneOrderInfo {
	private static final String FONT_STYLE="-fx-font-size:15;";
	
	public Text numberText;
	public Text idText;
	public Text nameText;
	public Text startTimeText;
	public Text endTimeText;
	
	public UndoneOrderInfo(){
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
	
	public void setNumber(long number){
		numberText.setText(String.valueOf(number));
	}
	
	public void setId(long id){
		idText.setText(String.valueOf(id));
	}
	
	public void setName(String userName){
		nameText.setText(userName);
	}
	
	public void setStartTime(String startTime){
		startTimeText.setText(startTime);
	}
	
	public void setEndTime(String endTime){
		endTimeText.setText(endTime);
	}
	
	

}
