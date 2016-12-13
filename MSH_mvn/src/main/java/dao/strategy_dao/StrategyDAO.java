package dao.strategy_dao;

import po.strategyPO.*;
import vo.*;
import java.rmi.RemoteException;
import java.util.*;
import tools.*;

public interface StrategyDAO {

    public StrategyPO find(String name) throws RemoteException;
    
    public ResultMessage add(StrategyPO po) throws RemoteException;
    
    public ResultMessage delete(String name) throws RemoteException;

	public void update(StrategyPO po) throws RemoteException;
	
	public ResultMessage modify(StrategyPO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
	public ArrayList<StrategyVO> getStrategy(String hotelName);
	
	public ArrayList<StrategyVO> getStrategy();
	
	public double getFinalPrice(OrderVO order,UserVO user,String hotelName);
	
//<<<<<<< HEAD
	
	//public void setCost(String cost) throws RemoteException;
	
	//public CostType getCostType() throws RemoteException;
	
	//public void setCostType(CostType costType) throws RemoteException;
	
	//public PeopleType getPeople() throws RemoteException;
	
	//public void setPeople(PeopleType people) throws RemoteException;

}
