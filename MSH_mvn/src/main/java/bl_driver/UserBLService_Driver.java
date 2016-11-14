package bl_driver;

import java.util.ArrayList;

import tools.ResultMessage;
import tools.UserType;
import vo.UserVO;
import blservice.user_blservice.UserBLService;

public class UserBLService_Driver {
	public void drive(UserBLService userBLService){
		ResultMessage rm = userBLService.add(new UserVO("Ö£Ïþ·å", "123456", UserType.CUSTOMER, 0, 0));
		System.out.println(rm);
		ArrayList<UserVO> users = userBLService.getAll();
		for (UserVO user : users)
			System.out.println(user.getName());
		UserVO testUser = userBLService.get("Ö£Ïþ·å");
		System.out.println(testUser.getPassword());
		userBLService.modify(new UserVO("Ö£Ïþ·å", "233333", UserType.CUSTOMER, 0, 0));
		userBLService.delete("Ö£Ïþ·å");
	}
}
