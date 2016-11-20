package bl_stub;

import java.util.ArrayList;

import tools.ResultMessage;
import vo.HotelVO;
import blservice.hotel_blservice.HotelBLService;
import blservice.strategy_blservice.StrategyBLService;

public class HotelBLService_Stub implements HotelBLService {

	public ResultMessage add(String hotel_id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage delete(String hotel_id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage modify(String hotel_id, String hotel_item, String input) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public HotelVO browse(ArrayList<HotelVO> hotelList) {
		// TODO Auto-generated method stub
		return new HotelVO();
	}

	public ArrayList<HotelVO> search(String address, String tradeArea) {
		// TODO Auto-generated method stub
		return new ArrayList<HotelVO>();
	}

	public ResultMessage update(String id) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public ResultMessage inputRoom(String type, double price) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	public double CalRoomPrice(StrategyBLService strategy) {
		// TODO Auto-generated method stub
		return 0.0;
	}

}
