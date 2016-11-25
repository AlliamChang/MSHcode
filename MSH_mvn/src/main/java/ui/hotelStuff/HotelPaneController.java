package ui.hotelStuff;

import javafx.scene.image.Image;
import ui.utility.MainPane;
import vo.OrderVO;
import blservice.order_blservice.*;

import java.util.List;

import bl_stub.Order_Stub;

public class HotelPaneController {
	
	private static HotelPaneController controller;
	private OrderBLService orderBL;
	private List<OrderVO> orderList;
	private long id;
	private String hotel;
	
	private HotelPaneController(){
		orderBL = new Order_Stub();
	}
	
	public static HotelPaneController getInstance(){
		if(controller == null){
			controller = new HotelPaneController();
		}
		return controller;
	}
	
	/**
	 * 跳转至酒店订单列表界面
	 * @param id
	 * @param hotel
	 * @param scul
	 */
	public void createOrderListPane(long id,String hotel,Image scul){
		if(MainPane.getInstance().getChildren().size() > 0 ){
			for(int i = 0; i < MainPane.getInstance().getChildren().size(); i ++)
				MainPane.getInstance().getChildren().remove(i);
		}
		this.id = id;
		this.hotel = hotel;
		
		new OrderListPane(id,hotel,scul);
	}
	
	public List<OrderVO> getTodayOrder(){
		
		orderList = orderBL.getTodayHotelOrder(id, hotel);
		return orderList;
	}
	
	public List<OrderVO> getAllOrder(){
		return orderBL.getAllHotelOrder(id, hotel);
	}
}
