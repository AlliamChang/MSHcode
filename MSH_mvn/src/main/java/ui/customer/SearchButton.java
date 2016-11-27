package ui.customer;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class SearchButton extends Button{
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);

	private SearchButton(String s){
		super(s);
	}
	
	public static SearchButton get(){
		SearchButton bn=new SearchButton("搜索");
		bn.setFont(f);
		return bn;
	}
}
