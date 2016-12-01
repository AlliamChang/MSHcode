package blservice.user_blservice;

import java.util.ArrayList;
import java.util.List;

import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;

public interface UserBLService {

	public ArrayList<UserVO> getAll();
	
	public ArrayList<UserVO> getAllMarketers();

	public UserVO get(String name);

	public ResultMessage add(UserVO userVO);

	public ResultMessage modify(UserVO userVO);

	public ResultMessage delete(int id);
	
	public List<CreditVO> getCredit();
}
