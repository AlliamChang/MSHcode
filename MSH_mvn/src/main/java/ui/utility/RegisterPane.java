package ui.utility;

import bl.user.UserBLServiceImpl;
import blservice.user.UserBLService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import tools.UserType;
import ui.customer.CustomerPaneController;
import vo.UserVO;

public class RegisterPane extends GridPane{

	private UserBLService user;
	private final Image ERROR = new Image(RegisterPane.class.getResourceAsStream("/image/wrong.png"));
	private final Image CORRECT = new Image(RegisterPane.class.getResourceAsStream("/image/correct.png"));
	
	private Label[] tip = new Label[7];
	private ImageView[] tipType = new ImageView[7];
	
	public RegisterPane(){
		user = new UserBLServiceImpl();
		init();
	}
	
	private void init(){
		
		for(int i = 0; i < tip.length; i ++){
			tipType[i] = new ImageView();
			tipType[i].setFitWidth(16);
			tipType[i].setFitHeight(16);
			tip[i] = new Label("");
			tip[i].setTextFill(Color.RED);
			tip[i].setMinWidth(150);
			tip[i].setGraphic(tipType[i]);
			tip[i].setGraphicTextGap(0.5);
			if(i > 2){
				GridPane.setConstraints(tip[i], 2, i+1);
			}else{
				GridPane.setConstraints(tip[i], 2, i);
			}
			this.getChildren().add(tip[i]);
		}
		
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
					tip[0].setText("账号不能少于6位");
					tipType[0].setImage(ERROR);
				}else if( accountInput.getText().length() > 18){
					tipType[0].setImage(ERROR);
					tip[0].setText("账号不能多于18位");
				}else if(accountInput.getText().matches("[0-9]*")){
					tipType[0].setImage(ERROR);
					tip[0].setText("账号不能为纯数字");
				}else{
					if(new UserBLServiceImpl().isUsed(accountInput.getText())){
						tipType[0].setImage(ERROR);
						tip[0].setText("该账号已存在");
					}else{
						tip[0].setText("");
						tipType[0].setImage(CORRECT);
					}
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
					tipType[1].setImage(ERROR);
					tip[1].setText("密码过短");
				}else if(passwordInput.getText().length() > 18){
					tipType[1].setImage(ERROR);
					tip[1].setText("密码过长");
				}else{
					tip[1].setText("");
					tipType[1].setImage(CORRECT);
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
					tipType[2].setImage(CORRECT);
					tip[2].setText("");
				}else{
					tipType[2].setImage(ERROR);
					tip[2].setText("两次密码不相同");
				}
			}
		});
		
		TextField nameInput = new TextField();
		nameInput.focusedProperty().addListener((listener,oldVal,newVal) -> {
			if(newVal == false){
				if(nameInput.getText() == null || nameInput.getText().equals("")){
					tipType[3].setImage(ERROR);
					tip[3].setText("此处不能为空");
				}else{
					tipType[3].setImage(CORRECT);
					tip[3].setText("");
				}
			}
		});
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
		male.focusedProperty().addListener((listener,oldVal,newVal) -> {
			if(newVal == false){
				if(sexChoose.getSelectedToggle() == null){
					tipType[4].setImage(ERROR);
					tip[4].setText("请选择你的性别");
				}else{
					tipType[4].setImage(CORRECT);
					tip[4].setText("");
				}
			}
		});
		female.focusedProperty().addListener((listener,oldVal,newVal) -> {
			if(newVal == false){
				if(sexChoose.getSelectedToggle() == null){
					tipType[4].setImage(ERROR);
					tip[4].setText("请选择你的性别");
				}else{
					tipType[4].setImage(CORRECT);
					tip[4].setText("");
				}
			}
		});
		GridPane.setConstraints(sexPick, 1,5);
		
		TextField phoneInput = new MyNumberField();
		phoneInput.focusedProperty().addListener((listener,oldVal,newVal) -> {
			if(newVal == false){
				if(phoneInput.getText() == null || phoneInput.getText().equals("")){
					tipType[5].setImage(ERROR);
					tip[5].setText("此处不能为空");
				}else{
					tipType[5].setImage(CORRECT);
					tip[5].setText("");
				}
			}
		});
		GridPane.setConstraints(phoneInput, 1, 6);
		
		MyDatePicker birthPick = new MyDatePicker();
		birthPick.focusedProperty().addListener((listener,oldVal,newVal) -> {
			if(newVal == false){
				if(birthPick.getEditor().getText() == null || birthPick.getEditor().getText().equals("")){
					tipType[6].setImage(ERROR);
					tip[6].setText("此处不能为空");
				}else{
					tipType[6].setImage(CORRECT);
					tip[6].setText("");
				}
			}
		});
		GridPane.setConstraints(birthPick, 1, 7);
		
		
		Button confirm = new Button("注册");
		confirm.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("请确认您的信息无误");
			alert.getDialogPane().setHeaderText(null);
			alert.showAndWait().ifPresent(type -> {
				if(type.equals(ButtonType.OK)){
					boolean isComplete = tipType[0].getImage().equals(CORRECT);
					for(int i = 1; i < tipType.length; i ++){
						isComplete = isComplete && tipType[i].getImage().equals(CORRECT);
					}
					if(isComplete){
						if(new UserBLServiceImpl().add(new UserVO(accountInput.getText(),passwordInput.getText(),nameInput.getText(),
								(String)sexChoose.getSelectedToggle().getUserData(),phoneInput.getText(),null,null,
								birthPick.getValue().getYear(),birthPick.getValue().getMonthValue(),birthPick.getValue().getDayOfMonth(),
								UserType.CUSTOMER)) > 0){
							Alert a = new Alert(AlertType.INFORMATION);
							a.setContentText("注册成功！");
							a.getDialogPane().setHeaderText(null);
							a.showAndWait().ifPresent(ok -> {
								MainPane.getInstance().logout();
								
							});
							
						}
					}else{
						Alert warn = new Alert(AlertType.ERROR);
						warn.setContentText("信息尚未填写完备");
						warn.getDialogPane().setHeaderText(null);
						warn.show();
					}
				}
			});
		});
		GridPane.setConstraints(confirm, 0, 8);
		
		Button cancel = new Button("取消");
		cancel.setOnAction(e -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setContentText("确定要放弃注册吗？");
			alert.getDialogPane().setHeaderText(null);
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
				nameInput,sexPick,phoneInput,birthPick,confirm,cancel,birth,sep);
		this.setVgap(20);
		this.setHgap(5);
		this.setPadding(new Insets(100,150,150,150));
		this.setStyle("-fx-border-color:black;-fx-font-size:14;");
		account.requestFocus();
	}
	
	
}
