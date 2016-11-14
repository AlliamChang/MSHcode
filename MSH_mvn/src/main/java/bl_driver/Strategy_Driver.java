package bl_driver;

import blservice.strategy_blservice.*;
import vo.*;
import tools.*;

public class Strategy_Driver {
	public void drive(StrategyBLService ss){
		ResultMessage result1=ss.setBirthDiscount(400);
		if(result1==result1.SUCCESS)
			System.out.println("succeed");
		
		ResultMessage result2=ss.setCoDiscount();
		if(result2==result2.SUCCESS)
			System.out.println("succeed");
		
		ResultMessage result3=ss.setDateDiscount();
		if(result3==result3.SUCCESS)
			System.out.println("succeed");
		
		ResultMessage result4=ss.setPluralDiscount(400);
		if(result4==result4.SUCCESS)
			System.out.println("succeed");
		
		ResultMessage result5=ss.setRank();
		if(result5==result5.SUCCESS)
			System.out.println("succeed");
		
		ResultMessage result6=ss.setVipPlaceDiscount();
		if(result6==result6.SUCCESS)
			System.out.println("succeed");
		
		ResultMessage result7=ss.setRankDiscount();
		if(result7==result7.SUCCESS)
			System.out.println("succeed");
		
		CoDiscountVO result8=ss.getCoDiscount();
		if(result8==null)
			System.out.println("succeed");
		
		BirthDiscountVO result9=ss.getBirthDiscount();
		if(result9==null)
			System.out.println("succeed");
		
		DateDiscountVO result10=ss.getDateDiscount();
		if(result10==null)
			System.out.println("succeed");
		
		VipPlaceDiscountVO result11=ss.getVipPlaceDiscount();
		if(result11==null)
			System.out.println("succeed");
		
		RankDiscountVO result12=ss.getRankDiscount();
		if(result12==null)
			System.out.println("succeed");
		
		RankVO result13=ss.getRank();
		if(result13==null)
			System.out.println("succeed");
		
		PluralDiscountVO result14=ss.getPluralDiscount();
		if(result14==null)
			System.out.println("succeed");
			
	}

}
