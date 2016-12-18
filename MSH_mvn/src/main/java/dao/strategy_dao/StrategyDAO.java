package dao.strategy_dao;

import po.strategyPO.*;
import po.*;
import po.hotelPO.RoomPO;
import java.rmi.RemoteException;
import java.util.*;
import tools.*;

public interface StrategyDAO {

    public StrategyPO findStrategy(String name) throws RemoteException;
    
    public ResultMessage addStrategy(StrategyPO po) throws RemoteException;
    
    public ResultMessage deleteStrategy(String name) throws RemoteException;
	
	public ResultMessage modifyStrategy(StrategyPO po) throws RemoteException;
	
	public List<StrategyPO> getStrategyInHotel(int hotelId) throws RemoteException;
	
	public List<StrategyPO> getStrategyInWeb() throws RemoteException;

	
//<<<<<<< HEAD
	
	//public void setCost(String cost) throws RemoteException;
	
	//public CostType getCostType() throws RemoteException;
	
	//public void setCostType(CostType costType) throws RemoteException;
	
	//public PeopleType getPeople() throws RemoteException;
	
	//public void setPeople(PeopleType people) throws RemoteException;

}
