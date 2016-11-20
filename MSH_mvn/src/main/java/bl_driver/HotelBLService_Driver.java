package bl_driver;

import tools.ResultMessage;
import vo.HotelVO;
import bl.strategy_bl.StrategyBL;
import blservice.hotel_blservice.*;
import blservice.strategy_blservice.StrategyBLService;

import java.util.ArrayList;

public class HotelBLService_Driver {
	public void drive(HotelBLService hotelBLService) {
		StrategyBLService strategy = new StrategyBL();
		ResultMessage result1 = hotelBLService.add("123");
		if (result1 == ResultMessage.EXIST)
			System.out.println("hotel EXISTs");
		else
			System.out.println("hotel does not EXIST");

		ResultMessage result2 = hotelBLService.delete("123");
		if (result2 == ResultMessage.EXIST)
			System.out.println("hotel EXISTs");
		else
			System.out.println("hotel does not EXIST");

		ResultMessage result3 = hotelBLService.modify("123", "南京", "上海");
		if (result3 == ResultMessage.EXIST)
			System.out.println("hotel EXISTs");
		else
			System.out.println("hotel does not EXIST");

		HotelVO v1 = hotelBLService.browse(new ArrayList<HotelVO>());
		if (v1.equals(new HotelVO()))
			System.out.println("browse succeed");
		else
			System.out.println("browse fail");

		ArrayList<HotelVO> hotellist = hotelBLService.search("NanJing",
				"XianLin");
		if (true)
			System.out.println("Search succeed");
		else
			System.out.println("Search fail");

		ResultMessage result4 = hotelBLService.update("123");
		if (result4 == ResultMessage.EXIST)
			System.out.println("update succeed");
		else
			System.out.println("update fail");

		ResultMessage result5 = hotelBLService.inputRoom("double", 110);
		if (result5 == ResultMessage.EXIST)
			System.out.println("input succeed");
		else
			System.out.println("input fail");

		if (hotelBLService.CalRoomPrice(strategy) == 120)
			System.out.println("cal succeed");
		else
			System.out.println("cal fail");
	}
}
