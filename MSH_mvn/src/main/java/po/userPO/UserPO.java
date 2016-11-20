package po.userPO;

import java.util.ArrayList;

import tools.UserType;

public class UserPO {
	String name, password;
	int level, credit;
	UserType type;
	ArrayList<String> creditChange;

	public UserPO(String name, String password, UserType type, int level,
			int credit) {
		this.name = name;
		this.password = password;
		this.type = type;
		this.level = level;
		this.credit = credit;
		creditChange = new ArrayList<String>();
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
