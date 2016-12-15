package bl_stub;

import java.util.Arrays;
import java.util.List;

import blservice.order_blservice.OrderBLService;
import tools.Date;
import tools.OrderState;
import tools.ResultMessage;
import vo.OrderVO;
import vo.UserVO;

public class Order_Stub implements OrderBLService {

	private ResultMessage result;

	public Order_Stub() {

	}

	/*public OrderVO createOrder(UserVO user, HotelVO hotel, OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}*/

//	public List<OrderVO> getHotelOrder(HotelVO hotel) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public List<OrderVO> getUserOrder(UserVO user) {
		// TODO Auto-generated method stub
		return Arrays.asList(
				new OrderVO(1000000001, 1, "aven", 0, "七天", "大床房", 1, new String[]{"刘钦"},
						new String[]{"12345678910"},3,
						new Date("2016/11/22",false), 0, null, null, false, 0, OrderState.UNEXECUTED,false),
				new OrderVO(1000000002, 2, "aven", 0, "七天", "大床房", 1, new String[]{"丁二玉"},
						new String[]{"12345678910"},2, 
						new Date("2016/11/03",false), 0, null, null, false, 0, OrderState.EXECUTED,false),
				new OrderVO(1000000013, 3, "aven", 0, "七天", "大床房", 1, new String[]{"张田田"},
						new String[]{"12345678910"},1, 
						new Date("2016/11/20",false), 0, null, null, false, 0, OrderState.ABNORMITY,false));
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
				new OrderVO(1000000001, 1, "aven", 0, "七天", "温暖大床房", 1, new String[]{"刘钦"},
						new String[]{"12345678910"},3,
						new Date("2016/11/22",false), 0, null, null, false, id, OrderState.UNEXECUTED,false));
	}

	
	public List<OrderVO> getAllHotelOrder(long id, String hotel) {
		// TODO Auto-generated method stub
		return Arrays.asList(
				new OrderVO(1000000001, 1,"aven", 0, "七天", "大床房", 1, new String[]{"刘钦"},
						new String[]{"12345678910"},3,
						new Date("2016/11/22",false), 0, null, null, false, id, OrderState.UNEXECUTED,false),
				new OrderVO(1000000002, 2,"aven", 0 , "七天", "大床房", 1, new String[]{"丁二玉"},
						new String[]{"12345678910"},2, 
						new Date("2016/11/03",false), OrderState.EXECUTED,false,new Date("2016/11/20 12:31:02",true)),
				new OrderVO(1000000013, 3,"aven", 0, "七天", "大床房", 1, new String[]{"张田田"},
						new String[]{"12345678910"},1, 
						new Date("2016/11/20",false), 0, null, null, false, id, OrderState.ABNORMITY,false),
				new OrderVO(1000000014, 4,"aven", 0, "七天", "大床房", 1, new String[]{"邵东"},
						new String[]{"12345678910"},1, 
						new Date("2016/12/01",false), 0, null, null, false, id, OrderState.CANCELED,false));
	}

	@Override
	public OrderVO createOrder(OrderVO order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getTodayHotelOrder(int hotelId, String hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getAllHotelOrder(int hotelId, String hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getUserOrder(int userID, String userAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getAbnormityOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderVO> getTodayUnexecutedOrder() {
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
	public ResultMessage cancelAbnormity(long orderID, boolean isReturnAll) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage checkout(long orderID, Date checkoutTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
