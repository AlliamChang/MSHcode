package blservice.order;

import vo.OrderVO;

import java.util.List;

import tools.Date;
import tools.ResultMessage;

public interface OrderBLService {

	/**
	 * 创建订单
	 * @param 创建订单所需的信息VO
	 * @return 创建好的OrderVO
	 */
	public OrderVO createOrder( OrderVO order);

	/**
	 * 得到酒店的当天订单
	 * @param hotelId
	 * @param hotelName
	 * @return 酒店当天订单的List
	 */
	public List<OrderVO> getTodayHotelOrder(int hotelId,String hotel);
	
	/**
	 * 得到酒店的所有订单
	 * @param hotelId
	 * @param hotelName
	 * @return 酒店所有订单的List
	 */
	public List<OrderVO> getAllHotelOrder(int hotelId,String hotel);

	/**
	 * 得到用户的所有订单
	 * @param userID
	 * @param userAccount
	 * @return 所找用户的所有订单的List，若没找到该用户则返回null
	 */
	public List<OrderVO> getUserOrder(int userID, String userAccount);
	
	/**
	 * 得到所有异常订单
	 * @return 所有异常 订单的List
	 */
	public List<OrderVO> getAbnormityOrder();
	
	/**
	 * 得到当天未执行订单
	 * @return 当天未执行订单的List
	 */
	public List<OrderVO> getTodayUnexecutedOrder();

	/**
	 * 查找某一订单
	 * @param id
	 * @return 如果找到该订单则返回订单的VO，若找不到，则返回null
	 */
	public OrderVO search(long id);

	/**
	 * 执行订单
	 * @param orderID
	 * @param executeTime 执行的时间(格式要yyyy/mm/dd hh:mm:ss)
	 * @return 执行结果
	 */
	public ResultMessage execute(long orderID, Date executeTime);

	/**
	 * 延期订单
	 * @param orderID
	 * @param delayDate
	 * @return 执行结果
	 */
	public ResultMessage delayAbnormity(long orderID,Date delayDate);

	/**
	 * 撤销订单
	 * @param orderID
	 * @return 执行结果
	 */
	public ResultMessage cancel(long orderID);

	/**
	 * 撤销异常订单
	 * @param orderID
	 * @param isReturnAll 是否返回所有信用值
	 * @return 执行结果
	 */
	public ResultMessage cancelAbnormity(long orderID,boolean isReturnAll);
	
	
	/**
	 * 订单退房
	 * @param orderID
	 * @param checkoutTime 退房时间
	 * @return 执行结果
	 */
	public ResultMessage checkout(long orderID,Date checkoutTime);
	
	/**
	 * 订单评价
	 * @param orderID
	 * @return 执行结果
	 */
	public ResultMessage evaluate(long orderID);
}
