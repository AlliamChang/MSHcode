package ui.websiteStuff;

import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Toggle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import java.util.*;
import vo.*;
import tools.*;
import ui.utility.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.beans.value.*;

public class StrategyListPane extends GridPane{
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",15);
	private static final String normalPeople="普通及会员";
	private static final String vipPeople="仅限会员";
	
	private Button modifyButton;
	private Button createButton;
	private Button cancelButton;
	private Label startLabel;
	private Label strategyNameLabel;
	private Label peopleLabel;
	private Label costLabel;
	private Label startTimeLabel;
	private Label endTimeLabel;
	//private MyNavigationBar navi;
	private RadioButton[] button=new RadioButton[9];
	/*private RadioButton chooseButton1;
	private RadioButton chooseButton2;
	private RadioButton chooseButton3;
	private RadioButton chooseButton4;
	private RadioButton chooseButton5;
	private RadioButton chooseButton6;
	private RadioButton chooseButton7;
	private RadioButton chooseButton8;
	private RadioButton chooseButton9;*/
	private ToggleGroup group;
	
	private OrderVO vo;
	private List<StrategyVO> strategy;
	
	public StrategyListPane(List<StrategyVO> strategy){
		super();
		this.strategy=strategy;
		
		this.start();
	}

	
	private void start(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setGridLinesVisible(false);
		
		
		this.startLabel=new Label("促销策略列表");
		startLabel.setFont(startFont);
		this.setHalignment(startLabel, HPos.LEFT);
		this.setValignment(startLabel, VPos.CENTER);
		
		this.strategyNameLabel=new Label("策略名称");
		strategyNameLabel.setFont(normalFont);
		this.setHalignment(strategyNameLabel, HPos.CENTER);
		this.setValignment(strategyNameLabel, VPos.CENTER);
		
		this.peopleLabel=new Label("面向人群");
		peopleLabel.setFont(normalFont);
		this.setHalignment(peopleLabel, HPos.CENTER);
		this.setValignment(peopleLabel, VPos.CENTER);
		
		this.costLabel=new Label("折扣");
		costLabel.setFont(normalFont);
		this.setHalignment(costLabel, HPos.CENTER);
		this.setValignment(costLabel, VPos.CENTER);
		
		this.startTimeLabel=new Label("开始时间");
		startTimeLabel.setFont(normalFont);
		this.setHalignment(startTimeLabel, HPos.CENTER);
		this.setValignment(startTimeLabel, VPos.CENTER);
		
		this.endTimeLabel=new Label("结束时间");
		endTimeLabel.setFont(normalFont);
		this.setHalignment(endTimeLabel, HPos.CENTER);
		this.setValignment(endTimeLabel, VPos.CENTER);
		
		group=new ToggleGroup();
		for(int i=0;i<button.length;i++){
			button[i]=new RadioButton();
			button[i].setToggleGroup(group);
			this.add(button[i], 1, i+3);
			button[i].setVisible(false);
		}
		
		createButton=new Button("新增");
		this.setHalignment(createButton, HPos.LEFT);
		this.setValignment(createButton, VPos.BOTTOM);
		
		modifyButton=new Button("修改");
		this.setHalignment(modifyButton, HPos.LEFT);
		this.setValignment(modifyButton, VPos.BOTTOM);
		
		cancelButton=new Button("撤销");
		this.setHalignment(cancelButton, HPos.LEFT);
		this.setValignment(cancelButton, VPos.BOTTOM);
		
		this.add(startLabel,1,1,5,1);
		this.add(strategyNameLabel, 2, 2);
		this.add(peopleLabel, 3, 2);
		this.add(costLabel, 4, 2);
		this.add(startTimeLabel, 5, 2);
		this.add(endTimeLabel, 6, 2);
		this.add(createButton, 3, 12,2,1);
		this.add(modifyButton, 4, 12,2,1);
		this.add(cancelButton, 5, 12,2,1);

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
		this.getRowConstraints().add(new RowConstraints(80));
		this.getColumnConstraints().add(new ColumnConstraints(20));
		this.getColumnConstraints().add(new ColumnConstraints(40));
		this.getColumnConstraints().add(new ColumnConstraints(110));
		this.getColumnConstraints().add(new ColumnConstraints(110));
		this.getColumnConstraints().add(new ColumnConstraints(110));
		this.getColumnConstraints().add(new ColumnConstraints(110));
		this.getColumnConstraints().add(new ColumnConstraints(110));
		
		for(int i=0;i<strategy.size();i++){
			Text nameText=new Text();
			nameText.setText(strategy.get(i).getName());
			this.setHalignment(nameText,HPos.CENTER);
			this.setValignment(nameText, VPos.CENTER);
			this.add(nameText, 2, i+3);
			Text peopleText=new Text();
			if(strategy.get(i).getPeople().equals(PeopleType.NORMAL))
				peopleText.setText(normalPeople);
			else
				peopleText.setText(vipPeople);
			this.setHalignment(peopleText,HPos.CENTER);
			this.setValignment(peopleText, VPos.CENTER);
			this.add(peopleText, 3, i+3);
			Text costText=new Text();
			costText.setText("￥"+strategy.get(i).getCost());
			this.setHalignment(costText,HPos.CENTER);
			this.setValignment(costText, VPos.CENTER);
			this.add(costText, 4, i+3);
			Text startTimeText=new Text();
			startTimeText.setText(strategy.get(i).getStartTime());
			this.setHalignment(startTimeText,HPos.CENTER);
			this.setValignment(startTimeText, VPos.CENTER);
			this.add(startTimeText, 5, i+3);
			Text endTimeText=new Text();
			endTimeText.setText(strategy.get(i).getEndTime());
			this.setHalignment(endTimeText,HPos.CENTER);
			this.setValignment(endTimeText, VPos.CENTER);
			this.add(endTimeText, 6, i+3);
			button[i].setVisible(true);
		}
		
		createButton.setOnAction((e) ->{
			WebsitePaneController.getInstance().createCreateStrategyPane();
		});
		
		group.selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> observable,Toggle oldValue,Toggle newValue) ->{
					if(group.getSelectedToggle()!=null){
						modifyButton.setOnAction(e ->{
							int i=0;
							while(!button[i].isSelected()){
								i++;
							}
							System.out.print(i);
							WebsitePaneController.getInstance().createModifyStrategyPane(strategy.get(i));
						});
						cancelButton.setOnAction(e ->{
							Alert alert=new Alert(AlertType.CONFIRMATION);
							alert.initModality(Modality.APPLICATION_MODAL);
							alert.getDialogPane().setHeaderText(null);
							alert.setContentText("确定要撤销选中的营销策略吗");
							alert.showAndWait().ifPresent(response ->{
								if(response==ButtonType.OK){
									//数据库中撤销策略
								}
							});
						});
					}
		});//修改按钮的事件
		modifyButton.setOnAction(e ->{
			if(group.getSelectedToggle()==null){
				Alert alert=new Alert(AlertType.ERROR);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.getDialogPane().setHeaderText(null);
				alert.setContentText("营销策略不存在或没有选中一个营销策略");
				alert.showAndWait();
			}
		});//修改按钮出错的事件
		cancelButton.setOnAction(e ->{
			if(group.getSelectedToggle()==null){
				Alert alert=new Alert(AlertType.ERROR);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.getDialogPane().setHeaderText(null);
				alert.setContentText("营销策略不存在或没有选中一个营销策略");
				alert.showAndWait();
			}
		});//撤销按钮出错的事件
	}
	
	

}
