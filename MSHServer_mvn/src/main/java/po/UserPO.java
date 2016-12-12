package po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javafx.scene.image.Image;
import tools.UserType;

@Entity
@Table(name = "user")
public class UserPO implements Serializable{
	private String name, account, password, gender, number, company;
	private int level, credit, ID, hotelID, year, month, day;
	private UserType type;
//	private Image image;

	public UserPO(){}
	
	public UserPO(String password, String name, String gender, String number, UserType type) {
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.number = number;
		this.type = type;
	}

/*	public UserPO(String account, String password, String name, String gender,
			String number, int year, int month, int day, UserType type, Image image){
		this(password, name, gender, number, type);
		this.account = account;
		this.year = year;
		this.month = month;
		this.day = day;
		this.image = image;
	}*/
	
/*	public UserPO(String account, String password, String name, String gender,
			String number, String company, int year, int month, int day, UserType type, Image image){
		this(account, password, name, gender, number, year, month, day, type, image);
		this.company = company;
	}
	*/
	@Id
	@Column(name = "ID")
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}
	
	@Column(name = "number")
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "account")
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Column(name = "gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "year")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "month")
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Column(name = "day")
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "type")
	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	@Column(name = "level")
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "credit")
	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	@Column(name = "hotelID")
	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	@Column(name = "company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
/*	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}*/

/*	@Column(name = "image")
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}*/
}
