package dao.hotel_dao;

import java.rmi.RemoteException;

import po.hotelPO.*;

public interface HotelDAO {
	public HotelPO find(String id) throws RemoteException;

	public void add(HotelPO po) throws RemoteException;

	public void delete(HotelPO po) throws RemoteException;

	public void update(HotelPO po) throws RemoteException;

	public void modify(HotelPO po) throws RemoteException;

	public void init() throws RemoteException;
}
