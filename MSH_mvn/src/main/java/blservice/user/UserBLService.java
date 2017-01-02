package blservice.user;

import java.util.List;

import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;

public interface UserBLService {
	
	/**
	 * 获取全部网站营销人员。
	 * @return
	 */
	public List<UserVO> getAllMarketers();

	/**
	 * 通过ID获取用户VO，若不存在返回null。
	 * @param ID
	 * @return
	 */
	public UserVO get(int ID);
	
	/**
	 * 通过账号获取用户VO，若不存在返回null。
	 * @param account
	 * @return
	 */
	public UserVO get(String account);

	/**
	 * 新增用户
	 * @param userVO
	 * @return 系统为新增用户分配的ID，若添加失败返回-1。
	 */
	public int add(UserVO userVO);
	
	/**
	 * 检查账号是否已被注册。
	 * @param account
	 * @return
	 */
	public boolean isUsed(String account);

	/**
	 * 更新用户信息。
	 * @param userVO
	 * @return
	 */
	public ResultMessage update(UserVO userVO);

	/**
	 * 删除用户。
	 * @param ID
	 * @return
	 */
	public ResultMessage delete(int ID);
	
	/**
	 * 通过该ID获得该用户的信用记录。
	 * @param ID
	 * @return
	 */
	public List<CreditVO> getCreditRecords(int ID);
	
	/**
	 * 增加信用记录，系统自动更新用户信用值。
	 * @param ID
	 * @param creditVO
	 * @return
	 */
	public ResultMessage addCreditRecord(CreditVO creditVO);
	
	/**
	 * 登录，用户不存在返回{@link tools.ResultMessage#NOT_EXIST}，密码错误返回{@link tools.ResultMessage#FAIL}，登录成功返回{@link tools.ResultMessage#SUCCESS}，已登录返回{@link tools.ResultMessage#LOGGED}。
	 * @param account ID或账号
	 * @param password 密码
	 * @return
	 */
	public ResultMessage login(String account, String password);
	
	public ResultMessage logout(int id);
	
	public ResultMessage changePassword(int id, String oldPW, String newPW);
}
