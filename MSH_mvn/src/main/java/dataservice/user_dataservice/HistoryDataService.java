package dataservice.user_dataservice;

import java.rmi.RemoteException;
import java.util.List;

public interface HistoryDataService {
	
	public List<String> getHistory(int ID) throws RemoteException;
	
}
