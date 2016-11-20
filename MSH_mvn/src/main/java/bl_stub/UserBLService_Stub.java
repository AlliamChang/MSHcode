package bl_stub;

import java.util.ArrayList;

import tools.ResultMessage;
import tools.UserType;
import vo.UserVO;
import blservice.user_blservice.UserBLService;

public class UserBLService_Stub implements UserBLService {

	public ArrayList<UserVO> getAll() {
		// TODO Auto-generated method stub
		UserVO testVO = new UserVO("֣����", "123456", UserType.CUSTOMER, 0, 0);
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(testVO);
		return list;
	}

	public UserVO get(String name) {
		// TODO Auto-generated method stub
		return new UserVO("֣����", "123456", UserType.CUSTOMER, 0, 0);
	}

	public ResultMessage add(UserVO userVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modify(UserVO userVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delete(String name) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
