package ui;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.Pos;
public class parent extends Parent{
	
	public static Parent createparent(){
		loginBox login=new loginBox();
		
		Label title=new Label("酒店预订系统");
		title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 30));
		GridPane grid=new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.add(title,1,1);
		
		HBox hbox=new HBox(2);
		hbox.setSpacing(200);
		hbox.getChildren().addAll(login.createLoginBox(),grid);
		return hbox;
	}
}
