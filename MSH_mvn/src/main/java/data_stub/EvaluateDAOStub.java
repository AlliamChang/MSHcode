package data_stub;

import java.rmi.RemoteException;
import java.util.List;

import po.EvaluatePO;
import tools.ResultMessage;
import dao.hotel.EvaluateDAO;

public class EvaluateDAOStub implements EvaluateDAO {

	@Override
	public List<EvaluatePO> getEvaluate(int hotel_id) throws RemoteException {
		return null;
	}

	@Override
	public ResultMessage createEvaluate(EvaluatePO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
