package bl_driver;

import blservice.login_blservice.LoginBLService;
import tools.ResultMessage;

public class LoginBLService_Driver {

	public void drive(LoginBLService loginBLService) {
		ResultMessage result = loginBLService.login("系统", "123456789");
		if (result == ResultMessage.EXIST)
			System.out.println("Login succeed");
		else
			System.out.println("Login fail");
	}
}
