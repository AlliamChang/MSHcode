package data_stub;


import java.rmi.RemoteException;
import java.util.List;

import po.hotelPO.*;
import dao.hotel_dao.HotelDAO;

public class HotelDAOStub implements HotelDAO {

	public HotelPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("find Succeed");
		List<Room>room = null;
		Room big=new Room("大床房",600,10);
		Room family=new Room("家庭套间",820,5);
		room.add(big);
		room.add(family);
		return new HotelPO(id, "渡口客栈","南京市中山北路20号", "鼓楼区", "南京", 456, 4.6, 4, room);
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
