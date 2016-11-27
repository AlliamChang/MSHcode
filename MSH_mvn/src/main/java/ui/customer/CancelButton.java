package ui.customer;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CancelButton extends Button {
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);

	private CancelButton(String s){
		super(s);
	}
	
	public static CancelButton get(){
		CancelButton bn=new CancelButton("取消");
		bn.setFont(f);
		return bn;
	}
}
