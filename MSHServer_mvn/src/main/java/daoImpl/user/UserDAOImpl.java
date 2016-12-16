package daoImpl.user;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.user.UserDAO;
import daoImpl.HibernateUtil;
import po.UserPO;
import tools.ResultMessage;

public class UserDAOImpl implements UserDAO{

	@Override
	public UserPO getUser(String account) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from UserPO where account = '" + account + "'");
		List<UserPO> list = query.list();
		transaction.commit();
		session.close();
		if (list.size() == 0)
			return null;
		else
			return list.get(0);
	}

	@Override
	public UserPO getUser(int ID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		UserPO result = (UserPO) session.get(UserPO.class, ID);
		transaction.commit();
		session.close();
		return result;
	}

	@Override
	public List<UserPO> getAllMarketers() throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from UserPO where type = '" + 4 + "'");
		List<UserPO> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	@Override
	public int addUser(UserPO userPO) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(userPO);
		transaction.commit();
		int id = Integer.parseInt(session.createSQLQuery("select @@identity").list().get(0).toString());
		session.close();
		return id;
	}

	@Override
	public ResultMessage updateUser(UserPO userPO) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(userPO);
		transaction.commit();
		session.close();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteUser(int ID) throws RemoteException {
		try{
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(session.load(UserPO.class, ID));
			transaction.commit();
			session.close();
			return ResultMessage.SUCCESS;
		} catch (ObjectNotFoundException e) {
			return ResultMessage.FAIL;
		}
	}

}
