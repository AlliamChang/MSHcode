package po;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="checkin")
public class CheckInPO implements Serializable {
	private static final long serialVersionUID = 8961415443390938361L;
	private String roomStyle;
	private String booker;
	private String checkinTime;
	private String preCheckOutTime;
	private String checkoutTime;
	private long orderId;
	private boolean belongOrder;
	private String roomId;
	private int roomNum;
	private int hotelId;
	private int id;
	@Id
	@Column(name="id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CheckInPO(){}
@Column(name="roomStyle")
	public String getRoomStyle() {
		return roomStyle;
	}

	public void setRoomStyle(String roomStyle) {
		this.roomStyle = roomStyle;
	}
@Column(name="booker")
	public String getBooker() {
		return booker;
	}

	public void setBooker(String booker) {
		this.booker = booker;
	}
@Column(name="checkinTime")
	public String getCheckinTime() {
		return checkinTime;
	}

	public void setCheckinTime(String checkinTime) {
		this.checkinTime = checkinTime;
	}
@Column(name="checkoutTime")
	public String getCheckoutTime() {
		return checkoutTime;
	}

	public void setCheckoutTime(String checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
@Column(name="orderId")
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
@Column(name="belongOrder")
	public boolean isBelongOrder() {
		return belongOrder;
	}

	public void setBelongOrder(boolean belongOrder) {
		this.belongOrder = belongOrder;
	}
@Column(name="roomId")
	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}
@Column(name="roomNum")
	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}
@Column(name="hotelId")
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
@Column(name="preCheckOutTime")
	public String getPreCheckOutTime() {
		return preCheckOutTime;
	}
	public void setPreCheckOutTime(String preCheckOutTime) {
		this.preCheckOutTime = preCheckOutTime;
	}
	
	
}
