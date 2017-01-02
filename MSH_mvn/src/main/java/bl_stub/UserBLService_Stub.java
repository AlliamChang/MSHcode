package bl_stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blservice.user.UserBLService;
import tools.ChangeReason;
import tools.Date;
import tools.Encryption;
import tools.ResultMessage;
import tools.UserType;
import vo.CreditVO;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService {
	private ArrayList<UserVO> database;
	private ArrayList<Integer> logged;
	private int idNow;
	
	public UserBLService_Stub() {
		logged = new ArrayList<Integer>();
		database = new ArrayList<UserVO>();
		idNow = -1;
	}
	
	public UserVO get(String account) {
		for (UserVO user: database)
			if (user.getAccount().equals(account))
				return user;
		return null;
	}

	public int add(UserVO userVO) {
		userVO.setID(++idNow);
		database.add(userVO);
		return idNow;
	}

	public ResultMessage update(UserVO userVO) {
		for (int i = 0; i < database.size(); i++)
			if (database.get(i).getID() == userVO.getID()) {
				database.set(i, userVO);
				return ResultMessage.SUCCESS;
			}
		return ResultMessage.FAIL;
	}

	public ResultMessage delete(int ID) {
		for (UserVO vo: database) 
			if (vo.getID() == ID) {
				database.remove(vo);
				return ResultMessage.SUCCESS;
			}
		return ResultMessage.FAIL;
	}

	@Override
	public List<CreditVO> getCreditRecords(int ID) {
		return Arrays.asList(new CreditVO(new Date("2016/09/01",false),ChangeReason.OFFLINE_RECHARGE,500,100),
			new CreditVO(new Date("2016/09/28",false),ChangeReason.OFFLINE_RECHARGE,500,1500),
			new CreditVO(new Date("2016/10/22",false),ChangeReason.ABNORMAL_ORDER,1500,1200));
	}

	@Override
	public List<UserVO> getAllMarketers() {
		ArrayList<UserVO> marketers = new ArrayList<UserVO>();
		for (UserVO vo: database)
			if (vo.getType() == UserType.MARKETER)
				marketers.add(vo);
		return marketers;
	}

	@Override
	public UserVO get(int ID) {
		for (UserVO vo: database)
			if (vo.getID() == ID)
				return vo;
		return null;
	}

	@Override
	public boolean isUsed(String account) {
		if (account == null)
			return false;
		for (UserVO vo: database)
			if (account.equals(vo.getAccount()))
				return true;
		return false;
	}

	@Override
	public ResultMessage addCreditRecord(CreditVO creditVO) {
		return null;
	}

	@Override
	public ResultMessage login(String account, String password) {
		UserVO vo;
		String md5 = Encryption.encrypt(password);
		try {
			int id = Integer.parseInt(account);
			vo = get(id);
		} catch (NumberFormatException e) {
			vo = get(account);
		}
		if (vo == null)
			return ResultMessage.NOT_EXIST;
		if (!vo.getPassword().equals(md5))
			return ResultMessage.FAIL;
		if (logged.contains((Integer)vo.getID()))
			return ResultMessage.LOGGED;
		logged.add((Integer)vo.getID());
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage logout(int id) {
		logged.remove((Integer)id);
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage changePassword(int id, String oldPW, String newPW) {
		UserVO user = get(id);
		if (user == null)
			return ResultMessage.NOT_EXIST;
		if (!Encryption.encrypt(oldPW).equals(user.getPassword()))
			return ResultMessage.FAIL;
		user.setPassword(newPW);
		update(user);
		return ResultMessage.SUCCESS;
	}


	
}
