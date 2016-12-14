package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.user.UserDAO;
import po.UserPO;
import tools.ResultMessage;
import tools.UserType;
import vo.UserVO;

public class UserDAOStub implements UserDAO {

	private ArrayList<UserPO> dataBase;
	private static int maxID;
	
	public UserDAOStub(){
		dataBase = new ArrayList<UserPO>();
		maxID = 0;
	}
	
	@Override
	public UserPO getUser(String account) throws RemoteException {
		for (UserPO po: dataBase)
			if (account.equals(po.getAccount()))
				return po;
		return null;
	}

	@Override
	public UserPO getUser(int ID) throws RemoteException {
		for (UserPO po: dataBase)
			if (po.getID() == ID)
				return po;
		return null;
	}

	@Override
	public List<UserPO> getAllMarketers() throws RemoteException {
		ArrayList<UserPO> ret = new ArrayList<UserPO>();
		for (UserPO po: dataBase)
			if (po.getType() == UserType.MARKETER)
				ret.add(po);
		return ret;
	}

	@Override
	public int addUser(UserPO userPO) throws RemoteException {
		maxID++;
		userPO.setID(maxID);
		dataBase.add(userPO);
		return maxID;
	}

	@Override
	public ResultMessage modifyUser(UserPO userPO) throws RemoteException {
		for (int i = 0; i < dataBase.size(); i++)
			if (dataBase.get(i).getID() == userPO.getID()){
				dataBase.set(i, userPO);
			}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage deleteUser(int ID) throws RemoteException {
		for (int i = 0; i < dataBase.size(); i++)
			if (dataBase.get(i).getID() == ID)
				dataBase.remove(i);
		return ResultMessage.SUCCESS;
	}

}
