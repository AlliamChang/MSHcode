package dao.strategy_dao;

import po.strategyPO.*;
import tools.ResultMessage;

public interface StrategyDao {
	public void init();
	
	public BirthDiscountPO getBirthDiscount();
	
	public PluralDiscountPO getPluralDiscount();
	
	public CoDiscountPO getCoDiscount();
	
	public DateDiscountPO getDateDiscount();
	
	public VipPlaceDiscountPO getVipDiscount();
	
	public RankDiscountPO getRankDiscount();

	public RankPO getRank();
    
	public ResultMessage setBirthDiscount();
	
	public ResultMessage setPluralDiscount();
	
	public ResultMessage setCoDiscount();
	
	public ResultMessage setDateDiscount();
	
	public ResultMessage setVipDiscount();
	
	public ResultMessage setRankDiscount();

	public ResultMessage setRank();

}
