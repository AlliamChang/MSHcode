package ui.hotelStuff.subgroup;

import java.util.Iterator;

import bl.strategy.StrategyBLServiceImpl;
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
import tools.Date;
import tools.StrategyType;
import vo.StrategyVO;

public class StrategyTable extends TableView{

	private final ObservableList<StrategyVO> data;
	
	public StrategyTable(Iterator<StrategyVO> list){
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
		
		TableColumn<StrategyVO,String> type = new TableColumn("策略类型");
		type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StrategyVO, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<StrategyVO, String> param) {
				SimpleStringProperty straName = new SimpleStringProperty();
				switch(param.getValue().getStrategyType()){
				case BIRTHDAY:
					straName.set("生日特惠");
					break;
				case CO_OPERATION:
					straName.set("合作企业特惠");
					break;
				case HOLIDAY:
					straName.set("节假日特惠");
					break;
				case TRIPLEROOM:
					straName.set("多房间优惠");
					break;
				}
				return straName;
			}
			
		});
		type.setMinWidth(115);
		type.setStyle("-fx-alignment:center");
		
		TableColumn discont = new TableColumn("折扣");
		discont.setCellValueFactory(new PropertyValueFactory("cost"));
		discont.setStyle("-fx-alignment:center");
		discont.setMinWidth(80);
		
		TableColumn<StrategyVO,String> begin = new TableColumn<>("开始时间");
		begin.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StrategyVO, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<StrategyVO, String> param) {
				// TODO Auto-generated method stub
				return new SimpleStringProperty(param.getValue().getStartTime());
			}
	    });
		begin.setCellFactory(new Callback<TableColumn<StrategyVO, String>, TableCell<StrategyVO, String>>() {
		      @Override 
		      public TableCell<StrategyVO, String> call(TableColumn<StrategyVO, String> param) {
		        return new TableCell<StrategyVO,String>(){
		        	
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
		
		TableColumn<StrategyVO,String> end = new TableColumn<>("结束时间");
		end.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<StrategyVO, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<StrategyVO, String> param) {
				// TODO Auto-generated method stub

				return new SimpleStringProperty(param.getValue().getEndTime());
//				return new SimpleStringProperty(param.getValue().getEnd().getDate());
			}
	    });
		end.setCellFactory(new Callback<TableColumn<StrategyVO, String>, TableCell<StrategyVO, String>>() {
		      @Override 
		      public TableCell<StrategyVO, String> call(TableColumn<StrategyVO, String> param) {
		        return new TableCell<StrategyVO,String>(){
		        	
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
		
		TableColumn<StrategyVO,Button> remove = new TableColumn<>("");
		remove.setCellFactory(new Callback<TableColumn<StrategyVO, Button>, TableCell<StrategyVO, Button>>() {
		      @Override 
		      public TableCell<StrategyVO, Button> call(TableColumn<StrategyVO, Button> param) {
		        return new TableCell<StrategyVO,Button>(){
		        	
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
		        						new StrategyBLServiceImpl().deleteStrategy((StrategyVO)StrategyTable.this.getItems().get(this.getTableRow().getIndex()));
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
