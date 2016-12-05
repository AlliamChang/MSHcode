package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
	public ResultMessage add(UserPO userPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(UserPO userPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


}
