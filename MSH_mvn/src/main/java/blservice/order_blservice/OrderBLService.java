package blservice.order_blservice;

import vo.OrderVO;

import java.util.List;

import vo.HotelVO;
import vo.UserVO;
import tools.ResultMessage;

public interface OrderBLService {
	
	public OrderVO createOrder(UserVO user,HotelVO hotel,OrderVO order);
	
	public List<OrderVO> getHotelOrder(HotelVO hotel);
	
	public List<OrderVO> getUserOrder(UserVO user);
	
	public OrderVO search(long id);
	
	public ResultMessage execute(OrderVO order);
	
	public ResultMessage executeAbnormity(OrderVO order);
	
	public ResultMessage cancel(OrderVO order);
	
	public ResultMessage cancelAbnormity(OrderVO order);
}
