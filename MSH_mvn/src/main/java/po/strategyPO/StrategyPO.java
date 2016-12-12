package po.strategyPO;

import tools.*;
import vo.StrategyVO;

public class StrategyPO {
	private StrategyType strategyType;
	private String name;
	private String city;
	private String area;
	private Date startTime;
	private Date endTime;
	private String cost;
	private CostType costType;
	private PeopleType people;
	
	public StrategyPO(StrategyVO vo){
		this.strategyType=vo.getStrategyType();
		this.name=vo.getName();
		this.startTime=vo.getStartTime();
		this.endTime=vo.getEndTime();
		this.city=vo.getCity();
		this.area=vo.getArea();
		this.cost=vo.getCost();
		this.costType=vo.getCostType();
		this.people=vo.getPeople();
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
	
	public CostType getCostType(){
		return costType;
	}
	
	public PeopleType getPeople(){
		return people;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setStrategyType(StrategyType strategyType){
		this.strategyType=strategyType;
	}
	
	public void setCity(String city){
		this.city=city;
	}
	
	public void setArea(String area){
		this.area=area;
	}
	
	public void setStartTime(Date startTime){
		this.startTime=startTime;
	}
	
	public void setEndTime(Date endTime){
		this.endTime=endTime;
	}
	
	public void setCost(String cost){
		this.cost=cost;
	}
	
	public void setCostType(CostType costType){
		this.costType=costType;
	}
	
	public void setPeople(PeopleType people){
		this.people=people;
	}
	
	public StrategyVO toVO(){
		return new StrategyVO(name,strategyType,city,area,startTime,endTime,cost,costType,people);
	}

}
