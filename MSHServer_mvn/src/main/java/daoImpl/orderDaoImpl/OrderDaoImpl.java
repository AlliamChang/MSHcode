package daoImpl.orderDaoImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.time.format.DateTimeFormatter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.order_dao.OrderDao;
import daoImpl.HibernateUtil;
import po.OrderPO;
import tools.ResultMessage;

public class OrderDaoImpl extends UnicastRemoteObject implements OrderDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	protected OrderDaoImpl() throws RemoteException {
		super();
	}

	@Override
	public ResultMessage add(OrderPO order) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(order);
		transaction.commit();
		session.close();
		return ResultMessage.SUCCESS;
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
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(order);
		transaction.commit();
		session.close();
		return ResultMessage.SUCCESS;
	}

	@Override
	public OrderPO find(long id) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrderPO where id = '" + id + "'");
		List<OrderPO> list = query.list();
		session.close();
		if(list.size() == 0)
			return null;
		else
			return list.get(0);
	}
	
	
}
