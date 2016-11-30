package ui.customer;

import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyNavigationBar;

public class HotelSearchPane extends Pane{
	private static final String user_name="angel"; 
	private GridPane pane;
	private int column_index=9;
	private int row_index=10;
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
		
		/*Label title=new Label("酒店预订系统");
		title.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 32));
		pane.add(title,column_index,row_index);*/
		
		Label City=new Label("城市");
		City.setFont(f);
		pane.add(City,column_index,row_index);
		
		ChoiceBox city=new ChoiceBox(FXCollections.observableArrayList("南京","北京","上海"));
		city.getSelectionModel().selectFirst();
		pane.add(city,column_index+1,row_index);
		
		Label trade_area=new Label("商圈");
		trade_area.setFont(f);
		pane.add(trade_area,column_index,row_index+1);
		
		ChoiceBox TradeArea=new ChoiceBox(FXCollections.observableArrayList("栖霞区","鼓楼区","江宁区"));
		TradeArea.getSelectionModel().selectFirst();
		pane.add(TradeArea,column_index+1,row_index+1);
		
		Label key=new Label("关键词");
		key.setFont(f);
		pane.add(key,column_index,row_index+2);
		
		TextField keyword=new TextField();
		keyword.setFont(f);
		keyword.setMaxWidth(100);
		pane.add(keyword, column_index+1, row_index+2);
		
		Button search=new Button("搜索");
		search.setFont(f);
		pane.add(search,column_index+2,row_index+2);
		
		Label enter_time=new Label("入住时间");
		enter_time.setFont(f);
		pane.add(enter_time, column_index, row_index+3);
		
		DatePicker enter=new MyDatePicker();
		enter.setMaxWidth(130);
		pane.add(enter, column_index+1, row_index+3);
		
		Label out_time=new Label("退房时间");
		out_time.setFont(f);
		pane.add(out_time,column_index,row_index+4);
		
		DatePicker out=new MyDatePicker();
		out.setMaxWidth(130);
		pane.add(out,column_index+1,row_index+4);
		
		this.getChildren().add(pane);
	}
}
