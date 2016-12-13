package dao.order_dao;

import java.util.List;

import po.OrderPO;

import java.rmi.*;

import tools.ResultMessage;

public interface OrderDao extends Remote{
	/**
	 * 添加订单
	 * @param order信息
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage add(OrderPO order) throws RemoteException;

	/**
	 * 展示用户所有的订单
	 * @param user
	 * @return
	 * @throws RemoteException
	 */
	public List<OrderPO> userShow(int userId) throws RemoteException;

	/**
	 * 展示酒店当天的订单
	 * @param hotelId
	 * @return
	 * @throws RemoteException
	 */
	public List<OrderPO> hotelShowToday(int hotelId) throws RemoteException;
	
	/**
	 * 展示酒店所有订单
	 * @param hotelId
	 * @return
	 * @throws RemoteException
	 */
	public List<OrderPO> hotelShowAll(int hotelId) throws RemoteException;

	/**
	 * 更新一个订单信息
	 * @param order
	 * @throws RemoteException
	 */
	public ResultMessage update(OrderPO order) throws RemoteException;

	/**
	 * 查找某一订单
	 * @param id
	 * @return 
	 * @throws RemoteException
	 */
	public OrderPO find(long id) throws RemoteException;

}
