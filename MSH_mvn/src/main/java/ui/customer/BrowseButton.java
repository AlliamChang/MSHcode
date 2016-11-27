package ui.customer;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BrowseButton extends Button{
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);

	private BrowseButton(String s){
		super(s);
	}
	
	public static BrowseButton get(){
		BrowseButton bn=new BrowseButton("查看");
		bn.setFont(f);
		return bn;
	}
}
