package ui.websiteStuff;

import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.*;
import vo.*;
import tools.*;
import ui.utility.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.text.*;

public class CreditPane extends GridPane{
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",20);
	
	private Label startLabel;
	private Label idLabel;
	private Label creditLabel;
	private TextField nameField;
	private TextField creditField;
	private Button chargeButton;
	private UserVO user;
	
	public CreditPane(UserVO user){
		this.user=user;
		this.start();
	}
	
	
	private void start(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setMaxSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
		this.startLabel=new Label("用户信用充值");
		startLabel.setFont(startFont);
		this.setHalignment(startLabel, HPos.LEFT);
		this.setValignment(startLabel, VPos.CENTER);
		
		this.idLabel=new Label("用户ID");
		idLabel.setFont(normalFont);
		this.setHalignment(idLabel, HPos.LEFT);
		this.setValignment(idLabel, VPos.CENTER);
		
		this.creditLabel=new Label("信用值");
		creditLabel.setFont(normalFont);
		this.setHalignment(creditLabel, HPos.LEFT);
		this.setValignment(creditLabel, VPos.CENTER);
		
		this.nameField=new TextField();
		nameField.setFont(normalFont);
		this.setHalignment(nameField, HPos.LEFT);
		this.setValignment(nameField, VPos.CENTER);
		
		this.creditField=new TextField();
		creditField.setFont(normalFont);
		this.setHalignment(creditField, HPos.LEFT);
		this.setValignment(creditField, VPos.CENTER);
		
		this.chargeButton=new Button("充值");
		chargeButton.setFont(normalFont);
		
		this.add(startLabel, 1, 1,5,1);
		this.add(idLabel, 3, 3);
		this.add(creditLabel, 3, 4);
		this.add(nameField, 5, 3);
		this.add(creditField, 5, 4);
		this.add(chargeButton, 4, 5);
		
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		
		this.getRowConstraints().add(new RowConstraints(50));
		this.getRowConstraints().add(new RowConstraints(120));
		this.getRowConstraints().add(new RowConstraints(180));
		this.getColumnConstraints().add(new ColumnConstraints(20));
		this.getColumnConstraints().add(new ColumnConstraints(20));
		
		this.getColumnConstraints().add(new ColumnConstraints(120));
		this.getColumnConstraints().add(new ColumnConstraints(80));
		this.getColumnConstraints().add(new ColumnConstraints(100));
		this.getColumnConstraints().add(new ColumnConstraints(120));
	}

}
