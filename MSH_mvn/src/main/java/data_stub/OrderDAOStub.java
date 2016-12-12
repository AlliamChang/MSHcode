package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.hotelPO.*;
import dao.order_ddao.OrderDAO;
import po.orderPO.OrderPO;
import tools.ResultMessage;

public class OrderDAOStub implements OrderDAO {

	@Override
	public ResultMessage add(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPO> userShow(int userId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPO> hotelShowToday(int hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderPO> hotelShowAll(int hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(OrderPO order) throws RemoteException {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
