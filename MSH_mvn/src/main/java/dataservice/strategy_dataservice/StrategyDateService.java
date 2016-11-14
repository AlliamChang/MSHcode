package dataservice.strategy_dataservice;

import po.strategyPO.*;
import tools.ResultMessage;

public interface StrategyDateService {
	public void init();
	
	public BirthDiscountPO getBirthDiscount();
	
	public PluralDiscountPO getPluralDiscount();
	
	public CoDiscountPO getCoDiscount();
	
	public DateDiscountPO getDateDiscount();
	
	public VipPlaceDiscountPO getVipPlaceDiscount();
	
	public RankDiscountPO getRankDiscount();

	public RankPO getRank();
	
	public ResultMessage setBirthDiscount();
	
	public ResultMessage setPluralDiscount();
	
	public ResultMessage setCoDiscount();
	
	public ResultMessage setDateDiscountVO();
	
	public ResultMessage setVipPlaceDiscount();
	
	public ResultMessage setRankDiscount();

	public ResultMessage setRank();

}
