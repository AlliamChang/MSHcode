package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.user.UserDAO;
import po.UserPO;
import tools.ResultMessage;
import tools.UserType;

public class UserDAOStub implements UserDAO {

	private ArrayList<UserPO> dataBase;
	private ArrayList<Integer> logged;
	private int maxID;
	private int request; 
	
	public UserDAOStub(){
		dataBase = new ArrayList<UserPO>();
		logged = new ArrayList<Integer>();
		maxID = 0;
		request = 100;
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
	public ResultMessage updateUser(UserPO userPO) throws RemoteException {
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

	@Override
	public ResultMessage login(String account, String password) throws RemoteException {
		UserPO po;
		try {
			int id = Integer.parseInt(account);
			po = getUser(id);
		} catch (NumberFormatException e) {
			po = getUser(account);
		}
		if (po == null)
			return ResultMessage.NOT_EXIST;
		if (!po.getPassword().equals(password))
			return ResultMessage.FAIL;
		if (logged.contains((Integer)po.getID()))
			return ResultMessage.LOGGED;
		logged.add((Integer)po.getID());
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage logout(int id) throws RemoteException {
		logged.remove((Integer)id);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage setLvUpRequest(int request) throws RemoteException {
		this.request = request;
		return ResultMessage.SUCCESS;
	}

	@Override
	public int getLvUpRequest() throws RemoteException {
		return request;
	}

}
