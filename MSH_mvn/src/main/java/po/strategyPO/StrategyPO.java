package po.strategyPO;

import tools.*;
import vo.StrategyVO;

public class StrategyPO {
	private StrategyType strategyType;
	private String name;
	private String city;
	private String area;
	private String startTime;
	private String endTime;
	private double cost;
	private PeopleType people;
	private int hotelId;
	
	public StrategyPO(String name,StrategyType strategyType,String city,String area
    		,String startTime,String endTime,double cost,PeopleType people){
		this.name=name;
    	this.strategyType=strategyType;
    	this.city=city;
    	this.area=area;
    	this.startTime=startTime;
    	this.endTime=endTime;
    	this.cost=cost;
    	this.people=people;
	}
	
	public StrategyPO(String name,StrategyType staretgyType,String city,String area
    		,String startTime,String endTime,double cost,PeopleType people,int hotelId){
    	this(name,staretgyType,city,area
    		,startTime,endTime,cost,people);
    	this.hotelId=hotelId;
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
	
	/*public StrategyVO toVO(){
		return new StrategyVO(name,strategyType,city,area,startTime,endTime,cost,costType,people);
	}*/

}
