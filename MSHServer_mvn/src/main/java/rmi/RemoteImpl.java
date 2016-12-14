package rmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.hotel.HotelDAO;
import dao.order.OrderDAO;
import dao.user.UserDAO;
import daoImpl.hotel.HotelDAOImpl;
import daoImpl.orderDaoImpl.OrderDAOImpl;
import daoImpl.user.UserDAOImpl;
import po.OrderPO;
import po.RoomPO;
import po.UserPO;
import po.hotelPO.HotelPO;
import tools.OrderState;
import tools.ResultMessage;

public class RemoteImpl extends UnicastRemoteObject implements Remote, UserDAO, HotelDAO, OrderDAO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5259237922846833482L;
	private UserDAO userDAO;
	private HotelDAO hotelDAO;
	private OrderDAO orderDAO;
	
	public RemoteImpl() throws RemoteException{
		userDAO = new UserDAOImpl();
		hotelDAO = new HotelDAOImpl();
		orderDAO = new OrderDAOImpl();
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
	public ResultMessage modifyUser(UserPO userPO) throws RemoteException {
		return userDAO.modifyUser(userPO);
	}

	@Override
	public ResultMessage deleteUser(int ID) throws RemoteException {
		return userDAO.deleteUser(ID);
	}

	@Override
	public HotelPO find(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addRoom(RoomPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage modify(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HotelPO> get(String province, String city, String tradeArea, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}
	
	//order的方法
		@Override
		public ResultMessage add(OrderPO order) throws RemoteException {
			return orderDAO.add(order);
		}

		@Override
		public List<OrderPO> userShow(int userId) throws RemoteException {
			// TODO Auto-generated method stub
			return orderDAO.userShow(userId);
		}

		@Override
		public List<OrderPO> hotelShowToday(int hotelId) throws RemoteException {
			// TODO Auto-generated method stub
			return orderDAO.hotelShowToday(hotelId);
		}

		@Override
		public List<OrderPO> hotelShowAll(int hotelId) throws RemoteException {
			// TODO Auto-generated method stub
			return orderDAO.hotelShowAll(hotelId);
		}

		@Override
		public List<OrderPO> orderStateShow(OrderState state, String date) throws RemoteException {
			// TODO Auto-generated method stub
			return orderDAO.orderStateShow(state, date);
		}

		@Override
		public ResultMessage update(OrderPO order) throws RemoteException {
			// TODO Auto-generated method stub
			return orderDAO.update(order);
		}

		@Override
		public OrderPO find(long id) throws RemoteException {
			// TODO Auto-generated method stub
			return orderDAO.find(id);
		}

}
