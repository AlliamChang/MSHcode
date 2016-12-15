package data_stub;

import java.rmi.RemoteException;
import java.util.List;

import dao.user.CreditRecordsDAO;
import po.CreditPO;
import tools.ResultMessage;
import vo.CreditVO;

public class CreditRecordsDAO_Stub implements CreditRecordsDAO{

	@Override
	public List<CreditPO> getRecords(int UserID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage createRecord(int ID, CreditPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
