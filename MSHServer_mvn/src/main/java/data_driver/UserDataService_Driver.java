package data_driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dao.user_dao.UserDao;
import po.userPO.UserPO;
import tools.ResultMessage;
import tools.UserType;

public class UserDataService_Driver {
	public void drive(UserDao userDataService){
		UserPO upo = new UserPO("zxf", "11111", UserType.CUSTOMER, 0, 0);
		ResultMessage rm = null;
		try {
			rm = userDataService.add(upo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rm.equals(ResultMessage.SUCCESS))
			System.out.println("Add successfully");
		ArrayList<UserPO> list = userDataService.getAll();
		for (UserPO user: list)
			System.out.println(user.getName());
		try {
			UserPO test = userDataService.get("zxf");
			System.out.println(test.getPassword());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			userDataService.modify(new UserPO("zxf", "23333", UserType.CUSTOMER, 0, 0));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			userDataService.delete("zxf");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
