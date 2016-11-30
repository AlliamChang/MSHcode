package ui.utility;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class MyRetreatButton extends Button{

	private static final Image PIC = 
			new Image(MyRetreatButton.class.getResource("/image/retreat.png").toExternalForm(),
					50,50,false,false);
	
	private Pane lastPane;
	
	
	public MyRetreatButton(Pane lastPane){
		super();
	}
	
	 
}
