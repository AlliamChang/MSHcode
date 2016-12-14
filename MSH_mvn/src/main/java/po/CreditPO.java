package po;

import java.io.Serializable;

import tools.ChangeReason;
import tools.Date;
import vo.CreditVO;

public class CreditPO implements Serializable{
	private Date change_date;
	private ChangeReason change_reason;
	private int last_value,current_value,user_id;

	public CreditPO(Date date,ChangeReason change,int last,int current,int user_id){
		this.change_date=date;
		this.change_reason=change;
		this.last_value=last;
		this.current_value=current;
		this.user_id=user_id;
	}

	public CreditPO(CreditVO creditVO) {
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Date getChange_date() {
		return change_date;
	}

	public void setChange_date(Date change_date) {
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
	
	public CreditVO tovo(){
		return new CreditVO(change_date,change_reason,last_value,current_value,user_id);
	}
}
