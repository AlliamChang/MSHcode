package runner;

import java.rmi.RemoteException;

import dao.user.CreditRecordsDAO;
import daoImpl.user.CreditRecordsDAOImpl;
import po.CreditPO;
import rmi.RemoteHelper;

public class Test {
	
	public static void main(String[] args) {
		
		CreditRecordsDAO crd = new CreditRecordsDAOImpl();
		try {
			crd.deleteRecords(2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}