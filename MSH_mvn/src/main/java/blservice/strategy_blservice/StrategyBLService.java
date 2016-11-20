package blservice.strategy_blservice;

import tools.*;
import vo.*;

public interface StrategyBLService {
	public BirthDiscountVO getBirthDiscount();

	public PluralDiscountVO getPluralDiscount();

	public CoDiscountVO getCoDiscount();

	public DateDiscountVO getDateDiscount();

	public VipPlaceDiscountVO getVipPlaceDiscount();

	public RankDiscountVO getRankDiscount();

	public RankVO getRank();

	public ResultMessage setBirthDiscount(int cost);

	public ResultMessage setPluralDiscount(int cost);

	public ResultMessage setCoDiscount();

	public ResultMessage setDateDiscount();

	public ResultMessage setVipPlaceDiscount();

	public ResultMessage setRankDiscount();

	public ResultMessage setRank();
}
