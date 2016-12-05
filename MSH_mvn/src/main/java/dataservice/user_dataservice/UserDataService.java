package dataservice.user_dataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import po.userPO.*;
import tools.ResultMessage;

public interface UserDataService {

	public UserPO get(String name) throws RemoteException;

	public ResultMessage add(UserPO userPO) throws RemoteException;

	public ResultMessage modify(UserPO userPO) throws RemoteException;

	public ResultMessage delete(String name) throws RemoteException;
}
