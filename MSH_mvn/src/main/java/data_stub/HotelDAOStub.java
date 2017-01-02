package data_stub;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import dao.hotel.HotelDAO;
import javafx.scene.image.Image;
import po.CheckInPO;
import po.RoomPO;
import po.hotelPO.*;
import tools.BedStyle;
import tools.ResultMessage;
import ui.customer.PersonInfoPane;

public class HotelDAOStub implements HotelDAO {
	private ArrayList<HotelPO> dataBase;
	private ArrayList<RoomPO> room_data;
	Image image=new Image(PersonInfoPane.class.getResource("/image/hotel.jpg").toExternalForm(),
			100,100,false,false);
	public HotelDAOStub(){
		dataBase=new ArrayList<HotelPO>();
		dataBase.add(new HotelPO());
		room_data=new ArrayList<RoomPO>();
		room_data.add(new RoomPO("大床房", BedStyle.DOUBLE_BEDS, 486, 30, 3, 1));
		
	}
	public HotelPO find(int id) throws RemoteException {
		HotelPO ret=null;
		for(int i=0;i<dataBase.size();i++)
			if(dataBase.get(i).getId()==id){
				ret=dataBase.get(i);
				break;
			}
		return ret;
	}

	public int add(HotelPO po) throws RemoteException {
		
			return 0;
	
	}

	public ResultMessage delete(int id) throws RemoteException {
		for(int i=0;i<dataBase.size();i++)
			if(dataBase.get(i).getId()==id)
				dataBase.remove(i);
			return ResultMessage.SUCCESS;
		
	}


	public ResultMessage modify(HotelPO po) throws RemoteException {
		for (int i = 0; i < dataBase.size(); i++)
			if (dataBase.get(i).getId() == po.getId()){
				dataBase.set(i, po);
			}
		return ResultMessage.SUCCESS;
		
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("init Succeed");
	}
	

	
	public List<String> getProvinces()throws RemoteException{
		ArrayList<String> ret=new ArrayList<String>();
		for(int i=0;i<dataBase.size();i++)
			ret.add(dataBase.get(i).getProvince());
		return ret;
	}
	
	public List<String>getCities(String province)throws RemoteException{
		ArrayList<String> ret=new ArrayList<String>();
		for(int i=0;i<dataBase.size();i++){
			if(dataBase.get(i).getProvince().equals(province))
				ret.add(dataBase.get(i).getCity());
		}
		return ret;
	}
	
	public List<String>getAreas(String province,String city)throws RemoteException{
		ArrayList<String> ret=new ArrayList<String>();
		for(int i=0;i<dataBase.size();i++){
			if(dataBase.get(i).getProvince().equals(province)&&dataBase.get(i).getCity().equals(city))
				ret.add(dataBase.get(i).getTrade_area());
		}
		return ret;
	}
	@Override
	public List<RoomPO> getRoom(int hotel_id) throws RemoteException {
		ArrayList<RoomPO> ret=new ArrayList<RoomPO>();
		for(int i=0;i<room_data.size();i++){
			if(room_data.get(i).getHotel_id()==hotel_id){
				ret.add(room_data.get(i));
			}
		}
		return ret;
	}
	@Override
	public ResultMessage addRoom(RoomPO po) throws RemoteException {
		if(po!=null){
		room_data.add(po);
		return ResultMessage.SUCCESS;
		}else
			return ResultMessage.FAIL;
	}
	@Override
	public ResultMessage update(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<HotelPO> getHotel(String province, String city, String area,
			String name, String enter_time, String out_time, String price,
			String score, int star) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage updateCheckin(CheckInPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CheckInPO> getHotelCheckinInfo(int hotelId)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage addCheckin(CheckInPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage removeRoom(int roomId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
