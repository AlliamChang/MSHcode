package po.userPO;

import java.io.Serializable;

import javafx.scene.image.Image;
import tools.UserType;
import vo.UserVO;

public class UserPO implements Serializable{
	private String name, account, password, gender, number, company;
	private int level, credit, ID, hotelID, year, month, day;
	private UserType type;
	private Image image;
	public static String INIT_PASSWORD = "123456";

	public UserPO(UserVO vo) {
		this.name = vo.getName();
		this.account = vo.getAccount();
		this.password = vo.getPassword();
		this.gender = vo.getGender();
		this.number = vo.getNumber();
		this.company = vo.getCompany();
		this.level = vo.getLevel();
		this.credit = vo.getCredit();
		this.ID = vo.getID();
		this.hotelID = vo.getHotelID();
		this.year = vo.getYear();
		this.month = vo.getMonth();
		this.day = vo.getDay();
		this.type = vo.getType();
		this.image = vo.getImage();
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public UserVO toVO(){
		UserVO ret = new UserVO(account, password, name, gender,
			number, company, year, month, day, type, image);
		ret.setID(ID);
		return ret;
	}
}
