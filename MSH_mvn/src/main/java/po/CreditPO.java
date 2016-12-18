package po;

import java.io.Serializable;

import tools.ChangeReason;

public class CreditPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2750505292836257473L;
	private String change_date;
	private ChangeReason change_reason;
	private int changeValue, user_id, Id;

	public CreditPO(){}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getChange_date() {
		return change_date;
	}

	public void setChange_date(String change_date) {
		this.change_date = change_date;
	}

	public ChangeReason getChange_reason() {
		return change_reason;
	}

	public void setChange_reason(ChangeReason change_reason) {
		this.change_reason = change_reason;
	}

	public int getchangeValue() {
		return changeValue;
	}

	public void setchangeValue(int changeValue) {
		this.changeValue = changeValue;
	}

}
