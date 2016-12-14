package dao.order;

import java.util.List;

import po.OrderPO;

import java.rmi.*;

import tools.OrderState;
import tools.ResultMessage;

public interface OrderDAO extends Remote{
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
	 * 得到某个日期某个状态的所有订单
	 * @param state 所需查找的状态
	 * @param date 所需查找的日期(如：2016/06/06)，null值等于查找所有时间
	 * @return 返回所查状态和日期的订单的List
	 * @throws RemoteException
	 */
	public List<OrderPO> orderStateShow(OrderState state,String date) throws RemoteException;

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
