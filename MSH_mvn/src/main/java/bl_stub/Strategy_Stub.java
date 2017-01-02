package bl_stub;

import java.util.Arrays;
import java.util.List;

import blservice.strategy.*;
import vo.*;
import tools.*;

public class Strategy_Stub implements StrategyBLService {
    public ResultMessage addStrategy(StrategyVO strategy){
	    return ResultMessage.SUCCESS; 
	//新增策略
    }
	
	public ResultMessage deleteStrategy(StrategyVO vo){
		return ResultMessage.FAIL;
	}//删除策略
	
	public ResultMessage modifyStrategy(StrategyVO vo){
		return ResultMessage.FAIL;//修改策略
	}
	
	public double getFinalPriceInHotel(UserVO user,OrderVO order,int hotelId){
		return this.getLowestPrice(user, hotelId)+this.getRoomPrice(order, hotelId);//下单后最终折扣
	}
	
	//public double getFinalPriceInWeb(UserVO user);
	
	public double getLowestPrice(UserVO user,int hotelId){
		return this.getBirthPrice(user, hotelId)+this.getCooperationPrice(user, hotelId)
		+this.getTimePrice(hotelId)+this.getVipPrice(user);//未下单时折扣
	}
	
	public List<StrategyVO> getStrategyInHotel(int hotelId){
		List<StrategyVO> list=Arrays.asList(new StrategyVO("test1",StrategyType.BIRTHDAY,"江苏省",
				"南京市","栖霞区","2016/11/11","2016/11/15",10.00,PeopleType.VIP,1),
				new StrategyVO("test2",StrategyType.CO_OPERATION,"江苏省",
						"南京市","栖霞区","2016/11/11","2016/11/15",10.00,PeopleType.VIP,1),
				new StrategyVO("test3",StrategyType.TRIPLEROOM,"江苏省",
						"南京市","栖霞区","2016/11/11","2016/11/15",10.00,PeopleType.VIP,1),
				new StrategyVO("test4",StrategyType.HOLIDAY,"江苏省",
				"南京市","栖霞区","2016/11/11","2016/11/15",10.00,PeopleType.VIP,1));//获得所有酒店策略
		return list;
	}
	
	public List<StrategyVO> getStrategyInWeb(){
		List<StrategyVO> list=Arrays.asList(new StrategyVO("test1",StrategyType.HOLIDAY,"江苏省",
				"南京市","栖霞区","2016/11/11","2016/11/15",10.00,PeopleType.VIP,0),
				new StrategyVO("test2",StrategyType.HOLIDAY,"江苏省",
						"南京市","栖霞区","2016/11/11","2016/11/15",10.00,PeopleType.VIP,0),
				new StrategyVO("test3",StrategyType.VIP,"江苏省",
						"南京市","栖霞区","2016/11/11","2016/11/15",10.00,PeopleType.VIP,0),
				new StrategyVO("test4",StrategyType.VIP,"江苏省",
				"南京市","栖霞区","2016/11/11","2016/11/15",10.00,PeopleType.VIP,0));
		return list;//获得所有网站策略
	}
	
	public double getBirthPrice(UserVO user,int hotelId){
		return 9.00;//获得生日折扣
	}
	
	public double getTimePrice(int hotelId){
		return 8.00;//获得特定日期折扣
	}
	
	public double getRoomPrice(OrderVO order,int hotelId){
		return 7.00;//获得三间房折扣
	}
	
	public double getVipPrice(UserVO user){
		return 6.00;//获得VIP折扣
	}
	
	public double getCooperationPrice(UserVO user,int hotelId){
		return 5.00;//获得合作企业折扣
	}
}
