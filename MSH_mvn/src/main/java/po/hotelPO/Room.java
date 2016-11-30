package po.hotelPO;

public class Room {
	private String type;
	private int price;
	private int left_number;
	
	public Room(String type,int price,int num){
		this.type=type;
		this.price=price;
		this.left_number=num;
	}
	
	public String getType(){
		return this.type;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int getnum(){
		return this.left_number;
	}
	
	public void setType(String type){
		this.type=type;
	}
	
	public void setPrice(int price){
		this.price=price;
	}
	
	public void setnum(int num){
		this.left_number=num;
	}
}
