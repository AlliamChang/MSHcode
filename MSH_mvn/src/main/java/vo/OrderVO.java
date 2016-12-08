package vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
	private long userID;
	/**
	 * 用户账号
	 */
	private String userAccount;
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
	 * 实际入住时间
	 */
	private Date checkin;
	/**
	 * 退房时间
	 */
	private Date checkout;
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
	
	//测试
	private StringProperty preCheckIn;
	private String firstBooker;
	private StringProperty evaluate;
	private StringProperty operation;
	public OrderVO(long i,long u, String userAccount,String h, String rs, int rn, String[] b,
			String[] bp, int d, Date p, OrderState s,boolean isEva) {
		id = i;
		userID = u;
		this.userAccount = userAccount;
		hotel = h;
		roomStyle = rs;
		roomNum = rn;
		booker = b;
		bookerPhone = bp;
		days = d;
		preCheckin = p;
		state = s;
		isEvaluated=isEva;
		preCheckIn = new SimpleStringProperty(p.getDate()); //测试
		if(b.length > 0)
			firstBooker = b[0]; //测试
	}
	public OrderVO(long i,long u,String userAccount, String h, String rs, int rn, String[] b,
			String[] bp, int d, Date p, OrderState s,boolean isEva,Date checkin) {
		id = i;
		userID = u;
		this.userAccount = userAccount;
		hotel = h;
		roomStyle = rs;
		roomNum = rn;
		booker = b;
		bookerPhone = bp;
		days = d;
		preCheckin = p;
		state = s;
		isEvaluated=isEva;
		preCheckIn = new SimpleStringProperty(p.getDate()); //测试
		if(b.length > 0)
			firstBooker = b[0]; //测试
		this.checkin = checkin;
	}
	//测试
	public StringProperty preCheckInProperty(){
		return preCheckIn;
	}
	public void setPreCheckInProperty(String s){
		this.preCheckIn = new SimpleStringProperty(s);
	}
	public String getPreCheckOut(){
		return preCheckin.plus(days);
	}
	public String getFirstBooker(){
		return firstBooker;
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
			evaluate=new SimpleStringProperty("有");
		else 
			evaluate=new SimpleStringProperty("无");
		return evaluate;
	}
	
	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
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
	
	public boolean getEvaluated(){
		return isEvaluated;
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
	
	public void setEvaluated(boolean eva){
		this.isEvaluated=eva;
	}
}
