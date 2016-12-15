package po;

import java.io.Serializable;

import tools.OrderState;

public class OrderPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	private String booker;
	/**
	 * 入住客人电话
	 */
	private String bookerPhone;
	/**
	 * 入住天数
	 */
	private int days;
	/**
	 * 预订入住日期
	 */
	private String preCheckin;
	/**
	 * 最晚入住时间
	 */
	private int latestCheckin;
	/**
	 * 实际入住时间
	 */
	private String checkin;
	/**
	 * 退房时间
	 */
	private String checkout;
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
	
	public OrderPO(){
		
	}
	
	public OrderPO(int userID, String userAccount, int hotelId, String hotel, String roomStyle, int roomNum,
			String booker, String bookerPhone, int days, String preCheckin, int latestCheckin, String checkin,
			String checkout, boolean hasChild, double price, OrderState state, boolean isEvaluated) {
		super();
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

	public String getBooker() {
		return booker;
	}

	public void setBooker(String booker) {
		this.booker = booker;
	}

	public String getBookerPhone() {
		return bookerPhone;
	}

	public void setBookerPhone(String bookerPhone) {
		this.bookerPhone = bookerPhone;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getPreCheckin() {
		return preCheckin;
	}

	public void setPreCheckin(String preCheckin) {
		this.preCheckin = preCheckin;
	}

	public int getLatestCheckin() {
		return latestCheckin;
	}

	public void setLatestCheckin(int latestCheckin) {
		this.latestCheckin = latestCheckin;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
}
