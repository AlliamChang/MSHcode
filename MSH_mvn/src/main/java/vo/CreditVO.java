package vo;

import po.CreditPO;
import tools.ChangeReason;
import tools.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreditVO {
	private Date changeDate;
	private ChangeReason changeReason;
	private int changeValue, userID;
	private StringProperty date;
	private StringProperty reason;
	private StringProperty change;
	public CreditVO(Date date,ChangeReason reason,int changeValue, int userID){
		this.changeDate=date;
		this.changeReason=reason;
		this.changeValue = changeValue;
		this.userID=userID;
		//this.date=new SimpleStringProperty(date.getDate());
	}
	
	public CreditVO(CreditPO po){
		this.changeDate=new Date(po.getChangeDate(), true);
		this.changeReason=po.getChangeReason();
		this.changeValue = po.getchangeValue();
		this.userID=po.getUserID();
	}
	
	public CreditPO toPO(){
		CreditPO po = new CreditPO();
		po.setChangeDate(this.changeDate == null ? null : this.changeDate.getDate());
		po.setChangeReason(changeReason);
		po.setchangeValue(changeValue);
		po.setUserID(userID);
		return po;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getdate(){
		return this.changeDate;
	}
	
	public StringProperty dateProperty(){
		date= new SimpleStringProperty(changeDate.getDate());
		return date;
	}
	
	public ChangeReason getreason(){
		return this.changeReason;
	}
	
	public StringProperty reasonProperty(){
		if(changeReason==ChangeReason.OFFLINE_RECHARGE)
			reason= new SimpleStringProperty("线下充值");
		else if(changeReason==ChangeReason.NORMAL_EXE)
			reason= new SimpleStringProperty("正常执行订单");
		else if(changeReason==ChangeReason.ABNORMAL_ORDER)
			reason= new SimpleStringProperty("有订单未正常执行");
		else reason=new SimpleStringProperty("返还信用值");
		return reason;
	}
	
	public StringProperty changeProperty(){
		change= new SimpleStringProperty((this.changeValue > 0 ? "+" : "") + String.valueOf(changeValue));
		return change;
	}
	
	public void setdate(Date date){
		this.changeDate=date;
	}
	
	public void setreason(ChangeReason reason){
		this.changeReason=reason;
	}

	public int getChangeValue() {
		return changeValue;
	}

	public void setChangeValue(int changeValue) {
		this.changeValue = changeValue;
	}

}
