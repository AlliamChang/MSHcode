package data_stub;

import java.rmi.RemoteException;
import java.util.List;

import dao.user_dao.HistorDAO;

public class HistoryDAO_Stub implements HistorDAO{

	@Override
	public List<String> getHistory(int ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
