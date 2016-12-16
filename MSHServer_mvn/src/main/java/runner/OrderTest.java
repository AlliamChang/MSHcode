package runner;

import daoImpl.orderDaoImpl.OrderDAOImpl;
import po.OrderPO;
import tools.OrderState;

import java.rmi.RemoteException;

import dao.order.OrderDAO;

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
			po.setBooker("郑皓铭");
			po.setBookerPhone("1234567890");
			po.setDays(1);
			po.setPreCheckin("2016/12/16");
			po.setLatestCheckin(14);
			po.setHasChild(false);
			po.setState(OrderState.UNEXECUTED);
			daoTest.add(po);
		System.out.println(daoTest.orderStateShow(OrderState.UNEXECUTED, null).size());	
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}
}
