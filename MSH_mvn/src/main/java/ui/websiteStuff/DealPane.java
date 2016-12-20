package ui.websiteStuff;

import javafx.scene.text.Font;
import javafx.stage.Modality;
import tools.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import java.util.List;
import java.util.ArrayList;
import vo.*;
import tools.*;
import ui.utility.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;

public class DealPane extends GridPane{
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",15);
	private static final Font buttonFont=new Font("方正幼圆",20);
	
	private List<OrderVO> order;
	
	private Label startLabel;
	private Label numberLabel;
	private Label nameLabel;
	private Label startTimeLabel;
	private Label endTimeLabel;
	private Button cancelButton;
	private ToggleGroup group;
	RadioButton[] button=new RadioButton[9];
	
	private Text numberText;
	private Text nameText;
	private Text startTimeText;
	private Text endTimeText;
	
	public DealPane(List<OrderVO> order){
		super();
		this.order=order;
		this.start();
	}
	
	
	private void start(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setGridLinesVisible(false);
		
		this.startLabel=new Label("异常订单列表");
		startLabel.setFont(startFont);
		this.setHalignment(startLabel, HPos.LEFT);
		this.setValignment(startLabel, VPos.CENTER);
		
		this.numberLabel=new Label("订单编号");
		numberLabel.setFont(normalFont);
		this.setHalignment(numberLabel, HPos.CENTER);
		this.setValignment(numberLabel, VPos.CENTER);
		
		this.nameLabel=new Label("用户姓名");
		nameLabel.setFont(normalFont);
		this.setHalignment(nameLabel, HPos.CENTER);
		this.setValignment(nameLabel, VPos.CENTER);
		
		this.startTimeLabel=new Label("订单开始时间");
		startTimeLabel.setFont(normalFont);
		this.setHalignment(startTimeLabel, HPos.CENTER);
		this.setValignment(startTimeLabel, VPos.CENTER);
		
		this.endTimeLabel=new Label("订单结束时间");
		endTimeLabel.setFont(normalFont);
		this.setHalignment(endTimeLabel, HPos.CENTER);
		this.setValignment(endTimeLabel, VPos.CENTER);
		
		this.cancelButton=new Button("撤销");
		
		

		group=new ToggleGroup();
		for(int i=0;i<button.length;i++){
			button[i]=new RadioButton();
			button[i].setToggleGroup(group);
			button[i].setVisible(false);
			this.add(button[i], 1, i+3);
		}
		/*button1.setToggleGroup(group);
		button2.setToggleGroup(group);
		button3.setToggleGroup(group);
		button4.setToggleGroup(group);
		button5.setToggleGroup(group);
		button6.setToggleGroup(group);
		button7.setToggleGroup(group);
		button8.setToggleGroup(group);
		button9.setToggleGroup(group);
		this.add(button1, 1, 3);
		this.add(button1, 1, 4);
		this.add(button1, 1, 5);
		this.add(button1, 1, 6);
		this.add(button1, 1, 7);
		this.add(button1, 1, 8);
		this.add(button1, 1, 9);
		this.add(button1, 1, 10);
		this.add(button1, 1, 11);
		button1.setVisible(false);
		button2.setVisible(false);
		button3.setVisible(false);
		button4.setVisible(false);
		button5.setVisible(false);
		button6.setVisible(false);
		button7.setVisible(false);
		button8.setVisible(false);
		button9.setVisible(false);*/
		
		cancelButton=new Button("撤销");
		this.setHalignment(cancelButton, HPos.RIGHT);
		this.setValignment(cancelButton, VPos.TOP);
		cancelButton.setFont(buttonFont);
		
		this.add(startLabel, 1, 1,5,1);
		this.add(numberLabel, 2, 2);
		this.add(nameLabel, 3, 2);
		this.add(startTimeLabel, 4, 2);
		this.add(endTimeLabel, 5, 2);
		this.add(cancelButton, 3, 13);
        
		if(order.get(0)!=null){
		    for(int i=0;i<order.size();i++){
			    Text numberText=new Text();
			    numberText.setFont(normalFont);
			    this.setHalignment(numberText, HPos.CENTER);
			    this.setValignment(numberText, VPos.CENTER);
			    numberText.setText(String.valueOf(order.get(i).getId()));
			    this.add(numberText, 2, i+3);
			    Text nameText=new Text();
			    nameText.setFont(normalFont);
			    this.setHalignment(nameText, HPos.CENTER);
			    this.setValignment(nameText, VPos.CENTER);
			    nameText.setText("用户姓名");
			    this.add(nameText, 3, i+3);
			    Text startTimeText=new Text();
			    startTimeText.setFont(normalFont);
			    this.setHalignment(startTimeText, HPos.CENTER);
			    this.setValignment(startTimeText, VPos.CENTER);
			    startTimeText.setText(order.get(i).getPreCheckin().getDate());
			    this.add(startTimeText, 4, i+3);
			    Text endTimeText=new Text();
			    endTimeText.setFont(normalFont);
			    this.setHalignment(endTimeText, HPos.CENTER);
			    this.setValignment(endTimeText, VPos.CENTER);
			    endTimeText.setText(order.get(i).getCheckin().getDate());
			    this.add(endTimeText, 5, i+3);
			    button[i].setVisible(true);
		    }
		}
		
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(40));
		this.getRowConstraints().add(new RowConstraints(20));
		this.getColumnConstraints().add(new ColumnConstraints(20));
		this.getColumnConstraints().add(new ColumnConstraints(40));
		this.getColumnConstraints().add(new ColumnConstraints(120));
		this.getColumnConstraints().add(new ColumnConstraints(120));
		this.getColumnConstraints().add(new ColumnConstraints(120));
		this.getColumnConstraints().add(new ColumnConstraints(120));
		
		group.selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> observable,Toggle oldValue,Toggle newValue)->{
					if(group.getSelectedToggle()!=null){
						cancelButton.setOnAction(e ->{
							int i=0;
							while(!button[i].isSelected()){
								i++;
							}
							WebsitePaneController.getInstance().createCancelSurePane(order.get(i),order.get(i).getUserID());
						});
					}
				});
		
		cancelButton.setOnAction(e ->{
			if(group.getSelectedToggle()==null){
				Alert alert=new Alert(AlertType.ERROR);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.setHeaderText(null);
				alert.setContentText("异常订单不存在或没有选中一个异常订单!");
				alert.showAndWait();
			}
		});
	}
	
	

}
