package ui.customer;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RevokeButton extends Button{
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);

	public RevokeButton(String s){
		super(s);
	}
	
	public static RevokeButton get(){
		RevokeButton bn=new RevokeButton("撤销");
		bn.setFont(f);
		return bn;
	}
}
