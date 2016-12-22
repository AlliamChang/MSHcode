package po;

import java.io.Serializable;

public class CheckInPO implements Serializable{
	private static final long serialVersionUID = 8961415443390938361L;
	private String roomStyle;
	private String booker;
	private String checkinTime;
	private String checkoutTime;
	private long orderId;
	private boolean belongOrder;
	private String[] roomId;
	private int roomNum;
	
	public CheckInPO(){}

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

	public String getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}

	public String getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(String checkoutTime) {
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
