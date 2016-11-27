package ui.webAdmin;

import tools.UserType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddUserPane extends AnchorPane{
	private GridPane grid;
	private Label setAccountLabel, userTypeLabel;
	private TextField textField;
	private HBox hBox;
	private Button confirm, cancel;
	
	public AddUserPane(UserType userType){
		super();
		setStyle("-fx-font-size: 20px;");
		grid = new GridPane();
		setAccountLabel = new Label("设置登录账号：");
		userTypeLabel = new Label("账号类型：" + (userType == UserType.MARKETER ? "网站营销人员" : "酒店工作人员"));
		textField = new TextField();
		textField.setPromptText(userType == UserType.MARKETER ? "如：maketer_0000" : "如：XXHotelStuff");
		textField.setMinWidth(250);
		textField.setStyle("-fx-prompt-text-fill: grey;");
		grid.setVgap(15);
		grid.setHgap(5);
		grid.add(setAccountLabel, 0, 0);
		grid.add(textField, 1, 0);
		grid.add(userTypeLabel, 0, 1, 2, 1);
		
		hBox = new HBox();
		hBox.setSpacing(30);
		confirm = new Button("确定");
		cancel = new Button("取消");
		confirm.setPadding(new Insets(7, 25, 7, 25));
		cancel.setPadding(new Insets(7, 25, 7, 25));
		hBox.getChildren().add(confirm);
		hBox.getChildren().add(cancel);
		

		getChildren().addAll(grid, hBox);
		
		AnchorPane.setBottomAnchor(hBox, 40.0);
		AnchorPane.setRightAnchor(hBox, 100.0);
		AnchorPane.setLeftAnchor(grid, 140.0);
		AnchorPane.setTopAnchor(grid, 240.0);
		
		confirm.setOnAction(event -> {
			Alert alert = new Alert(AlertType.INFORMATION, "");
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.getDialogPane().setContentText("添加成功！");
			alert.getDialogPane().setHeaderText(null);
			alert.showAndWait()
				.filter(response -> response == ButtonType.OK)
				.ifPresent(response -> System.out.println("Duang"));
		});
		cancel.setOnAction(event -> {
			System.out.println("Cancel");
		});
	}
}
