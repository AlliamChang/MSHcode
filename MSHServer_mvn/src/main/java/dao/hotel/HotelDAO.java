package dao.hotel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import po.RoomPO;
import po.hotelPO.*;
import tools.ResultMessage;

public interface HotelDAO extends Remote {
	public HotelPO find(int id) throws RemoteException;

	public ResultMessage add(HotelPO po) throws RemoteException;
	
	public ResultMessage addRoom(RoomPO po)throws RemoteException;

	public ResultMessage delete(int id) throws RemoteException;

	public void update(HotelPO po) throws RemoteException;

	public ResultMessage modify(HotelPO po) throws RemoteException;

	public void init() throws RemoteException;
	
	public List<HotelPO> get(String province, String city, String tradeArea,
			String name) throws RemoteException;
	
	public List<String> getProvinces()throws RemoteException;
	
	public List<String> getCities(String province)throws RemoteException;
	
	public List<String> getAreas(String province,String city)throws RemoteException;
	
	public List<RoomPO> getRoom(int hotel_id)throws RemoteException;
}