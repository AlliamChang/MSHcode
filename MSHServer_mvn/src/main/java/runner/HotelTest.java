package runner;

import java.rmi.RemoteException;
import java.time.LocalDate;

import po.EvaluatePO;
import dao.hotel.EvaluateDAO;
import dao.hotel.HotelDAO;
import daoImpl.hotel.EvaluateDAOImpl;
import daoImpl.hotel.HotelDAOImpl;

public class HotelTest {
	public static void main(String[]args){
		HotelDAO test=new HotelDAOImpl();
		EvaluateDAO eva=new EvaluateDAOImpl();
		try {
			EvaluatePO po=new EvaluatePO();
			po.setHotel_id(2);
			po.setContent("环境很优美，价格也适宜");
			po.setUsername("隔壁老王");
			po.setScore(4.5);
			po.setTime(LocalDate.now().toString());
			eva.createEvaluate(po);
			System.out.println(eva.getEvaluate(2).get(0).getTime());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
