package runner;

import java.rmi.RemoteException;

import dao.hotel.HotelDAO;
import daoImpl.hotel.HotelDAOImpl;

public class HotelTest {
	public static void main(String[]args){
		HotelDAO test=new HotelDAOImpl();
		try {
			System.out.println(test.getRoom(0));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
