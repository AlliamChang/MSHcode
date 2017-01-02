package ui.websiteStuff;

import ui.utility.*;
import bl.hotel_bl.*;
import rmi.RemoteHelper;
import dao.user.*;
import blservice.hotel_blservice.*;
import blservice.user_blservice.*;
import blservice.strategy_blservice.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import tools.Date;
import tools.OrderState;
import tools.PeopleType;
import tools.StrategyType;
import tools.UserType;
import tools.ResultMessage;
import blservice.order_blservice.*;
import bl_stub.*;
import bl.order_bl.*;
import bl.strategy_bl.*;
import bl.user_bl.UserBLServiceImpl;
import java.util.Arrays;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import vo.*;

public class MarketingPaneController {
	private static MarketingPaneController controller;
	private StrategyBLService strategyBL;
	private RemoteHelper helper;
	private UserDAO userDAO;
	private HotelBLService hotelBL;
	private UserBLService userBL;
	private OrderBLService orderBL;
	private List<OrderVO> orderVO;
	private List<StrategyVO> strategyVO;
	private final List<String> naviInfo=Arrays.asList("查看未执行订单","管理营销策略"
			,"添加营销策略","处理异常订单","用户信用充值","制定等级折扣");
	private final List<String> stuff=Arrays.asList("zhr","100");

	//public final OrderVO o1=new OrderVO(100,12,"u",999,"rs","大床房",3,new String[]{"liuqin"},new String[]{"1"},3,new Date("2016/11/11",false),
		    //2,new Date("2016/11/13",false),new Date("2016/11/13",false),false,500,OrderState.EXECUTED,false);
	//private final OrderVO o2=new OrderVO(100,12,"u",999,"rs","大床房",3,new String[]{"liuqin"},new String[]{"1"},3,new Date("2016/11/11",false),
		   // 2,new Date("2016/11/13",false),new Date("2016/11/13",false),false,500,OrderState.EXECUTED,false);
	//private List<OrderVO> order=Arrays.asList(o1,o2);
	//private final StrategyVO s1=new StrategyVO("11",StrategyType.VIP,"南京市","栖霞区","2016/11/11"
			//,"2016/11/12",99.00,PeopleType.NORMAL);
	//private final StrategyVO s2=new StrategyVO("11",StrategyType.CO_OPERATION,"南京市","栖霞区","2016/11/11",
			//"2016/11/12",99.00,PeopleType.VIP);
	//private List<StrategyVO> strategy=Arrays.asList(s1,s2);
	//public UserVO u1=new UserVO("zhr123","123","zhr","666","333","ASUS","imagePath",1,2,3,UserType.CUSTOMER);
	private MyNavigationBar navi;
	
	private MarketingPaneController(){
		strategyBL=new StrategyBL();
		orderBL=new OrderBL();
		hotelBL=new HotelBL();
		helper=RemoteHelper.getInstance();
		userDAO=helper.getUserDAO();
		userBL=new UserBLServiceImpl();
	}
	
	public static MarketingPaneController getInstance(){
		if(controller==null)
			controller=new MarketingPaneController();
		return controller;
	}
	
	public void init(int stuffId,String stuffName){
		navi=new MyNavigationBar(null,Arrays.asList("ID:"+stuffId,"姓名:"+stuffName),naviInfo);
		MainPane.getInstance().setNavigationBar(navi);
		this.createWebStuffStartPane();
		
		navi.getToggle().selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
					if(newValue != null){
						String temp = newValue.toString().split("'")[1];
						
						switch(temp){
						case "查看未执行订单":
							createWebStuffStartPane();break;
						case "管理营销策略":
						    createStrategyListPane();break;
						case "添加营销策略":
							createCreateStrategyPane();break;
						case "处理异常订单":
							createDealPane();break;
						case "用户信用充值":
							createCreditPane();break;
						case "制定等级折扣":
							createVipCostPane();break;
						}
					}
				});	
		
	}
	
	public void createWebStuffStartPane(){
		List<OrderVO> orderList=this.orderBL.getTodayUnexecutedOrder();
		MainPane.getInstance().setRightPane(new WebStuffStartPane(orderList));
	}
	
	public void createStrategyListPane(){
		MainPane.getInstance().setRightPane(new StrategyListPane(this.getStrategyInWeb()));
	}
	
	public void createCreateStrategyPane(){
		MainPane.getInstance().setRightPane(new CreateStrategyPane());
	}
	
	public void createModifyStrategyPane(StrategyVO strategy){
		MainPane.getInstance().setRightPane(new ModifyStrategyPane(strategy));
	}
	
	public void createDealPane(){
		
	     MainPane.getInstance().setRightPane(new DealPane(this.getAbnormityOrder()));
		
	}
	
	public void createCancelSurePane(OrderVO order,int userId){
		MainPane.getInstance().setRightPane(new CancelSurePane(order));
	}
	
	public void createVipCostPane(){
		MainPane.getInstance().setRightPane(new VipCostPane());
	}
	
	public void createCreditPane(){
		MainPane.getInstance().setRightPane(new CreditPane());
	}
	
	public ResultMessage addStrategy(StrategyVO strategy){
		return this.strategyBL.addStrategy(strategy);
	}
	
	public ResultMessage deteleStrategy(StrategyVO vo){
		return this.strategyBL.deleteStrategy(vo);
	}
	
	public ResultMessage modifyStrategy(StrategyVO vo){
		return this.strategyBL.modifyStrategy(vo);
	}
	
	public List<StrategyVO> getStrategyInWeb(){
		return this.strategyBL.getStrategyInWeb();
	}
	
	public List<OrderVO> getAbnormityOrder(){
		return this.orderBL.getAbnormityOrder();
	}
	
	public List<OrderVO> getTodayUnexecutedOrder(){
		return this.orderBL.getTodayUnexecutedOrder();
	}
	
	public ResultMessage cancelAbnormity(long orderID,boolean isReturnAll){
		return this.orderBL.cancelAbnormity(orderID, isReturnAll);
	}
	
	public ResultMessage addCreditRecord(CreditVO credit){
		return this.userBL.addCreditRecord(credit);
	}
	
	public List<String> getProvinces(){
		return hotelBL.getProvinces();
	}
	
	public List<String> getCities(String province){
		return hotelBL.getCities(province);
	}
	
	public List<String> getAreas(String province,String city){
		return hotelBL.getAreas(province, city);
	}
	
	public ResultMessage setLvUpRequest(int request){
		try{
			return userDAO.setLvUpRequest(request);
		}catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		
	}
	
	public int getLvUpRequest(){
		try {
			return userDAO.getLvUpRequest();
		} catch (RemoteException e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public double getVipCost(){
		List<StrategyVO> list=this.getStrategyInWeb();
		double result=0.0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getName().equals("AdminVipCost")){
				result=list.get(i).getCost();
			}
		}
		return result;
	}
	
	public ResultMessage setVipCost(double cost){
		StrategyVO vo=new StrategyVO("AdminVipCost",StrategyType.VIP,null,null,null,"2016/12/31","2060/01/01",cost,PeopleType.VIP);
		return this.modifyStrategy(vo);
	}

}
