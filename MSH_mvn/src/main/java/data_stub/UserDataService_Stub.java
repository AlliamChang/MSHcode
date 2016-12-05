package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.userPO.UserPO;
import tools.ResultMessage;
import tools.UserType;
import dataservice.user_dataservice.UserDataService;

public class UserDataService_Stub implements UserDataService {

	@Override
	public UserPO get(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPO get(int ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPO> getAllMarketers() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(UserPO userPO) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage modify(UserPO userPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(int ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
