package ui.hotelStuff.subgroup;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.util.Callback;
import javafx.util.StringConverter;
import tools.Date;
import tools.OrderState;
import tools.ResultMessage;
import ui.hotelStuff.CheckinInfoPane;
import ui.hotelStuff.OrderListPane;
import ui.hotelStuff.control.HotelPaneController;
import ui.utility.MainPane;
import ui.utility.MyDatePicker;
import vo.OrderVO;

public class OrderTable extends TableView{
	
	private final ObservableList<OrderVO> data;
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	private OrderListPane parent;
	
	/**
	 * 建立订单列表
	 * @param orderList
	 */
	public OrderTable(List<OrderVO> orderList,OrderListPane parent){
		super();
		data = FXCollections.observableArrayList();
		for(int i = 0; i < orderList.size(); i ++){
			data.add(orderList.get(i));
		}
		this.parent = parent;
		this.init();
	}
	
	public void updateOrder(List<OrderVO> orderList){
		data.remove(0, data.size());
		for(int i = 0; i < orderList.size(); i ++){
			data.add(orderList.get(i));
		}
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
		firstBooker.setMinWidth(80);
		firstBooker.setStyle("-fx-alignment:center;");

		TableColumn<OrderVO,String> checkin = new TableColumn<>();
		checkin.setText("实际入住时间");
		checkin.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<OrderVO, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getCheckin() == null? null:
					new SimpleStringProperty(param.getValue().getCheckin().getDate());
			}

			
	    });
		checkin.setCellFactory(new Callback<TableColumn<OrderVO, String>, TableCell<OrderVO, String>>() {
		      @Override 
		      public TableCell<OrderVO, String> call(TableColumn<OrderVO, String> param) {
		        return new TableCell<OrderVO,String>(){
		        	
		        	@Override
		        	protected void updateItem(String item,boolean empty){
		        		super.updateItem(item,empty);
		        		if(!empty){
		        			if(item == null){
		        				setText("尚未入住");
		        			}else{
		        				setText(item);
		        			}
		        		}else{
		        			setText(null);
		        		}
		        	}
		        };
		      }
		    });
		checkin.setMinWidth(165);
		checkin.setStyle("-fx-alignment:center;");
		
		TableColumn preCheckIn = new TableColumn();
		preCheckIn.setText("预订入住时间");
		preCheckIn.setCellValueFactory(new PropertyValueFactory("preCheckIn"));
		preCheckIn.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		preCheckIn.setMinWidth(115);
		preCheckIn.setStyle("-fx-alignment:center;");
		
		TableColumn orderState = new TableColumn();
		orderState.setText("订单状态");
		orderState.setCellValueFactory(new PropertyValueFactory("orderState"));
		orderState.setCellFactory(TextFieldTableCell.forTableColumn(sc));
		orderState.setMinWidth(80);
		orderState.setStyle("-fx-alignment:center;");
		
		TableColumn<OrderVO,String> orderOp = new TableColumn<>();
		orderOp.setMinWidth(90);
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
		        return new ExecuteCell(OrderTable.this);
		      }
		    });
		
		
		this.setItems(data);
		this.setEditable(false);
		this.setMinHeight(420);
//		this.setStyle("-fx-base: rgb(30,170,255);");
		this.getColumns().addAll(orderId,firstBooker,checkin,preCheckIn,orderState,orderOp);
		this.setPadding(new Insets(10,10,10,10));
		
		
	}
	
	public void filter(String id,String fb,String in,String preIn,String state){
		ObservableList<OrderVO> filt = FXCollections.observableArrayList();
		System.out.println(id);
		for(OrderVO o: data){
			boolean isId = String.valueOf(o.getId()).equals(id) || id == null || id.equals("");
			boolean isFirstBooker = o.getFirstBooker().equals(fb) || fb == null || fb.equals("");
			boolean isIn = (o.getCheckin().getDate() == null? false : o.getCheckin().getDate().split(" ")[0].equals(in) ) || in == null || in.equals("");
			boolean isPreIn = o.getPreCheckin().getDate().equals(preIn) || preIn == null || preIn.equals("");
			boolean isState = o.orderStateProperty().getValue().equals(state) || state == null || state.equals("");
			
			if( isId && isFirstBooker && isIn && isPreIn && isState){
				filt.add(o);
			}
		}
		this.setItems(filt);
	}
	
	public void clear(){
		this.setItems(data);
	}
	
	private <T> void addTooltipToRows(TableRow<OrderVO> row) {
		if(row != null){
			OrderVO o = (OrderVO)this.getItems().get(row.getIndex());
			Tooltip tip = new Tooltip();
			StringBuilder message = new StringBuilder();
			message.append("住客信息：\n");
			for(int i = 0; i < o.getBooker().length; i ++){
				message.append("   入住客人" + (i+1) + "：" + o.getBooker()[i] + "\n");
				message.append("   入住客人" + (i+1) + "：" + o.getBookerPhone()[i] + "\n");
			}
			message.append("入住信息：\n");
			message.append("   入住房型：" +o.getRoomStyle() + "\n");
			message.append("   房间数量：" + o.getRoomNum() + "\n");
			message.append("   入住天数：" + o.getDays() + "\n");
			message.append("\n订单总价：" + o.getPrice());
			tip.setText(message.toString());
			row.setTooltip(tip);
//			row.setone(e -> {
//				System.out.println(2);
//				tip.hide();
//				tip.setAutoHide(true);
//			});
		}
	}

	private class ExecuteCell extends TableCell<OrderVO,String>{
		// a button for adding a new person.
	    final Button addButton       = new Button();
	    // pads and centers the add button in the cell.
	    HBox paddedButton;
	    final Button moreButton = new Button("详情");
	    final OrderTable table;
	    Tooltip tip = null;
	    
	    ExecuteCell(OrderTable table){
	    	addButton.setStyle("-fx-font-size:12");
	    	moreButton.setStyle("-fx-font-size:12");
	    	this.table = table;
	    }

		/** places an add button in the row only if the row is not empty. */
	    @Override
	    protected void updateItem(String item, boolean empty) {
	      super.updateItem(item, empty);
	      if (!empty) {
	    	  this.paddedButton = new HBox();
		    	OrderTable.this.addTooltipToRows(this.getTableRow());
		        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		        setGraphic(paddedButton);
		        if(item.equals("异常订单")){
		        	addButton.setText("延期");
		        	addButton.setOnAction(event -> {
	//	        		System.out.println("处理");
		        		TextInputDialog alert = new TextInputDialog();
		        		alert.setHeaderText("延迟入住");
		        		Label l = new Label("选择延迟入住日期：");
						int i = this.getTableRow().getIndex();
						OrderVO o =(OrderVO)(table.getItems().get(i));
		    			MyDatePicker temp = new MyDatePicker(o.preCheckInProperty().get());
		    			temp.setMaxWidth(150);
		    			HBox hb = new HBox(5);
		    			hb.setAlignment(Pos.CENTER);
		    			hb.getChildren().addAll(l,temp);
		    			alert.getDialogPane().setContent(hb);
		    			
		    			alert.showAndWait().ifPresent(response -> {
		    				if(temp.getEditor().getText().equals("") || temp.getEditor().getText() == null){
		    					Alert a = new Alert(AlertType.ERROR);
		    	    			a.initModality(Modality.APPLICATION_MODAL);
		    	    			a.getDialogPane().setHeaderText(null);
		    	    			a.setContentText("尚未选择日期");
		    	    			a.show();
		    				}else{
		    					o.setPreCheckin(new Date(temp.getEditor().getText(),false));
		    					o.setState(OrderState.UNEXECUTED);
		    	        		Alert a = new Alert(AlertType.INFORMATION);
		    	    			a.initModality(Modality.APPLICATION_MODAL);
		    	    			a.getDialogPane().setHeaderText(null);
		    	    			if(ResultMessage.SUCCESS == HotelPaneController.getInstance().delay(o.getId(), o.getPreCheckin())){
			    					data.set(i, o);
			    	    			a.setContentText("已成功延期");
		    	    			}else{
		    	    				a.setContentText("延期失败");
		    	    			}
		    	    			a.show();
		    				}
		    			});
		        	});
		            paddedButton.getChildren().add(addButton);
		        }else if(item.equals("未执行")){
		        	addButton.setText("入住");
		        	addButton.setOnAction(e -> {
		        		Alert alert = new Alert(AlertType.CONFIRMATION);
		    			alert.initModality(Modality.APPLICATION_MODAL);
		    			alert.getDialogPane().setHeaderText(null);
		    			alert.setContentText("确定要入住吗？");
		    			alert.showAndWait().ifPresent(response -> {
		    				if(response == ButtonType.OK){
		    					int i = this.getTableRow().getIndex();
		    					OrderVO o = (OrderVO)table.getItems().get(i);
		    					o.setCheckin(new Date(LocalDateTime.now().format(format),true));
		    					o.setState(OrderState.EXECUTED);
		    					if( ResultMessage.SUCCESS == HotelPaneController.getInstance().checkin(o.getId(), o.getCheckin())){
		    						data.set(i, o);
		    					}
		    					//MainPane.getInstance().setRightPane(new CheckinInfoPane(parent,o.getBooker()[0],o.getRoomStyle(),o.getPreCheckin().getLocalDate(),o.getPreCheckin().getLocalDate().plusDays(o.getDays()),o.getId()));
		    				}
		    			});
		        	});
		        	
		            paddedButton.getChildren().add(addButton);
		        }
		        
		        moreButton.setOnMouseClicked(e -> {
		        	if(moreButton.getText().equals("详情")){
		        		tip = this.getTableRow().getTooltip();
		        		tip.show(this.getTableRow(), e.getScreenX()-200, e.getScreenY());
	//	        		this.getTableRow().getTooltip().setConsumeAutoHidingEvents(true);
		        		this.getTableRow().setTooltip(null);
		        		moreButton.setText("收起");
		        	}else{
		        		tip.hide();
		        		this.getTableRow().setTooltip(tip);
		        		tip = null;
		        		moreButton.setText("详情");
		        	}
		        });
		        
		        paddedButton.getChildren().add(moreButton);
	        
	        
	      }else{
	    	  this.getTableRow().setTooltip(null);
	    	  this.setGraphic(null);
	      }
	    }
	}
}


