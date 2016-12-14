package BLImplTest;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;

import org.junit.*;

import po.UserPO;
import tools.UserType;
import vo.UserVO;
import bl.user_bl.UserBLServiceImpl;
import blservice.user_blservice.UserBLService;
import dao.user.UserDAO;
import data_stub.UserDAOStub;

public class UserBLServiceImplTest {
	private UserBLService u;
	private UserVO u1, u2, u3, u4, u5;
	@Before
	public void setUP(){
		u = new UserBLServiceImpl();
		u1 = new UserVO("hello", "郑晓峰", "男", "15012345678", UserType.WEB_ADMIN){{setID(1);}};
		u2 = new UserVO("123456", "郑皓铭", "男", "15045671257", UserType.MARKETER){{setID(2);}};
		u3 = new UserVO("zxy", "3434", "赵新宇", "男", "15078945632", 
				1997, 8, 12, UserType.CUSTOMER, new Image(getClass().getResource("/image/用户2.png").toExternalForm())){{setID(3);}};
		u4 = new UserVO("zhr", "123", "赵鸿儒", "男", "15047962458", "南京大学",
				1997, 4, 21, UserType.COMPANY_CUSTOMER, new Image(getClass().getResource("/image/用户.png").toExternalForm())){{setID(4);}};
		u5 = new UserVO("2333", "小红", "女", "15789654123", UserType.HOTEL_STAFF);
	}
	
	@Test
	public void testGetAllMarketers(){
		
	}
	
}
