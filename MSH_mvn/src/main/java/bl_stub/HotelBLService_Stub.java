package bl_stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

	@Override
	public List<String> getProvinces() {
		return Arrays.asList("北京", "江苏省", "山东省");
	}

	@Override
	public List<String> getCities(String province) {
		HashMap<String, ArrayList<String> > cityList = new HashMap<String, ArrayList<String> >(){
			{
				put("江苏省", new ArrayList<String>(Arrays.asList("南京市", "无锡市")));
				put("山东省", new ArrayList<String>(Arrays.asList("济南市", "潍坊市")));
			}
		};
		return cityList.get(province);
	}

	@Override
	public List<String> getAreas(String province, String city) {
		HashMap<String, ArrayList<String> > areaList = new HashMap<String, ArrayList<String> >(){
			{
				put("江苏省南京市", new ArrayList<String>(Arrays.asList("栖霞区", "鼓楼区")));
				put("山东省济南市", new ArrayList<String>(Arrays.asList("市中区", "历下区")));
				put("北京", new ArrayList<String>(Arrays.asList("朝阳区", "西城区")));
			}
		};
		return areaList.get(province + (city == null ? "" : city));
	}

}
