package blservice.hotel_blservice;

import java.util.ArrayList;
import java.util.List;

import blservice.strategy_blservice.StrategyBLService;
import javafx.scene.image.Image;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.RoomVO;
import tools.ResultMessage;

public interface HotelBLService {
	//添加酒店
	public ResultMessage add(HotelInfoVO hotel);
	//删除酒店
	public ResultMessage delete(int hotel_id);
	//修改酒店信息
	public ResultMessage modify(HotelInfoVO hotelinfo);
	//搜索
	public List<HotelInfoVO> search(String province,String city,String area,String name,String enter_time,String out_time,String price,String score,int star );
	//
	public List<HotelInfoVO> search(String province, String city,String tradeArea,String name);
	//录入客房
	public ResultMessage inputRoom(RoomVO room);
	//得到房间列表
	public List<RoomVO> getRoom(int hotel_id);
	//得到所有省份
	public List<String> getProvinces();
	//得到对应省份的城市
	public List<String> getCities(String province);
	//得到对应城市的商圈
	public List<String> getAreas(String province, String city);
	//得到酒店信息
	public HotelInfoVO getHotel(int hotel_id);
	//得到酒店的评价列表
	public List<EvaluateVO> getEvaluate(int hotel_id);
	//按照价格由高到低排序
	public List<HotelInfoVO> sortByHighPrice(List<HotelInfoVO> list);
	//按照价格由低到高排序
	public List<HotelInfoVO> sortByLowPrice(List<HotelInfoVO> list);
	//按照星级由高到低排序
	public List<HotelInfoVO> sortByHighStar(List<HotelInfoVO>list);
	//按照星级由低到高排序
	public List<HotelInfoVO> sortByLowStar(List<HotelInfoVO> list);
	//按照评分由高到低排序
	public List<HotelInfoVO> sortByHighScore(List<HotelInfoVO>list);
	//按照评分由低到高排序
	public List<HotelInfoVO> sortByLowScore(List<HotelInfoVO> list);
	//历史酒店
	public List<HotelInfoVO> historyHotel(List<HotelInfoVO>list);

	}
		

