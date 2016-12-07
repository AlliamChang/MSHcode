package bl_stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blservice.user_blservice.UserBLService;
import javafx.scene.image.Image;
import tools.ChangeReason;
import tools.Date;
import tools.ResultMessage;
import tools.UserType;
import vo.CreditVO;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService {

	public UserVO get(String account) {
		// TODO Auto-generated method stub
		return "123".equals(account) 
				? new UserVO( "123", "456" , "小红", "女", "18360977498", "南京大学教育超市北边收银台", 0, 0, 0, UserType.COMPANY_CUSTOMER, null) 
				: null;
	}

	public int add(UserVO userVO) {
		System.out.println("成功添加 ");
		return 0;
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
		return Arrays.asList(new UserVO("123", "郑晓峰", "男", "15050582962", UserType.MARKETER){{setID(1);}},
				new UserVO("123", "郑皓铭", "男", "15011112962", UserType.MARKETER){{setID(2);}});
	}

	@Override
	public List<String> getReservationHistory(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO get(int ID) {
		// TODO Auto-generated method stub
		return ID == 1 ? new UserVO("456" , "angel", "女", "18360977498", UserType.HOTEL_STAFF) : null;
	}
}
