package trevor.RAP.Models;

public class user  {
	
	private int id;
	private String username;
	private String password;
	private int checking_balance;
	private String client_username;
	private String client_password;
	private String firstName;
	private int accountNumber;
	private Boolean approval;


	// constructor
	public user(int id, String firstName, String lastName) {
		this.id = id;
		this.username = firstName;
		this.password = lastName;
	}

	public user(int checking_balance) {
		this.setChecking_balance(checking_balance);
	}

	public user(String client_username, String client_password) {
		this.setClient_username(client_username);
		this.setClient_password(client_password);
	}

	public user(int accountNumber, Boolean approval) {
		this.setAccountNumber(accountNumber);
		this.setApproval(approval);
	}

	public user(String username) {
		this.username = username;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return username;
	}

	public void setUsername(String firstName) {
		this.username = firstName;
	}
	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return password;
	}

	public void setPassword(String lastName) {
		this.password = lastName;
	}

	public int getChecking_balance() {
		return checking_balance;
	}

	public void setChecking_balance(int checking_balance) {
		this.checking_balance = checking_balance;
	}

	public Boolean getApproval() {
		return approval;
	}

	public void setApproval(Boolean approval) {
		this.approval = approval;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getClient_password() {
		return client_password;
	}

	public void setClient_password(String client_password) {
		this.client_password = client_password;
	}

	public String getClient_username() {
		return client_username;
	}

	public void setClient_username(String client_username) {
		this.client_username = client_username;
	}	
	
}
	
	


