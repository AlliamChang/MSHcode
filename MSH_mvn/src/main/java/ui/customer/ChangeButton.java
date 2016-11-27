package ui.customer;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChangeButton extends Button{
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);

	
	private ChangeButton (String s){
		super(s);
	}
	
	public static ChangeButton get(){
		ChangeButton bn=new ChangeButton("修改");
		bn.setFont(f);
		return bn;
	}
}
