package blservice.hotel_blservice;

import java.util.ArrayList;
import java.util.List;

import blservice.strategy_blservice.StrategyBLService;
import javafx.scene.image.Image;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.HotelVO;
import vo.RoomVO;
import tools.ResultMessage;

public interface HotelBLService {
	public ResultMessage add(HotelInfoVO hotel);

	public ResultMessage delete(String hotel_id);

	public ResultMessage modify(String hotel_id, String hotel_item, String input);

	public HotelVO browse(ArrayList<HotelVO> hotelList);
	
	public List<String> search(String province,String city );

	public List<HotelInfoVO> search(String province, String city,String tradeArea,String name);

	public ResultMessage update(String id);

	public ResultMessage inputRoom(String type, double price);

	public double CalRoomPrice(StrategyBLService strategy);
	
	public List<RoomVO> getRoom(String hotel_id);
	
	public List<String> getProvinces();
	
	public List<String> getCities(String province);
	
	public List<String> getAreas(String province, String city);
	
	public HotelInfoVO getHotel(String hotel_id);
	
	public List<EvaluateVO> getEvaluate(String hotel_id);
	}
		

