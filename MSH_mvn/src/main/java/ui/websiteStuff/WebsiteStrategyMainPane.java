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

public class WebsiteStrategyMainPane extends GridPane{
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",15);
	private static final String normalPeople="普通及会员";
	private static final String vipPeople="仅限会员";
	
	private Button modifyButton;
	private Button createButton;
	private Button cancelButton;
	private RadioButton allChooseButton;
	private Label startLabel;
	private Label strategyNameLabel;
	private Label peopleLabel;
	private Label costLabel;
	private Label startTimeLabel;
	private Label endTimeLabel;
	private MyNavigationBar navi;
	private RadioButton chooseButton1;
	private RadioButton chooseButton2;
	private RadioButton chooseButton3;
	private RadioButton chooseButton4;
	private RadioButton chooseButton5;
	private RadioButton chooseButton6;
	private RadioButton chooseButton7;
	private RadioButton chooseButton8;
	private RadioButton chooseButton9;
	private ToggleGroup group;
	
	private OrderVO vo;
	private List<String> stuffName;
	private List<String> stuffId;
	private List<String> strategyName;
	private List<PeopleType> people;
	private List<String> cost;
	private List<String> startTime;
	private List<String> endTime;
	
	public WebsiteStrategyMainPane(List<String> stuffName,List<String> stuffId,List<String> strategyName
			,List<PeopleType> people,List<String> cost,List<String> startTime,List<String> endTime,Image scul){
		super();
		this.stuffName=stuffName;
		this.stuffId=stuffId;
		this.strategyName=strategyName;
		this.people=people;
		this.cost=cost;
		this.startTime=startTime;
		this.endTime=endTime;
		this.init(scul);
		this.start();
	}
	
	private void init(Image scul){
		navi = new MyNavigationBar(scul,stuffName,stuffId);
		MainPane.getInstance().setNavigationBar(navi);
		MainPane.getInstance().setRightPane(this);
		
	}
	
	private void start(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setGridLinesVisible(true);
		
		
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
		chooseButton1=new RadioButton();
		chooseButton2=new RadioButton();
		chooseButton3=new RadioButton();
		chooseButton4=new RadioButton();
		chooseButton5=new RadioButton();
		chooseButton6=new RadioButton();
		chooseButton7=new RadioButton();
		chooseButton8=new RadioButton();
		chooseButton9=new RadioButton();
		chooseButton1.setToggleGroup(group);
		chooseButton2.setToggleGroup(group);
		chooseButton3.setToggleGroup(group);
		chooseButton4.setToggleGroup(group);
		chooseButton5.setToggleGroup(group);
		chooseButton6.setToggleGroup(group);
		chooseButton7.setToggleGroup(group);
		chooseButton8.setToggleGroup(group);
		chooseButton9.setToggleGroup(group);
		
		allChooseButton=new RadioButton();
		allChooseButton.setVisible(true);
		allChooseButton.setSelected(true);
		
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
		this.add(allChooseButton, 1, 2);
		this.add(chooseButton1, 1, 3);
		this.add(chooseButton2, 1, 4);
		this.add(chooseButton3, 1, 5);
		this.add(chooseButton4, 1, 6);
		this.add(chooseButton5, 1, 7);
		this.add(chooseButton6, 1, 8);
		this.add(chooseButton7, 1, 9);
		this.add(chooseButton8, 1, 10);
		this.add(chooseButton9, 1, 11);
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
		
		for(int i=0;i<strategyName.size();i++){
			Text nameText=new Text();
			nameText.setText(strategyName.get(i));
			this.setHalignment(nameText,HPos.CENTER);
			this.setValignment(nameText, VPos.CENTER);
			this.add(nameText, 2, i+3);
			Text peopleText=new Text();
			if(people.get(i).equals(PeopleType.NORMAL))
				peopleText.setText(normalPeople);
			else
				peopleText.setText(vipPeople);
			this.setHalignment(peopleText,HPos.CENTER);
			this.setValignment(peopleText, VPos.CENTER);
			this.add(peopleText, 3, i+3);
			Text costText=new Text();
			costText.setText("￥"+cost.get(i));
			this.setHalignment(costText,HPos.CENTER);
			this.setValignment(costText, VPos.CENTER);
			this.add(costText, 4, i+3);
			Text startTimeText=new Text();
			startTimeText.setText(startTime.get(i));
			this.setHalignment(startTimeText,HPos.CENTER);
			this.setValignment(startTimeText, VPos.CENTER);
			this.add(startTimeText, 5, i+3);
			Text endTimeText=new Text();
			endTimeText.setText(endTime.get(i));
			this.setHalignment(endTimeText,HPos.CENTER);
			this.setValignment(endTimeText, VPos.CENTER);
			this.add(endTimeText, 6, i+3);
			
		}
		
		
	}
	
	

}
