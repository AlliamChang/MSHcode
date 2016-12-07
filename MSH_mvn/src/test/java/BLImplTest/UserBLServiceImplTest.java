package BLImplTest;

import org.junit.*;

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
		
	}
	
}
