package dao.user;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.CreditPO;
import tools.ResultMessage;

public interface CreditRecordsDAO extends Remote {
	public List<CreditPO> getRecords(int userID) throws RemoteException;
	
	public ResultMessage createRecord(CreditPO po) throws RemoteException;
	
}