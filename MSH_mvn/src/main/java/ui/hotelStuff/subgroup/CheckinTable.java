package ui.hotelStuff.subgroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.util.Callback;
import ui.hotelStuff.control.HotelPaneController;
import vo.CheckInVO;
import vo.OrderVO;
import vo.RoomVO;

public class CheckinTable extends TableView{

	private final ObservableList<CheckInVO> data;
	
	public CheckinTable(Iterator<CheckInVO> list){
		super();
		
		data = FXCollections.observableArrayList();
		while(list.hasNext()){
			data.add(list.next());
		}
		
		
		
		this.init();
	}
	
	private void init(){
		TableColumn checker = new TableColumn("登记者");
		checker.setCellValueFactory(new PropertyValueFactory("booker"));
		checker.setStyle("-fx-alignment:center");
		checker.setMinWidth(75);
		
		TableColumn checkin = new TableColumn("入住时间");
		checkin.setCellValueFactory(new PropertyValueFactory("checkinTime"));
		checkin.setStyle("-fx-alignment:center");
		checkin.setMinWidth(175);
		
		TableColumn checkout = new TableColumn("预计退房时间");
		checkout.setCellValueFactory(new PropertyValueFactory("checkoutTime"));
		checkout.setStyle("-fx-alignment:center");
		checkout.setMinWidth(105);
		
		TableColumn belongOrder = new TableColumn("附属订单号");
		belongOrder.setCellValueFactory(new PropertyValueFactory("orderId"));
		belongOrder.setStyle("-fx-alignment:center");
		belongOrder.setMinWidth(100);
		
		TableColumn<CheckInVO,String> roomId = new TableColumn<>("房间号");
		roomId.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<CheckInVO, String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<CheckInVO, String> param) {
				// TODO Auto-generated method stub
				String[] item = param.getValue().getRoomId();
				StringBuilder temp = new StringBuilder();
    			for(int i = 0; i < item.length; i ++){
    				temp.append(item[i]);
    				if(i < item.length - 1){
    					temp.append("、");
    				}
    			}
				return new SimpleStringProperty(temp.toString());
			}

			
	    });
		roomId.setCellFactory(new Callback<TableColumn<CheckInVO, String>, TableCell<CheckInVO, String>>() {
		      @Override 
		      public TableCell<CheckInVO, String> call(TableColumn<CheckInVO, String> param) {
		        return new TableCell<CheckInVO,String>(){
		        	
		        	protected void updateItem(String item,boolean empty){
		        		if(!empty){
		        			
		        			setText(item);
		        		}else{
		        			setText(null);
		        		}
		        	}
		        };
		      }
		    });
		roomId.setStyle("-fx-alignment:center");
		roomId.setMinWidth(100);
		
		TableColumn<CheckInVO,Button> remove = new TableColumn<>();
		remove.setCellFactory(new Callback<TableColumn<CheckInVO, Button>, TableCell<CheckInVO, Button>>() {
		      @Override 
		      public TableCell<CheckInVO, Button> call(TableColumn<CheckInVO, Button> param) {
		        return new TableCell<CheckInVO,Button>(){
		        	
		        	protected void updateItem(Button item,boolean empty){
		        		if(!empty){
		        			item = new Button("退房");
		        			
		        			this.setGraphic(item);
		        		}else{
		        			this.setGraphic(null);
		        		}
		        	}
		        };
		      }
		    });
		remove.setStyle("-fx-alignment:center");
		remove.setMaxWidth(65);
		remove.setMinWidth(65);
		
//		this.setStyle("-fx-alignment:center");
		this.setItems(data);
		this.setEditable(false);
		this.setMinHeight(415);
		this.setMaxHeight(415);
		this.getColumns().addAll(checker,checkin,checkout,belongOrder,roomId,remove);
		this.setPadding(new Insets(10,10,10,10));
		
	}
}
