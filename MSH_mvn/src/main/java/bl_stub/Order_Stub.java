package bl_stub;

import java.util.List;

import blservice.order_blservice.OrderBLService;
import tools.ResultMessage;
import vo.HotelVO;
import vo.OrderVO;
import vo.UserVO;

public class Order_Stub implements OrderBLService {

	private ResultMessage result;

	public Order_Stub() {

	}

	public OrderVO createOrder(UserVO user, HotelVO hotel, OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> getHotelOrder(HotelVO hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderVO> getUserOrder(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderVO search(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage execute(OrderVO order) {
		// TODO Auto-generated method stub
		return result.SUCCESS;
	}

	public ResultMessage executeAbnormity(OrderVO order) {
		// TODO Auto-generated method stub
		return result.SUCCESS;
	}

	public ResultMessage cancel(OrderVO order) {
		// TODO Auto-generated method stub
		return result.SUCCESS;
	}

	public ResultMessage cancelAbnormity(OrderVO order) {
		// TODO Auto-generated method stub
		return result.SUCCESS;
	}

}
