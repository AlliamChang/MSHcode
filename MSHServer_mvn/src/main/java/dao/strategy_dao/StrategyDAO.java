package dao.strategy_dao;

import java.rmi.*;
import java.util.*;

import po.strategyPO.*;
import tools.ResultMessage;

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
	
	
	/*public double getFinalPriceInHotel(UserPO user,RoomPO room,OrderPO order,int hotelId) throws RemoteException;
	
	public double getFinalPriceInWeb(UserPO user) throws RemoteException;
	
	public double getLowestPrice(UserPO user,RoomPO room,int hotelId) throws RemoteException;
	
	public double getBirthPrice(UserPO user,int hotelId);
	
	public double getTimePrice(int hotelId);
	
	public double getRoomPrice(OrderPO order,int hotelId);
	
	public double getVipPrice(UserPO user);
	
	public double getCooperationPrice(UserPO user,int hotelId);*/

}
