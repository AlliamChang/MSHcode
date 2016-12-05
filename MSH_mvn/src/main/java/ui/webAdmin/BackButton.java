package ui.webAdmin;

import ui.utility.MyRetreatButton;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackButton extends Button{
	private static final Image PIC = 
			new Image(MyRetreatButton.class.getResource("/image/retreat.png").toExternalForm(),
					50,50,false,false);
	private static final ImageView VIEW = new ImageView(PIC);
	
	
	public BackButton(Parent lastPane){
		super(null, VIEW);
		setStyle("-fx-background-color:null;");
		setCursor(Cursor.HAND);
		setOnAction(e -> WebAdminController.getInstance().goBack(lastPane));
	}
}
