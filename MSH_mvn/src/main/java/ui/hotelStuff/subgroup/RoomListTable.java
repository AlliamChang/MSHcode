package ui.hotelStuff.subgroup;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import vo.RoomVO;

public class RoomListTable extends TableView{

	private final ObservableList<RoomVO> data;
	
	public RoomListTable(Iterator<RoomVO> roomList){
		super();
		data = FXCollections.observableArrayList();
		while(roomList.hasNext()){
			data.add(roomList.next());
		}
		init();
	}
	
	private void init(){
		StringConverter<Object> sc = new StringConverter<Object>(){

			@Override
			public String toString(Object o) {
				return o == null? null : o.toString();
			}

			@Override
			public Object fromString(String string) {
				return string;
			}
			
		};
		
		TableColumn roomStyle = new TableColumn("客房类型");
		roomStyle.setCellValueFactory(new PropertyValueFactory("roomStyle"));
		roomStyle.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		roomStyle.setStyle("-fx-alignment:center;");
		
		TableColumn bedStyle = new TableColumn("床型");
		bedStyle.setCellValueFactory(new PropertyValueFactory("bedStyle"));
		bedStyle.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		bedStyle.setStyle("-fx-alignment:center;");
		
		TableColumn price = new TableColumn("原始价格(¥)");
		price.setCellValueFactory(new PropertyValueFactory("price"));
		price.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		price.setStyle("-fx-alignment:center;");
		
		TableColumn num = new TableColumn("客房数量");
		num.setCellValueFactory(new PropertyValueFactory("num"));
		num.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		num.setStyle("-fx-alignment:center;");
		
		TableColumn maxCustomer = new TableColumn("最多可住人数");
		maxCustomer.setCellValueFactory(new PropertyValueFactory("maxCustomer"));
		maxCustomer.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		maxCustomer.setStyle("-fx-alignment:center;");
		
		TableColumn edit = new TableColumn( );
		
		this.setItems(data);
		this.getColumns().addAll(roomStyle,bedStyle,price,num,maxCustomer,edit);
//		this.setStyle("-fx-border-color:black;");
		this.setPadding(new Insets(10,10,10,10));
		
	}
}
