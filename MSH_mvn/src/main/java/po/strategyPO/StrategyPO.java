package po.strategyPO;

import tools.*;

public class StrategyPO {
	StrategyType strategyType;
	String name;
	ResultMessage startTime;
	ResultMessage endTime;
	City city;
	Area area;
	double cost;
	CostType costUnit;
	PeopleType people;
	
	public StrategyPO(StrategyType strategyType,String name,ResultMessage startTime,ResultMessage endTime,
			City city,Area area,double cost,CostType costUnit,PeopleType people){
		this.strategyType=strategyType;
		this.name=name;
		this.startTime=startTime;
		this.endTime=endTime;
		this.city=city;
		this.area=area;
		this.cost=cost;
		this.costUnit=costUnit;
		this.people=people;
	}
	
	public StrategyType getStrategyType(){
		return strategyType;
	}
	
	public String getName(){
		return name;
	}
	
	public ResultMessage getStartTime(){
		return startTime;
	}
	
	public ResultMessage getEndTime(){
		return endTime;
	}
	
	public City getCity(){
		return city;
	}
	
	public Area getArea(){
		return area;
	}
	
	public double getCost(){
		return cost;
	}
	
	public CostType getCostUnit(){
		return costUnit;
	}
	
	public PeopleType getPeople(){
		return people;
	}
	
	
	
	

}
