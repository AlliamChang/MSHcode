package bl.order_bl;

import java.util.List;

import blservice.order_blservice.OrderBLService;
import tools.Date;
import tools.ResultMessage;
import vo.OrderVO;

public class OrderBL implements OrderBLService{

	@Override
	public OrderVO createOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getTodayHotelOrder(long hotelId, String hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getAllHotelOrder(long hotelId, String hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getUserOrder(long userID, String userAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO search(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage execute(long orderID, Date executeTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delayAbnormity(long orderID, Date delayDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage cancel(long orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage cancelAbnormity(long orderID) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
