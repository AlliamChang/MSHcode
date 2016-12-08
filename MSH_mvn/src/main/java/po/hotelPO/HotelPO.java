package po.hotelPO;

import java.util.List;

import javafx.scene.image.Image;
import vo.HotelInfoVO;

public class HotelPO {
	private String address,trade_area,city,name,phone,introduction,province;
	private int id,lowest_price,star_level,stuff_id,year;
	private double score;
	private String[]facility;
	private Image scul;
	private List<RoomPO>room;
	//private boolean isEmpty;
	
	public HotelPO(HotelInfoVO vo){
		this.id=vo.get_hotel_id();
		this.name=vo.getHotel();
		this.address=vo.getAdress();
		this.trade_area=vo.getTradingArea();
		this.city=vo.getCity();
		//this.lowest_price=vo.get
		this.score=vo.getscore();
		this.star_level=vo.star();
		this.scul=vo.getScul();
		this.stuff_id=vo.get_stuff_id();
		this.phone=vo.getPhone();
		this.year=vo.getYear();
		this.introduction=vo.getIntroduction();
		this.facility=vo.getFacility();
		this.province=vo.getProvince();
		
		//this.room=room;
	}
	public String getProvince(){
		return this.province;
	}
	
	public String getIntro(){
		return this.introduction;
	}
	
	public String[] getfaci(){
		return this.facility;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public int getStuff_id(){
		return this.stuff_id;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public void setIntro(String intro){
		this.introduction=intro;
	}
	
	public void setFac(String[] fac){
		this.facility=fac;
	}
	
	public void setPhone(String phone){
		this.phone=phone;
	}
	
	public void setStuff(int id){
		this.stuff_id=id;
	}
	
	public void setProvince(String pro){
		this.province=pro;
	}
	
	public void setYear(int year){
		this.year=year;
	}
	
	public int getid(){
		return this.id;
	}
	public String getname(){
		return this.name;
	}
	public String getaddress(){
		return this.address;
	}
	
	public String gettrade_area(){
		return this.trade_area;
	}
	
	public String getcity(){
			return this.city;
}
	
	public int getlowest_price(){
		return this.lowest_price;
	}
	
	public double getscore(){
			return this.score;
}
	public int getstar_level(){
		return this.star_level;
	}
	
	public void setid(int id){
		this.id=id;
	}
	
	public void setname(String name){
		this.name=name;
	}
	public void setaddress(String address){
		this.address=address;
	}
	
	public void settrade_area(String trade_area){
		this.trade_area=trade_area;
	}
	
	public void setcity(String city){
		this.city=city;
	}
	
	public void setlowest_price(int price){
		this.lowest_price=price;
	}
	
	public void setscore(double score){
		this.score=score;
	}
	
	public void setstar_level(int level){
		this.star_level=level;
	}
	
	public HotelInfoVO tovo(){
		return new HotelInfoVO(name, address, phone, facility, introduction, province, trade_area, year, scul, star_level, score, id, stuff_id,city);
	}
	
	
}
