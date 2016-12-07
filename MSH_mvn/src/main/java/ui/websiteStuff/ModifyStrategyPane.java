package ui.websiteStuff;

import javafx.scene.text.Font;
import tools.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.time.LocalDate;
import java.util.List;
import vo.*;
import tools.*;
import ui.utility.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.collections.*;

public class ModifyStrategyPane extends GridPane{
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",20);
	private static final String normalPeople="普通及会员";
	private static final String vipPeople="仅限会员";
	private static final String FONT_STYLE="-fx-font-size:20";
	
	private Label startLabel;
	private Label nameLabel;
	private Label areaLabel;
	private Label timeLabel;
	private Label toLabel;
	private Label costLabel;
	private Label peopleLabel;
	private Button modifyButton;
    private MyNavigationBar navi;
    private MyDatePicker startDate;
    private MyDatePicker endDate;
    private TextField nameText;
    private TextField costText;
    private ChoiceBox<String> cityBox;
    private ChoiceBox<String> areaBox;
    private ChoiceBox<String> costBox;
    private ChoiceBox<String> peopleBox;
	
    private StrategyVO strategy;
	private List<String> stuffName;
	private List<String> stuffId;
	private String name;
	private String city;
	private String area;
	private Date startTime;
    private Date endTime;
    private String cost;
    private CostType costType;
    private PeopleType people;

    
    public ModifyStrategyPane(StrategyVO strategy){
    	super();
    	this.strategy=strategy;
    	this.start();
    	
    }
    
    
    private void start(){
    	this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
    	this.setGridLinesVisible(false);
    	
    	this.startLabel=new Label("修改营销策略");
    	startLabel.setFont(startFont);
		this.setHalignment(startLabel, HPos.LEFT);
		this.setValignment(startLabel, VPos.CENTER);
		
		this.nameLabel=new Label("营销策略名称");
		nameLabel.setFont(normalFont);
		this.setHalignment(nameLabel, HPos.LEFT);
		this.setValignment(nameLabel, VPos.CENTER);
		
		this.areaLabel=new Label("城市与商圈");
		areaLabel.setFont(normalFont);
		this.setHalignment(areaLabel, HPos.LEFT);
		this.setValignment(areaLabel, VPos.CENTER);
		
		this.timeLabel=new Label("时间");
		timeLabel.setFont(normalFont);
		this.setHalignment(timeLabel, HPos.LEFT);
		this.setValignment(timeLabel, VPos.CENTER);
		
		this.toLabel=new Label("至");
		toLabel.setFont(normalFont);
		this.setHalignment(toLabel, HPos.CENTER);
		this.setValignment(toLabel, VPos.CENTER);
		
		this.costLabel=new Label("折扣");
		costLabel.setFont(normalFont);
		this.setHalignment(costLabel, HPos.LEFT);
		this.setValignment(costLabel, VPos.CENTER);
		
		this.peopleLabel=new Label("面向人群");
		peopleLabel.setFont(normalFont);
		this.setHalignment(peopleLabel, HPos.LEFT);
		this.setValignment(peopleLabel, VPos.CENTER);
		
		this.nameText=new TextField();
		nameText.setFont(normalFont);
		this.setHalignment(nameText, HPos.RIGHT);
		this.setValignment(nameText, VPos.CENTER);
		this.costText=new TextField();
		costText.setFont(normalFont);
		this.setHalignment(costText, HPos.RIGHT);
		this.setValignment(costText, VPos.CENTER);
	    
		ObservableList cityList=FXCollections.observableArrayList("南京市","北京市");
		ObservableList areaList=FXCollections.observableArrayList("栖霞区");
		ObservableList costList=FXCollections.observableArrayList("元","%");
		ObservableList peopleList=FXCollections.observableArrayList(normalPeople,vipPeople);
		
		cityBox=new ChoiceBox();
		cityBox.setStyle(FONT_STYLE);
		areaBox=new ChoiceBox();
		areaBox.setStyle(FONT_STYLE);
		costBox=new ChoiceBox();
		costBox.setStyle(FONT_STYLE);
		peopleBox=new ChoiceBox();
		peopleBox.setStyle(FONT_STYLE);
		cityBox.setItems(cityList);
		areaBox.setItems(areaList);
		costBox.setItems(costList);
		peopleBox.setItems(peopleList);
		modifyButton=new Button("修改");
		modifyButton.setFont(normalFont);
		this.setHalignment(cityBox, HPos.RIGHT);
		this.setValignment(cityBox, VPos.CENTER);
		this.setHalignment(areaBox, HPos.RIGHT);
		this.setValignment(areaBox, VPos.CENTER);
		this.setHalignment(costBox, HPos.RIGHT);
		this.setValignment(costBox, VPos.CENTER);
		this.setHalignment(peopleBox, HPos.RIGHT);
		this.setValignment(peopleBox, VPos.CENTER);
		this.setHalignment(modifyButton, HPos.RIGHT);
		this.setValignment(modifyButton, VPos.CENTER);
		
		startDate=new MyDatePicker();
		startDate.setStyle(FONT_STYLE);
		endDate=new MyDatePicker(); 
		endDate.setStyle(FONT_STYLE);
		
		this.add(startLabel, 1, 1,5,1);
	    this.add(nameLabel, 2, 2,2,1);
	    this.add(areaLabel, 2, 3,2,1);
	    this.add(timeLabel, 2, 4,2,1);
	    this.add(toLabel, 4, 4);
	    this.add(costLabel, 2, 5,2,1);
	    this.add(peopleLabel,2,6,2,1);
	    this.add(nameText,3,2,4,1);
	    this.add(cityBox, 3, 3,2,1);
	    this.add(areaBox, 5, 3,2,1);
	    this.add(startDate, 3, 4);
	    this.add(endDate, 5, 4);
	    this.add(costText, 3, 5);
	    this.add(costBox, 5, 5);
	    this.add(peopleBox, 5, 6,3,1);
	    this.add(modifyButton, 3, 7);
		
	    this.getRowConstraints().add(new RowConstraints(20));
	    this.getRowConstraints().add(new RowConstraints(80));
	    this.getRowConstraints().add(new RowConstraints(80));
	    this.getRowConstraints().add(new RowConstraints(80));
	    this.getRowConstraints().add(new RowConstraints(80));
	    this.getRowConstraints().add(new RowConstraints(80));
	    this.getRowConstraints().add(new RowConstraints(80));
		this.getColumnConstraints().add(new ColumnConstraints(20));
		this.getColumnConstraints().add(new ColumnConstraints(50));
		this.getColumnConstraints().add(new ColumnConstraints(150));
		this.getColumnConstraints().add(new ColumnConstraints(130));
		this.getColumnConstraints().add(new ColumnConstraints(90));
		this.getColumnConstraints().add(new ColumnConstraints(150));
		
		
		cityBox.getSelectionModel().select(strategy.getCity());
		areaBox.getSelectionModel().select(strategy.getArea());
		System.out.println(strategy.getName());
        if(strategy.getCostType().equals(CostType.PERCENT)){
        	costBox.getSelectionModel().select("%");
        }
        else
        	costBox.getSelectionModel().select("元");
        if(strategy.getPeople().equals(PeopleType.NORMAL)){
        	peopleBox.getSelectionModel().select(normalPeople);
        }
        else
        	peopleBox.getSelectionModel().select(vipPeople);
		nameText.setText(strategy.getName());
		costText.setText(strategy.getCost());
		startDate.setValue(LocalDate.of(2016, 1, 1));//获得年月日，需要增加
		endDate.setValue(LocalDate.of(2016, 5, 5));//需要增加
		
		modifyButton.setOnAction(e ->{
			//修改策略信息
		});
    }
    
    
    
    
    
}
