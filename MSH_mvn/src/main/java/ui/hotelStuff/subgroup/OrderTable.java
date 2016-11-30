package ui.hotelStuff.subgroup;

import java.util.List;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
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
		orderId.setStyle("-fx-alignment:center;");
		
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
		
		TableColumn<OrderVO,String> orderOp = new TableColumn<>();
		orderOp.setMinWidth(80);
		orderOp.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, String>, ObservableValue<String>>() {

				@Override
				public ObservableValue<String> call(CellDataFeatures<OrderVO, String> param) {
					// TODO Auto-generated method stub
					return param.getValue().orderStateProperty();
				}
		    });
		
		orderOp.setCellFactory(new Callback<TableColumn<OrderVO, String>, TableCell<OrderVO, String>>() {
		      @Override 
		      public TableCell<OrderVO, String> call(TableColumn<OrderVO, String> param) {
		        return new ExecuteCell();
		      }
		    });
		
		
		this.setItems(data);
		this.setEditable(false);
		this.setMinHeight(420);
//		this.setStyle("-fx-base: rgb(30,170,255);");
		this.getColumns().addAll(orderId,firstBooker,preCheckIn,preCheckOut,orderState,orderOp);
		this.setPadding(new Insets(10,10,10,10));
		
	}
	
	public void filter(String id,String fb,String preIn,String preOut,String state){
		ObservableList<OrderVO> filt = FXCollections.observableArrayList();
		System.out.println(id);
		for(OrderVO o: data){
			boolean isId = String.valueOf(o.getId()).equals(id) || id == null || id.equals("");
			boolean isFirstBooker = o.getFirstBooker().equals(fb) || fb == null || fb.equals("");
			boolean isPreIn = o.preCheckInProperty().getValue().equals(preIn) || preIn == null || preIn.equals("");
			boolean isPreOut = o.getPreCheckOut().equals(preOut) || preOut == null || preOut.equals("");
			boolean isState = o.orderStateProperty().getValue().equals(state) || state == null || state.equals("");
			
			if( isId && isFirstBooker && isPreIn && isPreOut
					&& isState){
				filt.add(o);
			}
		}
		this.setItems(filt);
	}
	
	public void clear(){
		this.setItems(data);
	}

}

class ExecuteCell extends TableCell<OrderVO,String>{
	// a button for adding a new person.
    final Button addButton       = new Button();
    // pads and centers the add button in the cell.
    final StackPane paddedButton = new StackPane();
    
    ExecuteCell(){
    	addButton.setStyle("-fx-font-size:13");
    }

	/** places an add button in the row only if the row is not empty. */
    @Override
    protected void updateItem(String item, boolean empty) {
      super.updateItem(item, empty);
      if (!empty) {
        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        setGraphic(paddedButton);
        if(paddedButton.getChildren().size() > 0){
        	paddedButton.getChildren().remove(0);
        }
        if(item.equals("异常订单")){
        	addButton.setText("延期");
        	addButton.setOnAction(event -> {
//        		System.out.println("处理");
        		
        	});
            paddedButton.getChildren().add(addButton);
        }else if(item.equals("未执行")){
        	addButton.setText("入住");
            paddedButton.getChildren().add(addButton);
        }
      }else{
    	  this.setGraphic(null);
      }
    }
}
