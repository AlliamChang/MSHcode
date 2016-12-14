package dao.strategy_dao;

import java.rmi.*;
import po.*;
import java.util.ArrayList;

import po.strategyPO.*;
import tools.ResultMessage;
import po.UserPO;

public interface StrategyDao extends Remote{
public StrategyPO findStrategy(String name) throws RemoteException;
    
    public ResultMessage addStrategy(StrategyPO po) throws RemoteException;
    
    public ResultMessage deleteStrategy(String name) throws RemoteException;

	public void updateStrategy(StrategyPO po) throws RemoteException;
	
	public ResultMessage modifyStrategy(StrategyPO po) throws RemoteException;
	
	public void initStrategy() throws RemoteException;
	
	public ArrayList<StrategyPO> getStrategyInHotel(int hotelId) throws RemoteException;
	
	public ArrayList<StrategyPO> getStrategyInWeb() throws RemoteException;
	
	public double getFinalPriceInHotel(UserPO user,RoomPO room,OrderPO order,int hotelId) throws RemoteException;
	
	public double getFinalPriceInWeb(UserPO user) throws RemoteException;
	
	public double getLowestPrice(UserPO user,RoomPO room,int hotelId) throws RemoteException;
	
	public double getBirthPrice(UserPO user,int hotelId);
	
	public double getTimePrice(int hotelId);
	
	public double getRoomPrice(OrderPO order,int hotelId);
	
	public double getVipPrice(UserPO user);
	
	public double getCooperationPrice(UserPO user,int hotelId);

}
