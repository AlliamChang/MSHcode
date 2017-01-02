package ui.hotelStuff.subgroup;

import java.util.Iterator;

import bl.hotel.HotelBLServiceImpl;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.util.Callback;
import javafx.util.StringConverter;
import vo.OrderVO;
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
		roomStyle.setMinWidth(150);
		roomStyle.setStyle("-fx-alignment:center;");
		
		TableColumn bedStyle = new TableColumn("床型");
		bedStyle.setCellValueFactory(new PropertyValueFactory("bedStyle"));
		bedStyle.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		bedStyle.setMinWidth(100);
		bedStyle.setStyle("-fx-alignment:center;");
		
		TableColumn price = new TableColumn("原始价格(¥)");
		price.setCellValueFactory(new PropertyValueFactory("price"));
		price.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		price.setMinWidth(100);
		price.setStyle("-fx-alignment:center;");
		
		TableColumn num = new TableColumn("客房数量");
		num.setCellValueFactory(new PropertyValueFactory("num"));
		num.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		num.setMinWidth(100);
		num.setStyle("-fx-alignment:center;");
		
		TableColumn maxCustomer = new TableColumn("最多可住人数");
		maxCustomer.setCellValueFactory(new PropertyValueFactory("maxCustomer"));
		maxCustomer.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		maxCustomer.setMinWidth(100);
		maxCustomer.setStyle("-fx-alignment:center;");
		
		TableColumn<RoomVO,Button> remove = new TableColumn<RoomVO,Button>( );
//		remove.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<RoomVO, String>, ObservableValue<String>>() {
//
//			@Override
//			public ObservableValue<String> call(CellDataFeatures<RoomVO, String> param) {
//				// TODO Auto-generated method stub
//				return null;
//			}
//	    });
		remove.setCellFactory(new Callback<TableColumn<RoomVO, Button>, TableCell<RoomVO, Button>>() {
		      @Override 
		      public TableCell<RoomVO, Button> call(TableColumn<RoomVO, Button> param) {
		        return new TableCell<RoomVO,Button>(){
		        	
		        	protected void updateItem(Button item,boolean empty){
		        		if(!empty){
		        			item = new Button("删除");
		        			item.setOnAction(event ->{
		        				Alert alert = new Alert(AlertType.CONFIRMATION);
		        				alert.initModality(Modality.APPLICATION_MODAL);
		        				alert.getDialogPane().setHeaderText(null);
		        				alert.getDialogPane().setContentText("确认删除？");
		        				alert.showAndWait().filter(response -> 
		        					response == ButtonType.OK).ifPresent(response ->{
		        						RoomListTable.this.getItems().remove(this.getTableRow().getIndex());
//		        						new HotelBL().;
		        					});
		        			});
		        		}else{
		        			item = null;
		        		}
		        		setGraphic(item);
		        	}
		        };
		      }
		    });
		remove.setMinWidth(83);
		remove.setStyle("-fx-alignment:center;");
		
		
		this.setItems(data);
		this.setEditable(true);
		this.getColumns().addAll(roomStyle,bedStyle,price,num,maxCustomer,remove);
//		this.setStyle("-fx-border-color:black;");
		this.setPadding(new Insets(10,10,10,10));
		
	}
}
