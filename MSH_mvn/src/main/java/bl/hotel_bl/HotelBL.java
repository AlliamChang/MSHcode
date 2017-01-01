package bl.hotel_bl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import po.EvaluatePO;
import po.UserPO;
import po.hotelPO.HotelPO;
import po.RoomPO;
import rmi.RemoteHelper;
import dao.hotel.EvaluateDAO;
import dao.hotel.HotelDAO;
import data_stub.EvaluateDAO_Stub;
import data_stub.HotelDAOStub;
import bl.user_bl.UserBLServiceImpl;
import blservice.hotel_blservice.*;
import blservice.strategy_blservice.StrategyBLService;
import tools.ResultMessage;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.RoomVO;
import vo.UserVO;
public class HotelBL implements HotelBLService{
	private HotelDAO hotel;
	private UserBLServiceImpl user;
	private RemoteHelper help;
	private EvaluateDAO evaluate;
	public HotelBL(){
		help=RemoteHelper.getInstance();
		hotel=help.getHotelDAO();
		user=new UserBLServiceImpl();
		evaluate=help.getEvaluateDAO();
		
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
			return this.hotel.update(hotel.toPO());
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
			System.out.println(hotel_id);
		return new HotelInfoVO(hotel.find(hotel_id));
		}catch (RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<EvaluateVO> getEvaluate(int hotel_id) {
		ArrayList<EvaluateVO> ret=new ArrayList<EvaluateVO>();
		try{
			List<EvaluatePO>list= evaluate.getEvaluate(hotel_id);
			for(int i=0;i<list.size();i++){
				ret.add(new EvaluateVO(list.get(i)));
			}
			return ret;
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultMessage add(HotelInfoVO hotel) {
		try {
			UserVO staff = user.get(hotel.getStuff_id());
			hotel.setPhone(staff.getNumber());
			int hotelID = this.hotel.add(hotel.toPO());
			staff.setHotelID(hotelID);
			user.update(staff);
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	@Override
	public List<HotelInfoVO> search(String province,String city,String area,String name,String enter_time,String out_time,String price,String score,int star) {
		List<HotelInfoVO>ret=new ArrayList<HotelInfoVO>();
		try{
			System.out.print(1);
			List<HotelPO>po=this.hotel.getHotel(province, city, area, name, enter_time, out_time, price, score, star);
			for(HotelPO item:po){
				ret.add(new HotelInfoVO(item));
			}
			return ret;
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
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

	@SuppressWarnings("unchecked")
	@Override
	public List<HotelInfoVO> sortByHighStar(List<HotelInfoVO> list) {
		Collections.sort(list, new Comparator(){
			@Override
			public int compare(Object arg0, Object arg1) {
				return ((HotelInfoVO)arg1).getStar() - ((HotelInfoVO)arg0).getStar();
			}});
		return list;
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

	@Override
	public ResultMessage createEvaluate(EvaluateVO vo) {
		try {
			return evaluate.createEvaluate(vo.topo());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
