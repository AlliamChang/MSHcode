package data_stub;

import java.rmi.RemoteException;
import java.util.List;

import po.CreditPO;
import tools.ResultMessage;
import vo.CreditVO;
import dao.user_dao.CreditRecordsDAO;

public class CreditRecordsDAO_Stub implements CreditRecordsDAO{

	@Override
	public List<CreditVO> getRecords(int UserID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addRecord(int ID, CreditPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
