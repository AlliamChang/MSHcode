package data_stub;
import dao.strategy_dao.*;
import java.util.*;
import po.strategyPO.*;
import tools.*;
import tools.Date;
import java.rmi.*;
import vo.*;
import java.time.LocalDate;

public class StrategyDAOStub implements StrategyDAO{
	private ArrayList<StrategyPO> database;
	
	public StrategyDAOStub(){
		database=new ArrayList<StrategyPO>();
		database.add(new StrategyPO("double11",StrategyType.BIRTHDAY,"Nanjing","Qixia"
				,new Date("2016/11/11",false),new Date("2016/11/12",false),"99.00",CostType.RMB,PeopleType.VIP));
	}
	
	public StrategyPO find(String name) throws RemoteException{
		StrategyPO ret=null;
		for(int i=0;i<database.size();i++){
			if(database.get(i).getName().equals(name)){
			    ret=database.get(i);
			    break;
			}	
		}
		return ret;
	}

	public ResultMessage add(StrategyPO po) throws RemoteException{
    	boolean isExist=false;
    	for(int i=0;i<database.size();i++){
    		if(database.get(i).getName().equals(po.getName()))
    			isExist=true;
    	}
    	if(isExist)
    		return ResultMessage.EXIST;
    	else{
    		database.add(po);
    		return ResultMessage.SUCCESS;
    	}
    }
	
	public ResultMessage delete(String name) throws RemoteException{
		for(int i=0;i<database.size();i++){
			if(database.get(i).getName().equals(name)){
				database.remove(i);
			}
		}
		return ResultMessage.SUCCESS;
	}
	
	public void update(StrategyPO po) throws RemoteException{
		System.out.println("Update Succeed!");
	}
	
	public ResultMessage modify(StrategyPO po) throws RemoteException{
		for(int i=0;i<database.size();i++){
			if(database.get(i).getName().equals(po.getName())){
				database.set(i, po);
			}
		}
		return ResultMessage.SUCCESS;
	}
	
	public void init() throws RemoteException{
		System.out.println("Init Succeed!");
	}
	
	public ArrayList<StrategyVO> getStrategy(String hotelName){
		ArrayList<StrategyVO> ret=new ArrayList<StrategyVO>();
		for(int i=0;i<database.size();i++){
			if(database.get(i).getHotelName()!=null&&database.get(i).getHotelName().equals(hotelName)){
				ret.add(new StrategyVO(database.get(i)));
			}
		}
		return ret;
	}
	
	public ArrayList<StrategyVO> getStrategy(){
		ArrayList<StrategyVO> ret=new ArrayList<StrategyVO>();
		for(int i=0;i<database.size();i++){
			if(database.get(i).getHotelName()==null){
				ret.add(new StrategyVO(database.get(i)));
			}
		}
		return ret;
	}
	
	public double getFinalPrice(OrderVO order,UserVO user,String hotelName){
		double finalPrice=0.0;
		LocalDate now=LocalDate.now();
		for(int i=0;i<database.size();i++){
			if(now.getMonthValue()==user.getMonth()){
				if(hotelName==database.get(i).getHotelName()&&
						database.get(i).getStrategyType()==StrategyType.BIRTHDAY){
					
				}
			}
		}
		return finalPrice;
	}
	//public void setName(String name);
	
	//public StrategyType getStrategyType();
	
	//public void setStrategyType(StrategyType strategyType);
	
//<<<<<<< HEAD
	//public String getCity();
	
	//public void setCity(String city);
	
	//public String getArea();
	
	

}
