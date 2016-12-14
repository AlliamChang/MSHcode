package bl.hotel_bl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import po.UserPO;
import po.hotelPO.HotelPO;
import po.hotelPO.RoomPO;
import data_stub.HotelDAOStub;
import bl.user_bl.UserBLServiceImpl;
import blservice.hotel_blservice.*;
import blservice.strategy_blservice.StrategyBLService;
import tools.ResultMessage;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.RoomVO;
public class HotelBL implements HotelBLService{
	private HotelDAOStub hotel;
	private UserBLServiceImpl user;
	public HotelBL(){
		hotel=new HotelDAOStub();
		user=new UserBLServiceImpl();
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
//由高到低
	@Override
	public List<HotelInfoVO> sortByHighPrice(List<HotelInfoVO> list) {
		ArrayList<HotelInfoVO> ret=new ArrayList<HotelInfoVO>();
		int temp;
		int count=list.size();
		int max=0;
		for(int j=1;j<count;j++){
			temp=0;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getLowest_price()>temp){
				temp=list.get(i).getLowest_price();
				max=i;
			}
				ret.add(list.get(max));
				list.remove(max);
		}
	}
		ret.add(list.get(0));
		return ret;
	}

	@Override
	public List<HotelInfoVO> sortByHighStar(List<HotelInfoVO> list) {
		ArrayList<HotelInfoVO> ret=new ArrayList<HotelInfoVO>();
		int temp;
		int count=list.size();
		int max=0;
		for(int j=1;j<count;j++){
			temp=0;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getStar()>temp){
				temp=list.get(i).getStar();
				max=i;
			}
				ret.add(list.get(max));
				list.remove(max);
		}
	}
		ret.add(list.get(0));
		return ret;
	}

	@Override
	public List<HotelInfoVO> sortByHighScore(List<HotelInfoVO> list) {
		ArrayList<HotelInfoVO> ret=new ArrayList<HotelInfoVO>();
		double temp;
		int count=list.size();
		int max=0;
		for(int j=1;j<count;j++){
			temp=0;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getScore()>temp){
				temp=list.get(i).getScore();
				max=i;
			}
				ret.add(list.get(max));
				list.remove(max);
		}
	}
		ret.add(list.get(0));
		return ret;
	}

	@Override
	public List<HotelInfoVO> sortByLowPrice(List<HotelInfoVO> list) {
		ArrayList<HotelInfoVO> ret=new ArrayList<HotelInfoVO>();
		int temp;
		int count=list.size();
		int min=0;
		for(int j=1;j<count;j++){
			temp=10000;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getLowest_price()<temp){
				temp=list.get(i).getLowest_price();
				min=i;
			}
				ret.add(list.get(min));
				list.remove(min);
		}
	}
		ret.add(list.get(0));
		return ret;
	}

	@Override
	public List<HotelInfoVO> sortByLowStar(List<HotelInfoVO> list) {
		ArrayList<HotelInfoVO> ret=new ArrayList<HotelInfoVO>();
		int temp;
		int count=list.size();
		int min=0;
		for(int j=1;j<count;j++){
			temp=10000;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getStar()<temp){
				temp=list.get(i).getStar();
				min=i;
			}
				ret.add(list.get(min));
				list.remove(min);
		}
	}
		ret.add(list.get(0));
		return ret;
	}

	@Override
	public List<HotelInfoVO> sortByLowScore(List<HotelInfoVO> list) {
		ArrayList<HotelInfoVO> ret=new ArrayList<HotelInfoVO>();
		double temp;
		int count=list.size();
		int min=0;
		for(int j=1;j<count;j++){
			temp=10000;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getScore()<temp){
				temp=list.get(i).getScore();
				min=i;
			}
				ret.add(list.get(min));
				list.remove(min);
		}
	}
		ret.add(list.get(0));
		return ret;
	}

	@Override
	public List<HotelInfoVO> historyHotel(List<HotelInfoVO> list) {
		ArrayList<HotelInfoVO> ret=new ArrayList<HotelInfoVO>();
		//List<Integer>id_li
		return ret;
	}

}
