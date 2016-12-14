package vo;

import po.CreditPO;
import tools.ChangeReason;
import tools.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreditVO {
	private Date change_date;
	private ChangeReason change_reason;
	private int last_value,current_value,user_id;
	private StringProperty date;
	private StringProperty reason;
	private StringProperty change;
	public CreditVO(Date date,ChangeReason reason,int last,int current,int user_id){
		this.change_date=date;
		this.change_reason=reason;
		this.last_value=last;
		this.current_value=current;
		this.user_id=user_id;
		//this.date=new SimpleStringProperty(date.getDate());
	}
	
	public CreditVO(CreditPO po){
		this.change_date=po.getChange_date();
		this.change_reason=po.getChange_reason();
		this.last_value=po.getLast_value();
		this.current_value=po.getCurrent_value();
		this.user_id=po.getUser_id();
	}
	
	public CreditPO topo(){
		return new CreditPO(change_date,change_reason,last_value,current_value,user_id);
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
