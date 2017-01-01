package po;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="evaluate")
public class EvaluatePO implements Serializable{
	private static final long serialVersionUID = -2750505292836257473L;
	private double score;
	private String content;
	private String time;
	private String username;
	private int hotel_id;
	private int id;
	
	public EvaluatePO(){}
@Column(name="score")
	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
@Column(name="content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
@Column(name="time")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
@Column(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
@Column(name="hotel_id")
	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
@Id
@Column(name="id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
