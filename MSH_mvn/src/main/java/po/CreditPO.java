package po;

import java.io.Serializable;

import tools.ChangeReason;

public class CreditPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7231641345089065830L;
	private String change_date;
	private ChangeReason change_reason;
	private int last_value,current_value,user_id, Id;

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

	public int getLast_value() {
		return last_value;
	}

	public void setLast_value(int last_value) {
		this.last_value = last_value;
	}

	public int getCurrent_value() {
		return current_value;
	}

	public void setCurrent_value(int current_value) {
		this.current_value = current_value;
	}
}
