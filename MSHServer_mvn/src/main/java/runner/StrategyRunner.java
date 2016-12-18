package runner;

import java.rmi.RemoteException;

import dao.strategy_dao.*;
import daoImpl.strategyDaoImpl.*;
import po.strategyPO.*;
import tools.OrderState;
import tools.StrategyType;
import tools.*;

public class StrategyRunner {
	public static void main(String[] args){
		StrategyDAO daoTest = new StrategyDAOImpl();
		try{
			StrategyPO po = new StrategyPO("double13",StrategyType.BIRTHDAY,"南京市","栖霞区",
					"2016/11/11","2016/11/12","99.00",PeopleType.VIP);
			daoTest.addStrategy(po);
		
		}catch(RemoteException e){
			e.printStackTrace();
		}
	}

}
