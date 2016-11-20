package bl.strategy_bl;

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
		return new StrategyVO();
	}
	
	
	
	

}
