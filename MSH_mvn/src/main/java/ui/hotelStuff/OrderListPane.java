package ui.hotelStuff;

import java.util.Arrays;

import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.image.Image;
import ui.utility.MainPane;
import ui.utility.MyNavigationBar;

public class OrderListPane {
	 
	private static final double MINWIDTH = 655,MINHEIGHT = 610;
	private static final String BORDER_STYLE = "-fx-border-color:black;";
	private static final String BACKGROUND_STYLE = "-fx-background-color:white;",
			FONT_STYLE = "-fx-font-size:15;";
	
	private MyNavigationBar navi;
	private TabPane orderTab;
	private Tab todayOrderTab;
	private Tab allOrderTab;
	
	private long id;
	private String hotel;
	
	public OrderListPane(long id,String hotel,Image scul){
		this.id = id;
		this.hotel = hotel;
		this.initTab();
		this.init(scul);
	}
	
	private void init(Image scul){
		navi = new MyNavigationBar(scul,Arrays.asList("ID:"+id,"酒店名："+hotel));
		MainPane.getInstance().getChildren().addAll(navi,orderTab);
		
	}
	
	private void initTab(){
		this.orderTab = new TabPane();
		this.orderTab.setMinSize(MINWIDTH, MINHEIGHT);
		this.orderTab.setSide(Side.TOP);
		this.orderTab.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		this.orderTab.setStyle(BORDER_STYLE + BACKGROUND_STYLE + FONT_STYLE);
		this.orderTab.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING);
		
		this.todayOrderTab = new Tab();
		this.todayOrderTab.setText("当天订单");
		
		this.allOrderTab = new Tab();
		this.allOrderTab.setText("所有订单");
		
		this.orderTab.getTabs().addAll(this.todayOrderTab,this.allOrderTab);
	}
}
