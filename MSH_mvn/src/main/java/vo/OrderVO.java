package vo;

import tools.Date;
import tools.OrderState;

public class OrderVO {
	private long id;
	private String userID;
	private String hotel;
	private String roomStyle;
	private int roomNum;
	private String[] booker;
	private String[] bookerPhone;
	private int days;
	private Date preCheckin;
	private Date checkin;
	private Date checkout;
	private double price;
	private OrderState state;
	
	public OrderVO(String u,String h,String rs,int rn,String[] b,String[] bp,int d,Date p,OrderState s){
		userID = u;
		hotel = h;
		roomStyle = rs;
		roomNum = rn;
		booker = b;
		bookerPhone = bp;
		days = d;
		preCheckin = p;
		state = s;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
}
