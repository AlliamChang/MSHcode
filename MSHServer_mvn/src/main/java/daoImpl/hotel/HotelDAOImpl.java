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

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.hotel.HotelDAO;
import daoImpl.HibernateUtil;
import po.OrderPO;
import po.RoomPO;
import po.UserPO;
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
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		HotelPO result=(HotelPO)session.get(HotelPO.class,id);
		session.close();
		return result;
	}

	@Override
	public ResultMessage add(HotelPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(po);
		transaction.commit();
		System.out.println("succeed");
		return ResultMessage.SUCCESS;
		
	}

	@Override
	public ResultMessage addRoom(RoomPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(po);
		transaction.commit();
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage delete(int id) throws RemoteException {
		try{
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.delete(session.load(UserPO.class, id));
			transaction.commit();
			session.close();
			return ResultMessage.SUCCESS;
		} catch (ObjectNotFoundException e) {
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage update(HotelPO po) throws RemoteException {
		Session session = HibernateUtil.getSession();
		Transaction transaction = session.beginTransaction();
		session.update(po);
		transaction.commit();
		session.close();
		return ResultMessage.SUCCESS;
	}


	@Override
	public List<HotelPO> get(String province, String city, String tradeArea, String name) throws RemoteException {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query;
		if(name == null)
			query = session.createQuery("from HotelPO where province = '" + province + "' and city='"+city+"' and trade_area='"+tradeArea+"'");
		else{
			query = session.createQuery("from HotelPO where province = '" + province + "' and city='"+city+"' and trade_area='"+tradeArea+"' and name="+name+"'");
		}
		List<HotelPO> list = query.list();
		session.close();
		return list;
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
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		Query query = session.createQuery("from RoomPO where hotel_id = '" + hotel_id + "'");
		List<RoomPO> list = query.list();
		session.close();
		return list;

}
}
