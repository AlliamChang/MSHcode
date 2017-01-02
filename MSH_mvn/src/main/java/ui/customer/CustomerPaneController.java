package ui.customer;

import java.util.Arrays;
import java.util.List;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;
import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import vo.CreditVO;
import vo.OrderVO;
import vo.RoomVO;
import bl.user_bl.UserBLServiceImpl;
import blservice.hotel_blservice.HotelBLService;
import blservice.order_blservice.OrderBLService;
import blservice.user_blservice.UserBLService;

public class CustomerPaneController {
	private static CustomerPaneController controller;
	private String user_name;
	private String type="普通会员";
	private boolean isRegistered=true;
	private HotelBLService HotelBL;
	private UserBLService UserBL=new UserBLServiceImpl();
	private OrderBLService OrderBL;
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
			 navi= new MyNavigationBar(scul,Arrays.asList("账号："+user_name,"会员类型："+type),naviInfo);
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
		MainPane.getInstance().setRightPane(new PersonInfoPane(UserBL.get(MainPane.getInstance().getUserId())));
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
		List <CreditVO>credit_list=UserBL.getCreditRecords(MainPane.getInstance().getUserId());
		return credit_list;
	}
	//得到订单记录
	public List<OrderVO> getOrder(){
		OrderBL=new bl.order_bl.OrderBL();
		List<OrderVO> order_list=OrderBL.getUserOrder(MainPane.getInstance().getUserId(), null);
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
	
	public String getAccount(){
		return user_name;
	}
}
