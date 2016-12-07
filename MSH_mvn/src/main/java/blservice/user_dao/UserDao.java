package blservice.user_dao;

import java.util.List;

import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;

public interface UserDao {
	
	public List<UserVO> getAllMarketers();

	public UserVO get(int ID);
	
	public UserVO get(String account);

	/**
	 * 新增用户
	 * @param userVO
	 * @return 系统为新增用户分配的ID，若添加失败返回-1。
	 */
	public int add(UserVO userVO);

	public ResultMessage modify(UserVO userVO);

	public ResultMessage delete(int ID);
	
	public List<CreditVO> getCredit(int ID);
	
	public List<String> getReservationHistory(int ID);
}
