package ui.customer;

import java.util.Arrays;
import java.util.List;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;
import ui.hotelStuff.OrderListPane;
import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import vo.CreditVO;
import vo.OrderVO;
import vo.RoomVO;
import bl_stub.HotelBLService_Stub;
import bl_stub.Order_Stub;
import bl_stub.UserBLService_Stub;
import blservice.hotel_blservice.HotelBLService;

public class CustomerPaneController {
	private static CustomerPaneController controller;
	private String user_name;
	private String type="普通会员";
	private boolean isRegistered=true;
	private boolean isLog=false;
	private HotelBLService HotelBL;
	private UserBLService_Stub UserBL;
	private Order_Stub OrderBL;
	private final List<String> naviInfo = Arrays.asList("搜索","个人信息","我的订单");
	private CustomerPaneController(){
		HotelBL=new bl.hotel_bl.HotelBL();
	}
	
	public static CustomerPaneController getInstance(){
		if(controller==null)
			controller= new CustomerPaneController();
		return controller;
	}
	
	//导航栏
	public void CustomerLogin(String username,Image scul){
		this.user_name=username;
		MyNavigationBar navi;
		if(!isRegistered)
			 navi= new MyNavigationBar(scul,Arrays.asList("用户名："+user_name),naviInfo);
		else
			 navi= new MyNavigationBar(scul,Arrays.asList("用户名："+user_name+"\n会员类型:"+type),naviInfo);
		if(MainPane.getInstance().isLogin()==true){
		MainPane.getInstance().setNavigationBar(navi);
		this.createHotelSearchPane();
		
		navi.getToggle().selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
					if(newValue != null){
						String temp = newValue.toString().split("'")[1];
						
						switch(temp){
						case "个人信息":
							createPersonInfoPane();
							break;
							
						case "我的订单":
							createMyOrderPane();
							break;
							
						case "搜索":
							createHotelSearchPane();
							break;
						
						}
					}
				});
		}else{
			 navi=new MyNavigationBar ();
			 MainPane.getInstance().setNavigationBar(navi);
			 this.createHotelSearchPane();
		}
	}
	//个人信息界面
	public void createPersonInfoPane(){
		MainPane.getInstance().setRightPane(new PersonInfoPane());
	}
	//我的订单界面
	public void createMyOrderPane(){
		MainPane.getInstance().setRightPane(new MyOrderPane());
	}
	//搜索界面
	public void createHotelSearchPane(){
		MainPane.getInstance().setRightPane(HotelSearchPane.getInstance());
	}
	//得到信用记录
	public List<CreditVO> getcredit(){
		UserBL=new UserBLService_Stub();
		List <CreditVO>credit_list=UserBL.getCreditRecords(1);
		return credit_list;
	}
	//得到订单记录
	public List<OrderVO> getOrder(){
		OrderBL=new Order_Stub();
		List<OrderVO> order_list=OrderBL.getUserOrder(null);
		return order_list;
	}
	//得到酒店房间信息
	public List<RoomVO> getRoom(int id){
		List<RoomVO> room_list=HotelBL.getRoom(id);
		return room_list;
	}
	
	public List<String> getProvince(){
		return HotelBL.getProvinces();
	}
	
	public List<String> getCity(String pro){
		return HotelBL.getCities(pro);
	}
	
	public List<String> getareas(String pro,String city){
		return HotelBL.getAreas(pro, city);
	}
}
