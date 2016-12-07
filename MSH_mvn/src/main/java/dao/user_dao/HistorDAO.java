package dao.user_dao;

import java.rmi.RemoteException;
import java.util.List;

public interface HistorDAO {
	
	public List<String> getHistory(int ID) throws RemoteException;
	
}
