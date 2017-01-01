package bl.strategy_bl;

//<<<<<<< HEAD
import tools.*;
import rmi.RemoteHelper;
import data_stub.*;
import dao.strategy_dao.*;
import java.rmi.*;
import java.time.LocalDate;
import java.util.*;
import vo.*;
import po.OrderPO;
import po.UserPO;
import po.strategyPO.*;
import blservice.strategy_blservice.StrategyBLService;
//=======


//>>>>>>> origin/master

public class StrategyBL implements StrategyBLService{
	private StrategyDAO strategy;
	private RemoteHelper helper;
	
	public StrategyBL(){
		helper=RemoteHelper.getInstance();
		strategy=helper.getStrategyDAO();
	}

	
	public ResultMessage addStrategy(StrategyVO vo){
		try{
			System.out.println(vo.getName());
			return strategy.addStrategy(vo.toPO());
		} catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}//添加新策略
	
	public ResultMessage deleteStrategy(StrategyVO vo){
		try{
			StrategyPO po=vo.toPO();
			po.setFuckId(vo.getFuckId());
			return strategy.deleteStrategy(po);
		} catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}//删除策略
	
	public ResultMessage modifyStrategy(StrategyVO vo){
		try{
			StrategyPO po=vo.toPO();
			po.setFuckId(vo.getFuckId());
			return strategy.modifyStrategy(po);
		} catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}//修改策略
   
	public List<StrategyVO> getStrategyInHotel(int hotelId){
		List<StrategyVO> ret=new ArrayList<StrategyVO>();
		try{
			List<StrategyPO> list=strategy.getStrategyInHotel(hotelId);
			for(int i=0;i<list.size();i++){
			    ret.add(new StrategyVO(list.get(i)));
			}    
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return ret;
	}//获取酒店策略列表
	
	public List<StrategyVO> getStrategyInWeb(){
		List<StrategyVO> ret=new ArrayList<StrategyVO>();
		try{
			List<StrategyPO> list=strategy.getStrategyInWeb();
			System.out.println(list.size());
			for(int i=0;i<list.size();i++){
				if(list.get(i).getName().equals("AdminVipCost"))
					continue;
				else
					ret.add(new StrategyVO(list.get(i)));
			}
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return ret;
	}//获取网站策略列表
	
	public double getFinalPriceInHotel(UserVO user,OrderVO order,int hotelId){
		double finalPrice=0.00;
		finalPrice+=this.getLowestPrice(user, hotelId)+this.getRoomPrice(order, hotelId);
		return finalPrice;
	}//下完单后，最终综合折扣减少的价格
	
	/*public double getFinalPriceInWeb(UserVO user){
		double finalPrice=0.00;
		return finalPrice;
	}*/
	
	public double getLowestPrice(UserVO user,int hotelId){
		double lowestPrice=0.00;
		lowestPrice=this.getBirthPrice(user, hotelId)+this.getCooperationPrice(user, hotelId)
		+this.getTimePrice(hotelId)+this.getVipPrice(user);
		return lowestPrice;
	}//未下单时，综合折扣减少的价格
	
	public double getBirthPrice(UserVO user,int hotelId){
		double birthPrice=0.00;
		LocalDate now=LocalDate.now();
		List<StrategyVO> list=this.getStrategyInHotel(hotelId);
		for(int i=0;i<list.size();i++){
			StrategyVO temp=list.get(i);
			if(temp.getHotelId()==hotelId&&temp.getStrategyType()==StrategyType.BIRTHDAY){
				if(now.getYear()==user.getYear()&&now.getMonthValue()==user.getMonth()&&now.getDayOfMonth()==user.getDay()){
					birthPrice+=temp.getCost();
				}
			}
		}
		return birthPrice;
	}//酒店策略--生日折扣
	
	public double getTimePrice(int hotelId){
		double timePrice=0.00;
		LocalDate now=LocalDate.now();
		List<StrategyVO> list=this.getStrategyInHotel(hotelId);
		for(int i=0;i<list.size();i++){
			StrategyVO temp=list.get(i);
			if(temp.getStrategyType()==StrategyType.HOLIDAY&&temp.getHotelId()==hotelId){
				String startTime=temp.getStartTime();
				String endTime=temp.getEndTime();
				String[] temp1=startTime.split("/");
				String[] temp2=endTime.split("/");
				int sYear=Integer.valueOf(temp1[0]);
				int eYear=Integer.valueOf(temp2[0]);
				int sMonth=Integer.valueOf(temp1[1]);
				int eMonth=Integer.valueOf(temp2[1]);
				int sDay=Integer.valueOf(temp1[2]);
				int eDay=Integer.valueOf(temp2[2]);
				if(now.getYear()>=sYear&&now.getYear()<eYear){
					if(now.getMonthValue()>=sMonth){
						if(now.getDayOfMonth()>=sDay){
							timePrice+=temp.getCost();
						}
					}
				}
				else if(now.getYear()==sYear){
					if(now.getMonthValue()>=sMonth){
						if(now.getMonthValue()<eMonth){
							timePrice+=temp.getCost();
						}
						else if(now.getMonthValue()==eMonth){
							if(now.getDayOfMonth()<=eDay){
								timePrice+=temp.getCost();
							}
						}
					}
				}
			}
		}
		return timePrice;
	}//酒店策略--特定日期折扣
	
	public double getRoomPrice(OrderVO order,int hotelId){
		double roomPrice=0.00;
		List<StrategyVO> list=this.getStrategyInHotel(hotelId);
		for(int i=0;i<list.size();i++){
			StrategyVO temp=list.get(i);
			if(order.getRoomNum()>=3&&temp.getStrategyType()==StrategyType.TRIPLEROOM&&temp.getHotelId()==hotelId)
				roomPrice+=temp.getCost();
		}
		return roomPrice;
	}//酒店策略--三间房减少价
	
	public double getVipPrice(UserVO user){
		double vipPrice=0.00;
		
		return vipPrice;
	}//网站策略--vip折扣
	
	public double getCooperationPrice(UserVO user,int hotelId){
		double cooperationPrice=0.00;
		List<StrategyVO> list=this.getStrategyInHotel(hotelId);
		for(int i=0;i<list.size();i++){
			StrategyVO temp=list.get(i);
			if(temp.getStrategyType()==StrategyType.CO_OPERATION&&user.getType()==UserType.COMPANY_CUSTOMER&&temp.getHotelId()==hotelId)
				cooperationPrice+=temp.getCost();
		}
		return cooperationPrice;
	}//酒店策略--合作企业折扣
}
