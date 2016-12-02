package ui.webAdmin;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;
import javafx.beans.value.*;

public class SearchBox extends Region {
	private TextField textBox;
	private Button clearButton;
	
	public SearchBox(Button searchButton){
		setId("SearchBox");
		getStyleClass().add("search-box");
		setMinHeight(30);
		setPrefSize(350, 30);
		setMaxSize(Control.USE_PREF_SIZE, Control.USE_PREF_SIZE);
		textBox = new TextField();
		textBox.setPromptText("输入账号或ID");
		clearButton = new Button();
		clearButton.setId("clearButton");
		clearButton.setVisible(false);
		getChildren().addAll(textBox, clearButton);
		clearButton.setOnAction(event -> {
            textBox.setText("");
            textBox.requestFocus();
        });
		textBox.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
			clearButton.setVisible(textBox.getText().length() != 0);
		});
		
		textBox.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER)
				searchButton.fire();
		});
	}
	
	protected void layoutChildren(){
		textBox.resize(getWidth(),  getHeight());
		clearButton.resizeRelocate(getWidth() - 18, 8.5, 12, 13);
	}
	
	public String getContent(){
		return textBox.getText();
	}
}
