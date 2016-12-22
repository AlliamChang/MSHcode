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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import tools.UserType;
import vo.UserVO;

public class RegisterPane extends GridPane{

	private UserBLService user;
	
	public RegisterPane(){
		user = new UserBLServiceImpl();
		init();
	}
	
	private void init(){
		Label tip = new Label();
		tip.setTextFill(Color.RED);
		tip.setMinWidth(150);
		
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
				if(accountInput.getText() != null)
				if(accountInput.getText().length() < 6){
					tip.setText(" 账号不能少于6位");
				}else if( accountInput.getText().length() > 18){
					tip.setText(" 账号不能多于18位");
				}else{
					if(new UserBLServiceImpl().isUsed(accountInput.getText())){
						tip.setText(" 该账号已存在");
					}else{
						tip.setText("");
					}
				}
				GridPane.setConstraints(tip, 2, 0);
				if(RegisterPane.this.getChildren().indexOf(tip) >= 0){
					RegisterPane.this.getChildren().remove(tip);
					RegisterPane.this.getChildren().add(tip);
				}else{
					RegisterPane.this.getChildren().add(tip);
				}
			}
		});
		GridPane.setConstraints(accountInput, 1, 0);
		
		PasswordField passwordInput = new PasswordField();
		passwordInput.setPromptText("<-6~18位由数字或字母组成->");
		passwordInput.focusedProperty().addListener((listener,oldVal,newVal) -> {
			if(newVal == false){
				if(passwordInput.getText() != null)
				if( passwordInput.getText().length() < 6 ){
					tip.setText(" 密码过短");
				}else if(passwordInput.getText().length() > 18){
					tip.setText(" 密码过长");
				}else{
					tip.setText("");
				}
				GridPane.setConstraints(tip, 2, 1);
				if(RegisterPane.this.getChildren().indexOf(tip) >= 0){
					RegisterPane.this.getChildren().remove(tip);
					RegisterPane.this.getChildren().add(tip);
				}else{
					RegisterPane.this.getChildren().add(tip);
				}
			}
		});
		GridPane.setConstraints(passwordInput, 1, 1);
		
		PasswordField passwordConfirmInput = new PasswordField();
		passwordConfirmInput.setPromptText("<-再次确认您的密码->");
		GridPane.setConstraints(passwordConfirmInput, 1, 2);
		passwordConfirmInput.focusedProperty().addListener((listener,oldVal,newVal) -> {
			if(newVal == false){
				if( passwordConfirmInput.getText().length() > 0 && passwordInput.getText().equals(passwordConfirmInput.getText())){
					
				}else{
					tip.setText(" 两次密码不相同");
				}
				GridPane.setConstraints(tip, 2, 2);
				if(RegisterPane.this.getChildren().indexOf(tip) >= 0){
					RegisterPane.this.getChildren().remove(tip);
					RegisterPane.this.getChildren().add(tip);
				}else{
					RegisterPane.this.getChildren().add(tip);
				}
			}
		});
		
		TextField nameInput = new TextField();
		GridPane.setConstraints(nameInput, 1, 4);
		
		HBox sexPick = new HBox(10);
		ToggleGroup sexChoose = new ToggleGroup();
		RadioButton male = new RadioButton("男");
		male.setUserData("男");
		male.setToggleGroup(sexChoose);
		RadioButton female = new RadioButton("女");
		female.setUserData("女");
		female.setToggleGroup(sexChoose);
		sexPick.getChildren().addAll(male,female);
		GridPane.setConstraints(sexPick, 1,5);
		
		TextField phoneInput = new MyNumberField();
		GridPane.setConstraints(phoneInput, 1, 6);
		
		MyDatePicker birthPick = new MyDatePicker();
//		birthPick.getd
		GridPane.setConstraints(birthPick, 1, 7);
		
		
		Button confirm = new Button("注册");
		confirm.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("确定要注册吗？");
			alert.getDialogPane().setHeaderText(null);
			alert.showAndWait().ifPresent(type -> {
				if(type.equals(ButtonType.OK)){
					new UserBLServiceImpl().add(new UserVO(accountInput.getText(),passwordInput.getText(),nameInput.getText(),
							(String)sexChoose.getSelectedToggle().getUserData(),phoneInput.getText(),null,null,
							birthPick.getValue().getYear(),birthPick.getValue().getMonthValue(),birthPick.getValue().getDayOfMonth(),
							UserType.CUSTOMER));
				}
			});
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

        ColumnConstraints colinfo1 = new ColumnConstraints(80,80,80);
        ColumnConstraints colinfo2 = new ColumnConstraints(220, 220, 220);
        ColumnConstraints colinfo3 = new ColumnConstraints(150, 150, 150);
        this.getColumnConstraints().addAll(colinfo1,colinfo2,colinfo3);
        
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.getChildren().addAll(account,password,passwordConfirm,name,sex,phone,accountInput,passwordInput,passwordConfirmInput,
				nameInput,sexPick,phoneInput,confirm,cancel,birth,sep,birthPick);
		this.setVgap(20);
		this.setPadding(new Insets(100,150,150,150));
		this.setStyle("-fx-border-color:black;-fx-font-size:14;");
	}
	
}
