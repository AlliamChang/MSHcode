package ui.utility;

import javafx.scene.control.TextField;

/**
 * 只允许输入数字的TextField
 * @author I Like Milk
 *
 */
public class MyNumberField extends TextField{
	public MyNumberField(){
		super();
	}
	
	public MyNumberField(String text) {
		super(text);
	}
	
	public void replaceText(int start, int end, String text){
		if (text.matches("[0-9]*"))
			super.replaceText(start, end, text);
	}
	
	public void replaceSelection(String text){
		if (text.matches("[0-9]*"))
			super.replaceSelection(text);
	}

}
