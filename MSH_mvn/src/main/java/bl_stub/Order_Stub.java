package bl_stub;

import java.util.Arrays;
import java.util.List;

import blservice.order_blservice.OrderBLService;
import tools.Date;
import tools.OrderState;
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

//	public List<OrderVO> getHotelOrder(HotelVO hotel) {
//		// TODO Auto-generated method stub
//		return null;
//	}

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

	public List<OrderVO> getTodayHotelOrder(long id, String hotel) {
		// TODO Auto-generated method stub
		return Arrays.asList(
				new OrderVO(1000000001, "aven", "七天", "大床房", 1, new String[]{"刘钦"},
						new String[]{"12345678910"},3,
						new Date("2016/11/22",false), OrderState.UNEXECUTED));
	}

	public List<OrderVO> getAllHotelOrder(long id, String hotel) {
		// TODO Auto-generated method stub
		return Arrays.asList(
				new OrderVO(1000000001, "aven", "七天", "大床房", 1, new String[]{"刘钦"},
						new String[]{"12345678910"},3,
						new Date("2016/11/22",false), OrderState.UNEXECUTED),
				new OrderVO(1000000002, "aven", "七天", "大床房", 1, new String[]{"丁二玉"},
						new String[]{"12345678910"},2, 
						new Date("2016/11/03",false), OrderState.EXECUTED),
				new OrderVO(1000000013, "aven", "七天", "大床房", 1, new String[]{"张田田"},
						new String[]{"12345678910"},1, 
						new Date("2016/11/20",false), OrderState.ABNORMITY));
	}

}
