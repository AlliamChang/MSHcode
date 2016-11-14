package daoImpl.orderDaoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.order_dao.OrderDao;
import po.hotelPO.HotelPO;
import po.orderPO.OrderPO;
import po.userPO.UserPO;
import tools.ResultMessage;

public class OrderDaoImpl extends UnicastRemoteObject implements OrderDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrderDaoImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultMessage add(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderPO> userShow(UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderPO> hotelShow(HotelPO hotel) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public OrderPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
