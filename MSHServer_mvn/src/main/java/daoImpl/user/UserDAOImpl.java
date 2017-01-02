package daoImpl.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
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
	
	private ArrayList<Integer> logged;
	
	public UserDAOImpl(){
		logged = new ArrayList<Integer>();
	}

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
		Transaction transaction = null;
		int id = -1;
		try {
			transaction = session.beginTransaction();
			session.save(userPO);
			transaction.commit();
			id = Integer.parseInt(session.createSQLQuery("select @@identity").list().get(0).toString());
		} catch (Exception e) {
			if (transaction != null)
				transaction.rollback();
		} finally {
			session.close();
		}
		return id;
	}

	@Override
	public ResultMessage updateUser(UserPO userPO) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		ResultMessage message = ResultMessage.SUCCESS;
		try {
			transaction = session.beginTransaction();
			session.update(userPO);
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
	public ResultMessage deleteUser(int ID) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		ResultMessage message = ResultMessage.SUCCESS;
		try {
			transaction = session.beginTransaction();
			session.delete(session.load(UserPO.class, ID));
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
	public ResultMessage login(String account, String password) throws RemoteException {
		UserPO po;
		try {
			int id = Integer.parseInt(account);
			po = getUser(id);
		} catch (NumberFormatException e) {
			po = getUser(account);
		}
		if (po == null)
			return ResultMessage.NOT_EXIST;
		if (!po.getPassword().equals(password))
			return ResultMessage.FAIL;
		if (logged.contains((Integer)po.getID()))
			return ResultMessage.LOGGED;
		logged.add((Integer)po.getID());
		return ResultMessage.SUCCESS;
	}
	
	@Override
	public ResultMessage logout(int id) throws RemoteException {
		logged.remove((Integer)id);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setLvUpRequest(int request) throws RemoteException {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("info/request.info")));
			bw.write(String.valueOf(request));
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
		return ResultMessage.SUCCESS;
	}

	@Override
	public int getLvUpRequest() throws RemoteException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("info/request.info")));
			int ret = Integer.parseInt(br.readLine());
			br.close();
			return ret;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}

}
