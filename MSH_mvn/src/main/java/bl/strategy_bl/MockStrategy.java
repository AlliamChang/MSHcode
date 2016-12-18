package bl.strategy_bl;

import tools.PeopleType;
import tools.StrategyType;
import vo.*;

public class MockStrategy extends StrategyBL{
	double price;
	String hotel;
	public MockStrategy (double p){
		price=p;
	}
	
	public double setPrice(){
		return price*0.9;
	}
	
	public StrategyVO getStrategy(String hotel){
		return new StrategyVO("11",StrategyType.VIP,"南京市","栖霞区","2016/11/11"
				,"2016/11/12",99.00,PeopleType.NORMAL);
	}
	
	
	
	

}
