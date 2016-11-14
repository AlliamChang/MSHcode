package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.userPO.UserPO;
import tools.ResultMessage;
import tools.UserType;
import dataservice.user_dataservice.UserDataService;

public class UserDataService_Stub implements UserDataService{

	public ArrayList<UserPO> getAll() {
		// TODO Auto-generated method stub
		UserPO testPO = new UserPO("֣����", "123456", UserType.CUSTOMER, 0, 0);
		ArrayList<UserPO> list = new ArrayList<UserPO>();
		list.add(testPO);
		return list;
	}

	public UserPO get(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return new UserPO("֣����", "123456", UserType.CUSTOMER, 0, 0);
	}

	public ResultMessage add(UserPO userPO) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modify(UserPO userPO) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delete(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
