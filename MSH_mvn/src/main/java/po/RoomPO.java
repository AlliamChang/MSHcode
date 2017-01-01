package po;

import java.io.Serializable;

import tools.BedStyle;
import vo.RoomVO;

public class RoomPO implements Serializable {
	private static final long serialVersionUID = 8961415443390938361L;
	private String room_type;
	private BedStyle bedStyle;
	private double price;
	private int num;
	private int id;
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

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public BedStyle getBedStyle() {
		return bedStyle;
	}

	public void setBedStyle(BedStyle bedStyle) {
		this.bedStyle = bedStyle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getMaxCustomer() {
		return maxCustomer;
	}

	public void setMaxCustomer(int maxCustomer) {
		this.maxCustomer = maxCustomer;
	}
	
	public RoomVO tovo(){
		RoomVO ret=new RoomVO(room_type, bedStyle, price, num,maxCustomer, hotel_id);
		return ret;
	}
	
	
}

