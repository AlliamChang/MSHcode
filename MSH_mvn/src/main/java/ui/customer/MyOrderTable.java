package ui.customer;

import java.util.LinkedList;
import java.util.List;

import tools.OrderState;
import ui.utility.MainPane;
import vo.HotelVO;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.util.Callback;

public class MyOrderTable extends TableView{
	private final ObservableList<OrderVO> data;
	private static List<String> order_info;
	private  List<OrderVO> list;
	private int width=80;
	
	public MyOrderTable(List<OrderVO> list){
		super();
		data = FXCollections.observableArrayList();
		for(int i=0;i<list.size();i++){
			data.add(list.get(i));
		}
		this.list=list;
		this.init();
		
	}
	
	public void init(){
		TableColumn start_time=new TableColumn("开始时间");
		start_time.setMinWidth(width);
		start_time.setCellValueFactory(new PropertyValueFactory("preCheckIn"));
		
		TableColumn check_out_time=new TableColumn("退房时间");
		check_out_time.setMinWidth(width);
		check_out_time.setCellValueFactory(new PropertyValueFactory("preCheckOut"));
		
		TableColumn room_type=new TableColumn("房间类型");
		room_type.setMinWidth(width);
		room_type.setCellValueFactory(new PropertyValueFactory("roomStyle"));
		
		TableColumn number=new TableColumn("数量");
		number.setMinWidth(width);
		number.setCellValueFactory(new PropertyValueFactory("roomNum"));
		
		TableColumn total=new TableColumn("总价(¥)");
		total.setMinWidth(width);
		total.setCellValueFactory(new PropertyValueFactory("price"));
		
		TableColumn state=new TableColumn("状态");
		state.setMinWidth(width);
		state.setCellValueFactory(new PropertyValueFactory("orderState"));
		
		TableColumn isEvaluated=new TableColumn("有无评价");
		isEvaluated.setMinWidth(width);
		isEvaluated.setCellValueFactory(new PropertyValueFactory("evaluate"));
		
		TableColumn<OrderVO, String> operation = new TableColumn<OrderVO, String>("");
		operation.setMinWidth(width);
		operation.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<OrderVO, String>, ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<OrderVO, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().operationProperty();
			}
			
	    });
		operation.setCellFactory(new Callback<TableColumn<OrderVO, String>, TableCell<OrderVO, String> >(){

			public TableCell<OrderVO, String> call(
					TableColumn<OrderVO, String> arg0) {
				return new TableCell<OrderVO, String>(){
					protected void updateItem(String item,boolean empty){
						if(item!=null){
						if(item.equals("评价")){
							Button bn=new Button("评价");
							bn.setOnMouseClicked((MouseEvent me)->{
								List<String> list=new LinkedList<String>();
								int row=this.getTableRow().getIndex();
								System.out.println(row);
								OrderVO this_row=MyOrderTable.this.list.get(row);
								/*if(this_row==null)
									System.out.println(2);
								System.out.println(this_row.getCheckin());
								System.out.println(this_row.getRoomStyle());*/
								list.add(this_row.getPreCheckin().getDate());
								list.add(this_row.getPreCheckOut());
								list.add(this_row.getRoomStyle());
								list.add(this_row.getRoomNum()+"");
								list.add(this_row.getPrice()+"");
								MyOrderTable.this.setList(list);
								System.out.println(list.get(0));
								MainPane.getInstance().setRightPane(new EvaluatePane());
							});
							setGraphic(bn);
						}
						else if(item.equals("撤销")){
							Button bn=new Button("撤销");
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
	}
	
	public void setList(List<String> list){
		this.order_info=list;
	}
	
	public static List<String> getList(){
		return order_info;
	}
}



