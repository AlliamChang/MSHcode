package blservice.user_blservice;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;

public interface UserBLService {
	
	public List<UserVO> getAllMarketers();

	public UserVO get(int ID);
	
	public UserVO get(String name);

	public int add(UserVO userVO);

	public ResultMessage modify(UserVO userVO);

	public ResultMessage delete(int ID);
	
	public List<CreditVO> getCredit(int ID);
	
	public Image getImage(int ID);
	
	public ResultMessage modifyPassword(int ID, String password);
	
	public List<String> getReservationHistory(int ID);
}
