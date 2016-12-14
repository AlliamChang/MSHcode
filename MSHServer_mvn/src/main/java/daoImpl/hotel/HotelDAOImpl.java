package daoImpl.hotel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import dao.hotel.HotelDAO;
import po.RoomPO;
import po.hotelPO.HotelPO;
import tools.ResultMessage;

public class HotelDAOImpl implements HotelDAO{
	private ArrayList<String> provinces;
	private HashMap<String, ArrayList<String>> cities, areas;
	
	public HotelDAOImpl(){
		provinces = new ArrayList<String>();
		cities = new HashMap<String, ArrayList<String>>();
		areas = new HashMap<String, ArrayList<String>>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("info/area.info")), "UTF-8"));
			int numOfPro = Integer.parseInt(br.readLine());
			String[] line;
			for (int i = 0; i < numOfPro; i++){
				line = br.readLine().split(" ");
				String province = line[0];
				provinces.add(province);
				int numOfCities = Integer.parseInt(line[1]);
				if (numOfCities != 0) {
					ArrayList<String> citiesTemp = new ArrayList<String>();
					for (int j = 0; j < numOfCities; j++) {
						line = br.readLine().split(" ");
						String city = line[0];
						citiesTemp.add(city);
						int numOfAreas = Integer.parseInt(line[1]);
						if (numOfAreas != 0)
							areas.put(province + city, new ArrayList<String>(Arrays.asList(br.readLine().split(" "))));
					}
					cities.put(province, citiesTemp);
				} else 
					areas.put(province, new ArrayList<String>(Arrays.asList(br.readLine().split(" "))));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

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
	public List<String> getCities(String province) throws RemoteException {	return cities.get(province); }

	@Override
	public List<String> getAreas(String province, String city) throws RemoteException {
		return areas.get(province + (city == null ? "" : city)); 
	}

	@Override
	public List<RoomPO> getRoom(int hotel_id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
