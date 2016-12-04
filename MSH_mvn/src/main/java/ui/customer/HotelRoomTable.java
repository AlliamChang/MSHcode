package ui.customer;

import java.util.LinkedList;
import java.util.List;

import ui.utility.MainPane;
import vo.OrderVO;
import vo.RoomVO;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

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
		
		TableColumn<RoomVO, String> operation = new TableColumn<RoomVO, String>("");
		operation.setMinWidth(width);
		
		operation.setCellFactory(new Callback<TableColumn<RoomVO, String>, TableCell<RoomVO, String> >(){

			public TableCell<RoomVO, String> call(
					TableColumn<RoomVO, String> arg0) {
				return new TableCell<RoomVO, String>(){
					protected void updateItem(String item,boolean empty){
						if(!empty){
							Button bn=new Button("预订");
							bn.setOnMouseClicked((MouseEvent me)->{
								MainPane.getInstance().setRightPane(new ReservePane());
							});
							setGraphic(bn);
						}
						else 
							setGraphic(null);
					
					}
				};
			}
		});
		this.setItems(data);
		this.setMinWidth(605);
		this.setMaxHeight(200);
		this.getColumns().addAll(room_type,bed_type,price,operation);
		
		
	}
}
