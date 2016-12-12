package data_stub;
import dao.strategy_dao.*;
import java.util.ArrayList;
import po.strategyPO.*;
import tools.*;
import java.rmi.*;
import vo.*;

public class StrategyDAOStub implements StrategyDAO{
	private ArrayList<StrategyPO> database;
	
	public StrategyDAOStub(){
		database=new ArrayList<StrategyPO>();
		database.add(new StrategyPO(new StrategyVO("double11",StrategyType.BIRTHDAY,"Nanjing","Qixia"
				,new Date("2016/11/11",false),new Date("2016/11/12",false),"99.00",CostType.RMB,PeopleType.VIP)));
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
	//public void setName(String name);
	
	//public StrategyType getStrategyType();
	
	//public void setStrategyType(StrategyType strategyType);
	
//<<<<<<< HEAD
	//public String getCity();
	
	//public void setCity(String city);
	
	//public String getArea();
	
	

}
