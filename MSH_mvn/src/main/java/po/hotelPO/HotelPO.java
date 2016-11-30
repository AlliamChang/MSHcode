package po.hotelPO;

import java.util.List;

public class HotelPO {
	private String id,address,trade_area,city,name;
	private int lowest_price,star_level;
	private double score;
	private List<Room>room;
	//private boolean isEmpty;
	
	public HotelPO(String id,String name,String address,String trade_area,String city,int lowest_price,double score,int star_level,List<Room>room){
		this.id=id;
		this.name=name;
		this.address=address;
		this.trade_area=trade_area;
		this.city=city;
		this.lowest_price=lowest_price;
		this.score=score;
		this.star_level=star_level;
		this.room=room;
	}
	
	public String getid(){
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
	
	public void setid(String id){
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
	
	
}
