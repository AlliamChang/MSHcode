package bl_driver;

import tools.ResultMessage;
import blservice.login_blservice.LoginBLService;


public class LoginBLService_Driver {
	
	public void drive(LoginBLService loginBLService){
		ResultMessage result=loginBLService.login("系统","123456789");
		if(result==ResultMessage.EXIST)
			System.out.println("Login succeed");
		else System.out.println("Login fail");
	}
}
