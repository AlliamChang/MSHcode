package runner;

import dao.order_dao.OrderDAO;
import daoImpl.orderDaoImpl.OrderDAOImpl;
import po.OrderPO;
import tools.OrderState;

import java.rmi.RemoteException;

public class OrderTest {

	public static void main(String[] args){
		OrderDAO daoTest = new OrderDAOImpl();
		OrderTest test = new OrderTest();
		try{
			OrderPO po = new OrderPO();
			po.setUserID(1);
			po.setUserAccount("Aven");
			po.setHotelId(1);
			po.setHotel("七天连锁");
			po.setRoomStyle("大床房");
			po.setRoomNum(1);
			po.setBooker("郑晓峰");
			po.setBookerPhone("1234567890");
			po.setDays(1);
			po.setPreCheckin("2016/12/14");
			po.setLatestCheckin(6);
			po.setHasChild(false);
			po.setState(OrderState.ABNORMITY);
//			daoTest.add(po);
		System.out.println(daoTest.orderStateShow(OrderState.UNEXECUTED, null).size());	
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
}
