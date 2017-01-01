package tools;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageConverter {
	public static byte[] fileToByte(String path){
		File f = new File(path);
System.out.println(path);
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
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return buffer;
	}
	
	public static void byteToFile(byte[] b, String path){
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
