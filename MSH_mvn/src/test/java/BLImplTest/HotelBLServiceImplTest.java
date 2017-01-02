package BLImplTest;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import po.hotelPO.HotelPO;
import tools.BedStyle;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.RoomVO;
import dao.hotel.HotelDAO;
import blservice.hotel_blservice.HotelBLService;

public class HotelBLServiceImplTest {
	private HotelBLService hotel;
	private HotelDAO dao; 
	private RoomVO v1;
	private EvaluateVO e;
	private HotelInfoVO i1,i2,i3;
	@Before
	public void setData(){
		v1=new RoomVO("大床房",BedStyle.BUNK_BED,400,5,2,5);
		e=new EvaluateVO("111", "222", 4, null, 4.4);
		HotelPO p1=new HotelPO();
		p1.setAddress("南京市中山北路10号");
		p1.setCity("南京市");
		p1.setId(4);
		p1.setLowest_price(500);
		p1.setName("青年旅馆");
		p1.setProvince("江苏省");
		p1.setTrade_area("鼓楼区");
		p1.setScore(2.5);
		p1.setStar_level(3);
		i1=new HotelInfoVO(p1);
		
		HotelPO p2=new HotelPO();
		p2.setAddress("南京市珠江路10号");
		p2.setCity("南京市");
		p1.setId(5);
		p1.setLowest_price(300);
		p1.setName("渡口客栈");
		p1.setProvince("江苏省");
		p1.setTrade_area("鼓楼区");
		p1.setScore(3.5);
		p1.setStar_level(4);
		i2=new HotelInfoVO(p2);
		
		HotelPO p3=new HotelPO();
		p3.setAddress("南京市上海路10号");
		p1.setCity("南京市");
		p1.setId(6);
		p1.setLowest_price(400);
		p1.setName("桃花源");
		p1.setProvince("江苏省");
		p1.setTrade_area("鼓楼区");
		p1.setScore(3.0);
		p1.setStar_level(5);
		i3=new HotelInfoVO(p3);
		
		try{
			dao.add(p1);
			dao.add(p2);
			dao.add(p3);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
	}
	@Test
	public void TestAdd(){
		HotelPO p1=new HotelPO();
		p1.setAddress("南京市中山北路10号");
		p1.setCity("南京市");
		p1.setId(6);
		p1.setLowest_price(500);
		p1.setName("青年旅馆");
		p1.setProvince("江苏省");
		p1.setTrade_area("鼓楼区");
		p1.setScore(2.5);
		p1.setStar_level(3);
		hotel.add(new HotelInfoVO(p1));
		assertEquals(hotel.getHotel(6),new HotelInfoVO(p1));
		
	}
	@Test
	public void TestDelete(){
		hotel.delete(i1.getHotel_id());
		assertEquals(null,hotel.getHotel(i1.getHotel_id()));
	}
	@Test
	public void TestModify(){
		i1.setStar(0);
		assertEquals(0,hotel.getHotel(i1.getHotel_id()).getStar());
	}
	@Test
	public void TestGet(){
		assertEquals(hotel.getHotel(i2.getHotel_id()).getHotel_id(),i2.getHotel_id());
	}
	@Test
	public void TestSearch(){
		assertEquals(hotel.search("江苏省", "南京市", "鼓楼区","渡口客栈",null, null, null, null, -1).size(),1);
	}
	@Test
	public void TestAddRoom(){
		v1.setid(2);
		hotel.inputRoom(v1);
		assertEquals(hotel.getRoom(2),v1);
	}
	@Test
	public void TestGetRoom(){
		assertEquals(hotel.getRoom(2),v1);
	}
	@Test
	public void TestGetPro(){
		assertEquals(hotel.getProvinces().get(0),"北京");
	}
	@Test
	public void TestGetCity(){
		assertEquals(hotel.getCities("江苏省").get(0),"南京");
	}
	@Test
	public void TestGetTrade(){
		assertEquals(hotel.getAreas("江苏省", "南京").get(0),"栖霞区");
	}
	@Test
	public void TestGetEvaluate(){
		assertEquals(hotel.getEvaluate(0),null);
	}
	@Test
	public void TestSortByStar(){
		List<HotelInfoVO>tmp=new ArrayList<HotelInfoVO>();
		tmp.add(i2);
		tmp.add(i3);
		tmp.add(i1);
		assertEquals(hotel.sortByHighStar(tmp).get(0).getStar(),5);
	}
	@SuppressWarnings("deprecation")
	@Test
	public void TestSortByScore(){
		List<HotelInfoVO>tmp=new ArrayList<HotelInfoVO>();
		tmp.add(i2);
		tmp.add(i3);
		tmp.add(i1);
		assertEquals(hotel.sortByHighScore(tmp).get(0).getScore(),3.5);
	}
	@Test
	public void TestSortByPrice(){
		List<HotelInfoVO>tmp=new ArrayList<HotelInfoVO>();
		tmp.add(i2);
		tmp.add(i3);
		tmp.add(i1);
		assertEquals(hotel.sortByHighPrice(tmp).get(0).getLowest_price(),"500");
	}
	@Test
	public void TestCreateEvaluate(){
		e.setHotel_id(6);
		hotel.createEvaluate(e);
		assertEquals(hotel.getEvaluate(5), null);
	}
	
}
