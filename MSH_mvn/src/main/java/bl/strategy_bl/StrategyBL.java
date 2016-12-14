package bl.strategy_bl;

//<<<<<<< HEAD
import tools.*;
import data_stub.*;
import java.rmi.*;
import java.util.*;
import vo.*;
import po.strategyPO.*;
import blservice.strategy_blservice.StrategyBLService;
//=======


//>>>>>>> origin/master

public class StrategyBL implements StrategyBLService{
	private StrategyDAOStub strategy;

	
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
   
	public ArrayList<StrategyVO> getStrategyInHotel(int hotelId){
		ArrayList<StrategyVO> ret=new ArrayList<StrategyVO>();
		try{
			ArrayList<StrategyPO> list=strategy.getStrategyInHotel(hotelId);
			for(int i=0;i<list.size();i++){
			    ret.add(new StrategyVO(list.get(i)));
			}    
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return ret;
	}
	
	public ArrayList<StrategyVO> getStrategyInWeb(){
		ArrayList<StrategyVO> ret=new ArrayList<StrategyVO>();
		try{
			ArrayList<StrategyPO> list=strategy.getStrategyInWeb();
			for(int i=0;i<list.size();i++){
				ret.add(new StrategyVO(list.get(i)));
			}
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return ret;
	}
	
	public double getFinalPriceInHotel(UserVO user,OrderVO order,RoomVO room,int hotelId){
		double finalPrice=0.00;
		try{
			finalPrice=strategy.getFinalPriceInHotel(user.toPO(), room.toPO(), order.toPO(), hotelId);
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return finalPrice;
	}
	
	public double getFinalPriceInWeb(UserVO user){
		double finalPrice=0.00;
		try{
			finalPrice=strategy.getFinalPriceInWeb(user.toPO());
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return finalPrice;
	}
}
