package vo;

public class EvaluateVO {
	private String content;
	private String user_id;
	private String date;
	private double score;
	
	public EvaluateVO(String content,String id,String date,double score){
		this.content=content;
		this.user_id=id;
		this.date=date;
		this.score=score;
	}
	
	public String getcontent(){
		return content;
	}
	
	public String getdate(){
		return date;
	}
	
	public String getid(){
		return user_id;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	
	public void setId(String id){
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
