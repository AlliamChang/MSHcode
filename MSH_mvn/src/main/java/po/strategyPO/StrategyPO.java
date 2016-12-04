package po.strategyPO;

import tools.*;

public class StrategyPO {
	StrategyType strategyType;
	String name;
	String city;
	String area;
	Date startTime;
	Date endTime;
	String cost;
	CostType costUnit;
	PeopleType people;
	
	public StrategyPO(StrategyType strategyType,String name,Date startTime,Date endTime,
			String city,String area,String cost,CostType costUnit,PeopleType people){
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
	
	public Date getStartTime(){
		return startTime;
	}
	
	public Date getEndTime(){
		return endTime;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getArea(){
		return area;
	}
	
	public String getCost(){
		return cost;
	}
	
	public CostType getCostUnit(){
		return costUnit;
	}
	
	public PeopleType getPeople(){
		return people;
	}
	
	
	
	

}
