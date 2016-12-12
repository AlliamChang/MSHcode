package dao.order_ddao;

import java.util.*;
import java.rmi.*;

import po.*;
import po.hotelPO.HotelPO;
import po.orderPO.OrderPO;
import tools.ResultMessage;

public interface OrderDAO {
	public ResultMessage add(OrderPO order) throws RemoteException;

	public List<OrderPO> userShow(UserPO user) throws RemoteException;

	public List<OrderPO> hotelShow(HotelPO hotel) throws RemoteException;

	public void update(OrderPO order) throws RemoteException;

	public OrderPO find(long id) throws RemoteException;
}