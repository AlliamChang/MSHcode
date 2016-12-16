package bl.order_bl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bl.user_bl.UserBLServiceImpl;
import blservice.order_blservice.OrderBLService;
import blservice.strategy_blservice.StrategyBLService;
import blservice.user_blservice.UserBLService;
import dao.order.OrderDAO;
import data_stub.OrderDAOStub;
import po.OrderPO;
import rmi.RemoteHelper;
import tools.Date;
import tools.OrderState;
import tools.ResultMessage;
import vo.CreditVO;
import vo.OrderVO;

public class OrderBL implements OrderBLService{
	
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
	
	private OrderDAO orderDataBase;
	private UserBLService user;
	private StrategyBLService strategy;
	private RemoteHelper remoteHelper;
	
	public OrderBL(){
		remoteHelper = RemoteHelper.getInstance();
		user = new UserBLServiceImpl();
		orderDataBase = remoteHelper.getOrderDAO();
	}

	/*
	 * 尚未完成
	 * @see blservice.order_blservice.OrderBLService#createOrder(vo.OrderVO)
	 */
	@Override
	public OrderVO createOrder(OrderVO order) {
		try{
			//设置订单状态
			order.setState(OrderState.UNEXECUTED);
			//设置是否被评价
			order.setEvaluated(false);
			//设置价格
			//order.setPrice();
			
			if(ResultMessage.SUCCESS == orderDataBase.add(order.toPO()))
				return order;
			else
				return null;
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<OrderVO> getTodayHotelOrder(int hotelId, String hotel) {
		try{
			
			Iterator<OrderPO> itr = this.orderDataBase.hotelShowToday(hotelId).iterator();
			List<OrderVO> hotelOrder = new ArrayList<OrderVO>();
			
			while(itr.hasNext()){
				hotelOrder.add(new OrderVO(itr.next()));
			}
			
			return hotelOrder;
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<OrderVO> getAllHotelOrder(int hotelId, String hotel) {
		try{
			Iterator<OrderPO> itr = this.orderDataBase.hotelShowAll(hotelId).iterator();
			List<OrderVO> hotelOrder = new ArrayList<OrderVO>();
			
			while(itr.hasNext()){
				hotelOrder.add(new OrderVO(itr.next()));
			}
			
			return hotelOrder;
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<OrderVO> getUserOrder(int userID, String userAccount) {
		try{
			Iterator<OrderPO> itr = this.orderDataBase.userShow(userID).iterator();
			List<OrderVO> userOrder = new ArrayList<OrderVO>();
			
			while(itr.hasNext()){
				userOrder.add(new OrderVO(itr.next()));
			}
			
			return userOrder;
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public OrderVO search(long id) {
		try{
			return new OrderVO(this.orderDataBase.find(id));
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResultMessage execute(long orderID, Date executeTime) {
		try{
			OrderPO po = this.orderDataBase.find(orderID);
			
			po.setCheckin(executeTime.getDate());
			po.setState(OrderState.EXECUTED);
			
			//添加信用
//			if(ResultMessage.SUCCESS == this.user.updateCredit(po.getUserID(), (int)po.getPrice()))	
				return this.orderDataBase.update(po);
//			else
//				return ResultMessage.FAIL;
		}catch(RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage delayAbnormity(long orderID, Date delayDate) {
		try{
			OrderPO po = this.orderDataBase.find(orderID);
			
			po.setPreCheckin(delayDate.getDate());
			po.setState(OrderState.UNEXECUTED);
			
			//返回信用值
			if(ResultMessage.SUCCESS == this.user.addCreditRecord(po.getUserID(), new CreditVO()))	
				return this.orderDataBase.update(po);
			else
				return ResultMessage.FAIL;
		}catch(RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage cancel(long orderID) {
		try{
			
			OrderPO po = this.orderDataBase.find(orderID);
			Date preCheckin = new Date(po.getPreCheckin(),false);
			if(LocalDateTime.now().getHour() + 6 <= po.getLatestCheckin() && preCheckin.getLocalDate().equals(LocalDate.now())){
				
			}
			return ResultMessage.SUCCESS;
		}catch(RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage cancelAbnormity(long orderID, boolean isReturnAll) {
		try{
			OrderPO po = this.orderDataBase.find(orderID);
			int temp;
			
			//返回信用
			if(isReturnAll)
				temp = (int)this.orderDataBase.find(orderID).getPrice();
			else
				temp = (int)this.orderDataBase.find(orderID).getPrice() / 2;
			user.updateCredit(po.getUserID(), temp);
			
			//更新订单
			po.setState(OrderState.CANCELED);
			po.setCheckout(LocalDateTime.now().format(format));
			orderDataBase.update(po);
			
			return ResultMessage.SUCCESS;
		}catch(RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage checkout(long orderID, Date checkoutTime) {
		try{
			OrderPO po = this.orderDataBase.find(orderID);
			
			po.setCheckout(checkoutTime.getDate());
			
			return this.orderDataBase.update(po);
		}catch(RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}

	@Override
	public List<OrderVO> getAbnormityOrder() {
		try{
			Iterator<OrderPO> itr = this.orderDataBase.orderStateShow(OrderState.ABNORMITY, null).iterator();
			List<OrderVO> list = new ArrayList<OrderVO>();
			while(itr.hasNext()){
				list.add(new OrderVO(itr.next()));
			}
			return list;
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<OrderVO> getTodayUnexecutedOrder() {
		try{
			Iterator<OrderPO> itr = this.orderDataBase.orderStateShow(OrderState.UNEXECUTED, LocalDate.now().format(format)).iterator();
			List<OrderVO> list = new ArrayList<OrderVO>();
			while(itr.hasNext()){
				list.add(new OrderVO(itr.next()));
			}
			return list;
		}catch(RemoteException e){
			e.printStackTrace();
			return null;
		}
	}

}
