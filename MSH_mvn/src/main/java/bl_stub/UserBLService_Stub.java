package bl_stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import tools.ChangeReason;
import tools.Date;
import tools.ResultMessage;
import tools.UserType;
import vo.CreditVO;
import vo.UserVO;
import blservice.user_blservice.UserBLService;

public class UserBLService_Stub implements UserBLService {

	public List<UserVO> getAll() {
		// TODO Auto-generated method stub
		UserVO testVO = new UserVO( "123","456" , "angel", "女", "18360977498", UserType.CUSTOMER);
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(testVO);
		return list;
	}

	public UserVO get(String name) {
		// TODO Auto-generated method stub
		return "123".equals(name) ? new UserVO( "123","456" , "angel", "女", "18360977498", UserType.CUSTOMER) : null;
	}

	public ResultMessage add(UserVO userVO) {
		System.out.println("成功添加 ");
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modify(UserVO userVO) {
		System.out.println("修改成功！");
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delete(int ID) {
		System.out.println("删除成功！");
		return ResultMessage.SUCCESS;
	}

	@Override
	public List<CreditVO> getCredit(int ID) {
		return Arrays.asList(new CreditVO(new Date("2016/09/01",false),ChangeReason.OFFLINE_RECHARGE,500,100),
			new CreditVO(new Date("2016/09/28",false),ChangeReason.OFFLINE_RECHARGE,500,1500),
			new CreditVO(new Date("2016/10/22",false),ChangeReason.ABNORMAL_ORDER,1500,1200));
	}

	@Override
	public List<UserVO> getAllMarketers() {
		return Arrays.asList(new UserVO("marketer1", "123", "郑晓峰", "男", "15050582962", UserType.MARKETER){{setID(1);}},
				new UserVO("marketer2", "123", "郑皓铭", "男", "15011112962", UserType.MARKETER){{setID(2);}});
	}

	@Override
	public Image getImage(int ID) {
		return new Image(getClass().getResource("/image/用户.png").toExternalForm());
	}

	@Override
	public ResultMessage modifyPassword(int ID, String password) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
}
