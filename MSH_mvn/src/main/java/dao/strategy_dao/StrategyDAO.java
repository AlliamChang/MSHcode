package dao.strategy_dao;

import po.strategyPO.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.*;
import tools.*;

public interface StrategyDAO extends Remote{
    public StrategyPO findStrategy(String name) throws RemoteException;
    /*查找一个策略*/
    
    public ResultMessage addStrategy(StrategyPO po) throws RemoteException;
    /*添加一个策略*/
    
    public ResultMessage deleteStrategy(StrategyPO po) throws RemoteException;
    /*删除一个策略*/

	//public void updateStrategy(StrategyPO po) throws RemoteException;
	
	public ResultMessage modifyStrategy(StrategyPO po) throws RemoteException;
	/*修改一个策略*/
	//public void initStrategy() throws RemoteException;
	
	public List<StrategyPO> getStrategyInHotel(int hotelId) throws RemoteException;
	/*获得酒店策略列表*/
	
	public List<StrategyPO> getStrategyInWeb() throws RemoteException;
	/*获得网站策略列表*/

	
//<<<<<<< HEAD
	
	//public void setCost(String cost) throws RemoteException;
	
	//public CostType getCostType() throws RemoteException;
	
	//public void setCostType(CostType costType) throws RemoteException;
	
	//public PeopleType getPeople() throws RemoteException;
	
	//public void setPeople(PeopleType people) throws RemoteException;

}
