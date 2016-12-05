package data_stub;

import java.rmi.RemoteException;
import java.util.List;

import vo.CreditVO;
import dataservice.user_dataservice.CreditRecordsDataService;

public class CreditRecordsDataService_Stub implements CreditRecordsDataService{

	@Override
	public List<CreditVO> getRecords(int UserID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
