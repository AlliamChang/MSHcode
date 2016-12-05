package bl.user_bl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.userPO.UserPO;
import data_stub.CreditRecordsDataService_Stub;
import data_stub.HistoryDataService_Stub;
import data_stub.UserDataService_Stub;
import dataservice.user_dataservice.*;
import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;
import blservice.user_blservice.UserBLService;

public class UserBL implements UserBLService{
	private UserDataService uds;
	private CreditRecordsDataService crds;
	private HistoryDataService hds;

	public UserBL(){
		uds = new UserDataService_Stub();
		crds = new CreditRecordsDataService_Stub();
		hds = new HistoryDataService_Stub();
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
			return uds.get(ID).toVO();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public UserVO get(String name) {
		try {
			return uds.get(name).toVO();
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
