package bl_stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tools.ChangeReason;
import tools.Date;
import tools.ResultMessage;
import tools.UserType;
import vo.CreditVO;
import vo.UserVO;
import blservice.user_blservice.UserBLService;

public class UserBLService_Stub implements UserBLService {

	public ArrayList<UserVO> getAll() {
		// TODO Auto-generated method stub
		UserVO testVO = new UserVO( "123","456" , "angel", "女", "18360977498", UserType.CUSTOMER, 2, 100);
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(testVO);
		return list;
	}

	public UserVO get(String name) {
		// TODO Auto-generated method stub
		return "123".equals(name) ? new UserVO( "123","456" , "angel", "女", "18360977498", UserType.CUSTOMER, 2, 100) : null;
	}

	public ResultMessage add(UserVO userVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modify(UserVO userVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delete(int id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<CreditVO> getCredit() {
		// TODO Auto-generated method stub
		return Arrays.asList(new CreditVO(new Date("2016/09/01",false),ChangeReason.OFFLINE_RECHARGE,500,100),
			new CreditVO(new Date("2016/09/28",false),ChangeReason.OFFLINE_RECHARGE,500,1500),
			new CreditVO(new Date("2016/10/22",false),ChangeReason.ABNORMAL_ORDER,1500,1200));
	}

	@Override
	public ArrayList<UserVO> getAllMarketers() {
		// TODO Auto-generated method stub
		return null;
	}

}
