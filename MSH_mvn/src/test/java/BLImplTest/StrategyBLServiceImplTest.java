package BLImplTest;

import static org.junit.Assert.*;

import java.rmi.Naming;
import java.util.List;


import org.junit.*;

import bl.strategy.*;
import blservice.strategy.*;
import tools.*;
import vo.*;
import rmi.RemoteHelper;

public class StrategyBLServiceImplTest {
	private RemoteHelper helper;
	private StrategyBLService strategy;
	private StrategyVO s1,s2,s3;
	private UserVO u1;
	private OrderVO o1;
	@Before
	public void setUp(){
		helper=RemoteHelper.getInstance();
		try{
			helper.setRemote(Naming.lookup("rmi://127.0.0.1:8888/RemoteImpl"));
		} catch (Exception e){
			e.printStackTrace();
		}
		
		strategy=new StrategyBLServiceImpl();
		s1=new StrategyVO("s1",StrategyType.HOLIDAY,"江苏省","南京市","栖霞区","2017/01/01","2017/01/03",
				10.00,PeopleType.VIP);
		s2=new StrategyVO("s2",StrategyType.HOLIDAY,"江苏省","南京市","栖霞区","2017/01/01","2017/01/03",
				11.00,PeopleType.VIP,1);
		u1=new UserVO("zhr","123123","zzz","男","133345612","公司",null,1999,1,1,UserType.CUSTOMER);
		o1=new OrderVO(123,"zhr",1,"Rujia","dachuang",3,null,null,2,new Date("2017/01/01",false),
				4,false,100);
	}
	
	@Test
	public void testAddStrategy(){
		assertEquals(strategy.addStrategy(s1),ResultMessage.SUCCESS);
		
	}
	
	@Test
	public void testDeleteStrategy(){
		strategy.addStrategy(s2);
		assertEquals(strategy.deleteStrategy(s2),ResultMessage.SUCCESS);
		
	}
	
	@Test
	public void testModifyStrategy(){
		strategy.addStrategy(s1);
		s1.setCity("changeTo徐州");
		assertEquals(strategy.modifyStrategy(s1),ResultMessage.SUCCESS);
		
	}
	
	@Test
	public void testGetStrategyInHotel(){
		
		List<StrategyVO> list=strategy.getStrategyInHotel(s2.getHotelId());
		s3=list.get(0);
		assertEquals(s2.getCost()==11.00,true);
		
	}
	
	@Test
	public void testGetStrategyInWeb(){
		strategy.addStrategy(s2);
		List<StrategyVO> list=strategy.getStrategyInWeb();
		assertEquals(list.get(0),s2);
		
	}
	
	@Test
	public void testGetFinalPriceInHotel(){
		
		assertEquals((strategy.getFinalPriceInHotel(u1, o1, 1)==21.00),true);
		
	}
	
	@Test
	public void testGetLowestPrice(){
		
		assertEquals((strategy.getLowestPrice(u1, 1)==21.00),true);
		
	}
	
	@Test
	public void testGetBirthPrice(){
		
		assertEquals((strategy.getBirthPrice(u1, 1)==0.00),true);
		
	}
	
	@Test
	public void testGetTimePrice(){
		
		assertEquals((strategy.getTimePrice(1)==10.00),true);
		
	}
	
	@Test
	public void testGetRoomPrice(){
		
		assertEquals((strategy.getRoomPrice(o1, 1)==10.00),true);
		
	}
	
	@Test
	public void testGetVipPrice(){
		
		assertEquals((strategy.getVipPrice(u1)==10.00),true);
		
	}
	
	@Test
	public void testGetCooperation(){
		
		assertEquals((strategy.getCooperationPrice(u1, 1)==0.00),true);
		
	}
	

}
