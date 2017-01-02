package blservice.strategy;

import tools.*;
import vo.*;
import java.util.*;


public interface StrategyBLService {
	
	public ResultMessage addStrategy(StrategyVO strategy);//增加策略
	
	public ResultMessage deleteStrategy(StrategyVO vo);//删除策略
	
	public ResultMessage modifyStrategy(StrategyVO vo);//修改策略
	
	public double getFinalPriceInHotel(UserVO user,OrderVO order,int hotelId);//下完单后最终折扣
	
	public double getLowestPrice(UserVO user,int hotelId);//未下单时最大折扣
	
	public List<StrategyVO> getStrategyInHotel(int hotelId);//获得酒店策略表
	
	public List<StrategyVO> getStrategyInWeb();//获得网站策略表
	
	public double getBirthPrice(UserVO user,int hotelId);//生日折扣
	
	public double getTimePrice(int hotelId);//特定日期折扣
	
	public double getRoomPrice(OrderVO order,int hotelId);//三间房折扣
	
	public double getVipPrice(UserVO user);//vip折扣
	
	public double getCooperationPrice(UserVO user,int hotelId);//合作企业折扣


}
