package ui.websiteStuff;

import ui.utility.*;
import rmi.RemoteHelper;
import dao.user.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import tools.Date;
import tools.OrderState;
import tools.PeopleType;
import tools.StrategyType;
import tools.UserType;
import tools.ResultMessage;
import blservice.hotel.*;
import blservice.order.*;
import blservice.strategy.*;
import blservice.user.*;
import bl_stub.*;
import bl.hotel.*;
import bl.order.*;
import bl.strategy.*;
import bl.user.UserBLServiceImpl;

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

	
	private MyNavigationBar navi;
	
	private MarketingPaneController(){
		strategyBL=new StrategyBLServiceImpl();
		orderBL=new OrderBLServiceImpl();
		hotelBL=new HotelBLServiceImpl();
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
				});	//控制跳转
		
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
	}//增加策略
	
	public ResultMessage deteleStrategy(StrategyVO vo){
		return this.strategyBL.deleteStrategy(vo);
	}//删除策略
	
	public ResultMessage modifyStrategy(StrategyVO vo){
		return this.strategyBL.modifyStrategy(vo);
	}//修改策略
	
	public List<StrategyVO> getStrategyInWeb(){
		return this.strategyBL.getStrategyInWeb();
	}//获得网站策略列表
	
	public List<OrderVO> getAbnormityOrder(){
		return this.orderBL.getAbnormityOrder();
	}//获得异常订单列表
	
	public List<OrderVO> getTodayUnexecutedOrder(){
		return this.orderBL.getTodayUnexecutedOrder();
	}//获得未执行正常订单列表
	
	public ResultMessage cancelAbnormity(long orderID,boolean isReturnAll){
		return this.orderBL.cancelAbnormity(orderID, isReturnAll);
	}//撤销异常订单
	
	public ResultMessage addCreditRecord(CreditVO credit){
		return this.userBL.addCreditRecord(credit);
	}//信用充值
	
	public List<String> getProvinces(){
		return hotelBL.getProvinces();
	}//获得省份
	
	public List<String> getCities(String province){
		return hotelBL.getCities(province);
	}//获得城市
	
	public List<String> getAreas(String province,String city){
		return hotelBL.getAreas(province, city);
	}//获得地区
	
	public ResultMessage setLvUpRequest(int request){
		try{
			return userDAO.setLvUpRequest(request);
		}catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		
	}//制定升级信用值
	
	public int getLvUpRequest(){
		try {
			return userDAO.getLvUpRequest();
		} catch (RemoteException e){
			e.printStackTrace();
			return 0;
		}
	}//获得升级信用值
	
	public double getVipCost(){
		List<StrategyVO> list=this.getStrategyInWeb();
		double result=0.0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).getName().equals("AdminVipCost")){
				result=list.get(i).getCost();
			}
		}
		return result;
	}//获得vip等级折扣
	
	public ResultMessage setVipCost(double cost){
		StrategyVO vo=new StrategyVO("AdminVipCost",StrategyType.VIP,null,null,null,"2016/12/31","2060/01/01",cost,PeopleType.VIP);
		return this.modifyStrategy(vo);
	}//制定vip等级折扣

}
