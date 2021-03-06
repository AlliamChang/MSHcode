package ui.customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

import blservice.order.OrderBLService;
import tools.OrderState;
import tools.ResultMessage;
import ui.utility.MainPane;
import vo.OrderVO;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

@SuppressWarnings("rawtypes")
public class MyOrderTable extends TableView{
	private final ObservableList<OrderVO> data;
	private static List<String> order_info;
	private boolean isCanceled=false;
	private  static List<OrderVO> list;
	private int width=80;
	
	@SuppressWarnings("static-access")
	public MyOrderTable(List<OrderVO> list){
		super();
		data = FXCollections.observableArrayList();
		for(int i=0;i<list.size();i++){
			data.add(list.get(i));
		}
		this.list=list;
		this.init();
		
	}
	
	@SuppressWarnings("unchecked")
	public void init(){
		TableColumn start_time=new TableColumn("开始时间");
		start_time.setMinWidth(width-10);
		start_time.setCellValueFactory(new PropertyValueFactory("preCheckIn"));
		
		TableColumn check_out_time=new TableColumn("退房时间");
		check_out_time.setMinWidth(width-10);
		check_out_time.setCellValueFactory(new PropertyValueFactory("CheckOut"));
		
		TableColumn room_type=new TableColumn("房间类型");
		room_type.setMinWidth(width);
		room_type.setCellValueFactory(new PropertyValueFactory("roomStyle"));
		
		TableColumn number=new TableColumn("数量");
		number.setMinWidth(width/2);
		number.setCellValueFactory(new PropertyValueFactory("roomNum"));
		
		TableColumn total=new TableColumn("总价(¥)");
		total.setMinWidth(width-1);
		total.setCellValueFactory(new PropertyValueFactory("price"));
		
		TableColumn state=new TableColumn("状态");
		state.setMinWidth(width-10);
		state.setCellValueFactory(new PropertyValueFactory("orderState"));
		
		TableColumn isEvaluated=new TableColumn("有无评价");
		isEvaluated.setMinWidth(width);
		isEvaluated.setCellValueFactory(new PropertyValueFactory("evaluate"));
		
		TableColumn<OrderVO, String> operation = new TableColumn<OrderVO, String>("");
		operation.setMinWidth(width-10);
		operation.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<OrderVO, String> param) {
				return param.getValue().operationProperty();
			}
			
	    });
		operation.setCellFactory(new Callback<TableColumn<OrderVO, String>, TableCell<OrderVO, String> >(){

			public TableCell<OrderVO, String> call(
					TableColumn<OrderVO, String> arg0) {
				return new TableCell<OrderVO, String>(){
					private boolean isContinue = false;
					
					@SuppressWarnings("static-access")
					protected void updateItem(String item,boolean empty){
						if(item!=null){
						if(item.equals("评价")){
							Button bn=new Button("评价");
							bn.setOnMouseClicked((MouseEvent me)->{
								List<String> list=new LinkedList<String>();
								int row=this.getTableRow().getIndex();
								OrderVO this_row=MyOrderTable.this.list.get(row);
								list.add(this_row.getPreCheckin().getDate());
								list.add(this_row.getLatestCheckin()+"");
								list.add(this_row.getRoomStyle());
								list.add(this_row.getRoomNum()+"");
								list.add(this_row.getPrice()+"");
								MyOrderTable.this.setList(list);
								MainPane.getInstance().setRightPane(new EvaluatePane(MyOrderTable.this.data.get(this.getTableRow().getIndex())));
							});
							setGraphic(bn);
						}
						else if(item.equals("撤销")){
							Button bn=new Button("撤销");
							
							bn.setOnMouseClicked((MouseEvent me)->{
								OrderBLService order=new bl.order.OrderBLServiceImpl();
								OrderVO vo = MyOrderTable.this.data.get(this.getTableRow().getIndex());
								isContinue = false;
								Alert alert = new Alert(AlertType.CONFIRMATION);
								alert.getDialogPane().setHeaderText(null);
								if(vo.getPreCheckin().getLocalDate().equals(LocalDate.now()) && vo.getLatestCheckin() - LocalTime.now().getHour() <= 6){
									alert.setContentText("距离最晚入住时间不足6个小时，撤销订单将会扣除您一半的信用。\n是否还需要继续撤销订单");
									alert.showAndWait().ifPresent(ok -> {
										if(ok.equals(ButtonType.OK))
											isContinue = true;
									});
								}else{
									alert.setContentText("您是否继续撤销该订单");
									alert.showAndWait().ifPresent(ok -> {
										isContinue = true;
									});
								}
								if(isContinue)
									if(ResultMessage.SUCCESS == order.cancel(vo.getId())){
										int row=this.getTableRow().getIndex();
										MyOrderTable.this.list.get(row).setState(OrderState.CANCELED);
										MyOrderTable.this.isCanceled=true;
										CustomerPaneController.getInstance().createMyOrderPane();
										alert.setAlertType(AlertType.INFORMATION);
										alert.setContentText("撤销成功");
										alert.show();
									}
							});
							if(isCanceled)
								bn=null;
							setGraphic(bn);
						}
						else 
							setGraphic(null);
					}
					}
				};
			}
		});
		
		this.setItems(data);
		this.getColumns().addAll(start_time,check_out_time,room_type,number,total,state,isEvaluated,operation);
		this.setPrefHeight(520);
	}
	
	@SuppressWarnings("static-access")
	public void setList(List<String> list){
		this.order_info=list;
	}
	
	public static List<String> getList(){
		return order_info;
	}
	
	public static List<OrderVO>getrder(){
		return list;
	}
}



