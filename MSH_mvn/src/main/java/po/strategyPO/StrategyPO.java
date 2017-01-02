package po.strategyPO;

import java.io.Serializable;


import tools.*;

public class StrategyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1643142476017846119L;
	private StrategyType strategyType;
	private String name;//名称
	private String province;//省份
	private String city;//城市
	private String area;//地区
	private String startTime;//开始时间
	private String endTime;//结束时间
	private double cost;//折扣量
	private PeopleType people;//面向人群
	private int hotelId;//酒店ID
	private int fuckId;
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

    public void setStrategyType(StrategyType strategyType){
	    this.strategyType=strategyType;
    }


	public String getName(){
		return name;
	}

    public void setName(String name){
	    this.name=name;
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
    
    public String getProvince(){
	    return this.province;
    }

    public void setProvince(String province){
    	this.province=province;
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
