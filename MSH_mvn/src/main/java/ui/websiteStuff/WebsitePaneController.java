package ui.websiteStuff;

import ui.utility.*;
import blservice.strategy_blservice.*;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Toggle;
import tools.Date;
import tools.OrderState;
import tools.PeopleType;
import tools.StrategyType;
import tools.UserType;
import tools.CostType;
import blservice.order_blservice.*;
import bl_stub.*;
import java.util.Arrays;
import java.util.List;
import vo.*;

public class WebsitePaneController {
	private static WebsitePaneController controller;
	private StrategyBLService strategyBL;
	private OrderBLService orderBL;
	private List<OrderVO> orderVO;
	private List<StrategyVO> strategyVO;
	private final List<String> naviInfo=Arrays.asList("查看未执行订单","管理营销策略"
			,"添加营销策略","处理异常订单","用户信用充值");
	private final List<String> stuff=Arrays.asList("zhr","100");

	public final OrderVO o1=new OrderVO(100,12,"u",999,"rs","大床房",3,new String[]{"liuqin"},new String[]{"1"},3,new Date("2016/11/11",false),
		    2,new Date("2016/11/13",false),new Date("2016/11/13",false),false,500,OrderState.EXECUTED,false);
	private final OrderVO o2=new OrderVO(100,12,"u",999,"rs","大床房",3,new String[]{"liuqin"},new String[]{"1"},3,new Date("2016/11/11",false),
		    2,new Date("2016/11/13",false),new Date("2016/11/13",false),false,500,OrderState.EXECUTED,false);
	private List<OrderVO> order=Arrays.asList(o1,o2);
	private final StrategyVO s1=new StrategyVO("11",StrategyType.VIP,"南京市","栖霞区",new Date("2016/11/11",false)
			,new Date("2016/11/12",false),99.00,PeopleType.NORMAL);
	private final StrategyVO s2=new StrategyVO("11",StrategyType.CO_OPERATION,"南京市","栖霞区",new Date("2016/11/11",false)
			,new Date("2016/11/12",false),99.00,PeopleType.VIP);
	private List<StrategyVO> strategy=Arrays.asList(s1,s2);
	public UserVO u1=new UserVO("zhr123","123","zhr","666","333","ASUS","imagePath",1,2,3,UserType.CUSTOMER);
	private MyNavigationBar navi;
	
	private WebsitePaneController(){
		strategyBL=new Strategy_Stub();
		orderBL=new Order_Stub();
	}
	
	public static WebsitePaneController getInstance(){
		if(controller==null)
			controller=new WebsitePaneController();
		return controller;
	}
	
	public void init(){
		navi=new MyNavigationBar(null,stuff,naviInfo);
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
						}
					}
				});	
		
	}
	
	public void createWebStuffStartPane(){
		MainPane.getInstance().setRightPane(new WebStuffStartPane(stuff,order));
	}
	
	public void createStrategyListPane(){
		MainPane.getInstance().setRightPane(new StrategyListPane(strategy));
	}
	
	public void createCreateStrategyPane(){
		MainPane.getInstance().setRightPane(new CreateStrategyPane());
	}
	
	public void createModifyStrategyPane(StrategyVO strategy){
		MainPane.getInstance().setRightPane(new ModifyStrategyPane(strategy));
	}
	
	public void createDealPane(){
		MainPane.getInstance().setRightPane(new DealPane(order));
	}
	
	public void createCancelSurePane(){
		MainPane.getInstance().setRightPane(new CancelSurePane(o1,u1));
	}
	
	public void createCreditPane(){
		MainPane.getInstance().setRightPane(new CreditPane(u1));
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

}
