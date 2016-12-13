package vo;

public class EvaluateVO {
	private String[] content;
	private int user_id;
	private String date;
	private double score;
	
	public EvaluateVO(String []content,int id,String date,double score){
		this.content=content;
		this.user_id=id;
		this.date=date;
		this.score=score;
	}
	
	public String []getContent(){
		return content;
	}
	
	public String getDate(){
		return date;
	}
	
	public int getId(){
		return user_id;
	}
	
	public void setContent(String[] content){
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
