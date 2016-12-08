package blservice.order_blservice;

import vo.OrderVO;

import java.util.List;

import vo.HotelVO;
import vo.UserVO;
import tools.Date;
import tools.ResultMessage;

public interface OrderBLService {

	public OrderVO createOrder( OrderVO order);

	public List<OrderVO> getTodayHotelOrder(long hotelId,String hotel);
	
	public List<OrderVO> getAllHotelOrder(long hotelId,String hotel);

	public List<OrderVO> getUserOrder(long userID, String userAccount);

	public OrderVO search(long id);

	public ResultMessage execute(long orderID, Date executeTime);

	public ResultMessage delayAbnormity(long orderID,Date delayDate);

	public ResultMessage cancel(long orderID);

	public ResultMessage cancelAbnormity(long orderID);
}
