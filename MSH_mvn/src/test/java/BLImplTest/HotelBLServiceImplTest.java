package BLImplTest;

import static org.junit.Assert.assertEquals;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import po.hotelPO.HotelPO;
import rmi.RemoteHelper;
import tools.BedStyle;
import tools.UserType;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.RoomVO;
import vo.UserVO;
import dao.hotel.HotelDAO;
import bl.hotel.HotelBLServiceImpl;
import bl.user.UserBLServiceImpl;
import blservice.hotel.HotelBLService;

public class HotelBLServiceImplTest {
	private HotelBLService hotel;
	private RemoteHelper remoteHelper;
	private HotelDAO dao; 
	private RoomVO v1;
	private EvaluateVO e;
	private HotelInfoVO i1,i2,i3;
	
		@Before
		public void setUP() {
			remoteHelper = RemoteHelper.getInstance();
			try {
				remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/RemoteImpl"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			hotel=new bl.hotel.HotelBLServiceImpl();
			i1 = new HotelInfoVO("青年旅馆", "南京市中山北路10号", null, null, null, "江苏省", "鼓楼区", 0, null, 3, 3.5, 2, 0, "南京市");
			i2 = new HotelInfoVO("天上人间", "南京市上海路10号", null, null, null, "江苏省", "鼓楼区", 0, null, 4, 4.0, 5, 4, "南京市");
			i3 = new HotelInfoVO("渡口客栈", "南京市珠江路10号", null, null, null, "江苏省", "鼓楼区", 0, null, 2, 3.0, 4, 1, "南京市");
			i1.setLowest_price(100);
			i2.setLowest_price(200);
			i3.setLowest_price(300);
		}
		
		@Test
		public void TestGet(){
			hotel.add(i3);
			assertEquals(hotel.getHotel(i3.getHotel_id()).getAdress(),i3.getAdress());
		}
	@Test
	public void TestAdd(){
		hotel.add(i2);
		assertEquals(hotel.getHotel(i2.getHotel_id()).getAdress(),i2.getAdress());
	}
	@Test
	public void TestDelete(){
		//hotel.add(i2);
		hotel.add(i1);
		
		//hotel.delete(i1.getHotel_id());
		//assertEquals(i2,hotel.getHotel(i2.getHotel_id()));
	}
	@Test
	public void TestModify(){
		i1.setStar(1);
		hotel.modify(i1);
		//assertEquals(0,hotel.getHotel(i1.getHotel_id()).getStar());
	}
	
	@Test
	public void TestSearch(){
		assertEquals(hotel.search("江苏省", "南京市", "鼓楼区","天上人间",null, null, null, null, -1).size(),1);
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
		assertEquals(hotel.getCities("江苏省").get(0),"南京市");
	}
	@Test
	public void TestGetTrade(){
		assertEquals(hotel.getAreas("江苏省", "南京市").get(0),"栖霞区");
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
		assertEquals(hotel.sortByHighStar(tmp).get(0).getStar(),4);
	}
	
	@Test
	public void TestSortByScore(){
		List<HotelInfoVO>tmp=new ArrayList<HotelInfoVO>();
		tmp.add(i2);
		tmp.add(i3);
		tmp.add(i1);
		assertEquals(hotel.sortByHighScore(tmp).get(0).getScore()+"",4.0+"");
	}
	@Test
	public void TestSortByPrice(){
		List<HotelInfoVO>tmp=new ArrayList<HotelInfoVO>();
		tmp.add(i2);
		tmp.add(i3);
		tmp.add(i1);
		assertEquals(hotel.sortByHighPrice(tmp).get(0).getLowest_price()+"","300");
	}
	@Test
	public void TestCreateEvaluate(){
		e.setHotel_id(6);
		hotel.createEvaluate(e);
		assertEquals(hotel.getEvaluate(5), null);
	}
	
}
