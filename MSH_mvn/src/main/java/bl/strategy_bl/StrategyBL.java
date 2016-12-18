package bl.strategy_bl;

//<<<<<<< HEAD
import tools.*;
import rmi.RemoteHelper;
import data_stub.*;
import dao.strategy_dao.*;
import java.rmi.*;
import java.util.*;
import vo.*;
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
			return strategy.addStrategy(vo.toPO());
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	
	public ResultMessage deleteStrategy(String name){
		try{
			return strategy.deleteStrategy(name);
		} catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	public ResultMessage modifyStrategy(StrategyVO vo){
		try{
			return strategy.modifyStrategy(vo.toPO());
		} catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
   
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
			for(int i=0;i<list.size();i++){
				ret.add(new StrategyVO(list.get(i)));
			}
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return ret;
	}//获取网站策略列表
	
	public double getFinalPriceInHotel(UserVO user,OrderVO order,int hotelId){
		double finalPrice=0.00;
		try{
			finalPrice=strategy.getFinalPriceInHotel(user.toPO(), order.toPO(), hotelId);
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return finalPrice;
	}//下完单后，最终综合折扣减少的价格
	
	public double getFinalPriceInWeb(UserVO user){
		double finalPrice=0.00;
		try{
			finalPrice=strategy.getFinalPriceInWeb(user.toPO());
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return finalPrice;
	}
	
	public double getLowestPrice(UserVO user,int hotelId){
		double lowestPrice=0.00;
		try{
			lowestPrice=strategy.getLowestPrice(user.toPO(), hotelId);
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return lowestPrice;
	}//未下单时，综合折扣减少的价格
}
