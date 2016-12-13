package blservice.strategy_blservice;

import tools.*;
import vo.*;
import java.util.*;

public interface StrategyBLService {
	
	public ResultMessage add(StrategyVO strategy);
	
	public ResultMessage delete(String name);
	
	public ResultMessage modify(StrategyVO vo);
	
	public double getFinalPrice(OrderVO order,UserVO user,StrategyVO strategy);
	
	public ArrayList<StrategyVO> getAllStrategy(String hotelName);
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
