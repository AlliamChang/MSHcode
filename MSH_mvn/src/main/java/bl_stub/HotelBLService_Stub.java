package bl_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import blservice.hotel_blservice.HotelBLService;
import blservice.strategy_blservice.StrategyBLService;
import dao.hotel.HotelDAO;
import javafx.scene.image.Image;
import rmi.RemoteHelper;
import tools.BedStyle;
import tools.ResultMessage;
import ui.customer.PersonInfoPane;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.RoomVO;

public class HotelBLService_Stub implements HotelBLService {
	private HotelDAO dao;
	private RemoteHelper helper;

	public HotelBLService_Stub(){
		helper = RemoteHelper.getInstance();
		dao = helper.getHotelDAO();
	}
	
	public List<String> search(String address, String tradeArea) {
		// TODO Auto-generated method stub
		return Arrays.asList("渡口客栈","青年旅馆");
	}


	@Override
	public List<String> getProvinces() {
		try {
			return dao.getProvinces();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> getCities(String province) {
		try {
			return dao.getCities(province);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> getAreas(String province, String city) {
		try {
			return dao.getAreas(province, city);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<RoomVO> getRoom(int id) {
		// TODO Auto-generated method stub
		return Arrays.asList(new RoomVO("大床房", BedStyle.DOUBLE_BEDS, 589, 0, 0,1),
				new RoomVO("单人房",BedStyle.BUNK_BED,489,0,0,1),
				new RoomVO("钟点房",BedStyle.BUNK_BED,280,0,0,1));
	}


	public HotelInfoVO getHotel(String hotel_id) {
		// TODO Auto-generated method stub
		Image image=new Image(PersonInfoPane.class.getResource("/image/hotel.jpg").toExternalForm(),
				100,100,false,false);
		return new HotelInfoVO("青年旅馆", "南京市中山南路10号", "8008208820", null, "简介", "江苏省", "鼓楼区", 0,image,4,4.5,1,2,"南京市");
	}

	@Override
	public List<HotelInfoVO> search(String province, String city, String tradeArea,
			String name) {
		return Arrays.asList(new HotelInfoVO("青年旅馆", "南京市中山南路10号", "8008208820", null, "简介", "江苏省", "鼓楼区", 0,null,4,4.5,1,2,"南京市"),
				new HotelInfoVO("如家快捷酒店", "南京市中山南路10号", "123456789", null, "简介", "江苏省", "鼓楼区", 0,null,4,4.5,1, 1,"南京市"));
	}

	@Override
	public List<EvaluateVO> getEvaluate(int hotel_id) {
		// TODO Auto-generated method stub
		return  Arrays.asList(new EvaluateVO("环境很不错，交通很方便，价格也挺合适，体验不错","Aven",1,"2016/11/01,14:35",4.8),
				new EvaluateVO("房间很干净舒适,设施也很完善","晓风残月",1,"2016/11/01,14:32",4.9));
	}

	@Override
	public ResultMessage add(HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delete(int hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modify(HotelInfoVO hotelinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage inputRoom(RoomVO room) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelInfoVO getHotel(int hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Integer> search(String province, String city, String tradeArea) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HotelInfoVO> sortByHighPrice(List<HotelInfoVO> list) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HotelInfoVO> sortByHighStar(List<HotelInfoVO> list) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HotelInfoVO> sortByHighScore(List<HotelInfoVO> list) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HotelInfoVO> sortByLowPrice(List<HotelInfoVO> list) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HotelInfoVO> sortByLowStar(List<HotelInfoVO> list) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HotelInfoVO> sortByLowScore(List<HotelInfoVO> list) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HotelInfoVO> historyHotel(List<HotelInfoVO> list) {
		// TODO Auto-generated method stub
		return null;
	}

}
