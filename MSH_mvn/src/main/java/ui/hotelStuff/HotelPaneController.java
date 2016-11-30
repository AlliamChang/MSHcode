package ui.hotelStuff;


import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;
import tools.BedStyle;
import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import vo.OrderVO;
import vo.RoomVO;
import blservice.order_blservice.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import bl_stub.Order_Stub;

public class HotelPaneController {
	
	private static HotelPaneController controller;
	private OrderBLService orderBL;
	private List<OrderVO> orderList;
	private long id;
	private String hotel;
	private final List<String> naviInfo = Arrays.asList("订单列表","客房列表","入住信息","促销策略","基本信息");
	
	private HotelPaneController(){
		orderBL = new Order_Stub();
	}
	
	public static HotelPaneController getInstance(){
		if(controller == null){
			controller = new HotelPaneController();
		}
		return controller;
	}
	
	public void hotelStuffLogin(long id,String hotel,Image scul){

		this.id = id;
		this.hotel = hotel;
		MyNavigationBar navi= new MyNavigationBar(scul,Arrays.asList("ID:"+id,"酒店名："+hotel),naviInfo);
		MainPane.getInstance().setNavigationBar(navi);
		this.createOrderListPane();
		
		navi.getToggle().selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
					if(newValue != null){
						String temp = newValue.toString().split("'")[1];
						
						switch(temp){
						case "订单列表":
							createOrderListPane();
							break;
							
						case "客房列表":
							createAddRoomPane();
							break;
							
						case "入住信息":
							createCheckInPane();
							break;
							
						case "促销策略":
							createHotelStrategyPane();
							break;
							
						case "基本信息":
							createHotelInfoPane();
							break;
						}
					}
				});
	}
	
	/**
	 * 跳转至酒店订单列表界面
	 */
	public void createOrderListPane(){
		MainPane.getInstance().setRightPane(new OrderListPane());
	}
	
	/**
	 * 跳转至酒店客房录入界面
	 */
	public void createAddRoomPane(){
		MainPane.getInstance().setRightPane(new AddRoomPane(this.getRoomList()));
	}
	
	/**
	 * 跳转至酒店基本信息界面
	 */
	public void createHotelInfoPane(){
		MainPane.getInstance().setRightPane(new HotelInfoPane());
	}
	
	/**
	 * 跳转至酒店促销策略界面
	 */
	public void createHotelStrategyPane(){
		MainPane.getInstance().setRightPane(new HotelStrategyPane());
	}
	
	/**
	 * 跳转至酒店入住信息界面
	 */
	public void createCheckInPane(){
		MainPane.getInstance().setRightPane(new CheckInPane());
	}
	
	public Iterator<RoomVO> getRoomList(){
		return Arrays.asList(
				new RoomVO("阳光大床房", BedStyle.KING_SIZE_BED, 320.00, 32, 2),
				new RoomVO("温暖双人房",BedStyle.DOUBLE_BEDS,349.00,50,2),
				new RoomVO("拥挤六人间", BedStyle.BUNK_BED, 99.00, 90, 6)).iterator();
	}
	
	public List<OrderVO> getTodayOrder(){
		
		orderList = orderBL.getTodayHotelOrder(id, hotel);
		return orderList;
	}
	
	public List<OrderVO> getAllOrder(){
		return orderBL.getAllHotelOrder(id, hotel);
	}
}
