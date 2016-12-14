package rmi;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dao.user.UserDAO;
import daoImpl.user.UserDAOImpl;
import po.UserPO;
import tools.ResultMessage;

public class RemoteImpl extends UnicastRemoteObject implements Remote, UserDAO {
	
	private UserDAO userDAO;
	
	public RemoteImpl() throws RemoteException{
		userDAO = new UserDAOImpl();
	}

	@Override
	public UserPO getUser(String account) throws RemoteException {
		return userDAO.getUser(account);
	}

	@Override
	public UserPO getUser(int ID) throws RemoteException {
		return userDAO.getUser(ID);
	}

	@Override
	public List<UserPO> getAllMarketers() throws RemoteException {
		return userDAO.getAllMarketers();
	}

	@Override
	public int addUser(UserPO userPO) throws RemoteException {
		return userDAO.addUser(userPO);
	}

	@Override
	public ResultMessage modifyUser(UserPO userPO) throws RemoteException {
		return userDAO.modifyUser(userPO);
	}

	@Override
	public ResultMessage deleteUser(int ID) throws RemoteException {
		return userDAO.deleteUser(ID);
	}
	
}
