package blservice.strategy_blservice;

import tools.*;
import vo.*;

public interface StrategyBLService {
	public StrategyVO getStrategyType();
	
	public StrategyVO getName();
	
	public StrategyVO getStartTime();
	
	public StrategyVO getEndTime();
	
	public ResultMessage setBirthDiscount(int cost);
	
	public ResultMessage setPluralDiscount(int cost);
	
	public ResultMessage setCoDiscount();
	
	public ResultMessage setDateDiscount();
	
	public ResultMessage setVipPlaceDiscount();
	
	public ResultMessage setRankDiscount();

	public ResultMessage setRank();
}
