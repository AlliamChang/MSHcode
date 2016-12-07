package dao.user_dao;

import java.rmi.RemoteException;
import java.util.List;

import po.CreditPO;
import tools.ResultMessage;
import vo.CreditVO;


public interface CreditRecordsDAO {
	public List<CreditVO> getRecords(int UserID) throws RemoteException;
	
	public ResultMessage addRecord(int ID, CreditPO po) throws RemoteException;
	
}
