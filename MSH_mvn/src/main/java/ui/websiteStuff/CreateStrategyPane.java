package ui.websiteStuff;

import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;
import vo.*;
import tools.*;
import ui.utility.*;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.collections.*;

public class CreateStrategyPane extends GridPane{
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",20);
	private static final String normalPeople="普通及会员";
	private static final String vipPeople="仅限会员";
	
	private String name;
	private String city;
	private String area;
	private double cost;
	private Date startTime;
	private Date endTime;
	private CostType costType;
	private PeopleType people;
	private List<String> stuffName;
	private List<String> stuffId;
	
	private Label startLabel;
	private Label nameLabel;
	private Label cityLabel;
	private Label timeLabel;
	private Label toLabel;
	private Label costLabel;
	private Label peopleLabel;
	private TextField nameText;
	private TextField costText;
	private ChoiceBox cityBox;
	private ChoiceBox areaBox;
	private MyDatePicker startDate;
	private MyDatePicker endDate;
	private Label costTypeLabel;
	private ChoiceBox peopleBox;
	private Button createButton;
	
	public CreateStrategyPane(){
	    super();
	    this.start();
	}
	
	
	private void start(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setGridLinesVisible(false);
		
		this.startLabel=new Label("新增促销策略");
		startLabel.setFont(startFont);
		this.setHalignment(startLabel, HPos.LEFT);
		this.setValignment(startLabel, VPos.CENTER);
		
		this.nameLabel=new Label("设置策略名称");
		nameLabel.setFont(normalFont);
		this.setHalignment(nameLabel, HPos.LEFT);
		this.setValignment(nameLabel, VPos.CENTER);
		
		this.cityLabel=new Label("设置商圈和地址");
		cityLabel.setFont(normalFont);
		this.setHalignment(cityLabel, HPos.LEFT);
		this.setValignment(cityLabel, VPos.CENTER);
		
		this.timeLabel=new Label("设置时间");
		timeLabel.setFont(normalFont);
		this.setHalignment(timeLabel, HPos.LEFT);
		this.setValignment(timeLabel, VPos.CENTER);
		
		this.toLabel=new Label("至");
		toLabel.setFont(normalFont);
		this.setHalignment(toLabel, HPos.CENTER);
		this.setValignment(toLabel, VPos.CENTER);
	
		this.costLabel=new Label("设置折扣");
		costLabel.setFont(normalFont);
		this.setHalignment(costLabel, HPos.LEFT);
		this.setValignment(costLabel, VPos.CENTER);
		
		this.peopleLabel=new Label("设置面向人群");
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
	    
	    this.cityBox=new ChoiceBox();
	    ObservableList cityList=FXCollections.observableArrayList("南京市","北京市");
	    cityBox.setItems(cityList);
	    this.setHalignment(cityBox, HPos.RIGHT);
		this.setValignment(cityBox, VPos.CENTER);
	    
	    this.areaBox=new ChoiceBox();
	    ObservableList areaList=FXCollections.observableArrayList("栖霞区");
	    areaBox.setItems(areaList);
	    this.setHalignment(areaBox, HPos.RIGHT);
		this.setValignment(areaBox, VPos.CENTER);
	    
	    this.startDate=new MyDatePicker();
	    
	    this.endDate=new MyDatePicker();
	    
	    this.costTypeLabel=new Label("元");
	    //ObservableList costList=FXCollections.observableArrayList("元","%");
	    //costBox.setItems(costList);
	    costTypeLabel.setFont(normalFont);
	    this.setHalignment(costTypeLabel, HPos.RIGHT);
		this.setValignment(costTypeLabel, VPos.CENTER);
	    
	    this.peopleBox=new ChoiceBox();
	    ObservableList peopleList=FXCollections.observableArrayList(normalPeople,vipPeople);
	    peopleBox.setItems(peopleList);
	    this.setHalignment(peopleBox, HPos.RIGHT);
		this.setValignment(peopleBox, VPos.CENTER);
	    
	    this.createButton=new Button("新增");
	    createButton.setFont(normalFont);
	    this.setHalignment(createButton, HPos.RIGHT);
		this.setValignment(createButton, VPos.BOTTOM);
	    
	    this.add(startLabel, 1, 1,5,1);
	    this.add(nameLabel, 2, 2,2,1);
	    this.add(cityLabel, 2, 3,2,1);
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
	    this.add(costTypeLabel, 5, 5);
	    this.add(peopleBox, 5, 6,3,1);
	    this.add(createButton, 3, 7);
	    
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
		
		createButton.setOnAction(e ->{
			//创建策略事件
			if(nameText.getText()==null||costText.getText()==null||cityBox.getItems()==null||areaBox.getItems()==null
					||peopleBox.getItems()==null){
				Alert alert=new Alert(AlertType.ERROR);
				alert.initModality(Modality.APPLICATION_MODAL);
				alert.getDialogPane().setHeaderText(null);
				alert.getDialogPane().setContentText("请填写完整的策略信息！");
				alert.showAndWait();
			}
			else{
			    Alert alert=new Alert(AlertType.CONFIRMATION);
			    alert.initModality(Modality.APPLICATION_MODAL);
			    alert.getDialogPane().setHeaderText(null);
			    alert.getDialogPane().setContentText("确认要新增吗?");
			    alert.showAndWait().ifPresent(response ->{
				    if(response==ButtonType.OK){
					    System.out.println("create");
					    //fwq新建
				    }
			    });
			}
		});
	}

}
