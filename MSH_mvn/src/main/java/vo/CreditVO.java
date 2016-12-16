package vo;

import po.CreditPO;
import tools.ChangeReason;
import tools.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreditVO {
	private Date change_date;
	private ChangeReason change_reason;
	private int changeValue, user_id;
	private StringProperty date;
	private StringProperty reason;
	private StringProperty change;
	public CreditVO(Date date,ChangeReason reason,int changeValue, int user_id){
		this.change_date=date;
		this.change_reason=reason;
		this.changeValue = changeValue;
		this.user_id=user_id;
		//this.date=new SimpleStringProperty(date.getDate());
	}
	
	public CreditVO(CreditPO po){
		this.change_date=new Date(po.getChange_date(), true);
		this.change_reason=po.getChange_reason();
		this.changeValue = po.getchangeValue();
		this.user_id=po.getUser_id();
	}
	
	public CreditPO toPO(){
		CreditPO po = new CreditPO();
		po.setChange_date(this.change_date.getDate());
		po.setChange_reason(change_reason);
		po.setchangeValue(changeValue);
		po.setUser_id(user_id);
		return po;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getdate(){
		return this.change_date;
	}
	
	public StringProperty dateProperty(){
		date= new SimpleStringProperty(change_date.getDate());
		return date;
	}
	
	public ChangeReason getreason(){
		return this.change_reason;
	}
	
	public StringProperty reasonProperty(){
		if(change_reason==ChangeReason.OFFLINE_RECHARGE)
			reason= new SimpleStringProperty("线下充值");
		else if(change_reason==ChangeReason.NORMAL_EXE)
			reason= new SimpleStringProperty("正常执行订单");
		else if(change_reason==ChangeReason.ABNORMAL_ORDER)
			reason= new SimpleStringProperty("有订单未正常执行");
		else reason=new SimpleStringProperty("返还信用值");
		return reason;
	}
	
	public StringProperty changeProperty(){
		change= new SimpleStringProperty((this.changeValue > 0 ? "+" : "") + String.valueOf(changeValue));
		return change;
	}
	
	public void setdate(Date date){
		this.change_date=date;
	}
	
	public void setreason(ChangeReason reason){
		this.change_reason=reason;
	}

	public int getChangeValue() {
		return changeValue;
	}

	public void setChangeValue(int changeValue) {
		this.changeValue = changeValue;
	}

}
