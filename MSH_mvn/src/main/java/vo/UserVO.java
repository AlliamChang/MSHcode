package vo;

import javafx.scene.image.Image;
import tools.UserType;

public class UserVO {
	private String name, account, password, gender, number, company;
	private int level, credit, ID, hotelID, year, month, day;
	private UserType type;
	private Image image;
	public static String INIT_PASSWORD = "123456";

	public UserVO(String password, String name, String gender, String number, UserType type) {
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.number = number;
		this.type = type;
	}

	public UserVO(String account, String password, String name, String gender,
			String number, int year, int month, int day, UserType type, Image image){
		this(password, name, gender, number, type);
		this.account = account;
		this.year = year;
		this.month = month;
		this.day = day;
		this.image = image;
	}
	
	public UserVO(String account, String password, String name, String gender,
			String number, String company, int year, int month, int day, UserType type, Image image){
		this(account, password, name, gender, number, year, month, day, type, image);
		this.company = company;
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
}
