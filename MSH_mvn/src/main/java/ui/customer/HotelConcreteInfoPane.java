package ui.customer;

import java.util.Arrays;

import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class HotelConcreteInfoPane extends Pane{
	private Label hotel_name=new Label("酒店名称:");
	private Label address=new Label("地址:");
	private Label trade_area=new Label("商圈:");
	private Label lowest_price=new Label("最低价格:");
	private Label score=new Label("评分:");
	private Label evaluate_area=new Label("评价区");
	private Label star_level=new Label("星级:");
	private TableView room_info;
	private MyNavigationBar navi;
	private Image scul;
	private int column=1;
	private int row=1;
	private GridPane pane;
	private static final String user_name="angel"; 
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 14);
	public HotelConcreteInfoPane(){
		initPane();
		init();
	}
	
	private void init(){
		navi = new MyNavigationBar(scul,Arrays.asList("用户名："+user_name),Arrays.asList("个人信息","我的订单","搜索"));
		MainPane.getInstance().getChildren().clear();
		MainPane.getInstance().getChildren().addAll(navi,pane);
	}
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 20));
		pane.setPrefWidth(600);
		//pane.setPrefHeight(100);
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setAlignment(Pos.CENTER);
		pane.setGridLinesVisible(true);
		
		room_info=new TableView();
		room_info.setPrefHeight(150);
		//room_info.setPrefWidth(500);
		TableColumn room_type=new TableColumn("房型");
		TableColumn bed_type=new TableColumn("床型");
		TableColumn price=new TableColumn("价格(¥)");
		room_info.getColumns().addAll(room_type,bed_type,price);
		pane.add(room_info, column, 4);
		
		hotel_name.setFont(f);
		pane.add(hotel_name,column,row);
		
		Text name=new Text("渡口客栈");
		name.setFont(f);
		pane.add(name, column, row);
		
		address.setFont(f);
		pane.add(address,column,row);
		
		Text add=new Text("南京市中山北路10号");
		pane.add(add, column+1, row);
		
		lowest_price.setFont(f);
		pane.add(lowest_price, column, row+1);
		
		Text Price=new Text("456");
		pane.add(Price, column, row+1);
		
		trade_area.setFont(f);
		pane.add(trade_area,column,row+1);
		
		Text TradeArea=new Text("新街口");
		pane.add(TradeArea,column+1,row+1);
		
		score.setFont(f);
		pane.add(score,column,row+2);
		
		Text Score=new Text("4.6");
		Score.setFont(f);
		pane.add(Score, column, row+2);
		
		star_level.setFont(f);
		pane.add(star_level, column, row+2);
		
		Text star=new Text("4");
		star.setFont(f);
		pane.add(star, column+1, row+2);
		
		evaluate_area.setFont(f);
		pane.add(evaluate_area, column, row+4);
		pane.setHalignment(trade_area, HPos.RIGHT);;
		pane.setHalignment(address, HPos.RIGHT);
		pane.setHalignment(star_level,HPos.RIGHT);
		pane.setHalignment(Price, HPos.CENTER);
		pane.setHalignment(Score, HPos.CENTER);
		pane.setHalignment(room_info, HPos.CENTER);
		pane.setHalignment(name, HPos.CENTER);

	}
}
