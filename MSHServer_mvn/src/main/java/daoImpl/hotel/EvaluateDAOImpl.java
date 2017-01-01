package daoImpl.hotel;

import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import po.EvaluatePO;
import po.RoomPO;
import tools.ResultMessage;
import dao.hotel.EvaluateDAO;
import daoImpl.HibernateUtil;

public class EvaluateDAOImpl implements EvaluateDAO {

	@Override
	public List<EvaluatePO> getEvaluate(int hotel_id) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction =session.beginTransaction();
		Query query = session.createQuery("from EvaluatePO where hotel_id = '" + hotel_id + "'");
		List<EvaluatePO> list = query.list();
		transaction.commit();
		session.close();
		return list;
	}

	@Override
	public ResultMessage createEvaluate(EvaluatePO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(po);
		transaction.commit();
		session.close();
		System.out.println("succeed");
		return ResultMessage.SUCCESS;
	}

}
