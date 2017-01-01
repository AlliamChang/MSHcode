package BLImplTest;

import static org.junit.Assert.*;

import java.rmi.Naming;
import java.util.List;


import org.junit.*;

import tools.ResultMessage;
import tools.UserType;
import vo.UserVO;
import bl.user_bl.UserBLServiceImpl;
import blservice.user_blservice.UserBLService;
import rmi.RemoteHelper;

public class UserBLServiceImplTest {
	private RemoteHelper remoteHelper;
	private UserBLService u;
	private UserVO u1, u2, u3;
	@Before
	public void setUP() {
		remoteHelper = RemoteHelper.getInstance();
		try {
			remoteHelper.setRemote(Naming.lookup("rmi://172.26.91.91:8888/RemoteImpl"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		u = new UserBLServiceImpl();
		u1 = new UserVO("testUser1", "123456", "长者", "男", "110", null, null, 1926, 8, 17, UserType.CUSTOMER);
		u2 = new UserVO("testUser2", "123456", "郑晓峰", "男", "15050582963", "南京大学", null, 1997, 6, 23, UserType.COMPANY_CUSTOMER);
		u3 = new UserVO(null, "123456", "郑浩铭", "男", "15050582963", null, null, 0, 0, 0, UserType.MARKETER);
	}
	
	@Test
	public void testGetAllMarketers() {
		u3.setID(u.add(u3));
		List<UserVO> list = u.getAllMarketers();
		UserVO m = list.get(0);
		u.delete(m.getID());
		assertEquals(comp(m, u3), true);
	}
	
	@Test
	public void testGet() {
		u1.setID(u.add(u1));
		u2.setID(u.add(u2));
		UserVO ret1 = u.get(u1.getID()), ret2 = u.get(u2.getAccount());
		u.delete(u1.getID());
		u.delete(u2.getID());
		assertEquals(comp(ret1, u1), true);
		assertEquals(comp(ret2, u2), true);
	}
	
	@Test
	public void testIsUsed() {
		u1.setID(u.add(u1));
		boolean result1 = u.isUsed(u1.getAccount()), result2 = u.isUsed("notUsed");
		u.delete(u1.getID());
		assertEquals(result1, true);
		assertEquals(result2, false);
	}
	
	@Test
	public void testUpdate() {
		u1.setID(u.add(u1));
		u1.setName("蛤");
		u.update(u1);
		UserVO after = u.get(u1.getID());
		u.delete(u1.getID());
		assertEquals(comp(after, u1), true);
	}
	
	@Test
	public void testDelete() {
		u1.setID(u.add(u1));
		u.delete(u1.getID());
		assertEquals(null, u.get(u1.getAccount()));
	}
	
	@Test
	public void testLogin() {
		u1.setID(u.add(u1));
		ResultMessage message1 = u.login(u1.getAccount(), "12345"), message2 = u.login(u1.getAccount(), "123456"), 
				message3 = u.login(u1.getAccount(), "123456"), message4 = u.login(u2.getAccount(), "123456");
		boolean result1 = message1 == ResultMessage.FAIL, result2 = message2 == ResultMessage.SUCCESS, 
				result3 = message3 == ResultMessage.LOGGED, result4 = message4 == ResultMessage.NOT_EXIST;
		u.delete(u1.getID());
		assertEquals(result1, true);
		assertEquals(result2, true);
		assertEquals(result3, true);
		assertEquals(result4, true);
	}
	
	@Test
	public void testLogout() {
		u1.setID(u.add(u1));
		u.login(u1.getAccount(), "123456");
		boolean result1 = u.login(u1.getAccount(), "123456") == ResultMessage.LOGGED;
		u.logout(u1.getID());
		boolean result2 = u.login(u1.getAccount(), "123456") == ResultMessage.SUCCESS;
		u.delete(u1.getID());
		assertEquals(result1, true);
		assertEquals(result2, true);
	}
	
	@Test
	public void testChangePassword() {
		u1.setID(u.add(u1));
		u.changePassword(u1.getID(), "123456", "changed");
		u1.setPassword("changed");
		UserVO vo = u.get(u1.getID());
		u.delete(u1.getID());
		assertEquals(vo.getPassword(), u1.getPassword());
	}
	
	private static boolean comp(UserVO vo1, UserVO vo2) {
		return (vo1.getAccount() == vo2.getAccount() || vo1.getAccount().equals(vo2.getAccount())) 
				&& (vo1.getCompany() == vo2.getCompany() || vo1.getCompany().equals(vo2.getCompany()))
				&& vo1.getCredit() == vo2.getCredit() && vo1.getDay() == vo2.getDay() && vo1.getGender().equals(vo2.getGender())
				&& vo1.getHotelID() == vo2.getHotelID() && vo1.getID() == vo2.getID() && vo1.getLevel() == vo2.getLevel()
				&& vo1.getMonth() == vo2.getMonth() 
				&& (vo1.getName() == vo2.getName() || vo1.getName().equals(vo2.getName())) 
				&& (vo1.getNumber() == vo2.getNumber() || vo1.getNumber().equals(vo2.getNumber()))
				&& vo1.getPassword().equals(vo2.getPassword()) && vo1.getType() == vo2.getType() && vo1.getYear() == vo2.getYear();
	}
}
