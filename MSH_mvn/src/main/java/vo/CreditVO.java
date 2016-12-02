package vo;

import tools.ChangeReason;
import tools.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreditVO {
	private Date change_date;
	private ChangeReason change_reason;
	private int last_value,current_value;
	private StringProperty date;
	private StringProperty reason;
	private StringProperty change;
	public CreditVO(Date date,ChangeReason reason,int last,int current){
		this.change_date=date;
		this.change_reason=reason;
		this.last_value=last;
		this.current_value=current;
		//this.date=new SimpleStringProperty(date.getDate());
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
		change= new SimpleStringProperty(last_value+"-"+current_value);
		return change;
	}
	public int getlast(){
		return this.last_value;
	}
	
	public int getcurrent(){
		return this.current_value;
	}
	
	public void setdate(Date date){
		this.change_date=date;
	}
	
	public void setreason(ChangeReason reason){
		this.change_reason=reason;
	}
	
	public void setlast(int last){
		this.last_value=last;
	}
	
	public void setcurrent(int current){
		this.current_value=current;
	}
}
