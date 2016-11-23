package bl_stub;

import vo.*;
import tools.*;
import blservice.strategy_blservice.*;

public class Strategy_Stub implements StrategyBLService {
	double discount;
	String birthday;
	int room;// ��������
	String date;
	String place;
	int rank;
	int credit;
	String type;// �ͻ�����
	ResultMessage result;

	public Strategy_Stub(double dis, String birth, int rm, String dt,
			String pl, int rk, int cre, String tp) {
		discount = dis;
		birthday = birth;
		room = rm;
		date = dt;
		place = pl;
		rank = rk;
		credit = cre;
		type = tp;
	}

	public BirthDiscountVO getBirthDiscount() {
		return null;
	}

	public PluralDiscountVO getPluralDiscount() {
		return null;
	}

	public DateDiscountVO getDateDiscount() {
		return null;
	}

	public CoDiscountVO getCoDiscount() {
		return null;
	}

	public VipPlaceDiscountVO getVipPlaceDiscount() {
		return null;
	}

	public RankDiscountVO getRankDiscount() {
		return null;
	}

	public RankVO getRank() {
		return null;
	}

	public ResultMessage setBirthDiscount(int cost) {
		return null;
	}

	public ResultMessage setPluralDiscount(int cost) {
		return null;
	}

	public ResultMessage setDateDiscount() {
		return null;
	}

	public ResultMessage setCoDiscount() {
		return null;
	}

	public ResultMessage setVipPlaceDiscount() {
		return null;
	}

	public ResultMessage setRankDiscount() {
		return null;
	}

	public ResultMessage setRank() {
		return null;
	}

	public StrategyVO getStrategyType() {
		// TODO Auto-generated method stub
		return null;
	}

	public StrategyVO getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public StrategyVO getStartTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public StrategyVO getEndTime() {
		// TODO Auto-generated method stub
		return null;
	}

}
