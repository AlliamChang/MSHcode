package runner;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;

import dao.user_dao.UserDAO;
import daoImpl.user_dao_Impl.UserDAOImpl;
import po.UserPO;
import tools.UserType;

public class TestRunner {
	public static void main(String[] args){
		UserDAO daoTest = new UserDAOImpl();
		TestRunner test = new TestRunner();
		String readPath = "C:/Users/I Like Milk/Desktop/1.png";
		String writePath = "C:/Users/I Like Milk/Desktop/2.png";
		try {
//			daoTest.addUser(new UserPO("zxf", "hello", "郑晓峰", "男",
//					"15050582962", "南京大学", 1997, 6, 23, UserType.COMPANY_CUSTOMER, test.fileToByte(readPath)));
			UserPO po = daoTest.getUser(5);
			test.byteToFile(po.getImage(), writePath);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public byte[] fileToByte(String path){
		File f = new File(path);
		byte[] buffer = null;
		try {
			FileInputStream fis = new FileInputStream(f);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
			byte[] temp = new byte[1024];
			int n;
			while ((n = fis.read(temp)) != -1)
				bos.write(temp, 0, n);
			buffer = bos.toByteArray();
			fis.close();
			bos.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer;
	}
	
	public void byteToFile(byte[] b, String path){
		try {
			BufferedOutputStream putter = new BufferedOutputStream(new FileOutputStream(new File(path)));
			putter.write(b);
			putter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
