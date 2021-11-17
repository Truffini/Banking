package trevor.RAP.BankDAO;

import java.util.ArrayList;
import java.util.List;

import trevor.RAP.Models.client;

public interface ClientDAO1 {

	// create
	public ArrayList<client> addClient(int accountNumber,String first_Name,String last_Name,String client_username,String client_password,Boolean approval);

	public ArrayList<client> addClientAccount(int id,String checkingAccount,String savingAccount,int client_id,int checking_balance,int saving_balance);
		
	// read 

	public int getClientAccountChecking(int client_id);
	
	public int getClientAccountSaving(int saving_balance);
	
	public String LogIn(String client_username, String client_password);
	
	// update
	
	public int depositInSavings(int client_id, int saving_balance);

	public int withdrawFromSavings(int client_id, int saving_balance);

	public int withdrawFromChecking(int client_id, int accountNumberOfSender);

	public ArrayList<client> addtransactions(int client_id, int deposit,int withdraw);
	
	public int depositInChecking( int client_id, int checking_balance);

}

