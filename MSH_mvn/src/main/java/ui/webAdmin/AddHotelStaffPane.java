package ui.webAdmin;

import tools.UserType;
import ui.utility.MainPane;
import vo.UserVO;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;

public class AddHotelStaffPane extends AnchorPane {
	private GridPane grid;
	private Label userTypeLabel, nameLabel, genderLabel, numberLabel;
	private TextField nameField, numberField;
	private HBox hBox;
	private Button confirm, cancel;
	private ChoiceBox<String> genderBox;
	
	public AddHotelStaffPane(AddHotelPane owner){
		super();
		setStyle("-fx-border-color: black");
		setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
		grid = new GridPane();
		userTypeLabel = new Label("账号类型：酒店工作人员");
		nameLabel = new Label("姓名");
		genderLabel = new Label("性别");
		genderBox = new ChoiceBox<String>();
		genderBox.getItems().addAll("男", "女");
		numberLabel = new Label("电话：");
		nameField = new TextField();
		numberField = new TextField(){
			public void replaceText(int start, int end, String text){
				if (text.matches("[0-9]{0,}"))
					super.replaceText(start, end, text);
			}
			
			public void replaceSelection(String text){
				if (text.matches("[0-9]{0,}"))
					super.replaceSelection(text);
			}
		};
		
		grid.setVgap(25);
		grid.setHgap(5);
		
		grid.add(userTypeLabel, 0, 0, 2, 1);
		grid.add(nameLabel, 0, 1);
		grid.add(nameField, 1, 1, 2, 1);
		grid.add(genderLabel, 0, 2);
		grid.add(genderBox, 1, 2);
		grid.add(numberLabel, 0, 3);
		grid.add(numberField, 1, 3, 2, 1);
		
		hBox = new HBox();
		hBox.setSpacing(30);
		confirm = new Button("确定");
		cancel = new Button("取消");
		confirm.setPrefSize(80, 30);
		cancel.setPrefSize(80, 30);
		hBox.getChildren().add(confirm);
		hBox.getChildren().add(cancel);
		

		getChildren().addAll(grid, hBox);
		
		AnchorPane.setBottomAnchor(hBox, 40.0);
		AnchorPane.setRightAnchor(hBox, 100.0);
		AnchorPane.setLeftAnchor(grid, 190.0);
		AnchorPane.setTopAnchor(grid, 180.0);
		
		confirm.setOnAction(event -> {
			if (nameField.getText() == null || nameField.getText().replace(" ", "").length() == 0
					|| numberField.getText() == null || numberField.getText().replace(" ", "").length() == 0
					|| genderBox.getValue() == null){
				Alert alert = new Alert(AlertType.ERROR, "");
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.getDialogPane().setHeaderText(null);
				alert.getDialogPane().setContentText("信息不完整！");
				alert.show();
				return;
			} else {
				owner.changeLabel(nameField.getText());
				owner.changeButton();
				owner.setAddPane(AddHotelStaffPane.this);
				WebAdminController.getInstance().goBack(owner);
			}
		});
		cancel.setOnAction(event -> {
			WebAdminController.getInstance().goBack(owner);
		});
	}
	
	public UserVO createStaff(){
		return new UserVO(null, UserVO.INIT_PASSWORD, nameField.getText(), genderBox.getValue(), numberField.getText(), UserType.HOTEL_STAFF);
	}
}
