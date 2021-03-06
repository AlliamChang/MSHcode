package ui.webAdmin;

import java.util.List;
import java.util.Arrays;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import ui.utility.MainPane;
import ui.utility.MyNavigationBar;
import vo.CreditVO;
import vo.HotelInfoVO;
import vo.UserVO;
import bl.hotel.HotelBLServiceImpl;
import bl.user.UserBLServiceImpl;
import blservice.hotel.HotelBLService;
import blservice.user.UserBLService;

public class WebAdminController {
	private static WebAdminController INSTANCE;
	public static WebAdminController getInstance(){
		return INSTANCE != null ? INSTANCE : (INSTANCE = new WebAdminController());
	}
	
	private UserBLService userBLService;
	private HotelBLService hotelBLService;
	
	private MyNavigationBar naviBar;
	
	private WebAdminController(){
		userBLService = new UserBLServiceImpl();
		hotelBLService = new HotelBLServiceImpl();
	}
	
	public void init(){
		naviBar = new MyNavigationBar(new Image(getClass().getResource("/image/default.png").toExternalForm(), 120, 120, false, false),
				Arrays.asList("Administrator"),
				Arrays.asList("查询用户", "营销人员", "浏览酒店"));
		MainPane.getInstance().setNavigationBar(naviBar);
		MainPane.getInstance().login(0);
		naviBar.getToggle().selectedToggleProperty().addListener((o, oldValue, newValue) -> {
			if(newValue != null && !newValue.equals(oldValue)){
				String temp = newValue.toString().split("'")[1];
				switch(temp){
				case "查询用户":
					setInitialPane();
					break;
				case "营销人员":
					setBrowseMarketersPane();
					break;
				case "浏览酒店":
					setBrowseHotelPane();
					break;
				}
			}
		});
		setInitialPane();
	}
	
	public void setInitialPane(){
		MainPane.getInstance().setRightPane(new InitialPane());
	}
	
	public void setBrowseMarketersPane(){
		MainPane.getInstance().setRightPane(new BrowseMarketersPane());
	}
	
	public void setBrowseHotelPane(){
		MainPane.getInstance().setRightPane(new BrowseHotelPane());
	}
	
	public void setModifyUserInfo(UserVO user, Parent lastPane){
		MainPane.getInstance().setRightPane(new ModifyUserInfoPane(user, lastPane));
	}
	
	public void setAddMarketerPane(){
		MainPane.getInstance().setRightPane(new AddMarketerPane());
	}
	
	public void setAddHotelPane(){
		MainPane.getInstance().setRightPane(new AddHotelPane());
	}
	
	public void setAddHotelStaffPane(AddHotelPane owner){
		MainPane.getInstance().setRightPane(new AddHotelStaffPane(owner));
	}
	
	public void go(Parent pane, Object... param){
		if (pane.getClass().equals(UserInfoPane.class))
			setUserInfoPane((UserVO)param[0], ((UserInfoPane)pane).getLastPane());
		else
			try {
				MainPane.getInstance().setRightPane(pane.getClass().newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
	}
	
	public void goBack(Parent pane){
		MainPane.getInstance().setRightPane(pane);
	}
	
	public void notFound(){
		Alert alert = new Alert(AlertType.ERROR);
		alert.initModality(Modality.APPLICATION_MODAL);
		alert.setHeaderText(null);
		alert.setContentText("没有找到该用户，请检查输入是否正确。");
		alert.show();
	}
	
	public void setUserInfoPane(UserVO user, Parent lastPane){
		MainPane.getInstance().setRightPane(new UserInfoPane(user, lastPane));
	}
	
	public void search(String s){
		if (s == null || s.trim().isEmpty())
			return;
		UserVO result = null;
		try {
			int id = Integer.parseInt(s);
			result = userBLService.get(id);
		} catch (NumberFormatException e){
			result = userBLService.get(s);
		}
		if (null == result)
			notFound();
		else
			setUserInfoPane(result, new InitialPane());
	}
	
	public UserVO getUser(int id){
		return userBLService.get(id);
	}
	
	public int addUser(UserVO user){
		return userBLService.add(user);
	}
	
	public void deleteUser(UserVO user){
		userBLService.delete(user.getID());
	}
	
	public void modifyUser(UserVO user){
		userBLService.update(user);
	}
	
	public void addHotel(String name, String province, String city, String area, int staffID){
		hotelBLService.add(new HotelInfoVO(name, null, null, null, 
				null, province, area, 0, null, 0, 0, 0, staffID, city));
	}
	
	public void delHotel(HotelInfoVO hotel){
		hotelBLService.delete(hotel.get_hotel_id());
	}
	
	public List<CreditVO> getCreditRecords(UserVO user){
		return userBLService.getCreditRecords(user.getID());
	}
	
	public ObservableList<UserVO> getAllMarketers(){
		return FXCollections.observableArrayList(userBLService.getAllMarketers());
	}
	
	public List<String> getProvinces(){
		return hotelBLService.getProvinces();
	}
	
	public List<String> getCities(String province){
		return hotelBLService.getCities(province);
	}
	
	public List<String> getAreas(String province, String city){
		return hotelBLService.getAreas(province, city);
	}

	public List<HotelInfoVO> filterHotel(String province, String city, String area,
			String name) {
		return hotelBLService.search(province, city, area, name, null, null, null, null, -1);
	}
	
	public String getHotelName(int ID) {
		return hotelBLService.getHotel(ID).getHotel();
	}
}
