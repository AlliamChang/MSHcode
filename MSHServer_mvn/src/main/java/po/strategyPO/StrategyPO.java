package po.strategyPO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import tools.*;

@Entity
@Table(name = "strategy")
public class StrategyPO {
	private StrategyType strategyType;
	private String name;//名称
	private String city;//城市
	private String area;//地区
	private String startTime;//开始时间
	private String endTime;//结束时间
	private String cost;//折扣量
	private PeopleType people;//面向人群
	private int hotelId;//酒店ID
	
	public StrategyPO(String name,StrategyType strategyType,String city,String area
    		,String startTime,String endTime,String cost,PeopleType people){
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
    		,String startTime,String endTime,String cost,PeopleType people,int hotelId){
    	this(name,staretgyType,city,area
    		,startTime,endTime,cost,people);
    	this.hotelId=hotelId;
    }

@Column(name="strategyType")
	public StrategyType getStrategyType(){
		return strategyType;
	}

    public void setStrategyType(StrategyType strategyType){
	    this.strategyType=strategyType;
    }

@Column(name="name")    
	public String getName(){
		return name;
	}

    public void setName(String name){
	    this.name=name;
    }
    
@Column(name="startTime")	
	public String getStartTime(){
		return startTime;
	}

    public void setStartTime(String startTime){
	    this.startTime=startTime;
    }
    
@Column(name="endTime")	
	public String getEndTime(){
		return endTime;
	}

    public void setEndTime(String endTime){
	    this.endTime=endTime;
    }
	
@Column(name="city")    
	public String getCity(){
		return city;
	}

    public void setCity(String city){
	    this.city=city;
    }
	
@Column(name="area")    
	public String getArea(){
		return area;
	}
	
	public void setArea(String area){
		this.area=area;
	}
	
@Column(name="cost")	
	public String getCost(){
		return cost;
	}
	
	public void setCost(String cost){
		this.cost=cost;
	}
	
@Column(name="peopleType")	
	public PeopleType getPeople(){
		return people;
	}
	
	public void setPeople(PeopleType people){
		this.people=people;
	}
@Id	
@Column(name="hotelId")	
	public int getHotelId(){
		return hotelId;
	}
	
	public void setHotelId(int hotelId){
		this.hotelId=hotelId;
	}
	
	/*public StrategyVO toVO(){
		return new StrategyVO(name,strategyType,city,area,startTime,endTime,cost,costType,people);
	}*/

}
