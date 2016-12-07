package BLImplTest;

import java.util.List;

import org.junit.*;

import vo.UserVO;
import bl.user_bl.UserBLServiceImpl;
import blservice.user_blservice.UserBLService;
import dao.user_dao.UserDAO;
import data_stub.UserDAOStub;

public class UserBLServiceImplTest {
	private UserBLService u;
	
	@Before
	public void setUP(){
		u = new UserBLServiceImpl();
	}
	
	@Test
	public void testGetAllMarketers(){
		List<UserVO> list = u.getAllMarketers();
		
	}
	
}
