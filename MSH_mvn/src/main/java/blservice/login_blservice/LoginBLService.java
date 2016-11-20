package blservice.login_blservice;

import tools.ResultMessage;

public interface LoginBLService {
	public ResultMessage login(String user_name, String password);
}
