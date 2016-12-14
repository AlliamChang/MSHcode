package dao.strategy_dao;

import po.strategyPO.*;
import po.*;
import po.hotelPO.*;

import java.rmi.RemoteException;
import java.util.*;
import tools.*;

public interface StrategyDAO {

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
	
	public double getLowestPrice(UserPO user,RoomVO room,int hotelId) throws RemoteException;
	
	public double getBirthPrice(UserPO user,int hotelId);
	
	public double getTimePrice(int hotelId);
	
	public double getRoomPrice(OrderPO order,int hotelId);
	
	public double getVipPrice(UserPO user);
	
	public double getCooperationPrice(UserPO user,int hotelId);
	
//<<<<<<< HEAD
	
	//public void setCost(String cost) throws RemoteException;
	
	//public CostType getCostType() throws RemoteException;
	
	//public void setCostType(CostType costType) throws RemoteException;
	
	//public PeopleType getPeople() throws RemoteException;
	
	//public void setPeople(PeopleType people) throws RemoteException;

}
