package runner;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import daoImpl.orderDaoImpl.OrderDaoImpl;

public class RemoteHelper {
	public RemoteHelper(){
		initServer();
	}
	
	private void initServer(){
		try{
			LocateRegistry.createRegistry(1098);
			Naming.bind("rmi://192.168.1.102:1098/OrderDao", new OrderDaoImpl());
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(MalformedURLException e){
			e.printStackTrace();
		}catch(AlreadyBoundException e){
			e.printStackTrace();
		}
	}
}
