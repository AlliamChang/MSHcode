package rmi;

import java.rmi.Remote;

import dao.order_ddao.OrderDAO;
import dao.user_dao.UserDAO;

public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper instance;
	public static RemoteHelper getInstance() {
		return instance == null ? (instance = new RemoteHelper()) : instance;
	}
	
	private RemoteHelper(){}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public UserDAO getUserDAO(){
		return (UserDAO)remote;
	}
	
	public OrderDAO getOrderDAO(){
		return (OrderDAO)remote;
	}
}
