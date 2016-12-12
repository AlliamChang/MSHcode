package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RemoteHelper {
	public RemoteHelper(){
		initServer();
	}
	
	public void initServer(){
		RemoteImpl remoteImpl;
		try {
			remoteImpl = new RemoteImpl();
			LocateRegistry.createRegistry(8888);
			Naming.bind("rmi://localhost:8888/RemoteImpl",
					remoteImpl);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
		
	}
}
