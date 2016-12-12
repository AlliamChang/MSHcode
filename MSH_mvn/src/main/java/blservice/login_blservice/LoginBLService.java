package blservice.login_blservice;

import vo.UserVO;

public interface LoginBLService {
	/**
	 * 返回UserVO，若返回null则登陆失败
	 * @param account 账号或id
	 * @param password
	 * @return
	 */
	public UserVO login(String account, String password);
}
