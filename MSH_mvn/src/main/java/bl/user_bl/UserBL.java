package bl.user_bl;

import java.util.List;

import data_stub.UserDataService_Stub;
import dataservice.user_dataservice.UserDataService;
import javafx.scene.image.Image;
import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;
import blservice.user_blservice.UserBLService;

public class UserBL implements UserBLService{
	private UserDataService uds;
	
	public UserBL(){
		uds = new UserDataService_Stub();
	}
	
	@Override
	public List<UserVO> getAllMarketers() {
		
		return null;
	}

	@Override
	public UserVO get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 返回ID
	 */
	@Override
	public int add(UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResultMessage modify(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CreditVO> getCredit(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image getImage(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyPassword(int ID, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getReservationHistory(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
