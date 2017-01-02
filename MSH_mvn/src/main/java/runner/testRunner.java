package runner;

import java.rmi.Naming;
import ui.utility.MainPane;
import ui.webAdmin.*;

import java.rmi.Naming;
import java.rmi.RemoteException;

import bl.user_bl.UserBLServiceImpl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.RemoteHelper;
import tools.ChangeReason;
import tools.UserType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rmi.RemoteHelper;
import ui.websiteStuff.*;
import vo.CreditVO;
import vo.UserVO;
import ui.utility.MainPane;

public class testRunner{
	private RemoteHelper remoteHelper;
	
	public static void main(String[] args) {
		testRunner test = new testRunner();
		test.linkToServer();
		UserVO u1 = new UserVO("testUser1", "123456", "长者", "男", "110", null, null, 1926, 8, 17, UserType.CUSTOMER);
		UserBLServiceImpl ub = new UserBLServiceImpl();
		int id = ub.add(u1);
		ub.addCreditRecord(new CreditVO(null, ChangeReason.ABNORMAL_ORDER, -1000, id));
	}
	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://172.26.91.91:8888/RemoteImpl"));
			System.out.println("linked");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
