package vo;

import tools.*;
import po.strategyPO.*;

public class StrategyVO {
	private String name;  //策略名
	private StrategyType strategyType; //策略类型
	private String province;//策略省份
	private String city;  //策略城市
	private String area;  //策略商圈
	private String startTime;  //策略开始时间
    private String endTime;  //策略结束时间
    private double cost;  //策略折扣
    private PeopleType people;  //策略面向人群
    private int hotelId;  //酒店id
    private int fuckId;
    private String roomStyle;//房间类型（酒店管理人员需要）
    
    public StrategyVO(String name,StrategyType strategyType,String province,String city,String area
    		,String startTime,String endTime,double cost,PeopleType people){
    	this.name=name;
    	this.strategyType=strategyType;
    	this.province=province;
    	this.city=city;
    	this.area=area;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.cost=cost;
    	this.people=people;
    }
    
    public StrategyVO(String name,StrategyType staretgyType,String province,String city,String area
    		,String startTime,String endTime,double cost,PeopleType people,int hotelId){
    	this(name,staretgyType,province,city,area
    		,startTime,endTime,cost,people);
    	this.hotelId=hotelId;
    }
    
    public StrategyVO(String name,StrategyType staretgyType,String province,String city,String area
    		,String startTime,String endTime,double cost,PeopleType people,int hotelId,String roomStyle){
		this(name,staretgyType,province,city,area
    		,startTime,endTime,cost,people,hotelId);
		this.roomStyle=roomStyle;
	}
    
    public StrategyVO(StrategyPO po){
    	this.strategyType=po.getStrategyType();
		this.name=po.getName();
		this.startTime=po.getStartTime();
		this.endTime=po.getEndTime();
		this.city=po.getCity();
		this.area=po.getArea();
		this.cost=po.getCost();
		this.people=po.getPeople();
		if(po.getHotelId()!=0)
		    this.hotelId=po.getHotelId();
		this.fuckId=po.getFuckId();
		this.roomStyle=po.getRoomStyle();
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
    
    public String getStartTime(){
    	return startTime;
    }
    
    public void setStartTime(String startTime){
    	this.startTime=startTime;
    }
    
    public String getEndTime(){
    	return endTime;
    }
    
    public void setEndTime(String endTime){
    	this.endTime=endTime;
    }
    
    public double getCost(){
    	return cost;
    }
    
    public void setCost(double cost){
    	this.cost=cost;
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
    		return new StrategyPO(name,strategyType,province,city,area,startTime,endTime,cost,people,hotelId,roomStyle);
    	else
    		return new StrategyPO(name,strategyType,province,city,area,startTime,endTime,cost,people);
    }
    
    public int getFuckId(){
    	return this.fuckId;
    }
    
    public void setFuckId(int fuckId){
    	this.fuckId=fuckId;
    }
    
    public String getRoomStyle(){
		return roomStyle;
	}
	
	public void setRoomStyle(String roomStyle){
		this.roomStyle=roomStyle;
	}
	
	public String getProvince(){
		return this.province;
	}
	
	public void setProvince(String province){
		this.province=province;
	}
}
