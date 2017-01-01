package BLImplTest;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.*;

import bl.order_bl.OrderBL;
import blservice.order_blservice.OrderBLService;
import dao.order.OrderDAO;
import po.OrderPO;
import tools.OrderState;
import vo.OrderVO;

public class OrderBLServiceImplTest {

	private OrderBLService order;
	private OrderDAO data;
	
	@Before
	public void setData(){
		order = new OrderBL();
		OrderPO po1 = new OrderPO(1	, "啊", 1, "大酒店", "标间", 1,
				"郑", "123", 3, "2016/12/12", 18, null,
				null, false, 200, OrderState.UNEXECUTED, false);
		OrderPO po2 = new OrderPO(1	, "啊", 1, "大酒店", "商务间", 1,
				"郑", "123", 3, "2016/12/12", 18, null,
				null, false, 200, OrderState.UNEXECUTED, false);
		OrderPO po3 = new OrderPO(1	, "啊", 1, "大酒店", "标间", 1,
				"郑", "123", 3, "2016/12/12", 18, null,
				null, false, 200, OrderState.UNEXECUTED, false);
		OrderPO po4 = new OrderPO(1	, "啊", 1, "小酒店", "标间", 1,
				"郑", "123", 3, "2016/12/12", 18, null,
				null, false, 200, OrderState.UNEXECUTED, false);
		OrderPO po5 = new OrderPO(1	, "啊", 1, "小酒店", "标间", 1,
				"郑", "123", 3, "2016/12/12", 18, null,
				null, false, 200, OrderState.UNEXECUTED, false);
		long id = 100;
		try {
			data.add(po1);
			data.add(po2);
			data.add(po3);
			data.add(po4);
			data.add(po5);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateOrder(){
		
	}
	
	@Test
	public void testCancel(){
		
	}
	
	@Test
	public void testCancelAbnormity(){
		
	}
	
	@Test
	public void testCheckOut(){
		
	}
	
	@Test
	public void testDelayAbnormity(){
		
	}
	
	@Test
	public void testSearch(){
		
	}
	
	@Test
	public void testExecute(){
		
	}
	
	@Test
	public void testGetUserOrder(){
		List<OrderVO> list = order.getUserOrder(1, "啊");
		
	}
	
	@Test
	public void testGetTodayHotelOrder(){
		
	}
	
	@Test
	public void testGetAllHotelOrder(){
		
	}
	
	@Test
	public void testGetAbnormityOrder(){
		
	}
	
	@Test
	public void testGetTodayUnexecutedOrder(){
		
	}
}
