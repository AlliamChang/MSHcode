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

public class CancelSurePane extends GridPane{
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",20);
	
	private OrderVO order;
	private int userId;
	
	private Label startLabel;
	private Label sureLabel;
	private Label allLabel;
	private Label halfLabel;
	private RadioButton allButton;
	private RadioButton halfButton;
	private Button cancelButton;
	private Button backButton;
	private ToggleGroup group;
	private boolean isReturnAll;
	
	public CancelSurePane(OrderVO order){
        this.order=order;
        this.userId=userId;
		this.start();
	}
	
	
	public void start(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		
        this.startLabel=new Label("确认撤销");
        startLabel.setFont(startFont);
        this.setHalignment(startLabel, HPos.LEFT);
        this.setValignment(startLabel, VPos.CENTER);
        
        this.sureLabel=new Label("请选择恢复的信用值数量");
        sureLabel.setFont(normalFont);
        this.setHalignment(sureLabel, HPos.LEFT);
        this.setValignment(sureLabel, VPos.CENTER);
        
        this.allLabel=new Label("恢复全部信用值");
        allLabel.setFont(normalFont);
        this.setHalignment(allLabel, HPos.LEFT);
        this.setValignment(allLabel, VPos.CENTER);
        
        this.halfLabel=new Label("恢复一半信用值");
        halfLabel.setFont(normalFont);
        this.setHalignment(halfLabel, HPos.LEFT);
        this.setValignment(halfLabel, VPos.CENTER);
        
        group=new ToggleGroup();
        this.allButton=new RadioButton();
        allButton.setToggleGroup(group);
        
        this.halfButton=new RadioButton();
        halfButton.setToggleGroup(group);
        
        this.cancelButton=new Button("撤销");
        cancelButton.setFont(normalFont);
        this.backButton=new Button("取消");
        backButton.setFont(normalFont);
        this.setHalignment(backButton, HPos.RIGHT);
        
        this.add(startLabel, 1, 1,5,1);
        this.add(sureLabel, 2, 2,5,1);
        this.add(allButton, 2, 3);
        this.add(halfButton, 2, 4);
        this.add(allLabel, 3, 3);
        this.add(halfLabel, 3, 4);
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
							MarketingPaneController.getInstance().cancelAbnormity(order.getId(), isReturnAll);
							MarketingPaneController.getInstance().createDealPane();
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
					MarketingPaneController.getInstance().createDealPane();
				}
			});
		});
	}

}
