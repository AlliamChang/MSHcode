package blservice.user_blservice;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.Image;
import tools.ResultMessage;
import vo.CreditVO;
import vo.UserVO;

public interface UserBLService {

	public List<UserVO> getAll();
	
	public List<UserVO> getAllMarketers();

	public UserVO get(String name);

	public ResultMessage add(UserVO userVO);

	public ResultMessage modify(UserVO userVO);

	public ResultMessage delete(int ID);
	
	public List<CreditVO> getCredit(int ID);
	
	public Image getImage(int ID);
	
	public ResultMessage modefyPassword(int ID, String password);
}
