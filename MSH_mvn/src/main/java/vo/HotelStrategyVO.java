package vo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tools.CostType;
import tools.Date;
import tools.HotelStrategyType;

public class HotelStrategyVO {

	private String name;
	private HotelStrategyType type;
	private CostType discountType;
	private double discount;
	private Date begin;
	private Date end;
	
	public HotelStrategyVO(String name, HotelStrategyType type,CostType discontType, double discont, Date begin, Date end) {
		super();
		this.name = name;
		this.type = type;
		this.discountType = discontType;
		this.discount = discont;
		this.begin = begin;
		this.end = end;
	}
	
	public StringProperty typeProperty(){
		if(type == HotelStrategyType.BIRTH)
			return new SimpleStringProperty("生日特惠");
		else if(type == HotelStrategyType.BUSINESS)
			return new SimpleStringProperty("合作企业特惠");
		else if(type == HotelStrategyType.FESTIVAL)
			return new SimpleStringProperty("节假日特惠");
		else if(type == HotelStrategyType.MORE_ROOMS)
			return new SimpleStringProperty("多房间特惠");
		else
			return new SimpleStringProperty("错误");
	}
	public StringProperty discontProperty(){
		if(discountType == CostType.PERCENT)
			return new SimpleStringProperty( "-" + discount + "%");
		else if(discountType == CostType.RMB)
			return new SimpleStringProperty("-¥" + discount);
		else
			return new SimpleStringProperty("错误");
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HotelStrategyType getType() {
		return type;
	}

	public void setType(HotelStrategyType type) {
		this.type = type;
	}

	public CostType getDiscontType() {
		return discountType;
	}

	public void setDiscontType(CostType discontType) {
		this.discountType = discontType;
	}

	public double getDiscont() {
		return discount;
	}

	public void setDiscont(double discont) {
		this.discount = discont;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
	
}
