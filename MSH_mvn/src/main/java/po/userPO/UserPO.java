package po.userPO;

import java.util.ArrayList;

import tools.UserType;

public class UserPO {
	private String name, account, password, gender, number;
	private int level, credit;
	private UserType type;
	private ArrayList<String> creditChange;

	public UserPO(String account, String password, String name, String gender, String number, UserType type, int level,
			int credit) {
		this.account = account;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.number = number;
		this.type = type;
		this.level = level;
		this.credit = credit;
		creditChange = new ArrayList<String>();
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

	public ArrayList<String> getCreditChange() {
		return creditChange;
	}

	public void setCreditChange(ArrayList<String> creditChange) {
		this.creditChange = creditChange;
	}

}
