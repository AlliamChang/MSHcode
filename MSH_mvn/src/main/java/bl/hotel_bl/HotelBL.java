package bl.hotel_bl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.UserPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;
import data_stub.HotelDAOStub;
import blservice.hotel_blservice.*;
import blservice.strategy_blservice.StrategyBLService;
import tools.ResultMessage;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.RoomVO;
public class HotelBL implements HotelBLService{
	private HotelDAOStub hotel;
	
	public HotelBL(){
		hotel=new HotelDAOStub();
	}

	@Override
	public ResultMessage delete(int hotel_id) {
		try {
			return hotel.delete(hotel_id);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage modify(HotelInfoVO hotel) {
		try {
			return this.hotel.modify(new HotelPO(hotel.getAdress(),hotel.getTradingArea(),hotel.getCity(),hotel.getProvince(),hotel.getHotel(),hotel.getPhone(),hotel.getIntroduction(),hotel.getHotel_id(),hotel.getStar(),hotel.get_stuff_id(),hotel.getYear(),hotel.getScore(),hotel.getScul(),hotel.getFacility()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}


	@Override
	public ResultMessage inputRoom(RoomVO vo) {
		try {
			return hotel.addRoom(new RoomPO(vo.getRoomStyle(),vo.getBedStyle(),vo.getPrice(),vo.getNum(),vo.getid(),vo.getMaxCustomer()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public double CalRoomPrice(StrategyBLService strategy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<HotelInfoVO> search(String province, String city, String tradeArea,
			String name) {
		ArrayList<HotelInfoVO> ret=new ArrayList<HotelInfoVO>();
		try{
		List<HotelPO> list=hotel.get(province, city, tradeArea, name);
		for(int i=0;i<list.size();i++)
			ret.add(list.get(i).tovo());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ret;
		
	}

	@Override
	public List<RoomVO> getRoom(int hotel_id) {
		ArrayList<RoomVO> ret=new ArrayList<RoomVO>();
		try{
			List<RoomPO> list=hotel.getRoom(hotel_id);
			for(int i=0;i<list.size();i++)
				ret.add(list.get(i).tovo());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<String> getProvinces() {
		try{
			return hotel.getProvinces();
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> getCities(String province) {
		try{
			return hotel.getCities(province);
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> getAreas(String province, String city) {
		try{
			return hotel.getAreas(province, city);
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public HotelInfoVO getHotel(int hotel_id) {
		try{
		return hotel.find(hotel_id).tovo();
		}catch (RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EvaluateVO> getEvaluate(int hotel_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage add(HotelInfoVO hotel) {
		try {
			return this.hotel.add(new HotelPO(hotel.getAdress(),hotel.getTradingArea(),hotel.getCity(),hotel.getProvince(),hotel.getHotel(),hotel.getPhone(),hotel.getIntroduction(),hotel.getHotel_id(),hotel.getStar(),hotel.get_stuff_id(),hotel.getYear(),hotel.getScore(),hotel.getScul(),hotel.getFacility()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public List<Integer> search(String province, String city, String tradeArea) {
		// TODO Auto-generated method stub
		return null;
	}

}
