package bl.user_bl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import blservice.user_blservice.UserBLService;
import po.CreditPO;
import po.UserPO;
import dao.user_dao.*;
import data_stub.CreditRecordsDAO_Stub;
import data_stub.HistoryDAO_Stub;
import data_stub.UserDAOStub;
import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;

public class UserBLServiceImpl implements UserBLService{
	private UserDAO ud;
	private CreditRecordsDAO crd;
	private HistorDAO hd;

	public UserBLServiceImpl(){
		ud = new UserDAOStub();
		crd = new CreditRecordsDAO_Stub();
		hd = new HistoryDAO_Stub();
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
			UserPO temp = ud.get(ID);
			return null == temp ? null : new UserVO(ud.get(ID));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserVO get(String account) {
		try {
			UserPO result = ud.get(account);
			return null == result ? null : new UserVO(ud.get(account));
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int add(UserVO userVO) {
		try {
			return ud.add(userVO.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public ResultMessage modify(UserVO userVO) {
		try {
			return ud.modify(userVO.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage delete(int ID) {
		try {
			return ud.delete(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public List<CreditVO> getCredit(int ID) {
		try {
			return crd.getRecords(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> getReservationHistory(int ID) {
		try {
			return hd.getHistory(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultMessage updateCredit(int ID, int val) {
		try {
			UserPO po = ud.get(ID);
			if (null == po)
				return ResultMessage.NOT_EXIST;
			po.setCredit(po.getCredit() + val);
			po.setLevel(updateLevel(po.getCredit()));
			ud.modify(po);
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public int updateLevel(int credit) {
		return credit / 1000 > 0 ? credit / 1000 : 1;
	}
	
	@Override
	public ResultMessage addCreditRecord(int ID, CreditVO creditVO) {
		try {
			return crd.addRecord(ID, new CreditPO(creditVO));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
}
