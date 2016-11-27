package ui.customer;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EvaluateButton extends Button{
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);

	private EvaluateButton(String s){
		super(s);
	}
	
	public static EvaluateButton get(){
		EvaluateButton bn=new EvaluateButton("评价");
		bn.setFont(f);
		return bn;
	}
}
