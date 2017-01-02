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

public class StrategyDAOImpl implements StrategyDAO{
	
	public StrategyPO findStrategy(String name) throws RemoteException{
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		Query query=session.createQuery("from StrategyPO where name= '"+name+"'");
		session.close();
		List<StrategyPO> list=query.list();
		if(list.size()==0)
			return null;
		else
			return list.get(0);
	}//查找策略
	
	public ResultMessage addStrategy(StrategyPO strategy) throws RemoteException{
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.save(strategy);
		transaction.commit();
		System.out.println("addSucceed");
		session.close();
		return ResultMessage.SUCCESS;
	}//增加策略
	
	public ResultMessage deleteStrategy(StrategyPO po) throws RemoteException{
		try{
			Session session=HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			//StrategyPO po=this.findStrategy(name);
			int fuckId=po.getFuckId();
			System.out.println(fuckId);
			session.delete(session.load(StrategyPO.class, fuckId));
			transaction.commit();
			session.close();
			return ResultMessage.SUCCESS;
		} catch(ObjectNotFoundException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}//删除策略
	
	public ResultMessage modifyStrategy(StrategyPO strategy) throws RemoteException{
		Session session=HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.update(strategy);
		transaction.commit();
		session.close();
		return ResultMessage.SUCCESS;
	}//修改策略
	
	public List<StrategyPO> getStrategyInHotel(int hotelId) throws RemoteException{
		Session session=HibernateUtil.getSession();
		//Transaction transaction=session.beginTransaction();
		session.beginTransaction();
		Query query=session.createQuery("from StrategyPO where hotelId = '"+hotelId+"'");
		List<StrategyPO> list=query.list();
		session.close();
		return list;
	}//获得酒店策略表
	
	public List<StrategyPO> getStrategyInWeb() throws RemoteException{
		Session session=HibernateUtil.getSession();
		//Transaction transaction=session.beginTransaction();
		session.beginTransaction();
		int hotelId=0;
		System.out.println(1);
		Query query=session.createQuery("from StrategyPO where hotelId = '"+hotelId+"'");
		List<StrategyPO> list=query.list();
		System.out.println(list.size());
		session.close();
		return list;
	}//获得网站策略表
	

}
