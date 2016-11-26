package tools;

public class Date {
	
	boolean hasTime;
	String date;
	
	public Date(String date,boolean hasTime){
		this.date = date;
		this.hasTime = hasTime;
		
	}

	public String getDate(){
		return date;
	}
}
