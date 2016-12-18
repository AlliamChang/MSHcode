package runner;

import java.rmi.RemoteException;
import java.util.List;

import po.hotelPO.HotelPO;
import dao.hotel.HotelDAO;
import daoImpl.hotel.HotelDAOImpl;

public class HotelTest {
	public static void main(String[]args){
		HotelDAO test=new HotelDAOImpl();
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
			//test.add(po);
			List<HotelPO> tmp=test.getHotel("江苏省", "南京市", "鼓楼区", "青年", null, null, null, null, -1);
			System.out.println(test.getHotel("江苏省", "南京市", "鼓楼区", "青年", null, null, null, null, -1).get(0).getCity());
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
}
