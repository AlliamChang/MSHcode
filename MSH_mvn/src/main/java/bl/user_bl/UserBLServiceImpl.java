package bl.user_bl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import blservice.user_blservice.UserBLService;
import dao.user.*;
import po.CreditPO;
import po.UserPO;
import rmi.RemoteHelper;
import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;

public class UserBLServiceImpl implements UserBLService{
	private UserDAO ud;
	private CreditRecordsDAO crd;
	private RemoteHelper helper;

	public UserBLServiceImpl(){
		helper = RemoteHelper.getInstance();
		ud = helper.getUserDAO();
		crd = helper.getCreditRecordsDAO();
	}
	
	@Override
	public List<UserVO> getAllMarketers() {
		try {
			List<UserPO> list = ud.getAllMarketers();
			List<UserVO> ret = new ArrayList<UserVO>();
			for (UserPO po: list)
				ret.add(new UserVO(po));
			return ret;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserVO get(int ID) {
		try {
			UserPO temp = ud.getUser(ID);
			return null == temp ? null : new UserVO(temp);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserVO get(String account) {
		try {
			UserPO temp = ud.getUser(account);
			return null == temp ? null : new UserVO(temp);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int add(UserVO userVO) {
		try {
			return ud.addUser(userVO.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public ResultMessage update(UserVO userVO) {
		try {
			return ud.updateUser(userVO.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage delete(int ID) {
		try {
			return ud.deleteUser(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public List<CreditVO> getCreditRecords(int ID) {
		try {
			List<CreditPO> temp = crd.getRecords(ID);
			ArrayList<CreditVO> ret = new ArrayList<CreditVO>();
			for (CreditPO po: temp)
				ret.add(new CreditVO(po));
			return ret;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	private int updateLevel(int credit) {
		return credit / 1000 > 0 ? credit / 1000 : 1;
	}
	
	@Override
	public ResultMessage addCreditRecord(CreditVO creditVO) {
		try {
			crd.createRecord(creditVO.toPO());
			UserPO userPO = ud.getUser(creditVO.getUser_id());
			userPO.setCredit(userPO.getCredit() + creditVO.getChangeValue());
			userPO.setLevel(updateLevel(userPO.getCredit()));
			ud.updateUser(userPO);
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage login(String account, String password) {
		try {
			return ud.login(account, password);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage logout(int id) {
		try {
			return ud.logout(id);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public boolean isUsed(String account) {
		try {
			if (ud.getUser(account) == null)
				return false;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
	}

}
