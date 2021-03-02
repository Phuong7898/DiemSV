package CONTROL;

public class AccountUniversity {
	private String account;// tài khoản
	private String Password;// mật khẩu
	private int Decentralization;// phân quyền
	public AccountUniversity() {}
	public AccountUniversity(String account, String password, int decentralization) {
		super();
		this.account = account;
		Password = password;
		Decentralization = decentralization;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getDecentralization() {
		return Decentralization;
	}

	public void setDecentralization(int decentralization) {
		Decentralization = decentralization;
	}
}
