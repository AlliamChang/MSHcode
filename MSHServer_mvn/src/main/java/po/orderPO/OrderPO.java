package po.orderPO;

import java.io.Serializable;

import tools.Date;
import tools.OrderState;

public class OrderPO implements Serializable{
	long id;
	String userID;
	String hotel;
	String roomStyle;
	int roomNum;
	String[] booker;
	String[] bookerPhone;
	int days;
	Date preCheckin;
	Date checkin;
	Date checkout;
	double price;
	OrderState state;
	
	public OrderPO(long i,String id,String h,String rs,int rn,String[] b,
			String[] bp,int d,Date pci,Date ci,Date co,double p,OrderState s){
		this.id = i;
		userID = id;
		hotel = h;
		roomStyle = rs;
		roomNum = rn;
		booker = b;
		bookerPhone = bp;
		days = d;
		preCheckin = pci;
		checkin = ci;
		checkout = co;
		price = p;
		state = s;
	}



	public String getUserID() {
		return userID;
	}



	public long getId() {
		return id;
	}



	public String getHotel() {
		return hotel;
	}



	public String getRoomStyle() {
		return roomStyle;
	}



	public int getRoomNum() {
		return roomNum;
	}



	public String[] getBooker() {
		return booker;
	}



	public String[] getBookerPhone() {
		return bookerPhone;
	}



	public int getDays() {
		return days;
	}



	public Date getPreCheckin() {
		return preCheckin;
	}



	public Date getCheckin() {
		return checkin;
	}



	public Date getCheckout() {
		return checkout;
	}



	public double getPrice() {
		return price;
	}
	
	public OrderState getState() {
		return state;
	}
}
