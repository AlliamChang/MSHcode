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

	public ResultMessage update(UserVO userVO);

	public ResultMessage delete(int ID);
	
	public List<CreditVO> getCreditRecords(int ID);
	
	/**
	 * 增加信用记录，系统自动更新用户信用值和会员等级
	 * @param ID
	 * @param creditVO
	 * @return
	 */
	public ResultMessage addCreditRecord(CreditVO creditVO);
	
	public ResultMessage login(String account, String password);
	
	public ResultMessage logout(int id);
	
}
