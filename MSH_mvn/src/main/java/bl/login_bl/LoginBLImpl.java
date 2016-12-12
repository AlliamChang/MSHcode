package bl.login_bl;

import java.rmi.RemoteException;

import blservice.login_blservice.LoginBLService;
import dao.user_dao.UserDAO;
import tools.ResultMessage;
import vo.UserVO;

public class LoginBLImpl implements LoginBLService {
	UserDAO userDAO;

	@Override
	public UserVO login(String account, String password) {
		UserVO user = null;
		try {
			int id = Integer.parseInt(account);
			user = new UserVO(userDAO.get(id));	
		} catch (NumberFormatException e){
			try {
				user = new UserVO(userDAO.get(account));
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
}