package bl_driver;

import java.util.List;

import blservice.order_blservice.OrderBLService;
import tools.Date;
import tools.OrderState;
import tools.ResultMessage;
import vo.HotelVO;
import vo.OrderVO;
import vo.UserVO;

public class Order_Driver {
	public void drive(OrderBLService orderService) {
		String[] booker = { "֣����", "֣���" };
		String[] phone = { "12345678910", "10987654321" };
		Date day = new Date("2016/11/25",false);
		OrderState state = OrderState.UNEXECUTED;
		ResultMessage result = null;

		OrderVO order = new OrderVO(1000000001,"Aven", "hotel", "big", 1, booker, phone,
				1, day, state);
		if (result.SUCCESS == orderService.execute(order))
			System.out.println("success");
		if (result.SUCCESS == orderService.cancel(order))
			System.out.println("success");

		order.setState(state.ABNORMITY);
		if (result.SUCCESS == orderService.executeAbnormity(order))
			System.out.println("success");
		if (result.SUCCESS == orderService.cancelAbnormity(order))
			System.out.println("success");

		HotelVO hotel = new HotelVO();
		UserVO user = new UserVO(null, null, null, 0, 0);
		if (orderService.createOrder(user, hotel, order).getPrice() == 300.0)
			System.out.println("success");

		List<OrderVO> list = orderService.getUserOrder(user);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId());
		}

		list = orderService.getTodayHotelOrder(10000,"七天");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getId());
		}
	}
}
