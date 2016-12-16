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
		session.close();
		transaction.commit();
		return list;
	}

	@Override
	public ResultMessage createRecord(CreditPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(po);
		transaction.commit();
		session.close();
		return ResultMessage.SUCCESS;
	}

}
