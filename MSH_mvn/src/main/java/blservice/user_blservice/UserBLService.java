package blservice.user_blservice;

import java.util.List;

import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;

public interface UserBLService {
	
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
	
	public ResultMessage addCreditRecord(int ID, CreditVO creditVO);
	
	/**
	 * 更改信用值，包括增加、减少、返还
	 * @param ID 用户ID
	 * @param val 改变值
	 * @return 执行结果
	 */
	public ResultMessage updateCredit(int ID, int val);
	
	public List<String> getReservationHistory(int ID);
}
