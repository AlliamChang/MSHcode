package ui.webAdmin;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class AddMarketerPane extends GridPane{
	public AddMarketerPane(){
		super();
//		this.setGridLinesVisible(true);
		setStyle("-fx-font-family: YouYuan; -fx-font-size: 20px;");
		setAlignment(Pos.CENTER);
		Label setAccount = new Label("设置登录账号："), userType = new Label("账号类型：网站营销人员");
		TextField textField = new TextField();
		textField.setPromptText("如：maketer_0000");
		textField.setMinWidth(250);
		textField.setStyle("-fx-prompt-text-fill: grey;");
		setVgap(15);
		setHgap(15);
		add(setAccount, 0, 10);
		add(textField, 1, 10);
		add(userType, 0, 11, 2, 1);
		
		HBox hBox = new HBox();
		hBox.setAlignment(Pos.CENTER_RIGHT);
		hBox.setSpacing(15);
		Button confirm = new Button("确定"), cancel = new Button("取消");
		confirm.setPadding(new Insets(7, 20, 7, 20));
		cancel.setPadding(new Insets(7, 20, 7, 20));
		hBox.getChildren().add(confirm);
		hBox.getChildren().add(cancel);
		add(hBox, 1, 20, 2, 1);
	}
}
