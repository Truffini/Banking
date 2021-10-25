package bank;

public class costumer extends user {

	private String username;
	private String password;
	private float saving_withdrawal;
	private float saving_deposit;
	private float checking_withdrawal;
	private float checking_deposit;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public float getSaving_withdrawal() {
		return saving_withdrawal;
	}
	public void setSaving_withdrawal(float saving_withdrawal) {
		this.saving_withdrawal = saving_withdrawal;
	}
	public float getSaving_deposit() {
		return saving_deposit;
	}
	public void setSaving_deposit(float saving_deposit) {
		this.saving_deposit = saving_deposit;
	}
	public float getChecking_withdrawal() {
		return checking_withdrawal;
	}
	public void setChecking_withdrawal(float checking_withdrawal) {
		this.checking_withdrawal = checking_withdrawal;
	}
	public float getChecking_deposit() {
		return checking_deposit;
	}
	public void setChecking_deposit(float checking_deposit) {
		this.checking_deposit = checking_deposit;
	}
	
	

	// view balance
	// deposit into checking
	// withdraw from checking
	// deposit into saving
	// withdraw from saving
	// accept money from another account
}
