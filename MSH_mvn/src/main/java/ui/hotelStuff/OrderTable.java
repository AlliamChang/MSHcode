package ui.hotelStuff;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import vo.OrderVO;

public class OrderTable extends TableView{
	
	private final ObservableList<OrderVO> data;
	
	public OrderTable(List<OrderVO> orderList){
		super();
		data = FXCollections.observableArrayList(orderList);
		this.init();
	}
	
	public void init(){
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
		
		TableColumn orderId = new TableColumn();
		orderId.setText("订单号");
		orderId.setCellValueFactory(new PropertyValueFactory("id"));
		orderId.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		
		TableColumn preCheckIn = new TableColumn();
		preCheckIn.setText("预订入住时间");
		preCheckIn.setCellValueFactory(new PropertyValueFactory("preChechIn"));
		preCheckIn.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		
		TableColumn preCheckOut = new TableColumn();
		
		TableColumn orderState = new TableColumn();
		
		TableColumn orderOp = new TableColumn();
		
		this.setItems(data);
		this.setEditable(false);
		this.getColumns().addAll(orderId,preCheckIn,preCheckOut,orderState,orderOp);
		
	}

}
