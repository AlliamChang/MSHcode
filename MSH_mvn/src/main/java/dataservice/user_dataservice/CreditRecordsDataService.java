package dataservice.user_dataservice;

import java.rmi.RemoteException;
import java.util.List;

import vo.CreditVO;


public interface CreditRecordsDataService {
	public List<CreditVO> getRecords(int UserID) throws RemoteException;
	
}
