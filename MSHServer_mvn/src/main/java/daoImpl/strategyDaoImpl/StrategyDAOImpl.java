package daoImpl.strategyDaoImpl;

import java.rmi.RemoteException;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.*;

import dao.strategy_dao.*;
import daoImpl.HibernateUtil;
import po.strategyPO.*;
import tools.*;

public class StrategyDAOImpl implements StrategyDao{
	
	public StrategyPO findStrategy(String name) throws RemoteException{
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		return null;
	}
	
	public ResultMessage addStrategy(StrategyPO strategy) throws RemoteException{
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.save(strategy);
		transaction.commit();
		session.close();
		return ResultMessage.SUCCESS;
	}
	
	public ResultMessage deleteStrategy(String name) throws RemoteException{
		try{
			Session session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			session.delete(session.load(StrategyPO.class, name));
			transaction.commit();
			session.close();
			return ResultMessage.SUCCESS;
		} catch(ObjectNotFoundException e){
			return ResultMessage.FAIL;
		}
	}
	
	public ResultMessage modifyStrategy(StrategyPO strategy) throws RemoteException{
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.update(strategy);
		transaction.commit();
		session.close();
		return ResultMessage.SUCCESS;
	}
	
	public List<StrategyPO> getStrategyInHotel(int hotelId) throws RemoteException{
		Session session=HibernateUtil.getSession();
		//Transaction transaction=session.beginTransaction();
		session.beginTransaction();
		Query query=session.createQuery("from StrategyPO where hotelId = '"+hotelId+"'");
		List<StrategyPO> list=query.list();
		session.close();
		return list;
	}
	
	public List<StrategyPO> getStrategyInWeb() throws RemoteException{
		Session session=HibernateUtil.getSession();
		//Transaction transaction=session.beginTransaction();
		session.beginTransaction();
		Query query=session.createQuery("from StrategyPO where hotelId = '"+0+"'");
		List<StrategyPO> list=query.list();
		session.close();
		return list;
	}
	

}
