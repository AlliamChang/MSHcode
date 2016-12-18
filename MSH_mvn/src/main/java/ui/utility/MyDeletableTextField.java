package ui.utility;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public class MyDeletableTextField extends StackPane{

	private Button delete;
	private TextField edit;
	private ImageView view = new ImageView(new Image(MyDeletableTextField.class.getResourceAsStream("/image/search-clear-over.png"),12,12,false,false));
	
	public MyDeletableTextField(Pane p){
		delete = new Button(null,view);
		delete.setVisible(false);
		delete.setStyle("-fx-background-color:white;");
		delete.setPrefSize(12, 12);
		delete.setMaxSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
		delete.setMinSize(Button.USE_PREF_SIZE, Button.USE_PREF_SIZE);
		delete.toFront();
		StackPane.setMargin(delete, new Insets(0,0,33,96));
//		StackPane.setAlignment(delete, Pos.TOP_RIGHT);
		edit = new TextField();
		edit.setMaxWidth(100);
		
		delete.setOnAction(e -> {
			p.getChildren().remove(this);
		});
		
		this.setOnMouseEntered(e -> {
			delete.setVisible(true);
		});
		this.setOnMouseExited(e -> {
			delete.setVisible(false);
		});
//		edit.setOnMouseExited(e -> {
//			delete.setVisible(false);
//		});
		
		this.setPrefSize(100, 20);
		this.setMaxSize(StackPane.USE_PREF_SIZE, StackPane.USE_PREF_SIZE);
		this.setMinSize(StackPane.USE_PREF_SIZE, StackPane.USE_PREF_SIZE);
		this.getChildren().addAll(edit,delete);
	}
	
	public MyDeletableTextField(Pane p,String text){
		this(p);
		this.edit.setText(text);
	}
	
	public String getContent(){
		return this.edit.getText();
	}
}
