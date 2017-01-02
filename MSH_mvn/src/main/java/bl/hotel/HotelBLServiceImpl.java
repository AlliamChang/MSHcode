package bl.hotel;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bl.user.UserBLServiceImpl;
import blservice.hotel.*;
import blservice.user.UserBLService;
import po.CheckInPO;
import po.EvaluatePO;
import po.hotelPO.HotelPO;
import po.RoomPO;
import rmi.RemoteHelper;
import dao.hotel.EvaluateDAO;
import dao.hotel.HotelDAO;
import tools.ResultMessage;
import vo.CheckInVO;
import vo.EvaluateVO;
import vo.HotelInfoVO;
import vo.RoomVO;
import vo.UserVO;
public class HotelBLServiceImpl implements HotelBLService{
	private HotelDAO hotel;
	private UserBLService user;
	private RemoteHelper help;
	private EvaluateDAO evaluate;
	public HotelBLServiceImpl(){
		help=RemoteHelper.getInstance();
		hotel=help.getHotelDAO();
		evaluate=help.getEvaluateDAO();
		user = new UserBLServiceImpl();
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
		Collections.sort(list, new Comparator<HotelInfoVO>(){
			@Override
			public int compare(HotelInfoVO arg0, HotelInfoVO arg1) {
				return arg1.getLowest_price() - arg0.getLowest_price();
			}});
		return list;
	}


	
	@Override
	public List<HotelInfoVO> sortByHighStar(List<HotelInfoVO> list) {
		Collections.sort(list, new Comparator<HotelInfoVO>(){
			@Override
			public int compare(HotelInfoVO arg0, HotelInfoVO arg1) {
				return arg1.getStar() - arg0.getStar();
			}});
		return list;
	}

	@Override
	public List<HotelInfoVO> sortByHighScore(List<HotelInfoVO> list) {
		Collections.sort(list, new Comparator<HotelInfoVO>(){
			@Override
			public int compare(HotelInfoVO arg0, HotelInfoVO arg1) {
				return (int)(arg1.getScore()*10 - arg0.getScore()*10);
			}});
		return list;
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

	@Override
	public ResultMessage checkin(CheckInVO vo) {
		try {
			this.hotel.addCheckin(vo.toPO());
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage checkout(CheckInVO vo) {
		try {
			this.hotel.updateCheckin(vo.toPO());
			return ResultMessage.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public List<CheckInVO> getCheckinInfo(int hotelId) {
		try {
			List<CheckInPO> po = this.hotel.getHotelCheckinInfo(hotelId);
			List<CheckInVO> vo = new ArrayList<CheckInVO>();
			for(CheckInPO p: po){
				if(p.getCheckoutTime() == null)
					vo.add(new CheckInVO(p));
			}
			return vo;
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return null;
		}
	}

}
