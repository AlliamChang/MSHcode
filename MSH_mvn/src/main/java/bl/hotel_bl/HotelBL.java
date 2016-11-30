package bl.hotel_bl;
import java.util.ArrayList;

import tools.ResultMessage;
import vo.HotelVO;
import blservice.hotel_blservice.*;
import blservice.strategy_blservice.StrategyBLService;
public class HotelBL implements HotelBLService{

	@Override
	public ResultMessage add(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(String hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(String hotel_id, String hotel_item, String input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelVO browse(ArrayList<HotelVO> hotelList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelVO> search(String address, String tradeArea) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage update(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage inputRoom(String type, double price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double CalRoomPrice(StrategyBLService strategy) {
		// TODO Auto-generated method stub
		return 0;
	}

}
