package ui.customer;

import java.util.List;

import vo.RoomVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HotelRoomTable extends TableView{
	private final ObservableList<RoomVO> data;
	private final int width=150;
	public HotelRoomTable(List<RoomVO> list){
		super();
		data = FXCollections.observableArrayList();
		for(int i=0;i<list.size();i++){
			data.add(list.get(i));
		}
		this.init();
	}
	
	public void init(){
		TableColumn room_type=new TableColumn("房型");
		room_type.setMinWidth(width);
		room_type.setCellValueFactory(new PropertyValueFactory("roomStyle"));
		
		TableColumn bed_type=new TableColumn("床型");
		bed_type.setMinWidth(width);
		bed_type.setCellValueFactory(new PropertyValueFactory("bedStyle"));
		
		TableColumn price=new TableColumn("价格(¥)");
		price.setMinWidth(width);
		price.setCellValueFactory(new PropertyValueFactory("price"));
		
		this.setItems(data);
		this.getColumns().addAll(room_type,bed_type,price);
		
		
	}
}
