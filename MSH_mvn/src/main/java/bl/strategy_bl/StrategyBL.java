package bl.strategy_bl;

//<<<<<<< HEAD
import tools.*;
import data_stub.*;

import blservice.strategy_blservice.StrategyBLService;
//=======
import blservice.strategy_blservice.StrategyBLService;

//>>>>>>> origin/master

public class StrategyBL implements StrategyBLService{
	private StrategyDAOStub strategy;
	
    public String getName(){
    	return 
    }
	
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
	
	public void setPeople(PeopleType people);
	
}
