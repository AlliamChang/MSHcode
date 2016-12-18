package ui.hotelStuff.control;


import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.control.Toggle;
import javafx.scene.image.Image;
import tools.BedStyle;
import tools.Date;
import tools.HotelStrategyType;
import tools.ResultMessage;
import ui.hotelStuff.AddRoomPane;
import ui.hotelStuff.CheckInListPane;
import ui.hotelStuff.HotelInfoPane;
import ui.hotelStuff.HotelStrategyPane;
import ui.hotelStuff.OrderListPane;
import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import vo.CheckInVO;
import vo.HotelInfoVO;
import vo.HotelStrategyVO;
import vo.OrderVO;
import vo.RoomVO;
import blservice.hotel_blservice.HotelBLService;
import blservice.order_blservice.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import bl.hotel_bl.HotelBL;
import bl.order_bl.OrderBL;
import bl_stub.Order_Stub;

public class HotelPaneController {
	
	private static HotelPaneController controller;
	private HotelBLService hotelBL;
	private OrderBLService orderBL;
	private List<OrderVO> orderList;
	private List<String> roomStyle;
	private int id;
	private String hotel;
	
	//导航栏
	private final List<String> naviInfo = Arrays.asList("订单列表","客房列表","入住信息","促销策略","基本信息");
	
	private HotelPaneController(){
		orderBL = new OrderBL();
//		hotelBL = new HotelBL();
	}
	
	public static HotelPaneController getInstance(){
		if(controller == null){
			controller = new HotelPaneController();
		}
		return controller;
	}
	
	public void hotelStuffLogin(int id,String hotel,Image scul){

		this.roomStyle = Arrays.asList(new String[]{"温暖大床房","经济标准间","难民六人间"});
		this.id = id;
		this.hotel = hotel;
		MyNavigationBar navi= new MyNavigationBar(scul,Arrays.asList("ID:"+id,"酒店名："+hotel),naviInfo);
		MainPane.getInstance().setNavigationBar(navi);
//		this.createOrderListPane();
		MainPane.getInstance().setRightPane(new Loading(naviInfo.get(0)));
		
		navi.getToggle().selectedToggleProperty().addListener(
				(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
					if(newValue != null){
						String temp = newValue.toString().split("'")[1];
						
						MainPane.getInstance().setRightPane(new Loading(temp));
					}
				});
	}
	
	/**
	 * 跳转至酒店订单列表界面
	 */
	public OrderListPane createOrderListPane(){
		return new OrderListPane();
	}
	
	/**
	 * 跳转至酒店客房录入界面
	 */
	public AddRoomPane createAddRoomPane(){
		return new AddRoomPane(this.getRoomList());
	}
	
	/**
	 * 跳转至酒店基本信息界面
	 */
	public HotelInfoPane createHotelInfoPane(){
		return new HotelInfoPane(hotel,id);
	}
	
	/**
	 * 跳转至酒店促销策略界面
	 */
	public HotelStrategyPane createHotelStrategyPane(){
		return new HotelStrategyPane(Arrays.asList(
				new HotelStrategyVO("双十一促销", HotelStrategyType.FESTIVAL, 10, new Date("2016/11/10",false), new Date("2016/11/12",false)),
				new HotelStrategyVO("腾讯公司合作优惠", HotelStrategyType.BUSINESS, CostType.RMB,50, new Date("2016/11/10",false), new Date("2016/12/12",false))
				));
	}
	
	/**
	 * 跳转至酒店入住信息界面
	 */
	public CheckInListPane createCheckInPane(){
		String[] roomStyle = {"温暖大床房","经济标准间","难民六人间"};
		List<CheckInVO> stub = Arrays.asList(
				new CheckInVO("温暖大床房","丁二玉",new Date("2016/12/05 11:11:11",true),
						new Date("2016/12/06",false)
						,1000000001,true,new String[]{"501","503"},2),
				new CheckInVO("经济标准间","丁二玉",new Date("2016/12/05 11:11:11",true),
						new Date("2016/12/06",false),0,false,new String[]{"502"},1),
				new CheckInVO("难民六人间","丁二玉",new Date("2016/12/05 11:11:11",true),
						new Date("2016/12/06",false)
						,1000000001,true,new String[]{"503"},1));
		return new CheckInListPane(roomStyle,stub.iterator());
	}
	
	public Iterator<RoomVO> getRoomList(){
		return Arrays.asList(
				new RoomVO("温暖大床房", BedStyle.KING_SIZE_BED, 320.00, 2, 2,id),
				new RoomVO("经济标准间",BedStyle.DOUBLE_BEDS,349.00,50,2,id),
				new RoomVO("难民六人间", BedStyle.BUNK_BED, 99.00, 90, 6,id)).iterator();
	}
	
	public HotelInfoVO getHotelInfo(){
		return new HotelInfoVO(hotel,"南京市夫子庙路3号102","12345678910", 
				new String[]{"24小时热水","普通分体空调","国内长途电话"}, 
				"南京夫子庙国际青年旅舍位于南京夫子庙平江府路68号（夫子庙东大门旁）。傍依秦淮河，是一幢具有明清风格的建筑。一楼为接待处，四楼酒吧茶座，并提供简餐，立志将其打造成户外自助旅游者的主题酒吧；二楼三楼四楼为客房。酒店诚心欢迎社会各界友人前来入住。交通：从南京南站出来，乘地铁3号线到夫子庙站下车，2号口出来之后右转至平江府路，由北向南步行约100米到店，与顺发扑克和苏克快餐店相邻。", 
				"南京", "夫子庙", 2015,
				new Image(HotelPaneController.class.getResourceAsStream("/image/hotel_scul.png"),200,200,false,false),
				4,4.5,1,1);
	}
	
	public int getHotelId(){
		return this.id;
	}
	
	public ResultMessage delay(long id,Date date){
		return this.orderBL.delayAbnormity(id, date);
	}
	
	public ResultMessage checkin(long id,Date date){
		return this.orderBL.execute(id, date);
	}
	
	public List<OrderVO> getTodayOrder(){
		
		return this.orderBL.getTodayHotelOrder(id, hotel);
	}
	
	public List<OrderVO> getAllOrder(){
		return orderBL.getAllHotelOrder(id, hotel);
	}
	
	public List<String> getRoomStyle(){
		return this.roomStyle;
	}
	
	
	private class Loading extends Task<Parent>{

		private String op;
		
		public Loading(String op){
			this.op = op;
		}
		
		@Override
		protected Parent call() throws Exception {
			Parent child = null;
			
			
			switch(op){
			case "订单列表":
				child = createOrderListPane();
				break;
				
			case "客房列表":
				child = createAddRoomPane();
				break;
				
			case "入住信息":
				child = createCheckInPane();
				break;
				
			case "促销策略":
				child = createHotelStrategyPane();
				break;
				
			case "基本信息":
				child = createHotelInfoPane();
				break;
				
			}
			
			
			return child;
		}
		
	}
}
