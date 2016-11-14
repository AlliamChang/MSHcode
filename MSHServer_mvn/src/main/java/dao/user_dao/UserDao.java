package dao.user_dao;

import java.rmi.RemoteException;
import java.util.ArrayList;
import po.userPO.*;
import tools.ResultMessage;

public interface UserDao {
	
	public ArrayList<UserPO> getAll();
	
	public UserPO get(String name) throws RemoteException;
	
	public ResultMessage add(UserPO userPO) throws RemoteException;
	
	public ResultMessage modify(UserPO userPO) throws RemoteException;
	
	public ResultMessage delete(String name) throws RemoteException;
}
