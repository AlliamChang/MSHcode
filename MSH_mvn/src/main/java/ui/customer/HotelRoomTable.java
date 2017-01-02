package ui.customer;

import java.util.List;

import ui.utility.MainPane;
import vo.RoomVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

@SuppressWarnings("rawtypes")
public class HotelRoomTable extends TableView{
	private final ObservableList<RoomVO> data;
	private List<RoomVO>list;
	private final int width=150;
	private Parent last;
	
	public HotelRoomTable(List<RoomVO> list,Parent last){
		super();
		this.list=list;
		this.last = last;
		data = FXCollections.observableArrayList();
		for(int i=0;i<list.size();i++){
			data.add(list.get(i));
		}
		this.init();
	}
	
	@SuppressWarnings("unchecked")
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
								if(MainPane.getInstance().isLogin()){
									MainPane.getInstance().setRightPane(new ReservePane(last, HotelRoomTable.this));
								}else{
									Alert alert = new Alert(AlertType.INFORMATION);
									alert.getDialogPane().setHeaderText(null);
									alert.setContentText("尚未登录，不能预订酒店");
									alert.show();
								}
								
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
		this.setPrefHeight(150);
		this.getColumns().addAll(room_type,bed_type,price,operation);
		
		
	}
	public List<RoomVO> getData(){
		return list;
	}
}
