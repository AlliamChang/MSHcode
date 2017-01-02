package po;

import java.io.Serializable;

import tools.ChangeReason;

public class CreditPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2750505292836257473L;
	private String changeDate;
	private ChangeReason changeReason;
	private int changeValue, userID, Id;

	public CreditPO(){}
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	public ChangeReason getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(ChangeReason changeReason) {
		this.changeReason = changeReason;
	}

	public int getchangeValue() {
		return changeValue;
	}

	public void setchangeValue(int changeValue) {
		this.changeValue = changeValue;
	}

}
