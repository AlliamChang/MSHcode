package bl.user_bl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import blservice.user_blservice.UserBLService;
import po.userPO.UserPO;
import dao.user_dao.*;
import data_stub.CreditRecordsDAO_Stub;
import data_stub.HistoryDAO_Stub;
import data_stub.UserDAOStub;
import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;

public class UserBLServiceImpl implements UserBLService{
	private UserDAO uds;
	private CreditRecordsDAO crds;
	private HistorDAO hds;

	public UserBLServiceImpl(){
		uds = new UserDAOStub();
		crds = new CreditRecordsDAO_Stub();
		hds = new HistoryDAO_Stub();
	}
	
	@Override
	public List<UserVO> getAllMarketers() {
		try {
			List<UserPO> list = uds.getAllMarketers();
			List<UserVO> ret = new ArrayList<UserVO>();
			for (UserPO po: list)
				ret.add(po.toVO());
			return ret;
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserVO get(int ID) {
		try {
			UserPO temp = uds.get(ID);
			return null == temp ? null : uds.get(ID).toVO();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserVO get(String account) {
		try {
			UserPO result = uds.get(account);
			return null == result ? null : uds.get(account).toVO();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int add(UserVO userVO) {
		try {
			return uds.add(new UserPO(userVO));
		} catch (RemoteException e) {
			e.printStackTrace();
			return -1;
		}
	}

	@Override
	public ResultMessage modify(UserVO userVO) {
		try {
			return uds.modify(new UserPO(userVO));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage delete(int ID) {
		try {
			return uds.delete(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public List<CreditVO> getCredit(int ID) {
		try {
			return crds.getRecords(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> getReservationHistory(int ID) {
		try {
			return hds.getHistory(ID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

}
