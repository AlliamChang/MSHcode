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
	private OrderDAOStub order;
	private UserDAOStub user;
	
	public ResultMessage add(StrategyVO vo){
		try{
			return strategy.add(vo.toPO());
		} catch (RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FAIL;
	}
	
	public ResultMessage delete(String name){
		try{
			return strategy.delete(name);
		} catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
	
	public ResultMessage modify(StrategyVO vo){
		try{
			return strategy.modify(vo.toPO());
		} catch (RemoteException e){
			e.printStackTrace();
			return ResultMessage.FAIL;
		}
	}
   
	public ArrayList<StrategyVO> getStrategy(String hotelName) throws RemoteException{
		return strategy.getStrategy(hotelName);
	}
	
	public double getFinalPrice(OrderVO order,UserVO user) throws RemoteException{
		return 0.0;
	}
}
