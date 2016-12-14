package blservice.strategy_blservice;

import tools.*;
import vo.*;
import java.util.*;

public interface StrategyBLService {
	
	public ResultMessage addStrategy(StrategyVO strategy);
	
	public ResultMessage deleteStrategy(String name);
	
	public ResultMessage modifyStrategy(StrategyVO vo);
	
	public double getFinalPriceInHotel(UserVO user,OrderVO order,RoomVO room,int hotelId);
	
	public double getFinalPriceInWeb(UserVO user);
	
	public ArrayList<StrategyVO> getStrategyInHotel(int hotelId);
	
	public ArrayList<StrategyVO> getStrategyInWeb();
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
