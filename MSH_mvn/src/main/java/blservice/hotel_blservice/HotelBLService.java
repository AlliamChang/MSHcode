package blservice.hotel_blservice;

import java.util.ArrayList;

import blservice.strategy_blservice.StrategyBLService;
import vo.HotelVO;
import tools.ResultMessage;

public interface HotelBLService {
	public ResultMessage add(String hotel_id);

	public ResultMessage delete(String hotel_id);

	public ResultMessage modify(String hotel_id, String hotel_item, String input);

	public HotelVO browse(ArrayList<HotelVO> hotelList);

	public ArrayList<HotelVO> search(String address, String tradeArea);

	public ResultMessage update(String id);

	public ResultMessage inputRoom(String type, double price);

	public double CalRoomPrice(StrategyBLService strategy);
}
