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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyNavigationBar;

public class HotelSearchPane extends Pane{
	private static final String user_name="angel"; 
	private GridPane pane;
	private int row=10;
	private int column=0;
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 20);
	public HotelSearchPane(){
		super();
		initPane();
	}
	
	
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setHgap(20);
		pane.setVgap(20);
		pane.setAlignment(Pos.TOP_LEFT);
		//pane.setGridLinesVisible(true);
		
		Label title=new Label("酒店预订系统");
		title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 32));
		pane.add(title,column+1,row-3,3,2);
		pane.setHalignment(title, HPos.CENTER);
		
		 ColumnConstraints colInfo = new ColumnConstraints();
	        colInfo.setPercentWidth(20);
	        
	        for(int i = 0; i < 100/colInfo.getPercentWidth(); i ++){
	        	this.pane.getColumnConstraints().add(colInfo);
	        }
	        
		Label City=new Label("城市:");
		City.setFont(f);
		pane.add(City,column,row);
		pane.setHalignment(City, HPos.RIGHT);
		
		ChoiceBox city=new ChoiceBox(FXCollections.observableArrayList("南京","北京","上海"));
		city.getSelectionModel().selectFirst();
		pane.add(city,column+1,row);
		
		Label trade_area=new Label("商圈:");
		trade_area.setFont(f);
		pane.add(trade_area,column+2,row);
		pane.setHalignment(trade_area, HPos.RIGHT);
		
		ChoiceBox TradeArea=new ChoiceBox(FXCollections.observableArrayList("栖霞区","鼓楼区","江宁区"));
		TradeArea.getSelectionModel().selectFirst();
		pane.add(TradeArea,column+3,row);
		
		Label key=new Label("关键词:");
		key.setFont(f);
		pane.add(key,column,row+1);
		pane.setHalignment(key, HPos.RIGHT);
		
		TextField keyword=new TextField();
		keyword.setFont(f);
		keyword.setMinWidth(200);
		pane.add(keyword, column+1, row+1,3,1);
		
		Button search=new Button("搜索");
		search.setFont(f);
		search.setOnMouseClicked((MouseEvent me)->{
			VBox room=new VBox();
			HotelRoomTable table=new HotelRoomTable(CustomerPaneController.getInstance().getRoom());
			room.getChildren().add(table);
			HotelListPane next=new HotelListPane(room);
			MainPane.getInstance().setRightPane(next);
			System.out.println(1);
		});
		pane.add(search,column+4,row+1);
		
		Label enter_time=new Label("入住时间:");
		enter_time.setFont(f);
		pane.add(enter_time, column, row+2);
		pane.setHalignment(enter_time, HPos.RIGHT);
		
		DatePicker enter=new MyDatePicker();
		enter.setMaxWidth(140);
		pane.add(enter, column+1, row+2);
		
		Label out_time=new Label("退房时间:");
		out_time.setFont(f);
		pane.add(out_time,column+2,row+2);
		pane.setHalignment(out_time, HPos.RIGHT);
		
		DatePicker out=new MyDatePicker();
		out.setMaxWidth(140);
		pane.add(out,column+3,row+2);
		
		this.getChildren().add(pane);
	}
}
