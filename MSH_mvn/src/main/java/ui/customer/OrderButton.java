package ui.customer;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class OrderButton extends Button{
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);

	private OrderButton(String s){
		super(s);
	}
	
	public static OrderButton get(){
		OrderButton bn=new OrderButton("预订");
		bn.setFont(f);
		return bn;
	}
}
