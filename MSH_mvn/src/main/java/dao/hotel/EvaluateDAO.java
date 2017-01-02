package dao.hotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.EvaluatePO;
import tools.ResultMessage;

public interface EvaluateDAO extends Remote{
	public List<EvaluatePO> getEvaluate(int hotel_id)throws RemoteException;
	
	public ResultMessage createEvaluate(EvaluatePO po)throws RemoteException;
}
