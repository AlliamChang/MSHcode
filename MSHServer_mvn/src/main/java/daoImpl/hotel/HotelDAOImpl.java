package daoImpl.hotel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.hotel.HotelDAO;
import po.RoomPO;
import po.hotelPO.HotelPO;
import tools.ResultMessage;

public class HotelDAOImpl implements HotelDAO{
	private ArrayList<String> provinces;
	private HashMap<String, ArrayList<String>> cities, areas;
	
	public HotelDAOImpl(){
		BufferedReader br = new BufferedReader(new FileReader(new File("info/regin.info")));
		provinces = new ArrayList<String>();
		cities = new ArrayList<String>();
		areas = new ArrayList<String>();
		File f = new File("info/regin.info");
	}

	@Override
	public HotelPO find(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addRoom(RoomPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(int id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultMessage modify(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HotelPO> get(String province, String city, String tradeArea, String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getProvinces() throws RemoteException {	return provinces; }

	@Override
	public List<String> getCities(String province) throws RemoteException {	return cities; }

	@Override
	public List<String> getAreas(String province, String city) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RoomPO> getRoom(int hotel_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
