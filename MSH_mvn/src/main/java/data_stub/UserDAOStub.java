package data_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.userPO.UserPO;
import tools.ResultMessage;
import tools.UserType;
import vo.UserVO;
import dao.user_dao.UserDAO;

public class UserDAOStub implements UserDAO {

	private ArrayList<UserPO> dataBase;
	private static int maxID;
	
	public UserDAOStub(){
		dataBase = new ArrayList<UserPO>();
		dataBase.add(new UserPO(new UserVO("hello", "郑晓峰", "男", "15012345678", UserType.WEB_ADMIN){{setID(1);}}));
		dataBase.add(new UserPO(new UserVO("123456", "郑皓铭", "男", "15045671257", UserType.MARKETER){{setID(2);}}));
		dataBase.add(new UserPO(new UserVO("love", "赵新宇", "男", "13845126987", UserType.MARKETER){{setID(3);}}));
		dataBase.add(new UserPO(new UserVO("gay", "赵鸿儒", "男", "13878126987", UserType.MARKETER){{setID(4);}}));
		maxID = 4;
	}
	
	@Override
	public UserPO get(String account) throws RemoteException {
		for (UserPO po: dataBase)
			if (account.equals(po.getAccount()))
				return po;
		return null;
	}

	@Override
	public UserPO get(int ID) throws RemoteException {
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
	public int add(UserPO userPO) throws RemoteException {
		maxID++;
		userPO.setID(maxID);
		dataBase.add(userPO);
		return maxID;
	}

	@Override
	public ResultMessage modify(UserPO userPO) throws RemoteException {
		for (int i = 0; i < dataBase.size(); i++)
			if (dataBase.get(i).getID() == userPO.getID()){
				dataBase.set(i, userPO);
			}
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(int ID) throws RemoteException {
		for (int i = 0; i < dataBase.size(); i++)
			if (dataBase.get(i).getID() == ID)
				dataBase.remove(i);
		return ResultMessage.SUCCESS;
	}

}
