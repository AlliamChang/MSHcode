package po.strategyPO;

import tools.*;


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
	private String hotelName;
	
	public StrategyPO(String name,StrategyType strategyType,String city,String area
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
	
	public StrategyPO(String name,StrategyType staretgyType,String city,String area
    		,Date startTime,Date endTime,String cost,CostType costType,PeopleType people,String hotelName){
    	this(name,staretgyType,city,area
    		,startTime,endTime,cost,costType,people);
    	this.hotelName=hotelName;
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
	
	public String getHotelName(){
		return hotelName;
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
	
	public void setHotelName(String hotelName){
		this.hotelName=hotelName;
	}
	
	/*public StrategyVO toVO(){
		return new StrategyVO(name,strategyType,city,area,startTime,endTime,cost,costType,people);
	}*/

}
