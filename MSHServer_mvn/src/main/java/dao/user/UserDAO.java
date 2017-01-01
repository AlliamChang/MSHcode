package dao.user;

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
	
	public ResultMessage updateUser(UserPO userPO) throws RemoteException;

	public ResultMessage deleteUser(int ID) throws RemoteException;
	
	public ResultMessage login(String account, String password) throws RemoteException;
	
	public ResultMessage logout(int id) throws RemoteException;
	
	/**
	 * 设置每升一级所需的信用值
	 * @param request
	 * @return
	 * @throws RemoteException
	 */
	public ResultMessage setLvUpRequest(int request) throws RemoteException;
	
	public int getLvUpRequest() throws RemoteException;
}
