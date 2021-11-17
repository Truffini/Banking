package trevor.RAP.Models;

public class client extends user {

	private int accountNumber;
	private String client_username;
	private String client_password;
	private int checking_balance;
	private double saving_balance;
	private boolean approval;
	private String checkingAccount;
	private static int id;
	private int client_id;
	private Object savingAccount;
	private String first_Name;
	private String last_Name;
	private int deposit;
	private int withdraw;
	private String password;
	private String username;
	
	public client() {
		super(1, null, null);
	}
	
	// constructor
	public client(int accountNumber, String first_Name, String last_Name, String client_username, String client_password, boolean approval) {
		super(accountNumber, first_Name, last_Name);
		this.client_username = client_username;
		this.client_password = client_password;
		this.approval = approval;
	}
	
	public client(int id, String checkingAccount, String savingAccount, int client_id, int checking_balance, double saving_balance) {
		super(id, checkingAccount, savingAccount);
		this.client_id = client_id;
		this.checking_balance = checking_balance;
		this.saving_balance = saving_balance;
		
	}
	
	public client(int checking_balance, int client_id,  String checkingAccount, String savingAccount, int id,
			double saving_balance) {
		super(id, checkingAccount, savingAccount);
		this.client_id = client_id;
		this.checking_balance = checking_balance;
		this.saving_balance = saving_balance;
	}
	public client(int checking_balance) {
		super(checking_balance);
	}

	public client(String client_username, String client_password, int accountNumber, String first_Name,
		String last_Name, Boolean approval) {
		super(client_username, client_password);
		this.accountNumber = accountNumber;
		this.setFirst_Name(first_Name);
		this.setLast_Name(last_Name);
		this.approval = approval;
	}
	

	public client(int accountNumber, Boolean approval) {
		super(accountNumber, approval);
	}
	
	public client(int client_id, int deposit, int withdraw) {
		super(id);
		this.client_id = client_id;
		this.deposit = deposit;
		this.withdraw = withdraw;
	}
	
	public client(String username, String password) {
		super(username);
		this.password = password;
	}
	

	public client(int id, int client_id, int deposit, int withdraw) {
		super(id);
		this.client_id = client_id;
		this.deposit = deposit;
		this.withdraw = withdraw;
	}

	public String toString() {
		return this.getFirstName() + " | " + this.getLastName() + " | " + this.client_username + " | " + this.client_password + " | " + this.checking_balance + " | " + this.saving_balance;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCheckingAccount() {
		return checkingAccount;
	}

	public void setCheckingAccount(String checkingAccount) {
		this.checkingAccount = checkingAccount;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public Object getSavingAccount() {
		return savingAccount;
	}

	public void setSavingAccount(Object savingAccount) {
		this.savingAccount = savingAccount;
	}

	public double getSaving_balance() {
		return saving_balance;
	}

	public void setSaving_balance(double saving_balance) {
		this.saving_balance = saving_balance;
	}

	public int getChecking_balance() {
		return checking_balance;
	}

	public void setChecking_balance(int checking_balance) {
		this.checking_balance = checking_balance;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

}
