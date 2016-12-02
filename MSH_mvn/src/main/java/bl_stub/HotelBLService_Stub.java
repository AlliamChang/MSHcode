package bl_stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tools.BedStyle;
import tools.ResultMessage;
import vo.HotelVO;
import vo.RoomVO;
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
	
	public List<RoomVO> getRoom(){
		return Arrays.asList(new RoomVO("大床房", BedStyle.DOUBLE_BEDS, 589, 0, 0),
				new RoomVO("单人房",BedStyle.BUNK_BED,489,0,0),
				new RoomVO("钟点房",BedStyle.BUNK_BED,280,0,0));
	}

}
