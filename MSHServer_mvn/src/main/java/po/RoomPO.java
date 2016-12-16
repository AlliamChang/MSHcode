package po;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import tools.BedStyle;
@Entity
@Table(name="room")
public class RoomPO implements Serializable{
	private static final long serialVersionUID = 8961415443390938361L;
	private String room_type;
	private BedStyle bedStyle;
	private double price;
	private int num;
	private int hotel_id;
	private int maxCustomer;
	
	public RoomPO(String room_type,BedStyle bedStyle,double price,int num,int hotel_id,int maxCustomer){
		this.room_type=room_type;
		this.bedStyle=bedStyle;
		this.price=price;
		this.num=num;
		this.hotel_id=hotel_id;
		this.maxCustomer=maxCustomer;
	}
@Column(name="room_type")
	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	
@Column(name="bedstyle")
	public BedStyle getBedStyle() {
		return bedStyle;
	}

	public void setBedStyle(BedStyle bedStyle) {
		this.bedStyle = bedStyle;
	}
@Column(name="price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
@Column(name="num")
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
@Id
@Column(name="hotel_id")
	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	
@Column(name="maxcustomer")
	public int getMaxCustomer() {
		return maxCustomer;
	}

	public void setMaxCustomer(int maxCustomer) {
		this.maxCustomer = maxCustomer;
	}
	
}
