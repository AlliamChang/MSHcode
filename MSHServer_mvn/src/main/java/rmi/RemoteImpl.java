package rmi;

import java.rmi.Remote;

import dao.strategy_dao.*;
import daoImpl.strategyDaoImpl.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.hotel.HotelDAO;
import dao.order.OrderDAO;
import dao.user.CreditRecordsDAO;
import dao.user.UserDAO;
import daoImpl.hotel.HotelDAOImpl;
import daoImpl.orderDaoImpl.OrderDAOImpl;
import daoImpl.user.CreditRecordsDAOImpl;
import daoImpl.user.UserDAOImpl;
import po.*;
import po.hotelPO.HotelPO;
import po.strategyPO.StrategyPO;
import tools.OrderState;
import tools.ResultMessage;

public class RemoteImpl extends UnicastRemoteObject implements Remote, UserDAO, HotelDAO, OrderDAO, CreditRecordsDAO, StrategyDAO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5259237922846833482L;
	private UserDAO userDAO;
	private HotelDAO hotelDAO;
	private OrderDAO orderDAO;
	private CreditRecordsDAO creditRecordsDAO;
	private StrategyDAO strategyDAO;
	
	public RemoteImpl() throws RemoteException{
		userDAO = new UserDAOImpl();
		hotelDAO = new HotelDAOImpl();
		orderDAO = new OrderDAOImpl();
		creditRecordsDAO = new CreditRecordsDAOImpl();
		strategyDAO=new StrategyDAOImpl();
	}

	@Override
	public UserPO getUser(String account) throws RemoteException {
		return userDAO.getUser(account);
	}

	@Override
	public UserPO getUser(int ID) throws RemoteException {
		return userDAO.getUser(ID);
	}

	@Override
	public List<UserPO> getAllMarketers() throws RemoteException {
		return userDAO.getAllMarketers();
	}

	@Override
	public int addUser(UserPO userPO) throws RemoteException {
		return userDAO.addUser(userPO);
	}

	@Override
	public ResultMessage updateUser(UserPO userPO) throws RemoteException {
		return userDAO.updateUser(userPO);
	}

	@Override
	public ResultMessage deleteUser(int ID) throws RemoteException {
		return userDAO.deleteUser(ID);
	}
	
	@Override
	public ResultMessage login(String account, String password)	throws RemoteException {
		return userDAO.login(account, password);
	}

	@Override
	public ResultMessage logout(int id) throws RemoteException {
		return userDAO.logout(id);
	}

	@Override
	public HotelPO find(int id) throws RemoteException {
		return hotelDAO.find(id);
	}

	@Override
	public ResultMessage add(HotelPO po) throws RemoteException {
		return hotelDAO.add(po);
	}

	@Override
	public ResultMessage addRoom(RoomPO po) throws RemoteException {
		return hotelDAO.addRoom(po);
	}

	@Override
	public ResultMessage delete(int id) throws RemoteException {
		return hotelDAO.delete(id);
	}

	@Override
	public ResultMessage update(HotelPO po) throws RemoteException {
		return hotelDAO.update(po);
		
	}


	@Override
	public List<HotelPO> get(String province, String city, String tradeArea, String name) throws RemoteException {
		return hotelDAO.get(province, city, tradeArea, name);
	}

	@Override
	public List<String> getProvinces() throws RemoteException {
		return hotelDAO.getProvinces();
	}

	@Override
	public List<String> getCities(String province) throws RemoteException {
		return hotelDAO.getCities(province);
	}

	@Override
	public List<String> getAreas(String province, String city) throws RemoteException {
		return hotelDAO.getAreas(province, city);
	}

	@Override
	public List<RoomPO> getRoom(int hotel_id) throws RemoteException {
		return hotelDAO.getRoom(hotel_id);
	}
	
	//order的方法
	@Override
	public ResultMessage add(OrderPO order) throws RemoteException {
		return orderDAO.add(order);
	}

	@Override
	public List<OrderPO> userShow(int userId) throws RemoteException {
		return orderDAO.userShow(userId);
	}
	
	@Override
	public List<OrderPO> hotelShowToday(int hotelId) throws RemoteException {
		return orderDAO.hotelShowToday(hotelId);
	}
	
	@Override
	public List<OrderPO> hotelShowAll(int hotelId) throws RemoteException {
		return orderDAO.hotelShowAll(hotelId);
	}
	
	@Override
	public List<OrderPO> orderStateShow(OrderState state, String date) throws RemoteException {
		return orderDAO.orderStateShow(state, date);
	}
	
	@Override
	public ResultMessage update(OrderPO order) throws RemoteException {
		return orderDAO.update(order);
	}

	@Override
	public OrderPO find(long id) throws RemoteException {
		return orderDAO.find(id);
	}

	@Override
	public List<CreditPO> getRecords(int userID) throws RemoteException {
		return creditRecordsDAO.getRecords(userID);
	}

	@Override
	public ResultMessage createRecord(CreditPO po) throws RemoteException {
		return creditRecordsDAO.createRecord(po);
	}
    	
	//strategy↓↓
	@Override
	public StrategyPO findStrategy(String name) throws RemoteException{
		return strategyDAO.findStrategy(name);
	}
    
	@Override
	public ResultMessage addStrategy(StrategyPO po) throws RemoteException{
		return strategyDAO.addStrategy(po);
	}
	
	@Override
	public ResultMessage deleteStrategy(String name) throws RemoteException{
		return strategyDAO.deleteStrategy(name);
	}
	
	@Override
	public ResultMessage modifyStrategy(StrategyPO po) throws RemoteException{
		return strategyDAO.modifyStrategy(po);
	}
	
	@Override	
	public List<StrategyPO> getStrategyInHotel(int hotelId) throws RemoteException{
		return strategyDAO.getStrategyInHotel(hotelId);
	}
	
	@Override
	public List<StrategyPO> getStrategyInWeb() throws RemoteException{
		return strategyDAO.getStrategyInWeb();
	}

	@Override
	public List<HotelPO> getHotel(String province, String city, String area,
			String name, String enter_time, String out_time, String price,
			String score, int star) throws RemoteException {
		return hotelDAO.getHotel(province, city, area, name, enter_time, out_time, price, score, star);
	}

}
