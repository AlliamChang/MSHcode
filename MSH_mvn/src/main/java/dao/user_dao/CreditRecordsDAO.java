package dao.user_dao;

import java.rmi.RemoteException;
import java.util.List;

import vo.CreditVO;


public interface CreditRecordsDAO {
	public List<CreditVO> getRecords(int UserID) throws RemoteException;
	
}
