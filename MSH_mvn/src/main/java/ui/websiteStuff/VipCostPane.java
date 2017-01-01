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
	private RadioButton levelCostField;
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
        
        this.levelUpLabel=new Label("请填写升级所需的信用值数量");
        levelUpLabel.setFont(normalFont);
        this.setHalignment(levelUpLabel, HPos.LEFT);
        this.setValignment(levelUpLabel, VPos.CENTER);
        
        this.vipCostLabel=new Label("请填写每一等级所享有的折扣");
        vipCostLabel.setFont(normalFont);
        this.setHalignment(vipCostLabel, HPos.LEFT);
        this.setValignment(vipCostLabel, VPos.CENTER);
        
        /*group=new ToggleGroup();
        this.allButton=new RadioButton();
        allButton.setToggleGroup(group);
        
        this.halfButton=new RadioButton();
        halfButton.setToggleGroup(group);
        
        this.cancelButton=new Button("撤销");
        cancelButton.setFont(normalFont);
        this.backButton=new Button("取消");
        backButton.setFont(normalFont);
        this.setHalignment(backButton, HPos.RIGHT);*/
        
        this.add(startLabel, 1, 1,5,1);
        //this.add(Label, 2, 2,5,1);
        this.add(allButton, 2, 3);
        this.add(halfButton, 2, 4);
        this.add(levelUpLabel, 3, 3);
        this.add(vipCostLabel, 3, 4);
        this.add(cancelButton, 2, 5);
        this.add(backButton, 3, 5);
        
        this.getRowConstraints().add(new RowConstraints(20));
        this.getRowConstraints().add(new RowConstraints(100));
        this.getRowConstraints().add(new RowConstraints(100));
        this.getRowConstraints().add(new RowConstraints(100));
        this.getRowConstraints().add(new RowConstraints(120));
		this.getColumnConstraints().add(new ColumnConstraints(20));
		this.getColumnConstraints().add(new ColumnConstraints(120));
		this.getColumnConstraints().add(new ColumnConstraints(100));
		
		group.selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> observable,Toggle oldValue,Toggle newValue)->{
					if(group.getSelectedToggle()!=null){
						cancelButton.setOnAction(e ->{
							if(allButton.isSelected()){
								isReturnAll=true;
							}
							else{
								isReturnAll=false;
							}
							WebsitePaneController.getInstance().cancelAbnormity(order.getId(), isReturnAll);	
						});
					}
				});
		cancelButton.setOnAction(e ->{
			if(group.getSelectedToggle()==null){
				Alert alert=new Alert(AlertType.ERROR);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.setHeaderText(null);
				alert.setContentText("请选择恢复的信用值数量！");
				alert.showAndWait();
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
