package vo;

import po.EvaluatePO;

public class EvaluateVO {
	private String content;
	private int user_id;
	private String date,name;
	private double score;
	
	public EvaluateVO(String content,String name,int id,String date,double score){
		this.content=content;
		this.user_id=id;
		this.date=date;
		this.score=score;
		this.name=name;
	}
	
	public EvaluateVO(EvaluatePO po){
		this.content=po.getContent();
		this.user_id=po.getUser_id();
		this.name=po.getName();
		this.date=po.getDate();
		this.score=po.getScore();
	}
	
	public EvaluatePO topo(){
		return new EvaluatePO(content,name,user_id,date,score);
	}
	
	public String getContent(){
		return content;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate(){
		return date;
	}
	
	public int getId(){
		return user_id;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	
	public void setId(int id){
		this.user_id=id;
	}
	
	public void setDate(String date){
		this.date=date;
	}
	
	public void setScore(double score){
		this.score=score;
	}
	
	public double getScore(){
		return score;
	}
}
