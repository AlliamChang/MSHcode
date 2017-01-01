package ui.websiteStuff;

import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import java.util.*;
import vo.*;
import tools.*;
import ui.utility.*;
import javafx.scene.image.*;
import javafx.beans.value.ObservableValue;
import javafx.geometry.*;
import javafx.scene.text.*;

public class VipCostPane extends GridPane{
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",20);
	
	
	private Label startLabel;
	private Label levelUpLabel;
	private Label vipCostLabel;
	//private Label halfLabel;
	private TextField levelUpField;
	private TextField vipCostField;
	private Button sureButton;
	private Button backButton;
	private boolean isReturnAll;
	
	public VipCostPane(){
        
		this.start();
	}
	
	
	public void start(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
        this.startLabel=new Label("制定VIP等级及折扣");
        startLabel.setFont(startFont);
        this.setHalignment(startLabel, HPos.LEFT);
        this.setValignment(startLabel, VPos.CENTER);
        
        /*this.inputLabel=new Label("请选择满多少信用值");
        sureLabel.setFont(normalFont);
        this.setHalignment(sureLabel, HPos.LEFT);
        this.setValignment(sureLabel, VPos.CENTER);*/
        
        this.levelUpLabel=new Label("升级所需的信用值数量");
        levelUpLabel.setFont(normalFont);
        this.setHalignment(levelUpLabel, HPos.LEFT);
        this.setValignment(levelUpLabel, VPos.CENTER);
        
        this.vipCostLabel=new Label("每一等级所享有的折扣");
        vipCostLabel.setFont(normalFont);
        this.setHalignment(vipCostLabel, HPos.LEFT);
        this.setValignment(vipCostLabel, VPos.CENTER);
        
        this.levelUpField=new TextField();
        levelUpField.setFont(normalFont);
        this.setHalignment(levelUpField, HPos.LEFT);
        this.setValignment(levelUpField, VPos.CENTER);
        
        this.vipCostField=new TextField();
        vipCostField.setFont(normalFont);
        this.setHalignment(vipCostField, HPos.LEFT);
        this.setValignment(vipCostField, VPos.CENTER);
        
        /*group=new ToggleGroup();
        this.allButton=new RadioButton();
        allButton.setToggleGroup(group);
        
        this.halfButton=new RadioButton();
        halfButton.setToggleGroup(group);
        */
        this.sureButton=new Button("确定");
        sureButton.setFont(normalFont);
        this.backButton=new Button("取消");
        backButton.setFont(normalFont);
        this.setHalignment(backButton, HPos.LEFT);
        
        this.add(startLabel, 1, 1,5,1);
        //this.add(Label, 2, 2,5,1);
        this.add(levelUpLabel, 2, 3,2,1);
        this.add(vipCostLabel, 2, 4,2,1);
        this.add(levelUpField, 4, 3);
        this.add(vipCostField, 4, 4);
        this.add(sureButton, 2, 5);
        this.add(backButton, 4, 5);
        
        if(WebsitePaneController.getInstance().getLvUpRequest()!=0)
        	levelUpField.setText(String.valueOf(WebsitePaneController.getInstance().getLvUpRequest()));
        
        
        
        this.getRowConstraints().add(new RowConstraints(20));
        this.getRowConstraints().add(new RowConstraints(100));
        this.getRowConstraints().add(new RowConstraints(70));
        this.getRowConstraints().add(new RowConstraints(100));
        this.getRowConstraints().add(new RowConstraints(150));
		this.getColumnConstraints().add(new ColumnConstraints(20));
		this.getColumnConstraints().add(new ColumnConstraints(120));
		this.getColumnConstraints().add(new ColumnConstraints(100));
		this.getColumnConstraints().add(new ColumnConstraints(150));
		this.getColumnConstraints().add(new ColumnConstraints(120));
		
		
		sureButton.setOnAction(e ->{
			if(levelUpField.getText().equals("")||vipCostField.getText().equals("")){
				Alert alert=new Alert(AlertType.ERROR);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.setHeaderText(null);
				alert.setContentText("请填写完整的数值！");
				alert.showAndWait();
			}
			else {
				Alert alert=new Alert(AlertType.CONFIRMATION);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.setHeaderText(null);
				alert.setContentText("确定更改吗？");
				alert.showAndWait().ifPresent(response ->{
					if(response==ButtonType.OK){
						WebsitePaneController.getInstance().setLvUpRequest(Integer.parseInt(levelUpField.getText()));
						
					}
				});
			}
		});
		
		backButton.setOnAction(e ->{
			Alert alert=new Alert(AlertType.CONFIRMATION);
			alert.initModality(Modality.APPLICATION_MODAL);
			alert.getDialogPane().setHeaderText(null);
			alert.getDialogPane().setContentText("确定要取消，返回上一个界面吗？");
			alert.showAndWait().ifPresent(response ->{
				if(response==ButtonType.OK){
					System.out.println("取消并返回");
					WebsitePaneController.getInstance().createDealPane();
				}
			});
		});
	}

}
