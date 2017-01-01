package ui.websiteStuff;

import javafx.scene.text.Font;
import javafx.beans.value.ChangeListener;
import javafx.stage.Modality;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import java.util.ArrayList;
import java.util.List;
import vo.*;
import tools.*;
import ui.utility.*;
import ui.webAdmin.WebAdminController;
import javafx.scene.image.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.collections.*;

public class CreateStrategyPane extends GridPane{
	private static final Font startFont=new Font("方正幼圆",30);
	private static final Font normalFont=new Font("方正幼圆",20);
	private static final String normalPeople="普通及会员";
	private static final String vipPeople="仅限会员";
	private static final String holiday="特定期间活动策略";
	private static final String vip="VIP会员专属策略";
	private static final String FONT_STYLE="-fx-font-size:20";
	
	private String name;
	private String province;
	private String city;
	private String area;
	private double cost;
	private String startTime;
	private String endTime;
	private PeopleType people;
	private StrategyType strategyType;
	
	private Label startLabel;
	private Label nameLabel;
	private Label cityLabel;
	private Label timeLabel;
	private Label toLabel;
	private Label costLabel;
	private Label peopleLabel;
	private Label strategyTypeLabel;
	private TextField nameText;
	private TextField costText;
	private ChoiceBox cityBox;
	private ChoiceBox areaBox;
	private ChoiceBox provinceBox;
	private MyDatePicker startDate;
	private MyDatePicker endDate;
	private Label costTypeLabel;
	private ChoiceBox peopleBox;
	private Button createButton;
	private ChoiceBox strategyTypeBox;
	
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
		
		this.provinceBox=new ChoiceBox();
	    ObservableList provinceList=FXCollections.observableList(WebsitePaneController.getInstance().getProvinces());
	    provinceBox.setItems(provinceList);
	    this.setHalignment(provinceBox, HPos.LEFT);
		this.setValignment(provinceBox, VPos.CENTER);
	    
	    this.cityBox=new ChoiceBox();
	    //ObservableList cityList=FXCollections.observableArrayList("南京市","北京市");
	    //cityBox.setItems(cityList);
	    this.setHalignment(cityBox, HPos.CENTER);
		this.setValignment(cityBox, VPos.CENTER);
	    
	    this.areaBox=new ChoiceBox();
	    //ObservableList areaList=FXCollections.observableArrayList("栖霞区");
	    //areaBox.setItems(areaList);
	    this.setHalignment(areaBox, HPos.RIGHT);
		this.setValignment(areaBox, VPos.CENTER);
	    
	    this.startDate=new MyDatePicker();
	    startDate.setStyle(FONT_STYLE);
	    this.endDate=new MyDatePicker();
	    endDate.setStyle(FONT_STYLE);
	    
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
		
		this.strategyTypeLabel=new Label("设置策略类型");
		strategyTypeLabel.setFont(normalFont);
		this.setHalignment(strategyTypeLabel, HPos.LEFT);
		this.setValignment(strategyTypeLabel, VPos.CENTER);
		
		this.strategyTypeBox=new ChoiceBox();
		ObservableList strategyTypeList=FXCollections.observableArrayList(holiday,vip);
		strategyTypeBox.setItems(strategyTypeList);
	    this.setHalignment(strategyTypeBox, HPos.RIGHT);
		this.setValignment(strategyTypeBox, VPos.CENTER);
	    
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
	    this.add(strategyTypeLabel,2,7,2,1);
	    this.add(nameText,3,2,4,1);
	    this.add(provinceBox, 3, 3,1,1);
	    this.add(cityBox, 4, 3,1,1);
	    this.add(areaBox, 5, 3,1,1);
	    this.add(startDate, 3, 4);
	    this.add(endDate, 5, 4);
	    this.add(costText, 3, 5);
	    this.add(costTypeLabel, 5, 5);
	    this.add(peopleBox, 5, 6,3,1);
	    this.add(strategyTypeBox,5,7,2,1);
	    this.add(createButton, 3, 8);
	    
	    this.getRowConstraints().add(new RowConstraints(20));
	    this.getRowConstraints().add(new RowConstraints(70));
	    this.getRowConstraints().add(new RowConstraints(70));
	    this.getRowConstraints().add(new RowConstraints(70));
	    this.getRowConstraints().add(new RowConstraints(70));
	    this.getRowConstraints().add(new RowConstraints(70));
	    this.getRowConstraints().add(new RowConstraints(70));
	    this.getRowConstraints().add(new RowConstraints(70));
		this.getColumnConstraints().add(new ColumnConstraints(20));
		this.getColumnConstraints().add(new ColumnConstraints(50));
		this.getColumnConstraints().add(new ColumnConstraints(150));
		this.getColumnConstraints().add(new ColumnConstraints(130));
		this.getColumnConstraints().add(new ColumnConstraints(90));
		this.getColumnConstraints().add(new ColumnConstraints(150));
		
		provinceBox.getSelectionModel().selectedItemProperty().addListener((ov, old_val, new_val) -> {
			cityBox.getItems().clear();
			List<String> cities = WebsitePaneController.getInstance().getCities((String)new_val);
			if (cities != null){
				cityBox.setDisable(false);;
				cityBox.getItems().addAll(cities);
			} else
				cityBox.setDisable(true);
			cityBox.getSelectionModel().selectFirst();
		});
		
		cityBox.getSelectionModel().selectedItemProperty().addListener((ov, old_val, new_val) -> {
			areaBox.getItems().clear();
			List<String> areas = WebsitePaneController.getInstance().getAreas(provinceBox.getValue().toString(), (String)new_val);
			if (areas != null){
				areaBox.setDisable(false);
				areaBox.getItems().addAll(areas);
			} else
				areaBox.setDisable(true);	
			areaBox.getSelectionModel().selectFirst();
		});
		
		createButton.setOnAction(e ->{
			//创建策略事件
			/*String name=nameText.getText();
		    double cost=Double.parseDouble(costText.getText());
		    String city=cityBox.getSelectionModel().getSelectedItem().toString();
		    String area=areaBox.getSelectionModel().getSelectedItem().toString();
		    String startTime=startDate.getEditor().getText();
		    String endTime=endDate.getEditor().getText();
		    PeopleType pt;
		    StrategyType st;
		    if(peopleBox.getSelectionModel().getSelectedItem().toString().equals(normalPeople))
		    	pt=PeopleType.NORMAL;
		    else
		    	pt=PeopleType.VIP;
		    if(strategyTypeBox.getSelectionModel().getSelectedItem().toString().equals(holiday))
		    	st=StrategyType.HOLIDAY;
		    else
		    	st=StrategyType.VIP;*/
			if(nameText.getText().equals("")||costText.getText().equals("")||cityBox.getSelectionModel()==null||areaBox.getSelectionModel()==null
					||peopleBox.getSelectionModel()==null){
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
					    name=nameText.getText();
					    cost=Double.parseDouble(costText.getText());
					    province=provinceBox.getSelectionModel().getSelectedItem().toString();
					    city=cityBox.getSelectionModel().getSelectedItem().toString();
					    area=areaBox.getSelectionModel().getSelectedItem().toString();
					    startTime=startDate.getEditor().getText();
					    endTime=endDate.getEditor().getText();
					    if(peopleBox.getSelectionModel().getSelectedItem().toString().equals(normalPeople))
					    	people=PeopleType.NORMAL;
					    else
					    	people=PeopleType.VIP;
					    if(strategyTypeBox.getSelectionModel().getSelectedItem().toString().equals(holiday))
					    	strategyType=StrategyType.HOLIDAY;
					    else
					    	strategyType=StrategyType.VIP;
					    StrategyVO strategy=new StrategyVO(name,strategyType,province,city,area,startTime,endTime,cost,people);
					    WebsitePaneController.getInstance().addStrategy(strategy);
					    //System.out.println(city);
					    //System.out.println(name+"\n"+cost+"\n"+city+"\n"+area+"\n"+startTime+"\n"+endTime+"\n"+strategy.getArea());
					    WebsitePaneController.getInstance().createStrategyListPane();
				    }
			    });
			}
		});
	}

}
