package ui.hotelStuff;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;
import vo.OrderVO;

public class OrderTable extends TableView{
	
	private final ObservableList<OrderVO> data;
	
	/**
	 * 建立订单列表
	 * @param orderList
	 */
	public OrderTable(List<OrderVO> orderList){
		super();
		data = FXCollections.observableArrayList();
		for(int i = 0; i < orderList.size(); i ++){
			data.add(orderList.get(i));
		}
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
		orderId.setMinWidth(100);
		
		TableColumn firstBooker = new TableColumn();
		firstBooker.setText("预订者");
		firstBooker.setCellValueFactory(new PropertyValueFactory("firstBooker"));
		firstBooker.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		firstBooker.setMinWidth(100);
		firstBooker.setStyle("-fx-alignment:center;");
		
		TableColumn preCheckIn = new TableColumn();
		preCheckIn.setText("预订入住时间");
		preCheckIn.setCellValueFactory(new PropertyValueFactory("preCheckIn"));
		preCheckIn.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		preCheckIn.setMinWidth(125);
		preCheckIn.setStyle("-fx-alignment:center;");
		
		TableColumn preCheckOut = new TableColumn();
		preCheckOut.setText("预订退房时间");
		preCheckOut.setCellValueFactory(new PropertyValueFactory("preCheckOut"));
		preCheckOut.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		preCheckOut.setMinWidth(125);
		preCheckOut.setStyle("-fx-alignment:center;");
		
		TableColumn orderState = new TableColumn();
		orderState.setText("订单状态");
		orderState.setCellValueFactory(new PropertyValueFactory("orderState"));
		orderState.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		orderState.setMinWidth(100);
		orderState.setStyle("-fx-alignment:center;");
		
		TableColumn orderOp = new TableColumn();
		orderOp.setMinWidth(80);
		
		
		this.setItems(data);
		this.setEditable(false);
		this.setMinHeight(420);
		this.setStyle("-fx-base: rgb(30,170,255);");
		this.getColumns().addAll(orderId,firstBooker,preCheckIn,preCheckOut,orderState,orderOp);
		this.setPadding(new Insets(10,10,10,10));
	
	}

}
