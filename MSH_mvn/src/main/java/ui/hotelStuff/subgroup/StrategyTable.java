package ui.hotelStuff.subgroup;

import java.util.Iterator;

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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.util.Callback;
import tools.Date;
import vo.CheckInVO;
import vo.HotelStrategyVO;
import vo.OrderVO;

public class StrategyTable extends TableView{

	private final ObservableList<HotelStrategyVO> data;
	
	public StrategyTable(Iterator<HotelStrategyVO> list){
		data = FXCollections.observableArrayList();
		
		while(list.hasNext()){
			data.add(list.next());
		}
		this.init();
	}
	
	private void init(){
		TableColumn name = new TableColumn("策略名称"); 
		name.setCellValueFactory(new PropertyValueFactory("name"));
		name.setMinWidth(150);
		
		TableColumn type = new TableColumn("策略类型");
		type.setCellValueFactory(new PropertyValueFactory("type"));
		type.setMinWidth(115);
		type.setStyle("-fx-alignment:center");
		
		TableColumn discont = new TableColumn("折扣");
		discont.setCellValueFactory(new PropertyValueFactory("discont"));
		discont.setStyle("-fx-alignment:center");
		discont.setMinWidth(80);
		
		TableColumn<HotelStrategyVO,String> begin = new TableColumn<>("开始时间");
		begin.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HotelStrategyVO, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<HotelStrategyVO, String> param) {
				// TODO Auto-generated method stub
				String temp = param.getValue().getBegin().getDate();
				return new SimpleStringProperty(temp);
			}
	    });
		begin.setCellFactory(new Callback<TableColumn<HotelStrategyVO, String>, TableCell<HotelStrategyVO, String>>() {
		      @Override 
		      public TableCell<HotelStrategyVO, String> call(TableColumn<HotelStrategyVO, String> param) {
		        return new TableCell<HotelStrategyVO,String>(){
		        	
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
		begin.setStyle("-fx-alignment:center");
		begin.setMinWidth(115);
		
		TableColumn<HotelStrategyVO,String> end = new TableColumn<>("结束时间");
		end.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<HotelStrategyVO, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<HotelStrategyVO, String> param) {
				// TODO Auto-generated method stub

				Date temp = param.getValue().getEnd();
				return new SimpleStringProperty(temp.getDate());
//				return new SimpleStringProperty(param.getValue().getEnd().getDate());
			}
	    });
		end.setCellFactory(new Callback<TableColumn<HotelStrategyVO, String>, TableCell<HotelStrategyVO, String>>() {
		      @Override 
		      public TableCell<HotelStrategyVO, String> call(TableColumn<HotelStrategyVO, String> param) {
		        return new TableCell<HotelStrategyVO,String>(){
		        	
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
		end.setStyle("-fx-alignment:center");
		end.setMinWidth(115);
		
		TableColumn<HotelStrategyVO,Button> remove = new TableColumn<>("");
		remove.setCellFactory(new Callback<TableColumn<HotelStrategyVO, Button>, TableCell<HotelStrategyVO, Button>>() {
		      @Override 
		      public TableCell<HotelStrategyVO, Button> call(TableColumn<HotelStrategyVO, Button> param) {
		        return new TableCell<HotelStrategyVO,Button>(){
		        	
		        	protected void updateItem(Button item,boolean empty){
		        		if(!empty){
		        			item = new Button("移除");
		        			item.setMaxWidth(50);
		        			item.setOnAction(e -> {
		        				Alert alert = new Alert(AlertType.CONFIRMATION);
		        				alert.initModality(Modality.APPLICATION_MODAL);
		        				alert.getDialogPane().setHeaderText(null);
		        				alert.getDialogPane().setContentText("确定要移除该策略吗？");
		        				alert.showAndWait().filter(response -> 
		        					response == ButtonType.OK).ifPresent(response ->{
		        						StrategyTable.this.getItems().remove(this.getTableRow().getIndex());
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
		remove.setMinWidth(59);
		remove.setMaxWidth(59);
		
		this.setItems(data);
		this.getColumns().addAll(name,type,discont,begin,end,remove);
		this.setEditable(false);
		this.setMinHeight(425);
		this.setPadding(new Insets(10,10,10,10));
	}
}
