package ui.customer;

import java.util.List;

import vo.OrderVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MyOrderTable extends TableView{
	private final ObservableList<OrderVO> data;
	private int width=80;
	public MyOrderTable(List<OrderVO> list){
		super();
		data = FXCollections.observableArrayList();
		for(int i=0;i<list.size();i++){
			data.add(list.get(i));
		}
		this.init();
	}
	
	public void init(){
		TableColumn start_time=new TableColumn("开始时间");
		start_time.setMinWidth(width);
		start_time.setCellValueFactory(new PropertyValueFactory("preCheckIn"));
		
		TableColumn check_out_time=new TableColumn("退房时间");
		check_out_time.setMinWidth(width);
		check_out_time.setCellValueFactory(new PropertyValueFactory("preCheckOut"));
		
		TableColumn room_type=new TableColumn("房间类型");
		room_type.setMinWidth(width);
		room_type.setCellValueFactory(new PropertyValueFactory("room_type"));
		
		TableColumn number=new TableColumn("数量");
		number.setMinWidth(width);
		number.setCellValueFactory(new PropertyValueFactory("num"));
		
		TableColumn total=new TableColumn("总价(¥)");
		total.setMinWidth(width);
		total.setCellValueFactory(new PropertyValueFactory("total"));
		
		TableColumn state=new TableColumn("状态");
		state.setMinWidth(width);
		state.setCellValueFactory(new PropertyValueFactory("orderState"));
		
		TableColumn isEvaluated=new TableColumn("有无评价");
		isEvaluated.setMinWidth(width);
		isEvaluated.setCellValueFactory(new PropertyValueFactory("evaluate"));
		
		this.setItems(data);
		this.getColumns().addAll(start_time,check_out_time,room_type,number,total,state,isEvaluated);
	}
}
