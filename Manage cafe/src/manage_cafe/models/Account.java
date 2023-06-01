package manage_cafe.models;

import java.util.Objects;

public class Account {
	
	private String account;
	private String pass;
	
	public Account() {
		
	}

	public Account(String account, String pass) {
		this.account = account;
		this.pass = pass;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Account [account=" + account + ", pass=" + pass + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, pass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(account, other.account) && Objects.equals(pass, other.pass);
	}
	
	
}
