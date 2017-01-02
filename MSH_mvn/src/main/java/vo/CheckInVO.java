package vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import po.CheckInPO;
import tools.Date;

public class CheckInVO {
	
	private int id;
	private int hotelId;
	private String roomStyle;
	private String booker;
	private Date checkinTime;
	private Date preCheckOutTime;
	private Date checkoutTime;
	private long orderId;
	private boolean belongOrder;
	private String roomId;
	private int roomNum;
	
	public CheckInVO(int hotelId,String roomStyle,String booker, 
			Date checkinTime,Date preCheckOutTime,Date checkoutTime, long orderId, boolean belongOrder, String roomId,int roomNum) {
		super();
		this.hotelId = hotelId;
		this.roomStyle = roomStyle;
		this.booker = booker;
		this.checkinTime = checkinTime;
		this.preCheckOutTime = preCheckOutTime;
		this.checkoutTime = checkoutTime;
		this.orderId = orderId;
		this.belongOrder = belongOrder;
		this.roomId = roomId;
		this.roomNum = roomNum;
	}
	
	public CheckInVO(CheckInPO po){
		this.id = po.getId();
		this.hotelId = po.getHotelId();
		this.belongOrder = po.isBelongOrder();
		this.booker = po.getBooker();
		this.checkinTime = new Date(po.getCheckinTime(),true);
		this.preCheckOutTime = new Date(po.getPrecheckOutTime(),false);
		this.checkoutTime = new Date(po.getCheckoutTime(),false);
		this.orderId = po.getOrderId();
		this.roomId = po.getRoomId();
		this.roomNum = po.getRoomNum();
		this.roomStyle = po.getRoomStyle();
	}
	
	public CheckInPO toPO(){
		CheckInPO po = new CheckInPO();
		
		po.setHotelId(hotelId);
		po.setBelongOrder(this.belongOrder);
		po.setBooker(booker);
		po.setCheckinTime(checkinTime.getDate());
		po.setPrecheckOutTime(this.preCheckOutTime.getDate());
		po.setCheckoutTime(checkoutTime.getDate());
		po.setOrderId(orderId);
		po.setRoomId(this.roomId);
		po.setRoomNum(roomNum);
		po.setRoomStyle(roomStyle);
		
		return po;
	}
	
	public StringProperty orderIdProperty(){
		if(belongOrder)
			return new SimpleStringProperty(String.valueOf(orderId));
		else
			return new SimpleStringProperty("无");
	}
	public StringProperty checkinTimeProperty(){
		return new SimpleStringProperty(this.checkinTime.getDate());
	}
	public StringProperty checkoutTimeProperty(){
		return new SimpleStringProperty(this.checkoutTime.getDate());
	}

	public String getRoomStyle() {
		return roomStyle;
	}

	public void setRoomStyle(String roomStyle) {
		this.roomStyle = roomStyle;
	}

	public String getBooker() {
		return booker;
	}

	public void setBooker(String booker) {
		this.booker = booker;
	}

	public Date getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}

	public Date getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public boolean isBelongOrder() {
		return belongOrder;
	}

	public void setBelongOrder(boolean belongOrder) {
		this.belongOrder = belongOrder;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public Date getPreCheckOutTime() {
		return preCheckOutTime;
	}

	public void setPreCheckOutTime(Date preCheckOutTime) {
		this.preCheckOutTime = preCheckOutTime;
	}
	
	
}
