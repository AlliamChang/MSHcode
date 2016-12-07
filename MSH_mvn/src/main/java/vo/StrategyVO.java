package vo;

import tools.*;

public class StrategyVO {
	private String name;  //策略名
	private StrategyType strategyType; //策略类型
	private String city;  //策略城市
	private String area;  //策略商圈
	private Date startTime;  //策略开始时间
    private Date endTime;  //策略结束时间
    private String cost;  //策略折扣
    private CostType costType;  //策略折扣单位
    private PeopleType people;  //策略面向人群
    
    public StrategyVO(String name,StrategyType staretgyType,String city,String area
    		,Date startTime,Date endTime,String cost,CostType costType,PeopleType people){
    	this.name=name;
    	this.strategyType=strategyType;
    	this.city=city;
    	this.area=area;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.cost=cost;
    	this.costType=costType;
    	this.people=people;
    }
    
    public String getName(){
    	return name;
    }
    
    public void setName(String name){
    	this.name=name;
    }
    
    public StrategyType getStrategyType(){
    	return strategyType;
    }
    
    public void setStrategyType(StrategyType strategyType){
    	this.strategyType=strategyType;
    }
    
    public String getCity(){
    	return city;
    }
    
    public void setCity(String city){
    	this.city=city;
    }
    
    public String getArea(){
    	return area;
    }
    
    public void setArea(String area){
    	this.area=area;
    }
    
    public Date getStartTime(){
    	return startTime;
    }
    
    public void setStartTime(Date startTime){
    	this.startTime=startTime;
    }
    
    public Date getEndTime(){
    	return endTime;
    }
    
    public void setEndTime(Date endTime){
    	this.endTime=endTime;
    }
    
    public String getCost(){
    	return cost;
    }
    
    public void setCost(String cost){
    	this.cost=cost;
    }
    
    public CostType getCostType(){
    	return costType;
    }
    
    public void setCostType(CostType costType){
    	this.costType=costType;
    }

    public PeopleType getPeople(){
    	return people;
    }
    
    public void setPeople(PeopleType people){
    	this.people=people;
    }
    
}
