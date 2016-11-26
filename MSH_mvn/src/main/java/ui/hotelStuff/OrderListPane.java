package ui.hotelStuff;

import java.util.Arrays;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyNavigationBar;

public class OrderListPane extends TabPane{
	 
	private static final double MINWIDTH = 655,MINHEIGHT = 610;
	private static final String BORDER_STYLE = "-fx-border-color:black;";
	private static final String BACKGROUND_STYLE = "-fx-background-color:white;",
			FONT_STYLE = "-fx-font-size:15;";
	
	private MyNavigationBar navi;
	private Tab todayOrderTab;
	private Tab allOrderTab;
	private GridPane allOrderPane;
	private OrderTable todayOrderTable,allOrderTable;
	
	private long id;
	private String hotel;
	
	public OrderListPane(long id,String hotel,Image scul){
		super();
		this.id = id;
		this.hotel = hotel;
		this.initTab();
		this.init(scul);
	}
	
	private void init(Image scul){
		navi = new MyNavigationBar(scul,Arrays.asList("ID:"+id,"酒店名："+hotel));
		MainPane.getInstance().getChildren().addAll(navi,this);
		
	}
	
	private void initTab(){
		this.setMinSize(MINWIDTH, MINHEIGHT);
		this.setSide(Side.TOP);
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.setStyle(BORDER_STYLE + BACKGROUND_STYLE + FONT_STYLE);
		this.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING);
		
		this.todayOrderTab = new Tab();
		this.todayOrderTab.setText("当天订单");
		this.todayOrderTable = new OrderTable(HotelPaneController.getInstance().getTodayOrder());
		
		this.allOrderTab = new Tab();
		this.allOrderTab.setText("所有订单");
		this.allOrderTable = new OrderTable(HotelPaneController.getInstance().getAllOrder());

		this.initAllOrderPane();
		
		
		Label preCheckinLabel = new Label("预计入住时间：");
		GridPane.setHalignment(preCheckinLabel, HPos.RIGHT);
		this.allOrderPane.add(preCheckinLabel, 0, 0);
		
		MyDatePicker preCinPick = new MyDatePicker();
		GridPane.setHalignment(preCinPick, HPos.CENTER);
		this.allOrderPane.add(preCinPick, 1, 0);
		
		Label preCheckoutLabel = new Label("预计退房时间：");
		GridPane.setHalignment(preCheckoutLabel, HPos.RIGHT);
		this.allOrderPane.add(preCheckoutLabel, 2, 0);
		
		MyDatePicker preCoutPick = new MyDatePicker();
		GridPane.setHalignment(preCoutPick, HPos.CENTER);
		this.allOrderPane.add(preCoutPick, 3, 0);
		
		Label orderIdLabel = new Label("订单号：");
		GridPane.setHalignment(orderIdLabel, HPos.RIGHT);
		this.allOrderPane.add(orderIdLabel, 0, 1);

		TextField orderIdField = new TextField();
		GridPane.setHalignment(orderIdField, HPos.CENTER);
		this.allOrderPane.add(orderIdField, 1, 1);
		
		
		ToggleGroup pickState = new ToggleGroup();
		RadioButton unexecuted = new RadioButton("未执行");
		unexecuted.setToggleGroup(pickState);
		
		RadioButton executed = new RadioButton("已执行");
		executed.setToggleGroup(pickState);
		
		RadioButton unusual = new RadioButton("异常订单");
		unusual.setToggleGroup(pickState);
		
		HBox pickButton = new HBox(3);
		GridPane.setHalignment(pickButton, HPos.CENTER);
		pickButton.setPadding(new Insets(0,8,0,8));
		pickButton.setMaxSize(260, 20);
		pickButton.getChildren().addAll(unexecuted,executed,unusual);
		
		Button search = new Button("查询");
		GridPane.setHalignment(search, HPos.CENTER);
		search.setMinWidth(100);
		
		this.allOrderPane.add(pickButton, 2,1,2,1);
		this.allOrderPane.add(search, 4, 1);
		
		this.todayOrderTab.setContent(todayOrderTable);
		this.allOrderTab.setContent(allOrderPane);
		
		this.getTabs().addAll(this.todayOrderTab,this.allOrderTab);
	}
	
	private void initAllOrderPane(){
		this.allOrderPane = new GridPane();
//		this.allOrderPane.setPadding(new Insets(8,8,8,8));
		RowConstraints rowinfo1 = new RowConstraints();
        rowinfo1.setPercentHeight(10);
        
        RowConstraints rowinfo2 = new RowConstraints();
        rowinfo2.setPercentHeight(80);
        
        ColumnConstraints colInfo = new ColumnConstraints();
        colInfo.setPercentWidth(20);
        
        this.allOrderPane.getRowConstraints().addAll(rowinfo1,rowinfo1,rowinfo2);
        for(int i = 0; i < 100/colInfo.getPercentWidth(); i ++){
        	this.allOrderPane.getColumnConstraints().add(colInfo);
        }
        
		this.allOrderPane.setGridLinesVisible(false);
		this.allOrderPane.setStyle(BACKGROUND_STYLE);
		this.allOrderPane.add(allOrderTable, 0, 2,5,1);
		
	}
}
