package data_stub;

import java.rmi.RemoteException;

import po.hotelPO.*;
import dataservice.hotel_dataservice.Hotel_dataService;

public class hotel_dataService_Stub implements Hotel_dataService {

	public HotelPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find Succeed");
		return new HotelPO();
	}

	public void add(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("add Succeed");
	}

	public void delete(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("delete Succeed");
	}

	public void update(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("update Succeed");
	}

	public void modify(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("modify Succeed");
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("init Succeed");
	}
}
