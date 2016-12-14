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
	
	public HotelPO(String address,String trade_area,String city,String province,String name,String phone,String introductin,int id,int star_level,int stuff_id,int year,double score,Image scul,String[]facility){
		this.id=id;
		this.name=name;
		this.address=address;
		this.trade_area=trade_area;
		this.city=city;
		//this.lowest_price=vo.get
		this.score=score;
		this.star_level=star_level;
		this.scul=scul;
		this.stuff_id=stuff_id;
		this.phone=phone;
		this.year=year;
		this.introduction=introduction;
		this.facility=facility;
		this.province=province;
		
		//this.room=room;
	}
	public Image getScul() {
		return scul;
	}
	public void setScul(Image scul) {
		this.scul = scul;
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
