package vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tools.Date;

public class CheckInVO {
	
	private String roomStyle;
	private String booker;
	private Date checkinTime;
	private Date checkoutTime;
	private long orderId;
	private boolean belongOrder;
	private String[] roomId;
	private int roomNum;
	
	public CheckInVO(String roomStyle,String booker, 
			Date checkinTime,Date checkoutTime, long orderId, boolean belongOrder, String[] roomId,int roomNum) {
		super();
		this.roomStyle = roomStyle;
		this.booker = booker;
		this.checkinTime = checkinTime;
		this.checkoutTime = checkoutTime;
		this.orderId = orderId;
		this.belongOrder = belongOrder;
		this.roomId = roomId;
		this.roomNum = roomNum;
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

	public String[] getRoomId() {
		return roomId;
	}

	public void setRoomId(String[] roomId) {
		this.roomId = roomId;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
	
	
}
