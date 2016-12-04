package ui.websiteStuff;

import javafx.scene.text.Font;
import tools.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
	private static final Font normalFont=new Font("方正幼圆",15);
	private static final String normalPeople="普通及会员";
	private static final String vipPeople="仅限会员";
	
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
    private ObservableList<String> cityList;
    private ObservableList<String> areaList;	
    
    public ModifyStrategyPane(List<String> stuffName,List<String> stuffId,String name,String city,String area,Date startTime,Date endTime,
    		String cost,CostType costType,PeopleType people,Image scul){
    	super();
    	this.stuffName=stuffName;
    	this.stuffId=stuffId;
    	this.name=name;
    	this.city=city;
    	this.area=area;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.cost=cost;
    	this.costType=costType;
    	this.people=people;
    	this.init(scul);
    	this.start();
    	System.out.println("1");
    }
    
    private void init(Image scul){
		navi = new MyNavigationBar(scul,stuffName,stuffId);
		MainPane.getInstance().setNavigationBar(navi);
		MainPane.getInstance().setRightPane(this);	
	}
    
    private void start(){
    	this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
    	this.setGridLinesVisible(true);
    	
    	this.startLabel=new Label("修改营销策略");
    	startLabel.setFont(startFont);
		this.setHalignment(startLabel, HPos.LEFT);
		this.setValignment(startLabel, VPos.CENTER);
		
		this.nameLabel=new Label("营销策略名称");
		nameLabel.setFont(normalFont);
		this.setHalignment(nameLabel, HPos.CENTER);
		this.setValignment(nameLabel, VPos.CENTER);
		
		this.areaLabel=new Label("城市与商圈");
		areaLabel.setFont(normalFont);
		this.setHalignment(areaLabel, HPos.CENTER);
		this.setValignment(areaLabel, VPos.CENTER);
		
		this.timeLabel=new Label("时间");
		timeLabel.setFont(normalFont);
		this.setHalignment(timeLabel, HPos.CENTER);
		this.setValignment(timeLabel, VPos.CENTER);
		
		this.toLabel=new Label("至");
		toLabel.setFont(normalFont);
		this.setHalignment(toLabel, HPos.CENTER);
		this.setValignment(toLabel, VPos.CENTER);
		
		this.costLabel=new Label("折扣");
		costLabel.setFont(normalFont);
		this.setHalignment(costLabel, HPos.CENTER);
		this.setValignment(costLabel, VPos.CENTER);
		
		this.peopleLabel=new Label("面向人群");
		peopleLabel.setFont(normalFont);
		this.setHalignment(peopleLabel, HPos.CENTER);
		this.setValignment(peopleLabel, VPos.CENTER);
		
		this.nameText=new TextField();
		nameText.setFont(normalFont);
		this.costText=new TextField();
		costText.setFont(normalFont);
	
		cityBox=new ChoiceBox();
		areaBox=new ChoiceBox();
		costBox=new ChoiceBox();
		peopleBox=new ChoiceBox();
		cityBox.setItems(cityList);
		areaBox.setItems(areaList);
		costBox.setItems(FXCollections.observableArrayList("元","%"));
		peopleBox.setItems(FXCollections.observableArrayList(normalPeople,vipPeople));
		modifyButton=new Button("修改");
		
		startDate=new MyDatePicker();
		endDate=new MyDatePicker(); 
		
		this.add(startLabel, 1, 1,5,1);
		this.add(nameLabel, 2, 2,2,1);
		this.add(areaLabel, 3, 3);
		this.add(timeLabel, 3, 4);
		this.add(costLabel, 3, 5);
		this.add(peopleLabel, 3, 6);
		this.add(modifyButton, 5, 7);
		this.add(nameText, 5, 2,5,1);
		this.add(cityBox, 5, 3,2,1);
		this.add(areaBox, 7, 3,2,1);
		this.add(startDate, 5, 4,2,1);
		this.add(toLabel, 6, 4);
		this.add(endDate, 7, 4,2,1);
		this.add(costText,5,5,2,1);
		this.add(costBox, 7, 5,2,1);
		this.add(peopleBox, 7, 5,2,1);
    }
    
    
    
    
    
}
