package ui.utility;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.util.Pair;

public class LoginDialog extends Dialog<Pair<String, String> >{
	private Label accountLabel, passwordLabel;
	private TextField accountField, passwordField;
	private GridPane grid;
	
	public LoginDialog(){
		super();
		setTitle("登录");
		initModality(Modality.APPLICATION_MODAL);
		
		accountLabel = new Label("账号：");
		accountLabel.setMinWidth(50);
		passwordLabel = new Label("密码：");
		accountField = new TextField();
		passwordField = new PasswordField();
		grid = new GridPane();
		grid.add(accountLabel, 0, 0);
		grid.add(passwordLabel, 0, 1);
		grid.add(accountField, 1, 0);
		grid.add(passwordField, 1, 1);
		grid.setVgap(20);
		getDialogPane().setContent(grid);
		
		ButtonType type = new ButtonType("登录", ButtonData.OK_DONE); 
		getDialogPane().getButtonTypes().add(type);
		Node button = getDialogPane().lookupButton(type);
		button.setDisable(true);
		
		accountField.textProperty().addListener((o, old_val, new_val)
				-> button.setDisable(new_val.trim().isEmpty() || passwordField.getText().trim().isEmpty()));
		passwordField.textProperty().addListener((o, old_val, new_val)
				-> button.setDisable(new_val.trim().isEmpty() || accountField.getText().trim().isEmpty()));
		
		Platform.runLater(() -> accountField.requestFocus());
		
		setResultConverter(dialogButton -> {
			if (dialogButton != null)
				return new Pair<>(accountField.getText(), passwordField.getText());
			else
				return null;
		});
	}
}