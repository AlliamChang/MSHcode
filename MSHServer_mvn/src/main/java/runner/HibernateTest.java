package runner;


import java.rmi.RemoteException;
import java.util.List;

import org.hibernate.Session;

import daoImpl.HibernateUtil;
import daoImpl.user_dao_Impl.UserDAOImpl;
import po.UserPO;
import tools.UserType;

public class HibernateTest {
	public static void main(String[] args){
		UserDAOImpl test = new UserDAOImpl();
		try {
			UserPO po = test.get(1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
