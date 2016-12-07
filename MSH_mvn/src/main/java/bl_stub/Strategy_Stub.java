package bl_stub;

import blservice.strategy_blservice.*;
import vo.*;
import tools.*;

public class Strategy_Stub implements StrategyBLService {
	private String name;
	private StrategyType strategyType;
	private String city;
	private String area;
	private Date startTime;
	private Date endTime;
	private String cost;
	private CostType costType;
	private PeopleType people;
	
	public String getName(){
		return "double11";
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public StrategyType getStrategyType(){
		return StrategyType.BIRTHDAY;
	}
	
	public void setStrategyType(StrategyType st){
		this.strategyType=st;
	}
	
	public String getCity(){
		return "NanJING";	
	}
	
	public void setCity(String city){
		this.city=city;
	}
	
	public String getArea(){
		return "QIXIA";
	}
	
	public void setArea(String area){
		this.area=area;
	}
	
	public Date getStartTime(){
		return new Date("2016/1/1",false);
	}
	
	public void setStartTime(Date startTime){
		this.startTime=startTime;
	}
	
	public Date getEndTime(){
		return new Date("2016/2/2",false);
	}
	
	public void setEndTime(Date endTime){
		this.endTime=endTime;
	}
	
	public String getCost(){
		return "99.00";
	}
	
	public void setCost(String cost){
		this.cost=cost;
	}
	
	public CostType getCostType(){
		return CostType.RMB;
	}
	
	public void setCostType(CostType ct){
		this.costType=ct;
	}
	
	public PeopleType getPeople(){
		return PeopleType.VIP;
	}
	
	public void setPeople(PeopleType people){
		this.people=people;
	}
}
