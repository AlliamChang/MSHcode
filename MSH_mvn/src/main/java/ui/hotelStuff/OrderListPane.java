package ui.hotelStuff;

import java.util.Arrays;
import java.util.List;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.geometry.VPos;
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
import ui.hotelStuff.control.HotelPaneController;
import ui.hotelStuff.subgroup.OrderTable;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyNavigationBar;

public class OrderListPane extends TabPane{
	 
	private static final String BORDER_STYLE = "-fx-border-color:black;";
	private static final String BACKGROUND_STYLE = "-fx-background-color:white;",
			FONT_STYLE = "-fx-font-size:15;";
	
	private Tab todayOrderTab;
	private Tab allOrderTab;
	private GridPane allOrderPane;
	private OrderTable todayOrderTable,allOrderTable;
	
	
	public OrderListPane(){
		super();
		this.initTab();
	}
	
	
	private void initTab(){
		this.setMinSize(MainPane.MINWIDTH, MainPane.MINHEIGHT);
		this.setSide(Side.TOP);
		this.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.setStyle(BORDER_STYLE + BACKGROUND_STYLE + FONT_STYLE);
		this.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING);
		
		this.todayOrderTab = new Tab();
		this.todayOrderTab.setText("当天订单");
		this.todayOrderTable = new OrderTable(HotelPaneController.getInstance().getTodayOrder(),this);
		
		this.allOrderTab = new Tab();
		this.allOrderTab.setText("所有订单");
		this.allOrderTable = new OrderTable(HotelPaneController.getInstance().getAllOrder(),this);
		
		this.initAllOrderPane();
		
		
		Label preCheckinLabel = new Label("预计入住时间：");
		GridPane.setHalignment(preCheckinLabel, HPos.RIGHT);
		GridPane.setValignment(preCheckinLabel, VPos.BOTTOM);
		this.allOrderPane.add(preCheckinLabel, 0, 0);
		
		MyDatePicker preCinPick = new MyDatePicker();
		GridPane.setHalignment(preCinPick, HPos.CENTER);
		GridPane.setValignment(preCinPick, VPos.BOTTOM);
		this.allOrderPane.add(preCinPick, 1, 0);
		
		Label checkinLabel = new Label("实际入住时间：");
		GridPane.setHalignment(checkinLabel, HPos.RIGHT);
		GridPane.setValignment(checkinLabel, VPos.BOTTOM);
		this.allOrderPane.add(checkinLabel, 2, 0);
		
		MyDatePicker checkinPick = new MyDatePicker();
		checkinPick.setBeforeDisable(preCinPick);
		GridPane.setHalignment(checkinPick, HPos.CENTER);
		GridPane.setValignment(checkinPick, VPos.BOTTOM);
		this.allOrderPane.add(checkinPick, 3, 0);
		
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
		
		RadioButton cancel = new RadioButton("已撤销");
		cancel.setToggleGroup(pickState);
		
		HBox pickButton = new HBox(3);
		GridPane.setHalignment(pickButton, HPos.CENTER);
		pickButton.setPadding(new Insets(0,8,0,8));
		pickButton.setMaxSize(260, 20);
		pickButton.getChildren().addAll(unexecuted,executed,unusual,cancel);
		pickButton.setStyle("-fx-font-size:11");
		pickButton.setAlignment(Pos.CENTER);
		
		Button search = new Button("查询");
		GridPane.setHalignment(search, HPos.CENTER);
		search.setMinWidth(100);
		search.setOnAction(event -> {
			RadioButton temp = (RadioButton)pickState.getSelectedToggle();
			if(temp != null)
				this.allOrderTable.filter(orderIdField.getText(),null,
						checkinPick.getEditor().getText(),preCinPick.getEditor().getText(),
						temp.getText());
			else
				this.allOrderTable.filter(orderIdField.getText(),null,
						checkinPick.getEditor().getText(),preCinPick.getEditor().getText(),
						null);
			
		});
		
		Button clear = new Button("清空");
		GridPane.setHalignment(clear, HPos.CENTER);
		GridPane.setValignment(clear, VPos.BOTTOM);
		clear.setMinWidth(100);
		clear.setOnAction(event -> {
			this.allOrderTable.clear();
			preCinPick.getEditor().setText("");
			checkinPick.getEditor().setText("");
			orderIdField.setText("");
			pickState.selectToggle(null);
		});
		this.allOrderPane.add(clear, 4, 0);
		
		this.allOrderPane.add(pickButton, 2,1,2,1);
		this.allOrderPane.add(search, 4, 1);
		
		this.todayOrderTab.setContent(todayOrderTable);
		this.allOrderTab.setContent(allOrderPane);
		
		this.getTabs().addAll(this.todayOrderTab,this.allOrderTab);
		
		this.selectionModelProperty().addListener((listener,oldVal,newVal) -> {
			if(newVal != null){
				System.out.println(newVal);
			}
		});
		this.getSelectionModel().selectedIndexProperty().addListener(listener -> {
			if(this.getSelectionModel().getSelectedIndex() == 0){
				this.todayOrderTable.updateOrder(HotelPaneController.getInstance().getTodayOrder());
			}else{
				this.allOrderTable.updateOrder(HotelPaneController.getInstance().getAllOrder());
			}
		});
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
