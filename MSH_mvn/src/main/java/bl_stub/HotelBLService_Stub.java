package bl_stub;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import blservice.hotel_blservice.HotelBLService;
import blservice.strategy_blservice.StrategyBLService;
import javafx.scene.image.Image;
import tools.BedStyle;
import tools.ResultMessage;
import ui.customer.PersonInfoPane;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.HotelVO;
import vo.RoomVO;

public class HotelBLService_Stub implements HotelBLService {

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

	public List<String> search(String address, String tradeArea) {
		// TODO Auto-generated method stub
		return Arrays.asList("渡口客栈","青年旅馆");
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

	@Override
	public List<RoomVO> getRoom(String id) {
		// TODO Auto-generated method stub
		return Arrays.asList(new RoomVO("大床房", BedStyle.DOUBLE_BEDS, 589, 0, 0),
				new RoomVO("单人房",BedStyle.BUNK_BED,489,0,0),
				new RoomVO("钟点房",BedStyle.BUNK_BED,280,0,0));
	}


	public HotelInfoVO getHotel(String hotel_id) {
		// TODO Auto-generated method stub
		Image image=new Image(PersonInfoPane.class.getResource("/image/hotel.jpg").toExternalForm(),
				100,100,false,false);
		return new HotelInfoVO("青年旅馆", "南京市中山南路10号", "8008208820", null, "简介", "江苏省", "鼓楼区", 0,image,4,4.5,1,2);
	}

	@Override
	public List<HotelInfoVO> search(String province, String city, String tradeArea,
			String name) {
		return Arrays.asList(new HotelInfoVO("青年旅馆", "南京市中山南路10号", "8008208820", null, "简介", "江苏省", "鼓楼区", 0,null,4,4.5,1,2),
				new HotelInfoVO("如家快捷酒店", "南京市中山南路10号", "123456789", null, "简介", "江苏省", "鼓楼区", 0,null,4,4.5,1, 1));
	}

	@Override
	public List<EvaluateVO> getEvaluate(String hotel_id) {
		// TODO Auto-generated method stub
		return  Arrays.asList(new EvaluateVO("环境很不错，交通很方便，价格也挺合适，体验不错","Aven","2016/11/01,14:35",4.8),
				new EvaluateVO("房间很干净舒适,设施也很完善","晓风残月","2016/11/01,14:32",4.9));
	}

	@Override
	public ResultMessage add(HotelInfoVO hotel) {
		// TODO Auto-generated method stub
		return null;
	}

}
