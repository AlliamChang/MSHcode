package po.strategyPO;

import java.io.Serializable;

import tools.*;
import vo.StrategyVO;

public class StrategyPO implements Serializable{
	private StrategyType strategyType;//策略类型
	private String name;//策略名
	private String province;//策略省份
	private String city;//策略城市
	private String area;//策略商圈
	private String startTime;//策略开始时间
	private String endTime;//策略到期时间
	private double cost;//策略折扣
	private PeopleType people;//策略面向人群
	private int hotelId;//酒店ID
	private int fuckId;//策略内部区分ID
	private String roomStyle;//房间类型（酒店管理人员需要）
	
    public StrategyPO(){
		
	}
	
	public StrategyPO(String name,StrategyType strategyType,String province,String city,String area
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
	
	public StrategyPO(String name,StrategyType staretgyType,String province,String city,String area
    		,String startTime,String endTime,double cost,PeopleType people,int hotelId){
    	this(name,staretgyType,province,city,area
    		,startTime,endTime,cost,people);
    	this.hotelId=hotelId;
    }
	
	public StrategyPO(String name,StrategyType staretgyType,String province,String city,String area
    		,String startTime,String endTime,double cost,PeopleType people,int hotelId,String roomStyle){
		this(name,staretgyType,province,city,area
    		,startTime,endTime,cost,people,hotelId);
		this.roomStyle=roomStyle;
	}
	
	public StrategyType getStrategyType(){
		return strategyType;
	}
	
	public String getName(){
		return name;
	}
	
	public String getStartTime(){
		return startTime;
	}
	
	public String getEndTime(){
		return endTime;
	}
	
	public String getProvince(){
		return city;
	}
	
	public String getCity(){
		return city;
	}
	
	public String getArea(){
		return area;
	}
	
	public double getCost(){
		return cost;
	}
	
	public PeopleType getPeople(){
		return people;
	}
	
	public int getHotelId(){
		return hotelId;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setStrategyType(StrategyType strategyType){
		this.strategyType=strategyType;
	}
	
	public void setProvince(String province){
		this.province=province;
	}
	
	public void setCity(String city){
		this.city=city;
	}
	
	public void setArea(String area){
		this.area=area;
	}
	
	public void setStartTime(String startTime){
		this.startTime=startTime;
	}
	
	public void setEndTime(String endTime){
		this.endTime=endTime;
	}
	
	public void setCost(double cost){
		this.cost=cost;
	}
	
	public void setPeople(PeopleType people){
		this.people=people;
	}
	
	public void setHotelId(int hotelId){
		this.hotelId=hotelId;
	}
	
	public int getFuckId(){
		return fuckId;
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
	
	/*public StrategyVO toVO(){
		return new StrategyVO(name,strategyType,city,area,startTime,endTime,cost,costType,people);
	}*/

}
