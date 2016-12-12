package dao.strategy_dao;

import po.strategyPO.*;
import java.rmi.RemoteException;

import tools.*;

public interface StrategyDAO {

    public StrategyPO find(String name) throws RemoteException;
    
    public ResultMessage add(StrategyPO po) throws RemoteException;
    
    public ResultMessage delete(String name) throws RemoteException;

	public void update(StrategyPO po) throws RemoteException;
	
	public ResultMessage modify(StrategyPO po) throws RemoteException;
	
	public void init() throws RemoteException;
	
//<<<<<<< HEAD
	
	//public void setCost(String cost) throws RemoteException;
	
	//public CostType getCostType() throws RemoteException;
	
	//public void setCostType(CostType costType) throws RemoteException;
	
	//public PeopleType getPeople() throws RemoteException;
	
	//public void setPeople(PeopleType people) throws RemoteException;

}
