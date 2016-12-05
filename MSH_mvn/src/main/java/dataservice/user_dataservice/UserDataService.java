package dataservice.user_dataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.userPO.*;
import tools.ResultMessage;

public interface UserDataService {

	public UserPO get(String name) throws RemoteException;
	
	public UserPO get(int ID) throws RemoteException;
	
	public List<UserPO> getAllMarketers() throws RemoteException;

	/**
	 * 添加新用户，返回系统分配ID
	 * @param userPO
	 * @return
	 * @throws RemoteException
	 */
	public int add(UserPO userPO) throws RemoteException;
	
	public ResultMessage modify(UserPO userPO) throws RemoteException;

	public ResultMessage delete(int ID) throws RemoteException;
}
