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

	public ResultMessage delete(int hotel_id);

	public ResultMessage modify(HotelInfoVO hotelinfo);
	
	public List<Integer> search(String province,String city,String tradeArea );

	public List<HotelInfoVO> search(String province, String city,String tradeArea,String name);

	public ResultMessage inputRoom(RoomVO room);

	public double CalRoomPrice(StrategyBLService strategy);
	
	public List<RoomVO> getRoom(int hotel_id);
	
	public List<String> getProvinces();
	
	public List<String> getCities(String province);
	
	public List<String> getAreas(String province, String city);
	
	public HotelInfoVO getHotel(int hotel_id);
	
	public List<EvaluateVO> getEvaluate(int hotel_id);


	}
		

