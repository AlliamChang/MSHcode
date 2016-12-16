package runner;

import java.rmi.RemoteException;

import po.hotelPO.HotelPO;
import daoImpl.hotel.HotelDAOImpl;

public class HotelTest {
	public static void main(String[]args){
		HotelDAOImpl test=new HotelDAOImpl();
		try{
			HotelPO po=new HotelPO();
			po.setId(0);
			po.setAddress("南京市中山北路20号");
			po.setCity("南京市");
			po.setName("青年旅馆");
			po.setProvince("江苏省");
			po.setScore(4.5);
			po.setStar_level(4);
			po.setFacility(null);
			po.setLowest_price(400);
			po.setIntroduction(null);
			po.setScul(null);
			po.setPhone("123456789");
			po.setTrade_area("鼓楼区");
			po.setYear(2012);
			po.setStuff_id(2);
			test.add(po);
			System.out.println(1);
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
}
