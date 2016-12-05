package ui.webAdmin;

import ui.utility.MainPane;
import ui.utility.MyImageView;
import vo.UserVO;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Modality;

public class ModifyUserInfoPane extends AnchorPane{
	private Label typeLabel, nameLabel, genderLabel, phoneNumberLabel, accountLabel;
	private TextField nameField, numberField;
	private ChoiceBox<String> genderBox;
	private GridPane grid;
	private MyImageView userImage;
	private VBox imageNameBox;
	private HBox buttonBox;
	private Button confirmButton, cancelButton;
	
	public ModifyUserInfoPane(UserVO user, Parent lastPane){
		setStyle("-fx-border-color: black");
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
		typeLabel = new Label("账户类型：" + UserInfoPane.typeCheck(user.getType()));
		nameLabel = new Label("姓名：");
		nameField = new TextField(user.getName());
		nameField.setFocusTraversable(false);
		nameField.setMaxWidth(170);
		genderLabel = new Label("性别：");
		genderBox = new ChoiceBox<String>();
		genderBox.getItems().addAll("男", "女");
		genderBox.getSelectionModel().select(user.getGender());
		genderBox.setFocusTraversable(false);
		phoneNumberLabel = new Label("联系电话：");
		numberField = new TextField(user.getNumber()){
			public void replaceText(int start, int end, String text){
				if (text.matches("[0-9]{0,}"))
					super.replaceText(start, end, text);
			}
			
			public void replaceSelection(String text){
				if (text.matches("[0-9]{0,}"))
					super.replaceSelection(text);
			}
		};
		numberField.setFocusTraversable(false);
		numberField.setMaxWidth(170);
		grid = new GridPane();
		grid.setVgap(30);
		grid.add(typeLabel, 0, 0, 2, 1);
		grid.add(nameLabel, 0, 1);
		grid.add(nameField, 1, 1);
		grid.add(genderLabel, 0, 2);
		grid.add(genderBox, 1, 2);
		grid.add(phoneNumberLabel, 0, 3);
		grid.add(numberField, 1, 3);
		getChildren().add(grid);
		AnchorPane.setTopAnchor(grid, 120.0);
		AnchorPane.setLeftAnchor(grid, 70.0);
		

		userImage = new MyImageView(user.getImage());
		userImage.setFitWidth(200); userImage.setFitHeight(200);
		accountLabel = new Label(user.getAccount() != null ? user.getAccount() : ("ID: " + String.format("%08d", user.getID())));
		accountLabel.setPrefWidth(200);
		accountLabel.setMaxWidth(200);
		accountLabel.setStyle("-fx-font-size: 30px; -fx-alignment: center;");
		imageNameBox = new VBox();
		imageNameBox.getChildren().addAll(userImage, accountLabel);
		getChildren().add(imageNameBox);
		AnchorPane.setRightAnchor(imageNameBox, 70.0);
		AnchorPane.setTopAnchor(imageNameBox, 90.0);
		
		confirmButton = new Button("确定");
		cancelButton = new Button("取消");
		confirmButton.setPrefSize(80, 30);
		cancelButton.setPrefSize(80, 30);
		buttonBox = new HBox();
		buttonBox.setSpacing(30);
		buttonBox.getChildren().addAll(confirmButton, cancelButton);	
		getChildren().add(buttonBox);
		AnchorPane.setRightAnchor(buttonBox, 100.0);
		AnchorPane.setBottomAnchor(buttonBox, 40.0);
		
		confirmButton.setOnAction(e -> {
			AlertType type;
			String content;
			Alert alert;
			if (nameField.getText() == null || nameField.getText().length() == 0 
					|| numberField.getText() == null || numberField.getText().length() == 0){
				content = "信息不完整！";
				type = AlertType.ERROR;
			} else {
				content = "确认修改？";
				type = AlertType.CONFIRMATION;
			}
			alert = new Alert(type);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.setHeaderText(null);
			alert.setContentText(content);
			if (type == AlertType.CONFIRMATION)
				alert.showAndWait().filter(r -> r == ButtonType.OK).ifPresent(r -> {
					user.setName(nameField.getText());
					user.setGender(genderBox.getValue());
					user.setNumber(numberField.getText());
					WebAdminController.getInstance().modifyUser(user);
					WebAdminController.getInstance().go(lastPane, user);
				});
			else
				alert.show();
		});
		
		cancelButton.setOnAction(e -> {
			WebAdminController.getInstance().goBack(lastPane);;
		});
	}
}
