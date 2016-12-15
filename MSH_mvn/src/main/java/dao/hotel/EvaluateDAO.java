package dao.hotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.EvaluatePO;

public interface EvaluateDAO extends Remote{
	public List<EvaluatePO> getEvaluate(int hotel_id)throws RemoteException;
}
