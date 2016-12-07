package bl_stub;

import blservice.login_blservice.LoginBLService;
import tools.ResultMessage;

public class LoginBLService_Stub implements LoginBLService {

	public ResultMessage login(String user_name, String password) {
		if (user_name.equals("系统") && password.equals("123456789"))
			return ResultMessage.EXIST;
		else
			return ResultMessage.NOT_EXIST;
	}
}