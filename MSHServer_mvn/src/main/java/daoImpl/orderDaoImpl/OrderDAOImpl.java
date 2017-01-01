package daoImpl.orderDaoImpl;

import java.rmi.RemoteException;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
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
	//
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	public OrderDAOImpl(){
		new OrderMonitor().start();
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
			date = date.trim();
			query = session.createQuery("from OrderPO where state = '" + state + "' and preCheckin = '" + date + "'");
		}
		List<OrderPO> list = query.list();
		session.close();
		return list;
	}
	
	/**
	 * 订单监听器
	 * @author 53068
	 *
	 */
	private class OrderMonitor extends Thread{
		public void run(){
			LocalTime timeNow;
			while(true){
				timeNow = LocalTime.now();
				if(timeNow.getMinute() == 59 && timeNow.getSecond() > 57){
					Session session = HibernateUtil.getSession();
					session.beginTransaction();
					Query query = session.createQuery("from OrderPO where preCheckin = '" + LocalDate.now().format(format) + "'"
							+ " and state = '" + OrderState.UNEXECUTED + "' and latestCheckin = '" + (timeNow.getHour()+1) + "'");
					List<OrderPO> list = query.list();
					session.close();

					
					
					for(OrderPO o:list){
						o.setState(OrderState.ABNORMITY);
						Session session2 = HibernateUtil.getSession();
						Transaction transaction = session2.beginTransaction();
						session2.update(o);
						transaction.commit();
						session2.close();
					}
					
					try{
						Thread.sleep(3600000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}else{
					try{
//						System.out.println(timeNow.toString());
						Thread.sleep(1000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
}
