package po;

import vo.EvaluateVO;

public class EvaluatePO {
	private String[]content;
	private int user_id;
	private String date;
	private double score;
	
	public EvaluatePO(String[]content,int user_id,String date,double score){
		this.content=content;
		this.user_id=user_id;
		this.date=date;
		this.score=score;
	}

	public String[] getContent() {
		return content;
	}

	public void setContent(String[] content) {
		this.content = content;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	
	public EvaluateVO tovo(){
		return new EvaluateVO(content,user_id,date,score);
	}
}
