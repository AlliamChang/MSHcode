package Order;

import static org.junit.Assert.*;

import org.junit.*;

import dao.order.OrderDAO;
import daoImpl.orderDaoImpl.OrderDAOImpl;

public class OrderDaoTest {
	private OrderDAO orderDao;
	@Before
	public void setUp(){
		orderDao = new OrderDAOImpl();
	}
	@Test
	public void test(){
		assertEquals(1,1);
	}
}
