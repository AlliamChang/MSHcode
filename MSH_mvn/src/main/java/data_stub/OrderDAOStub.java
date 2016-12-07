package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.hotelPO.*;
import po.userPO.*;
import dao.order_ddao.OrderDAO;
import po.orderPO.OrderPO;
import tools.ResultMessage;

public class OrderDAOStub implements OrderDAO {

	public ResultMessage add(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public List<OrderPO> userShow(po.userPO.UserPO user) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderPO> hotelShow(po.hotelPO.HotelPO hotel)
			throws RemoteException {
		// TODO Auto-generated method stub
		return new ArrayList<OrderPO>();
	}

	public void update(OrderPO order) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public OrderPO find(long id) throws RemoteException {
		// TODO Auto-generated method stub
		return new OrderPO(id, null, null, null, 0, null, null, 0, null, null,
				null, id, null);
	}

}
