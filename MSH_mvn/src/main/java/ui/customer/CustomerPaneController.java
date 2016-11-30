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
import bl_stub.HotelBLService_Stub;
import bl_stub.UserBLService_Stub;
import blservice.hotel_blservice.HotelBLService;

public class CustomerPaneController {
	private static CustomerPaneController controller;
	private String user_name;
	private HotelBLService HotelBL;
	private UserBLService_Stub UserBL;
	private final List<String> naviInfo = Arrays.asList("个人信息","我的订单","搜索");
	private CustomerPaneController(){
		HotelBL=new HotelBLService_Stub();
	}
	
	public static CustomerPaneController getInstance(){
		if(controller==null)
			controller= new CustomerPaneController();
		return controller;
	}
	
	public void CustomerLogin(String username,Image scul){
		this.user_name=username;
		MyNavigationBar navi= new MyNavigationBar(scul,Arrays.asList("用户名："+user_name),naviInfo);
		MainPane.getInstance().setNavigationBar(navi);
		this.createPersonInfoPane();
		
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
	}
	
	public void createPersonInfoPane(){
		MainPane.getInstance().setRightPane(new PersonInfoPane());
	}
	
	public void createMyOrderPane(){
		MainPane.getInstance().setRightPane(new MyOrderPane());
	}
	
	public void createHotelSearchPane(){
		MainPane.getInstance().setRightPane(new HotelSearchPane());
	}
	
	public List<CreditVO> getcredit(){
		UserBL=new UserBLService_Stub();
		List <CreditVO>credit_list=UserBL.getCredit();
		return credit_list;
	}
}
