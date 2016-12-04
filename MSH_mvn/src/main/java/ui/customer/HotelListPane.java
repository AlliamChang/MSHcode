package ui.customer;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyNavigationBar;

public class HotelListPane extends Pane{
	private GridPane pane;
	private Label City=new Label("城市");
	private Label trade_area=new Label("商圈");
	private Label enter_time=new Label("入住时间");
	private Label out_time=new Label("退房时间");
	private Label price_range=new Label("价格区间");
	private Label score_range=new Label("评分区间");
	private Label star=new Label("星级");
	//private Label HotelName=new Label("酒店名称");
	private int column=0;
	private int row=0;
	private static final String user_name="angel"; 
	private ScrollPane sp;
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 14);
	public HotelListPane(ScrollPane s){
		super();
		this.setList(s);
		initPane();
	}
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 0, 10, 0));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setAlignment(Pos.TOP_LEFT);
		//pane.setGridLinesVisible(true);
		
		 ColumnConstraints col0 = new ColumnConstraints(100);
		 ColumnConstraints col1 = new ColumnConstraints(100);
		 ColumnConstraints col2 = new ColumnConstraints(130);
		 ColumnConstraints col3 = new ColumnConstraints(130);
		 ColumnConstraints col4 = new ColumnConstraints(100);
		 this.pane.getColumnConstraints().addAll(col0,col1,col2,col3,col4);
		
		City.setFont(f);
		pane.add(City, column, row);
		
		ChoiceBox city=new ChoiceBox(FXCollections.observableArrayList("南京","北京","上海"));
		city.getSelectionModel().selectFirst();
		pane.add(city,column,row+1);
		
		trade_area.setFont(f);
		pane.add(trade_area,column+1,row);
		
		ChoiceBox TradeArea=new ChoiceBox(FXCollections.observableArrayList("栖霞区","鼓楼区","江宁区"));
		TradeArea.getSelectionModel().selectFirst();
		pane.add(TradeArea, column+1, row+1);
		
		enter_time.setFont(f);
		pane.add(enter_time,column+2,row);
		
		DatePicker enter=new MyDatePicker();
		enter.setMaxWidth(130);
		pane.add(enter,column+2,row+1);
		
		out_time.setFont(f);
		pane.add(out_time, column+3, row);
		
		DatePicker out=new MyDatePicker();
		out.setMaxWidth(130);
		pane.add(out,column+3,row+1);
		
		price_range.setFont(f);
		pane.add(price_range,column,row+3);
		
		ChoiceBox price=new ChoiceBox(FXCollections.observableArrayList("200-499","500-999","1000以上"));
		price.getSelectionModel().selectFirst();
		pane.add(price, column, row+4);
		
		score_range.setFont(f);
		pane.add(score_range,column+1,row+3);
		
		ChoiceBox score=new ChoiceBox(FXCollections.observableArrayList("4.1-5.0","3.1-4.0","0.1-3.0"));
		score.getSelectionModel().selectFirst();
		pane.add(score, column+1, row+4);
		
		star.setFont(f);
		pane.add(star,column+2,row+3);
		
		ChoiceBox star_level=new ChoiceBox(FXCollections.observableArrayList("5","4","3","2","1"));
		star_level.getSelectionModel().selectFirst();
		pane.add(star_level,column+2,row+4);
		
		Button search=new Button("搜索");
		search.setFont(f);
		pane.add(search,column+4,row+2);
		
		TextField key=new TextField();
		pane.add(key,column,row+2,4,1);
		
		pane.setHalignment(City, HPos.CENTER);
		pane.setHalignment(trade_area, HPos.CENTER);
		pane.setHalignment(enter_time, HPos.CENTER);
		pane.setHalignment(out_time, HPos.CENTER);
		pane.setHalignment(price_range, HPos.CENTER);
		pane.setHalignment(score_range, HPos.CENTER);
		pane.setHalignment(star, HPos.CENTER);
		pane.setHalignment(star_level, HPos.CENTER);
		
		pane.add(sp, column, row+5);
		this.getChildren().addAll(pane);
		
	}
	
	public void setList(ScrollPane  info){
		this.sp=info;
	}
	

}
