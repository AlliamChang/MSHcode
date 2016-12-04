package vo;

import javafx.scene.image.Image;

public class HotelInfoVO {

	private String adress;
	private String hotel;
	private String phone;
	private String[] facility;
	private String introduction;
	private String province;
	private String tradingArea;
	private int year;
	private Image scul;
	private int star;
	private double score;
	
	public HotelInfoVO(String hotel, String adress,String phone, String[] facility, String introduction, String province,
			String tradingArea,int year,Image scul,int star,double score) {
		this.hotel = hotel;
		this.adress = adress;
		this.phone = phone;
		this.facility = facility;
		this.introduction = introduction;
		this.province = province;
		this.tradingArea = tradingArea;
		this.year = year;
		this.scul = scul;
		this.star=star;
		this.score=score;
	}
	
	public Image getScul() {
		return scul;
	}

	public void setScul(Image scul) {
		this.scul = scul;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getHotel() {
		return hotel;
	}
	public void setHotel(String hotel) {
		this.hotel = hotel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getFacility() {
		return facility;
	}
	public void setFacility(String[] facility) {
		this.facility = facility;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getTradingArea() {
		return tradingArea;
	}
	public void setTradingArea(String tradingArea) {
		this.tradingArea = tradingArea;
	}
	
	public double getscore(){
		return score;
	}
	
	public void setScore(double score){
		this.score=score;
	}
	
	public int star(){
		return star;
	}
	
	public void setStar(int star){
		this.star=star;
	}
}
