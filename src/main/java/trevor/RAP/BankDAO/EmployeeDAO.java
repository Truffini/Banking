package trevor.RAP.BankDAO;

import java.util.ArrayList;

import trevor.RAP.Models.client;

public interface EmployeeDAO {

	public client getClient(int accountNumber);
	
	public String employeeLogIn(String username, String password);
	
	public ArrayList<client> getClientAccount(int client_id1);
	
	public ArrayList<client> getAllClients();
	
	public ArrayList<client> removeClient(int accountNumbers);
	
	public ArrayList<client> accountApproval(int accountNumber, boolean approval);
	
	public boolean getApproval(int accountNumber);
	
	public int getClientAccountChecking(int client_id);
	
	public int getClientAccountSaving(int saving_balance);

	public ArrayList<client> getAllClientAccounts();
	
	public ArrayList<client> getAllTransactions();


}
