package ui.utility;

import bl.user_bl.UserBLServiceImpl;
import blservice.user_blservice.UserBLService;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class RegisterPane extends GridPane{

	private UserBLService user;
	
	public RegisterPane(){
		user = new UserBLServiceImpl();
		init();
	}
	
	private void init(){
		Tooltip tip = new Tooltip();
		tip.setAutoHide(true);
		
		Label account = new Label("账号：");
		GridPane.setConstraints(account, 0, 0);
		
		Label password = new Label("密码：");
		GridPane.setConstraints(password, 0, 1);
		
		Label passwordConfirm = new Label("确认密码：");
		GridPane.setConstraints(passwordConfirm, 0, 2);
		
		Separator sep = new Separator();
		sep.setMinWidth(300);
		sep.setStyle("-fx-background-color:black;-fx-width:2");
		GridPane.setConstraints(sep, 0, 3, 2, 1);
		
		Label name = new Label("名字：");
		GridPane.setConstraints(name, 0, 4);
		
		Label sex = new Label("性别：");
		GridPane.setConstraints(sex, 0, 5);
		
		Label phone = new Label("电话：");
		GridPane.setConstraints(phone, 0, 6);
		
		Label birth = new Label("生日：");
		GridPane.setConstraints(birth, 0, 7);
		
		TextField accountInput = new TextField();
		accountInput.setPromptText("<-6~18位由字母和数字组成->");
		accountInput.focusedProperty().addListener((listener,oldVal,newVal) -> {
			if(newVal == false){
				System.out.print(accountInput.getLayoutX()+" "+accountInput.getScaleX()+" "+accountInput.getTranslateX());
				if(accountInput.getText() != null)
				if(accountInput.getText().length() < 6 || accountInput.getText().length() > 18){
					tip.setText("账号名不能少于6位或者多于18位");
					tip.show(accountInput,0,0);
				}else{
					if(new UserBLServiceImpl().isUsed(accountInput.getText())){
						
					}else{
						
					}
				}
			}
		});
		GridPane.setConstraints(accountInput, 1, 0);
		
		PasswordField passwordInput = new PasswordField();
		passwordInput.setPromptText("<-6~18位由数字或字母组成->");
		GridPane.setConstraints(passwordInput, 1, 1);
		
		PasswordField passwordConfirmInput = new PasswordField();
		passwordConfirmInput.setPromptText("<-再次确认您的密码->");
		GridPane.setConstraints(passwordConfirmInput, 1, 2);
		
		TextField nameInput = new TextField();
		GridPane.setConstraints(nameInput, 1, 4);
		
		HBox sexPick = new HBox(10);
		ToggleGroup sexChoose = new ToggleGroup();
		RadioButton male = new RadioButton("男");
		male.setToggleGroup(sexChoose);
		RadioButton female = new RadioButton("女");
		female.setToggleGroup(sexChoose);
		sexPick.getChildren().addAll(male,female);
		GridPane.setConstraints(sexPick, 1,5);
		
		TextField phoneInput = new MyNumberField();
		GridPane.setConstraints(phoneInput, 1, 6);
		
		MyDatePicker birthPick = new MyDatePicker();
//		birthPick.getd
		GridPane.setConstraints(birthPick, 1, 7);
		
		
		Button confirm = new Button("确认注册");
		confirm.setOnAction(e -> {
			
		});
		GridPane.setConstraints(confirm, 0, 8);
		
		Button cancel = new Button("取消");
		cancel.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("确定要放弃注册吗？");
			alert.showAndWait().ifPresent(type -> {
				if(type.equals(ButtonType.OK)){
					MainPane.getInstance().logout();
				}
			});
		});
		GridPane.setConstraints(cancel, 1, 8);
		GridPane.setHalignment(cancel, HPos.CENTER);
		
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.getChildren().addAll(account,password,passwordConfirm,name,sex,phone,accountInput,passwordInput,nameInput,
				passwordConfirmInput,sexPick,phoneInput,confirm,cancel,birth,sep,birthPick);
		this.setVgap(20);
		this.setPadding(new Insets(100,150,150,150));
		this.setStyle("-fx-border-color:black;-fx-font-size:14;");
	}
	
}
