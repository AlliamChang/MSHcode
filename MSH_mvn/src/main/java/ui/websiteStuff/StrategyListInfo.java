package ui.websiteStuff;

import javafx.scene.control.*;
//添加策略列表的按钮等的方法
public class StrategyListInfo {
	public static void setButton(ToggleGroup group,RadioButton button){
		button.setToggleGroup(group);
		button.setSelected(true);
	}
	
	public static void setFocus(RadioButton button){
		button.setSelected(true);
		button.requestFocus();
	}
	
	

}
