package ui.utility;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class RegisterPane extends GridPane{

	
	
	public RegisterPane(){
		
	}
	
	private void init(){
		Label account = new Label("账号：");
		
		Label password = new Label("密码：");
		
		Label vipKind = new Label("会员类型：");
		
		TextField accountInput = new TextField();
		accountInput.setPromptText("<-6~18位由字母和数字组成的账号名->");
		
		PasswordField passwordInput = new PasswordField();
		passwordInput.setPromptText("<-6~18位由数字或字母组成的密码->");
		
		TextField businessPassword = new TextField();
		
		Button confirm = new Button("确认注册");
		
		Button cancel = new Button("取消");
		
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
	}
	
}
