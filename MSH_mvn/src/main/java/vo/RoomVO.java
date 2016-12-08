package vo;

import java.text.DecimalFormat;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tools.BedStyle;

public class RoomVO {
	private int hotel_id;
	private String roomStyle;
	private BedStyle bedStyle;
	private Double price;
	private int num;
	private int maxCustomer;
	private final DecimalFormat df = new DecimalFormat("#.00");
	
	/**
	 * 
	 * @param roomStyle
	 * @param bedStyle
	 * @param price
	 * @param num
	 * @param maxCustomer
	 */
	public RoomVO(String roomStyle,BedStyle bedStyle,double price,int num,int maxCustomer,int id){
		this.roomStyle = roomStyle;
		this.bedStyle = bedStyle;
		this.price = price;
		this.num = num;
		this.maxCustomer = maxCustomer;
		this.hotel_id=id;
	}
	
	//
	public StringProperty bedStyleProperty(){
		if(bedStyle == BedStyle.BUNK_BED)
			return new SimpleStringProperty("上下铺");
		else if(bedStyle == BedStyle.DOUBLE_BEDS)
			return new SimpleStringProperty("双人床");
		else
			return new SimpleStringProperty("大床");
	}
	public StringProperty priceProperty(){
		return new SimpleStringProperty(df.format(price));
	}

	public String getRoomStyle() {
		return roomStyle;
	}

	public void setRoomStyle(String roomStyle) {
		this.roomStyle = roomStyle;
	}

	public BedStyle getBedStyle() {
		return bedStyle;
	}

	public void setBedStyle(BedStyle bedStyle) {
		this.bedStyle = bedStyle;
	}
	
	public int getid(){
		return this.hotel_id;
	}
	
	public void setid(int id){
		this.hotel_id=id;
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

	public int getMaxCustomer() {
		return maxCustomer;
	}

	public void setMaxCustomer(int maxCustomer) {
		this.maxCustomer = maxCustomer;
	}
	
}
