package rmi;

import java.rmi.Remote;
import dao.strategy_dao.*;

import dao.hotel.HotelDAO;
import dao.order.OrderDAO;
import dao.user.CreditRecordsDAO;
import dao.user.UserDAO;

public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper instance;
	public static RemoteHelper getInstance() {
		return instance == null ? (instance = new RemoteHelper()) : instance;
	}
	
	private RemoteHelper() {}
	
	public void setRemote(Remote remote) {
		this.remote = remote;
	}
	
	public UserDAO getUserDAO() {
		return (UserDAO)remote;
	}
	
	public OrderDAO getOrderDAO() {
		return (OrderDAO)remote;
	}
	
	public HotelDAO getHotelDAO() {
		return (HotelDAO)remote;
	}
	
	public CreditRecordsDAO getCreditRecordsDAO() {
		return (CreditRecordsDAO)remote;
	}
	
	public StrategyDAO getStrategyDAO(){
		return (StrategyDAO)remote;
	}
}
