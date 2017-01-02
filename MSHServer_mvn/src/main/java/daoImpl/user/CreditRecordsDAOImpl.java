package daoImpl.user;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.user.CreditRecordsDAO;
import daoImpl.HibernateUtil;
import po.CreditPO;
import tools.ResultMessage;

public class CreditRecordsDAOImpl implements CreditRecordsDAO {

	@Override
	public List<CreditPO> getRecords(int userID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from CreditPO where userID = '" + userID + "'");
		List<CreditPO> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	@Override
	public ResultMessage createRecord(CreditPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		ResultMessage message = ResultMessage.SUCCESS;
		try {
			transaction = session.beginTransaction();
			session.save(po);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			message = ResultMessage.FAIL;
		} finally {
			session.close();
		}
		return message;
	}

	@Override
	public ResultMessage deleteRecords(int userID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		ResultMessage message = ResultMessage.SUCCESS;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from CreditPO where userID = '" + userID + "'");
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
			message = ResultMessage.FAIL;
		} finally {
			session.close();
		}
		return message;
	}

}
