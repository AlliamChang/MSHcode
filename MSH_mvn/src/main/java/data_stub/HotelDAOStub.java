package data_stub;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import po.hotelPO.*;
import tools.BedStyle;
import tools.ResultMessage;
import ui.customer.PersonInfoPane;
import vo.HotelInfoVO;
import vo.RoomVO;
import dao.hotel_dao.HotelDAO;

public class HotelDAOStub implements HotelDAO {
	private ArrayList<HotelPO> dataBase;
	private ArrayList<RoomPO> room_data;
	Image image=new Image(PersonInfoPane.class.getResource("/image/hotel.jpg").toExternalForm(),
			100,100,false,false);
	public HotelDAOStub(){
		dataBase=new ArrayList<HotelPO>();
		dataBase.add(new HotelPO(new HotelInfoVO("渡口客栈","南京市中山北路10号","8008208820",null,null,"江苏省","鼓楼区",10,image,4,4.5,1,1,"南京市")));
		room_data=new ArrayList<RoomPO>();
		room_data.add(new RoomPO(new RoomVO("大床房", BedStyle.DOUBLE_BEDS, 486, 30, 3, 1)));
		
	}
	public HotelPO find(int id) throws RemoteException {
		HotelPO ret=null;
		for(int i=0;i<dataBase.size();i++)
			if(dataBase.get(i).getid()==id){
				ret=dataBase.get(i);
				break;
			}
		return ret;
	}

	public ResultMessage add(HotelPO po) throws RemoteException {
		boolean isExist=false;
		for(int i=0;i<dataBase.size();i++){
			if(dataBase.get(i).getid()==po.getid())
				isExist=true;
		}
		if(isExist)
			return ResultMessage.EXIST;
		else{
			dataBase.add(po);
			return ResultMessage.SUCCESS;
	}
	}

	public ResultMessage delete(int id) throws RemoteException {
		for(int i=0;i<dataBase.size();i++)
			if(dataBase.get(i).getid()==id)
				dataBase.remove(i);
			return ResultMessage.SUCCESS;
		
	}

	public void update(HotelPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("update Succeed");
	}

	public ResultMessage modify(HotelPO po) throws RemoteException {
		for (int i = 0; i < dataBase.size(); i++)
			if (dataBase.get(i).getid() == po.getid()){
				dataBase.set(i, po);
			}
		return ResultMessage.SUCCESS;
		
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("init Succeed");
	}
	@Override
	public List<HotelPO> get(String province, String city, String tradeArea,
			String name)throws RemoteException {
		ArrayList<HotelPO> ret=new ArrayList<HotelPO>();
		if(name!=null){
			for(int i=0;i<dataBase.size();i++){
				if(dataBase.get(i).getProvince().equals(province)&&dataBase.get(i).getcity().equals(city)&&dataBase.get(i).gettrade_area().equals(tradeArea)&&dataBase.get(i).getname().equals(name))
					ret.add(dataBase.get(i));
			}
		}
		else{
			for(int i=0;i<dataBase.size();i++){
				if(dataBase.get(i).getProvince().equals(province)&&dataBase.get(i).getcity().equals(city)&&dataBase.get(i).gettrade_area().equals(tradeArea))
					ret.add(dataBase.get(i));
		}
	}
		return ret;
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
				ret.add(dataBase.get(i).getcity());
		}
		return ret;
	}
	
	public List<String>getAreas(String province,String city)throws RemoteException{
		ArrayList<String> ret=new ArrayList<String>();
		for(int i=0;i<dataBase.size();i++){
			if(dataBase.get(i).getProvince().equals(province)&&dataBase.get(i).getcity().equals(city))
				ret.add(dataBase.get(i).gettrade_area());
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
}
