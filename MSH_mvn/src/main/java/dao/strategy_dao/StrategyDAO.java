package dao.strategy_dao;

import po.strategyPO.*;

import tools.*;

public interface StrategyDAO {
    public StrategyPO getStrategyType();
	
	public StrategyPO getName();
	
	public StrategyPO getStartTime();
	
	public StrategyPO getEndTime();
	
	public StrategyPO getCity();
	
	public StrategyPO getArea();
	
	public StrategyPO getCost();

	public StrategyPO getCostUnit();
	
	public StrategyPO getPeople();
	
    public StrategyType setStrategyType();
	
	public ResultMessage setName();
	
	public ResultMessage setStartTime();
	
	public ResultMessage setEndTime();
	
	public ResultMessage setCity();
	
	public ResultMessage setArea();
	
	public ResultMessage setCost();

	public ResultMessage setCostUnit();
	
	public ResultMessage setPeople();

}
