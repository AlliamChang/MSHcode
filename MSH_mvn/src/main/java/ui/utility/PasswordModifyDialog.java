package ui.utility;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.util.Pair;

public class PasswordModifyDialog extends Dialog<Pair<String,String> >{

	private Label oldPass,newPass;
	private PasswordField oldPasswr,newPasswr;
	private GridPane pane;
	
	public PasswordModifyDialog(){
		super();
		setTitle("修改密码");
		initModality(Modality.APPLICATION_MODAL);
		
		oldPass = new Label("旧的密码：");
		newPass = new Label("新的密码：");
		oldPasswr = new PasswordField();
		newPasswr = new PasswordField();
		pane = new GridPane();
		pane.add(oldPass, 0, 0);
		pane.add(newPass, 0, 1);
		pane.add(oldPasswr, 1, 0);
		pane.add(newPasswr, 1, 1);
		pane.setVgap(20);
		getDialogPane().setContent(pane);
		
		ButtonType type = new ButtonType("修改", ButtonData.OK_DONE); 
		getDialogPane().getButtonTypes().add(type);
		Node button = getDialogPane().lookupButton(type);
		button.setDisable(true);
		
		oldPasswr.textProperty().addListener((o, old_val, new_val)
				-> button.setDisable(new_val.trim().isEmpty() || newPasswr.getText().trim().isEmpty()));
		newPasswr.textProperty().addListener((o, old_val, new_val)
				-> button.setDisable(new_val.trim().isEmpty() || oldPasswr.getText().trim().isEmpty()));
		
		Platform.runLater(() -> oldPasswr.requestFocus());
		
		setResultConverter(dialogButton -> {
			if (dialogButton != null)
				return new Pair<>(oldPasswr.getText(), newPasswr.getText());
			else
				return null;
		});
	}
}
