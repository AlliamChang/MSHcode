package ui;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
public class loginBox extends VBox{
	//private loginBox login;
	public loginBox(){
		super();
	}
	
	public loginBox createLoginBox(){
		loginBox login=new loginBox();
		login.setSpacing(20);
		//login.setBorder(arg0);
		Button bn1=new Button("登录");
		bn1.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
		Button bn2=new Button("注册");
		bn2.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 24));
		
		login.getChildren().addAll(bn1,bn2);
		login.setAlignment(Pos.CENTER_LEFT);
		login.setPadding(new Insets(20));
		login.setBorder(Border.EMPTY);
		return login;
	}
	
	/*public static loginBox get(){
		return login;
	}*/
}
