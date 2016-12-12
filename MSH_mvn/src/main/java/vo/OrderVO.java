package vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.orderPO.OrderPO;
import tools.Date;
import tools.OrderState;

public class OrderVO {
	/**
	 * 订单号
	 */
	private long id;
	/**
	 * 用户id
	 */
	private int userID;
	/**
	 * 用户账号
	 */
	private String userAccount;
	/**
	 * 酒店id
	 */
	private int hotelId;
	/**
	 * 酒店名称
	 */
	private String hotel;
	/**
	 * 房间类型
	 */
	private String roomStyle;
	/**
	 * 房间数量
	 */
	private int roomNum;
	/**
	 * 入住客人姓名
	 */
	private String[] booker;
	/**
	 * 入住客人电话
	 */
	private String[] bookerPhone;
	/**
	 * 入住天数
	 */
	private int days;
	/**
	 * 预订入住日期
	 */
	private Date preCheckin;
	/**
	 * 最晚入住时间
	 */
	private int latestCheckin;
	/**
	 * 实际入住时间
	 */
	private Date checkin;
	/**
	 * 退房时间
	 */
	private Date checkout;
	/**
	 * 是否有小孩
	 */
	private boolean hasChild;
	/**
	 * 订单总价
	 */
	private double price;
	/**
	 * 订单状态
	 */
	private OrderState state;
	/**
	 * 是否被评价
	 */
	private boolean isEvaluated;
	
	public OrderVO(long id, int userID, String userAccount, int hotelId, String hotel, String roomStyle, int roomNum,
			String[] booker, String[] bookerPhone, int days, Date preCheckin, int latestCheckin, Date checkin,
			Date checkout, boolean hasChild, double price, OrderState state, boolean isEvaluated) {
		super();
		this.id = id;
		this.userID = userID;
		this.userAccount = userAccount;
		this.hotelId = hotelId;
		this.hotel = hotel;
		this.roomStyle = roomStyle;
		this.roomNum = roomNum;
		this.booker = booker;
		this.bookerPhone = bookerPhone;
		this.days = days;
		this.preCheckin = preCheckin;
		this.latestCheckin = latestCheckin;
		this.checkin = checkin;
		this.checkout = checkout;
		this.hasChild = hasChild;
		this.price = price;
		this.state = state;
		this.isEvaluated = isEvaluated;
	}

	public OrderVO(OrderPO po){
		super();
		this.id = po.getId();
		this.userID = po.getUserID();
		this.userAccount = po.getUserAccount();
		this.hotelId = po.getHotelId();
		this.hotel = po.getHotel();
		this.roomStyle = po.getRoomStyle();
		this.roomNum = po.getRoomNum();
		this.booker = po.getBooker();
		this.bookerPhone = po.getBookerPhone();
		this.days = po.getDays();
		this.preCheckin = new Date(po.getPreCheckin(),false);
		this.latestCheckin = po.getLatestCheckin();
		this.checkin = new Date(po.getCheckin(),true);
		this.checkout = new Date(po.getCheckout(),true);
		this.hasChild = po.isHasChild();
		this.price = po.getPrice();
		this.state = po.getState();
		this.isEvaluated = po.isEvaluated();
	}
	
	public OrderPO toPO(){
		OrderPO po = new OrderPO();
		po.setId(id);
		po.setUserID(userID);
		po.setUserAccount(userAccount);
		po.setHotelId(hotelId);
		po.setHotel(hotel);
		po.setRoomStyle(roomStyle);
		po.setRoomNum(roomNum);
		po.setBooker(booker);
		po.setBookerPhone(bookerPhone);
		po.setDays(days);
		po.setPreCheckin(preCheckin.getDate());
		po.setLatestCheckin(latestCheckin);
		po.setCheckin(checkin == null?null:checkin.getDate());
		po.setCheckout(checkout == null?null:checkout.getDate());
		po.setHasChild(hasChild);
		po.setPrice(price);
		po.setState(state);
		po.setEvaluated(isEvaluated);
		return po;
	}
	
	//测试
	public StringProperty preCheckInProperty(){
		return new SimpleStringProperty(preCheckin.getDate());
	}
	public StringProperty preCheckOutProperty(){
		return new SimpleStringProperty(preCheckin.plus(days));
	}
	public String getFirstBooker(){
		return this.booker[0];
	}
	public StringProperty orderStateProperty(){
		if(state == OrderState.ABNORMITY)
			return new SimpleStringProperty("异常订单");
		else if(state == OrderState.CANCELED)
			return new SimpleStringProperty("已撤销");
		else if(state == OrderState.EXECUTED)
			return new SimpleStringProperty("已执行");
		else
			return new SimpleStringProperty("未执行");
	}
	public StringProperty operationProperty(){
		if(state==OrderState.EXECUTED){
			if(isEvaluated==false){
				return new SimpleStringProperty("评价");
			}
		}else if(state==OrderState.UNEXECUTED){
			return new SimpleStringProperty("撤销");
		} 
			return new SimpleStringProperty("空");
	}
	public StringProperty evaluateProperty(){
		if(isEvaluated==true)
			return new SimpleStringProperty("有");
		else 
			return new SimpleStringProperty("无");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public String getRoomStyle() {
		return roomStyle;
	}

	public void setRoomStyle(String roomStyle) {
		this.roomStyle = roomStyle;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public String[] getBooker() {
		return booker;
	}

	public void setBooker(String[] booker) {
		this.booker = booker;
	}

	public String[] getBookerPhone() {
		return bookerPhone;
	}

	public void setBookerPhone(String[] bookerPhone) {
		this.bookerPhone = bookerPhone;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Date getPreCheckin() {
		return preCheckin;
	}

	public void setPreCheckin(Date preCheckin) {
		this.preCheckin = preCheckin;
	}

	public int getLatestCheckin() {
		return latestCheckin;
	}

	public void setLatestCheckin(int latestCheckin) {
		this.latestCheckin = latestCheckin;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public boolean isEvaluated() {
		return isEvaluated;
	}

	public void setEvaluated(boolean isEvaluated) {
		this.isEvaluated = isEvaluated;
	}
	
	
}
