package daoImpl.orderDaoImpl;

import java.rmi.RemoteException;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.order.OrderDAO;
import daoImpl.HibernateUtil;
import po.OrderPO;
import tools.OrderState;
import tools.ResultMessage;

public class OrderDAOImpl implements OrderDAO{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	
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
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrderPO where userID = '" + userId + "'");
		List<OrderPO> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<OrderPO> hotelShowToday(int hotelId) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrderPO where hotelId = '" + hotelId + "' and preCheckin = '" + LocalDate.now().format(format) + "'");
		List<OrderPO> list = query.list();
		session.close();
		return list;
	}

	@Override
	public List<OrderPO> hotelShowAll(int hotelId) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from OrderPO where hotelId = '" + hotelId + "'");
		List<OrderPO> list = query.list();
		session.close();
		return list;
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

	@Override
	public List<OrderPO> orderStateShow(OrderState state, String date) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query;
		if(date == null)
			query = session.createQuery("from OrderPO where state = '" + state + "'");
		else{
			query = session.createQuery("from OrderPO where state = '" + state + "' and preCheckin = '" + date + "'");
			date = date.trim();
		}
		List<OrderPO> list = query.list();
		session.close();
		return list;
	}
	
	
}
