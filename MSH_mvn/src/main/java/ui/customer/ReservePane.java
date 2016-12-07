package ui.customer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import ui.utility.MyNavigationBar;
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

public class ReservePane extends Pane {
	private GridPane pane;
	private List<String>room_type;
	private static final String user_name="angel"; 
	private int row_index=1;
	private int column_index=1;
	private static final Font f=Font.font("Tahoma", FontWeight.MEDIUM, 14);
	
	public ReservePane(){
		super();
		initPane();
	}
	
	private void initPane(){
		pane=new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setHgap(10);
		pane.setVgap(16);
		pane.setAlignment(Pos.TOP_LEFT);
		//pane.setGridLinesVisible(true);
		
		Label reserve_info=new Label("预订信息");
		reserve_info.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 25));
		pane.add(reserve_info,column_index,row_index);
		
		Label enter_info=new Label("入住信息");
		enter_info.setFont(Font.font("Tahoma", FontWeight.MEDIUM, 25));
		pane.add(enter_info,column_index,row_index+4);
		
		Label RoomType=new Label("房间类型:");
		RoomType.setFont(f);
		pane.add(RoomType, column_index+1, row_index+1);
		
		room_type=new LinkedList<String>();
		room_type.add("大床房");
		room_type.add("单人间");
		room_type.add("商务间");
		ChoiceBox cb=new ChoiceBox(FXCollections.observableArrayList(room_type));
		pane.add(cb, column_index+2, row_index+1);
		
		Label enter_time=new Label("入住时间:");
		enter_time.setFont(f);
		pane.add(enter_time, column_index+1, row_index+2);
		
		DatePicker enter=new MyDatePicker();
		enter.setMaxWidth(130);
		pane.add(enter, column_index+2, row_index+2);
		
		Label out_time=new Label("退房时间:");
		out_time.setFont(f);
		pane.add(out_time, column_index+3, row_index+2);
		
		MyDatePicker out=new MyDatePicker();
		out.setMaxWidth(130);
		out.setBeforeDisable(enter);
		pane.add(out, column_index+4, row_index+2);
		
		Label num=new Label("房间数量:");
		num.setFont(f);
		pane.add(num,column_index+1,row_index+3);
		
		TextField number=new TextField();
		number.setFont(f);
		number.setMaxWidth(100);
		pane.add(number,column_index+2,row_index+3);
		
		Label name=new Label("入住人姓名:");
		name.setFont(f);
		pane.add(name, column_index+1, row_index+5);
		
		TextField Name=new TextField();
		Name.setFont(f);
		Name.setMaxWidth(100);
		pane.add(Name,column_index+2, row_index+5);
		
		Label contact=new Label("联系方式:");
		contact.setFont(f);
		pane.add(contact,column_index+1,row_index+6);
		
		TextField phone=new TextField();
		phone.setFont(f);
		phone.setMaxWidth(130);
		pane.add(phone, column_index+2, row_index+6);
		
		Label latest_time=new Label("最晚入住时间:");
		latest_time.setFont(f);
		pane.add(latest_time,column_index+1,row_index+7);
		
		TextField latestTime=new TextField();
		latestTime.setFont(f);
		latestTime.setMaxWidth(130);
		pane.add(latestTime,column_index+2,row_index+7);
		
		Label num_of_people=new Label("预计入住人数:");
		num_of_people.setFont(f);
		pane.add(num_of_people,column_index+1,row_index+8);
		
		TextField number_of_people=new TextField();
		number_of_people.setFont(f);
		number_of_people.setMaxWidth(100);
		pane.add(number_of_people, column_index+2, row_index+8);
		
		Label does_own_child=new Label("有无儿童:");
		does_own_child.setFont(f);
		pane.add(does_own_child,column_index+1,row_index+9);
		
		ChoiceBox child=new ChoiceBox(FXCollections.observableArrayList("有","无"));
		child.setMinWidth(95);
		pane.add(child, column_index+2, row_index+9);
		
		Button cancel=new Button("取消");
		cancel.setFont(f);
		pane.add(cancel,column_index+5,row_index+11);
		
		Button ensure=new Button("确定");
		ensure.setFont(f);
		pane.add(ensure, column_index+5, row_index+10);
		this.getChildren().add(pane);
	}
}
