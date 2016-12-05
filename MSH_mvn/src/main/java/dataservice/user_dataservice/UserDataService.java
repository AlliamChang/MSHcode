package dataservice.user_dataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javafx.scene.image.Image;
import po.userPO.*;
import tools.ResultMessage;

public interface UserDataService {

	public UserPO get(String name) throws RemoteException;
	
	public UserPO get(int ID) throws RemoteException;

	/**
	 * 添加新用户，返回系统分配ID
	 * @param userPO
	 * @return
	 * @throws RemoteException
	 */
	public int add(UserPO userPO) throws RemoteException;

	public ResultMessage modifyPassword(int ID, String newPW) throws RemoteException;

	public ResultMessage delete(String name) throws RemoteException;
}
