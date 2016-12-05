package data_stub;

import java.rmi.RemoteException;
import java.util.List;

import dataservice.user_dataservice.HistoryDataService;

public class HistoryDataService_Stub implements HistoryDataService{

	@Override
	public List<String> getHistory(int ID) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
