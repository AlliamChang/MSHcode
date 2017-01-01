package vo;

import po.EvaluatePO;

public class EvaluateVO {
	private String content;
	private int hotel_id;
	private String date;
	private double score;
	private String username;
	
	public EvaluateVO(String content,String username,int hotel_id,String date,double score){
		this.content=content;
		this.hotel_id=hotel_id;
		this.date=date;
		this.score=score;
		this.username=username;
	}
	
	public EvaluateVO(EvaluatePO po){
		this.content=po.getContent();
		this.hotel_id=po.getHotel_id();
		this.username=po.getUsername();
		this.date=po.getTime();
		this.score=po.getScore();
	}
	
	public EvaluatePO topo(){
		EvaluatePO po=new EvaluatePO();
		po.setContent(this.content);
		po.setHotel_id(this.hotel_id);
		po.setScore(this.score);
		po.setTime(this.date);
		po.setUsername(this.username);
		return po;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
