package ui.webAdmin;

import ui.utility.MainPane;
import ui.utility.MyImageView;
import ui.utility.MyNumberField;
import vo.UserVO;
import javafx.beans.value.ObservableValue;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import tools.UserType;

public class ModifyUserInfoPane extends AnchorPane{
	private Label typeLabel, nameLabel, genderLabel, phoneNumberLabel, accountLabel, companyLabel;
	private TextField nameField, numberField, companyField;
	private ChoiceBox<String> genderBox;
	private GridPane grid;
	private MyImageView userImage;
	private VBox imageNameBox;
	private HBox buttonBox, typeBox;
	private Button confirmButton, cancelButton;
	private ToggleButton customerButton, companyCustomerButton;
	private ToggleGroup group;
	
	public ModifyUserInfoPane(UserVO user, Parent lastPane){
		setStyle("-fx-border-color: black");
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);

		typeLabel = new Label("账户类型：");
		grid = new GridPane();
		if (user.getType() != UserType.CUSTOMER && user.getType() != UserType.COMPANY_CUSTOMER)
			grid.add(new Label(UserInfoPane.typeCheck(user.getType())), 1, 0);
		else {
			companyLabel = new Label("企业：");
			companyField = new TextField(user.getCompany());
			customerButton = new ToggleButton("普通会员");
			customerButton.setStyle("-fx-background-radius: 3 0 0 3, 3 0 0 3, 2 0 0 2, 1 0 0 1;");
			companyCustomerButton = new ToggleButton("企业会员");
			companyCustomerButton.setStyle("-fx-background-radius: 0 3 3 0, 0 3 3 0, 0 2 2 0, 0 1 1 0;");
			group = new ToggleGroup();
			customerButton.setToggleGroup(group);
			companyCustomerButton.setToggleGroup(group);
			group.selectedToggleProperty().addListener(
					(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
						if (newValue == null) {
							group.selectToggle(oldValue);
						} else {
							if (newValue.equals(companyCustomerButton)) {
								grid.add(companyLabel, 0, 4);
								grid.add(companyField, 1, 4);
							} else {
								grid.getChildren().remove(companyLabel);
								grid.getChildren().remove(companyField);
							}
						}
			});
			group.selectToggle(user.getType() == UserType.CUSTOMER ? customerButton : companyCustomerButton);
			typeBox = new HBox();
			typeBox.getChildren().addAll(customerButton, companyCustomerButton);
			grid.add(typeBox, 1, 0);
		}
		
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
		numberField = new MyNumberField(user.getNumber());
		numberField.setFocusTraversable(false);
		numberField.setMaxWidth(170);
		grid.setVgap(30);
		grid.add(typeLabel, 0, 0);
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
		AnchorPane.setTopAnchor(imageNameBox, 70.0);
		
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
			if (nameField.getText().trim().isEmpty()
					|| numberField.getText().trim().isEmpty()){
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
					user.setType(group.getSelectedToggle().equals(customerButton) ? UserType.CUSTOMER : UserType.COMPANY_CUSTOMER);
					user.setCompany(user.getType() == UserType.COMPANY_CUSTOMER ? companyField.getText() : null);
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
