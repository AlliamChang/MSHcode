package blservice.strategy_blservice;

import tools.*;
import vo.*;
import java.util.*;

import po.OrderPO;
import po.UserPO;

public interface StrategyBLService {
	
	public ResultMessage addStrategy(StrategyVO strategy);
	
	public ResultMessage deleteStrategy(StrategyVO vo);
	
	public ResultMessage modifyStrategy(StrategyVO vo);
	
	public double getFinalPriceInHotel(UserVO user,OrderVO order,int hotelId);
	
	public double getFinalPriceInWeb(UserVO user);
	
	public double getLowestPrice(UserVO user,int hotelId);
	
	public List<StrategyVO> getStrategyInHotel(int hotelId);
	
	public List<StrategyVO> getStrategyInWeb();
	
	public double getBirthPrice(UserVO user,int hotelId);
	
	public double getTimePrice(int hotelId);
	
	public double getRoomPrice(OrderVO order,int hotelId);
	
	public double getVipPrice(UserVO user);
	
	public double getCooperationPrice(UserVO user,int hotelId);
	/*public String getName();
	
	public void setName(String name);
	
	public StrategyType getStrategyType();
	
	public void setStrategyType(StrategyType strategyType);
	
//<<<<<<< HEAD
	public String getCity();
	
	public void setCity(String city);
	
	public String getArea();
	
	public void setArea(String area);
	
	public Date getStartTime();
	
	public void setStartTime(Date startTime);
	
	public Date getEndTime();
	
	public void setEndTime(Date endTime);
	
	public String getCost();
//=======
	public ResultMessage setBirthDiscount(int cost);
//>>>>>>> origin/master
	
	public void setCost(String cost);
	
	public CostType getCostType();
	
	public void setCostType(CostType costType);
	
	public PeopleType getPeople();
	
	public void setPeople(PeopleType people);*/

}
