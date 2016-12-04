package bl.user_bl;

import java.util.List;

import javafx.scene.image.Image;
import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;
import blservice.user_blservice.UserBLService;

public class UserBL implements UserBLService{
	
	@Override
	public List<UserVO> getAllMarketers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO get(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(UserVO userVO) {
		// TODO Auto-generated method stub
		return null;
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
