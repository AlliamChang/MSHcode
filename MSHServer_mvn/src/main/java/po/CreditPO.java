package po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import tools.ChangeReason;

@Entity
@Table(name = "creditrecord")
public class CreditPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2750505292836257473L;
	private String change_date;
	private ChangeReason change_reason;
	private int changeValue, user_id, Id;

	public CreditPO(){}
	
	@Id
	@Column(name = "Id")
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Column(name = "userID")
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	@Column(name = "changeDate")
	public String getChange_date() {
		return change_date;
	}

	public void setChange_date(String change_date) {
		this.change_date = change_date;
	}

	@Column(name = "reason")
	public ChangeReason getChange_reason() {
		return change_reason;
	}

	public void setChange_reason(ChangeReason change_reason) {
		this.change_reason = change_reason;
	}

	@Column(name = "changeValue")
	public int getchangeValue() {
		return changeValue;
	}

	public void setchangeValue(int changeValue) {
		this.changeValue = changeValue;
	}

}
