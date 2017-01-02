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
	private String changeDate;
	private ChangeReason changeReason;
	private int changeValue, userID, Id;

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
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Column(name = "changeDate")
	public String getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}

	@Column(name = "reason")
	public ChangeReason getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(ChangeReason changeReason) {
		this.changeReason = changeReason;
	}

	@Column(name = "changeValue")
	public int getchangeValue() {
		return changeValue;
	}

	public void setchangeValue(int changeValue) {
		this.changeValue = changeValue;
	}

}
