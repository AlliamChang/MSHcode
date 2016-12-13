package dao.strategy_dao;

import java.rmi.*;
import java.util.ArrayList;

import po.strategyPO.*;
import tools.ResultMessage;
import po.orderPO.*;
import po.UserPO;

public interface StrategyDao extends Remote{
	    public StrategyPO find(String name) throws RemoteException;
	    
	    public ResultMessage add(StrategyPO po) throws RemoteException;
	    
	    public ResultMessage delete(String name) throws RemoteException;

		public void update(StrategyPO po) throws RemoteException;
		
		public ResultMessage modify(StrategyPO po) throws RemoteException;
		
		public void init() throws RemoteException;
		
		public ArrayList<StrategyPO> getStrategy(String hotelName);
		
		public ArrayList<StrategyPO> getStrategy();
		
		public double getFinalPrice(OrderPO order,UserPO user);

}
