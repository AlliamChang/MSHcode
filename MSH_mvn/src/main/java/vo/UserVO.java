package vo;

import java.io.File;

import javafx.scene.image.Image;
import po.UserPO;
import tools.ImageConverter;
import tools.UserType;

public class UserVO{
	public static final String INIT_PASSWORD = "123456";
	private String name, account, password, gender, number, company, imagePath;
	private int level, credit, ID, hotelID, year, month, day;
	private UserType type;

	public UserVO(String account, String password, String name, String gender, String number, 
			String company, String imagePath, int year, int month, int day, UserType type){
		this.account = account;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.number = number;
		this.company = company;
		this.imagePath = imagePath;
		this.year = year;
		this.month = month;
		this.day = day;
		this.type = type;
	}
	
	public UserVO(UserPO po){
		this.name = po.getName();
		this.account = po.getAccount();
		this.password = po.getPassword();
		this.gender = po.getGender();
		this.number = po.getNumber();
		this.company = po.getCompany();
		if (po.getImage() != null) {
			File path = new File("image/user");
			if (!path.exists())
				path.mkdirs();
			this.imagePath = "image/user/" + po.getID() + "." + po.getImageExtension();
			ImageConverter.byteToFile(po.getImage(), imagePath);
		}
		this.level = po.getLevel();
		this.credit = po.getCredit();
		this.ID = po.getID();
		this.hotelID = po.getHotelID();
		this.year = po.getYear();
		this.month = po.getMonth();
		this.day = po.getDay();
		this.type = po.getType();
	}
	
	public UserPO toPO(){
		UserPO po = new UserPO();
		po.setName(name);
		po.setAccount(account);
		po.setPassword(password);
		po.setGender(gender);
		po.setNumber(number);
		po.setCompany(company);
		if (imagePath != null) {
			po.setImage(ImageConverter.fileToByte(imagePath));
			po.setImageExtension(new File(imagePath).getName().split("\\.")[1]);
		}
		po.setLevel(level);
		po.setCredit(credit);
		po.setID(ID);
		po.setHotelID(hotelID);
		po.setYear(year);
		po.setMonth(month);
		po.setDay(day);
		po.setType(type);
		return po;
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
		if (imagePath == null || !new File(imagePath).exists())
			return new Image("/image/default.png");
		return new Image("file:" + imagePath);
	}
	
	/**
	 * 
	 * @param imagePath 图片路径
	 */
	public void setImage(String imagePath){
		this.imagePath = imagePath;
	}
}
