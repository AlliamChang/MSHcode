package vo;

import tools.*;
import po.strategyPO.*;

public class StrategyVO {
	private String name;  //策略名
	private StrategyType strategyType; //策略类型
	private String city;  //策略城市
	private String area;  //策略商圈
	private Date startTime;  //策略开始时间
    private Date endTime;  //策略结束时间
    private double cost;  //策略折扣
    private CostType costType;  //策略折扣单位
    private PeopleType people;  //策略面向人群
    private int hotelId;  //酒店id
    
    public StrategyVO(String name,StrategyType strategyType,String city,String area
    		,Date startTime,Date endTime,double cost,CostType costType,PeopleType people){
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
    
    public StrategyVO(String name,StrategyType staretgyType,String city,String area
    		,Date startTime,Date endTime,double cost,CostType costType,PeopleType people,int hotelId){
    	this(name,staretgyType,city,area
    		,startTime,endTime,cost,costType,people);
    	this.hotelId=hotelId;
    }
    
    public StrategyVO(StrategyPO po){
    	this.strategyType=po.getStrategyType();
		this.name=po.getName();
		this.startTime=po.getStartTime();
		this.endTime=po.getEndTime();
		this.city=po.getCity();
		this.area=po.getArea();
		this.cost=po.getCost();
		this.costType=po.getCostType();
		this.people=po.getPeople();
		if(po.getHotelId()!=0)
		    this.hotelId=po.getHotelId();
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
    
    public double getCost(){
    	return cost;
    }
    
    public void setCost(double cost){
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
    
    public int getHotelId(){
    	return hotelId;
    }
    
    public void setHotelId(int hotelId){
    	this.hotelId=hotelId;
    }
    
    public StrategyPO toPO(){
    	if(hotelId!=0)
    		return new StrategyPO(name,strategyType,city,area,startTime,endTime,cost,costType,people,hotelId);
    	else
    		return new StrategyPO(name,strategyType,city,area,startTime,endTime,cost,costType,people);
    }
}
