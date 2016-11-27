package ui.webAdmin;

import tools.UserType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class AddUserPane extends AnchorPane{
	public AddUserPane(UserType userType){
		super();
//		this.setGridLinesVisible(true);
		setStyle("-fx-font-family: YouYuan; -fx-font-size: 20px;");
		GridPane grid = new GridPane();
		Label setAccountLabel = new Label("设置登录账号：");
		Label userTypeLabel = new Label("账号类型：" + (userType == UserType.MARKETER ? "网站营销人员" : "酒店工作人员"));
		TextField textField = new TextField();
		textField.setPromptText("如：maketer_0000");
		textField.setMinWidth(250);
		textField.setStyle("-fx-prompt-text-fill: grey;");
		grid.setVgap(15);
		grid.setHgap(5);
		grid.add(setAccountLabel, 0, 0);
		grid.add(textField, 1, 0);
		grid.add(userTypeLabel, 0, 1, 2, 1);
		
		HBox hBox = new HBox();
		hBox.setSpacing(40);
		Button confirm = new Button("确定"), cancel = new Button("取消");
		confirm.setPadding(new Insets(7, 20, 7, 20));
		cancel.setPadding(new Insets(7, 20, 7, 20));
		hBox.getChildren().add(confirm);
		hBox.getChildren().add(cancel);
		

		getChildren().addAll(grid, hBox);
		
		AnchorPane.setBottomAnchor(hBox, 40.0);
		AnchorPane.setRightAnchor(hBox, 100.0);
		AnchorPane.setLeftAnchor(grid, 150.0);
		AnchorPane.setTopAnchor(grid, 240.0);
		
		confirm.setOnAction(event -> {
			System.out.println("Confirm");
		});
		cancel.setOnAction(event -> {
			System.out.println("Cancel");
		});
		
		
	}
}
