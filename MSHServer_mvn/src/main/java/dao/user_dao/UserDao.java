package dao.user_dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.UserPO;
import tools.ResultMessage;

public interface UserDAO extends Remote {

	public UserPO getUser(String account) throws RemoteException;
	
	public UserPO getUser(int ID) throws RemoteException;
	
	public List<UserPO> getAllMarketers() throws RemoteException;

	/**
	 * 添加新用户，返回系统分配ID
	 * @param userPO
	 * @return
	 * @throws RemoteException
	 */
	public int addUser(UserPO userPO) throws RemoteException;
	
	public ResultMessage modifyUser(UserPO userPO) throws RemoteException;

	public ResultMessage deleteUser(int ID) throws RemoteException;
}
