package data_driver;

import java.rmi.RemoteException;
import java.util.List;

import dao.order_dao.OrderDao;
import po.hotelPO.HotelPO;
import po.orderPO.OrderPO;
import po.userPO.UserPO;
import tools.Date;
import tools.OrderState;
import tools.ResultMessage;

public class OrderDao_driver {
	
	public void drive(OrderDao orderDataService) throws RemoteException{
		String[] booker = {"֣���","֣����"};
		String[] phone = {"12345678910","10987654321"};
		Date day = new Date();
		OrderState state = OrderState.UNEXECUTED;
		ResultMessage result = null;
		
		OrderPO order = new OrderPO(1000000,"Aven","�Ͼ����������������Ƶ�","�󴲷�",1,booker,phone,1,day,null,null,300,state);
		if(result.SUCCESS == orderDataService.add(order))
			System.out.println("��ӳɹ�");
		if(orderDataService.find(1000000).getUserID().equals("Aven"))
			System.out.println("���ҳɹ�");
		
		HotelPO hotel = new HotelPO();
		UserPO user = new UserPO(null, null, null, 0, 0);
		List<OrderPO> list = orderDataService.hotelShow(hotel);
		for(int i = 0; i < list.size(); i ++){
			System.out.println(list.get(i).getId());
		}
		
		list = orderDataService.userShow(user);
		for(int i = 0; i < list.size(); i ++){
			System.out.println(list.get(i).getId());
		}
		
		orderDataService.update(order);
		System.out.println("���³ɹ�");
	}
	
}
