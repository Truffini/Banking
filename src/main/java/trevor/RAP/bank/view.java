package trevor.RAP.bank;

import java.util.ArrayList;


import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import trevor.RAP.BankDAO.ClientDAO1;
import trevor.RAP.BankDAO.ClientDAOimpl;
import trevor.RAP.BankDAO.EmployeeDAO;
import trevor.RAP.BankDAO.EmployeeDAOImpl;
import trevor.RAP.Models.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class view extends main{
	
	private static final Logger LOG = LogManager.getLogger(view.class);
	
	public static void welcome() {
		LOG.trace("start welcome");
		System.out.println("Welcome to trevors Bank");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Would you like to \n 1)Log in as client \n 2)Log in as employee \n 3)Create an account");
		LOG.trace("end welcome");
	}
	
	public static void viewClientAccountChecking() {
		LOG.trace("start view checking");
		Scanner scanner2 = new Scanner(System.in);
		EmployeeDAO employeeDAO =new EmployeeDAOImpl();
			
		System.out.println("\nenter accountNumber");
		int accountNumber = scanner2.nextInt();

		int gotchecking = employeeDAO.getClientAccountChecking(accountNumber);

		System.out.println("Checking account balance: $" + gotchecking);
		LOG.trace("end view checking");
	}
	
	public static void viewClientAccountSaving() {
		LOG.trace("start view savings");
		Scanner scanner2 = new Scanner(System.in);
		EmployeeDAO employeeDAO =new EmployeeDAOImpl();
		
		
		System.out.println("\nenter accountNumber");
		int accountNumber = scanner2.nextInt();
		
		client gotClient = employeeDAO.getClient(accountNumber);
		
		System.out.println(gotClient);
		
		int gotsaving = employeeDAO.getClientAccountSaving(accountNumber);

		System.out.println("Savings account balance: $" + gotsaving);
		LOG.trace("end view savings");
		
	}
	
	public static void depositInChecking() {
		LOG.trace("start checking deposit");
		Scanner scanner = new Scanner(System.in);
		ClientDAO1 clientDAO1 =new ClientDAOimpl();
		
		System.out.println("enter account number");
		int accountNumber = scanner.nextInt();
		
		if(view.CheckApprovalStatus() == false) {
			System.out.println("your account has been rejected");
		}
		else {

		int gotAccountsChecking = clientDAO1.getClientAccountChecking(accountNumber);		
			
		System.out.println("Checking account Total: $" + gotAccountsChecking);
			
		System.out.println("enter amount to deposit into checking account");
			
		int dep = scanner.nextInt();
			
		if (dep < 0 ) {
			System.out.println("invalid transaction");
			LOG.error("deposited negative number in checkings account");
		}
		else {
			int deposit = clientDAO1.depositInChecking(accountNumber,(dep + gotAccountsChecking) );
			
			System.out.println(deposit);		
			
			ArrayList<client> Clients1 =  clientDAO1.addtransactions( accountNumber, dep, 0);
			
			for (client client1 : Clients1) {
				System.out.println(client1);
			}
		}
	}
		LOG.trace("end checking deposit");
}
	
	public static void depositInSaving() {
		LOG.trace("start savings deposit");
		Scanner scanner = new Scanner(System.in);
		ClientDAO1 clientDAO1 =new ClientDAOimpl();
		System.out.println("enter account number");
		int accountNumber = scanner.nextInt();
		
		int gotAccountsSaving = clientDAO1.getClientAccountSaving(accountNumber);
				
		System.out.println("Saving account Total: $" + gotAccountsSaving);
			
		System.out.println("enter amount to deposit in savings account");
		
		int dep = scanner.nextInt();
			
		if (dep < 0) {
			System.out.println("invalid transaction");
			LOG.error("deposited negative number in savings account");
		}
		else {
			int deposit = clientDAO1.depositInSavings(accountNumber,(dep + gotAccountsSaving) );
			
			System.out.println(deposit);
			
			ArrayList<client> Clients1 =  clientDAO1.addtransactions( accountNumber, dep, 0);
			
			for (client client1 : Clients1) {
				System.out.println(client1);
			}
		}
		LOG.trace("end savings deposit");
	}
	public static void withdrawFromChecking() {
		LOG.trace("start withdraw from checking");
		Scanner scanner = new Scanner(System.in);
		ClientDAO1 clientDAO1 = new ClientDAOimpl();
		System.out.println("enter account number");
		int accountNumber = scanner.nextInt();
		
		int gotAccountsChecking = clientDAO1.getClientAccountChecking(accountNumber);
	
		System.out.println("Checking account Total: $" + gotAccountsChecking);

		System.out.println("enter amount to withdraw from checking account");

		int withdraw = scanner.nextInt();
		if (withdraw > gotAccountsChecking) {
			LOG.error("tried to withdraw more than is in the account");
			System.out.println("cannot withdraw more then is in the account");
		}
		else if(withdraw <= 0) {
			LOG.error("tried to withdraw a negative number or 0 from checking");
			System.out.println("must withdraw a positive value");
		}	
		else {
	
		int withdrawBalance = clientDAO1.depositInChecking(accountNumber,(gotAccountsChecking - withdraw) );
		
		ArrayList<client> Clients1 =  clientDAO1.addtransactions( accountNumber, 0, withdraw);
		
		for (client client1 : Clients1) {
			System.out.println(client1);
		}
	}
		LOG.trace("end withdraw from checking");
}
	
	public static void withdrawFromSavings() {
		LOG.trace("start withdraw from savings");
		Scanner scanner = new Scanner(System.in);
		ClientDAO1 clientDAO1 = new ClientDAOimpl();
		
		System.out.println("enter account number");
		int accountNumber = scanner.nextInt();
		
		int gotAccountsSavings = clientDAO1.getClientAccountSaving(accountNumber);
	
		System.out.println("Saving account Total: $" + gotAccountsSavings);

		System.out.println("enter amount to withdraw from savings account");

		int withdraw = scanner.nextInt();
		if (withdraw > gotAccountsSavings ) {
			System.out.println("cannot withdraw more then is in the account");
		}
		else if(withdraw <= 0) {
			LOG.error("tried to withdraw negativ number or 0 from savings");
			System.out.println("must withdraw a positive value");
		}	
		else {
		int withdrawBalance= clientDAO1.withdrawFromSavings(accountNumber,(gotAccountsSavings - withdraw) );
		
		ArrayList<client> Clients1 =  clientDAO1.addtransactions( accountNumber, 0, withdraw);
		
		for (client client1 : Clients1) {
			System.out.println(client1);
		}
	}
		LOG.trace("end withdraw from savings");
}
	
	public static void transferCheckingToChecking() {
		LOG.trace("start checking to checking transfer");
		ClientDAO1 clientDAO1 = new ClientDAOimpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter amount to transfer");

		
		int transfer = scanner.nextInt();
		
		System.out.println("enter your account number");
		int accountNumberOfSender = scanner.nextInt();
		
		System.out.println("enter recievers account number");
		int accountNumberOfReciever = scanner.nextInt();
		
		int gotSendersChecking = clientDAO1.getClientAccountChecking(accountNumberOfSender);
		int gotRecieversChecking = clientDAO1.getClientAccountChecking(accountNumberOfReciever);
		
		if (transfer <= 0  && transfer <= gotSendersChecking) {
			LOG.error("transfer was less than or equall to 0 or more money than they had checking to checking");
			System.out.println("invalid transaction");
		}
		else {
		
		int wtotal = clientDAO1.withdrawFromChecking(accountNumberOfSender,(gotSendersChecking - transfer) );
		
		
		int wtotal2 = clientDAO1.depositInChecking(accountNumberOfReciever,(gotRecieversChecking + transfer));
		
		ArrayList<client> Clients1 =  clientDAO1.addtransactions( accountNumberOfSender, 0, transfer);
		
		for (client client1 : Clients1) {
			System.out.println(client1);
		}
		ArrayList<client> Clients2 =  clientDAO1.addtransactions( accountNumberOfReciever, transfer, 0);
		
		for (client client1 : Clients2) {
			System.out.println(client1);
		}
	}
		LOG.trace("end checking to checking transfer");
}
	
	public static void transferCheckingToSaving() {
		LOG.trace("start tranfer checking to savings");
		ClientDAO1 clientDAO1 = new ClientDAOimpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter amount to transfer");

		
		int transfer = scanner.nextInt();
		
		System.out.println("enter your account number");
		int accountNumberOfSender = scanner.nextInt();
		
		System.out.println("enter recievers account number");
		int accountNumberOfReciever = scanner.nextInt();
		
		int gotSendersChecking = clientDAO1.getClientAccountChecking(accountNumberOfSender);
		int gotRecieversSavings = clientDAO1.getClientAccountSaving(accountNumberOfReciever);
		
		if (transfer <= 0  && transfer <= gotSendersChecking) {
			LOG.error("transfer was less than or equall to 0 or more money than they had checking to saving");
			System.out.println("invalid transaction");
		}
		else {
		
		int wtotal = clientDAO1.withdrawFromChecking(accountNumberOfSender,(gotSendersChecking - transfer) );
		
		
		int wtotal2 = clientDAO1.depositInChecking(accountNumberOfReciever,(gotRecieversSavings + transfer));
		
		ArrayList<client> Clients1 =  clientDAO1.addtransactions( accountNumberOfSender, 0, transfer);
		
		for (client client1 : Clients1) {
			System.out.println(client1);
		}
		ArrayList<client> Clients2 =  clientDAO1.addtransactions( accountNumberOfReciever, transfer, 0);
		
		for (client client1 : Clients2) {
			System.out.println(client1);
		}
	}
		LOG.trace("end tranfer checking to savings");
}
	
	public static void transferSavingToSaving() {
		LOG.trace("start tranfer saving to savings");
		ClientDAO1 clientDAO1 = new ClientDAOimpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter amount to transfer");

		
		int transfer = scanner.nextInt();
		
		System.out.println("enter your account number");
		int accountNumberOfSender = scanner.nextInt();
		
		System.out.println("enter recievers account number");
		int accountNumberOfReciever = scanner.nextInt();
		
		int gotSendersSavings = clientDAO1.getClientAccountSaving(accountNumberOfSender);
		int gotRecieversSavings = clientDAO1.getClientAccountSaving(accountNumberOfReciever);
		
		if (transfer <= 0  && transfer <= gotSendersSavings) {
			LOG.error("transfer was less than or equall to 0 or more money than they had saving to saving");
			System.out.println("invalid transaction");
		}
		else {
		
		int wtotal = clientDAO1.withdrawFromChecking(accountNumberOfSender,(gotSendersSavings - transfer) );
		
		
		int wtotal2 = clientDAO1.depositInChecking(accountNumberOfReciever,(gotRecieversSavings + transfer));
		
		ArrayList<client> Clients1 =  clientDAO1.addtransactions( accountNumberOfSender, 0, transfer);
		
		for (client client1 : Clients1) {
			System.out.println(client1);
		}
		ArrayList<client> Clients2 =  clientDAO1.addtransactions( accountNumberOfReciever, transfer, 0);
		
		for (client client1 : Clients2) {
			System.out.println(client1);
		}
	}
		LOG.trace("end tranfer saving to savings");
}
	
	public static void transferSavingToChecking() {
		LOG.trace("start tranfer saving to checking");
		ClientDAO1 clientDAO1 = new ClientDAOimpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter amount to transfer");

		
		int transfer = scanner.nextInt();
		
		System.out.println("enter your account number");
		int accountNumberOfSender = scanner.nextInt();
		
		System.out.println("enter recievers account number");
		int accountNumberOfReciever = scanner.nextInt();
		
		int gotSendersSavings = clientDAO1.getClientAccountSaving(accountNumberOfSender);
		int gotRecieversChecking = clientDAO1.getClientAccountChecking(accountNumberOfReciever);
		
		if (transfer <= 0  && transfer <= gotSendersSavings) {
			LOG.error("transfer was less than or equall to 0 or more money than they had saving to checking");
			System.out.println("invalid transaction");
		}
		else {
		
		int wtotal = clientDAO1.withdrawFromChecking(accountNumberOfSender,(gotSendersSavings - transfer) );
		
		
		int wtotal2 = clientDAO1.depositInChecking(accountNumberOfReciever,(gotRecieversChecking + transfer));
		
		ArrayList<client> Clients1 =  clientDAO1.addtransactions( accountNumberOfSender, 0, transfer);
		
		for (client client1 : Clients1) {
			System.out.println(client1);
		}
		ArrayList<client> Clients2 =  clientDAO1.addtransactions( accountNumberOfReciever, transfer, 0);
		
		for (client client1 : Clients2) {
			System.out.println(client1);
		}
	}
		LOG.trace("end tranfer saving to checking");
}
	
	public static void createAccount() {
		LOG.trace("start create account");
		System.out.println("Please enter the following information");
		ClientDAO1 clientDAO1 =new ClientDAOimpl();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Account number:");
		int accountNumber = scanner.nextInt();

		String firstname = scanner.nextLine();
		System.out.println("First name:");

		String first_name = scanner.nextLine();
		System.out.println("Last name:");

		String last_name = scanner.nextLine();

		System.out.println("Username:");

		String username = scanner.nextLine();

		System.out.println("Password:");

		String password = scanner.nextLine();
		
		ArrayList<client> Clients1 =  clientDAO1.addClient(accountNumber, first_name, last_name, username, password, false);
		
//      create Client account\/

		System.out.println("id");
		int id = scanner.nextInt();

		System.out.println("amount to deposit into checking account");
		int checking_balance = scanner.nextInt();

		System.out.println("amount to add to savings");
		int saving_balance = scanner.nextInt();
		
		int client_id = accountNumber;

		
		ArrayList<client> Clients2 =  clientDAO1.addClientAccount(id,"checking account", "saving account",client_id, checking_balance, saving_balance);
		
		for (client client1 : Clients2) {
		System.out.println(client1);
		}
		LOG.trace("end create account");
	}

	public static boolean logIn() {
		LOG.trace("start login");
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter username");
		String username = scanner.nextLine();
		
		System.out.println("enter password");
		String password = scanner.nextLine();
		
		ClientDAO1 clientDAO1 =new ClientDAOimpl();
		String Clients1 =  clientDAO1.LogIn(username, password);

		if (Clients1.contains(username) && Clients1.contains(password)){
			System.out.print("hello " + username);
			LOG.trace("end login");
			return true;
			
		}
		else {
			System.out.println("username or password invalid");		
			System.exit(0);
			LOG.error("error logging in client");
			return false;
		}
			
	}
	
	public static boolean employeeLogIn() {
		LOG.trace("start employee login");
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter username");
		String username = scanner.nextLine();
		
		System.out.println("enter password");
		String password = scanner.nextLine();
		
		EmployeeDAO employeeDAO =new EmployeeDAOImpl();
		String Clients1 =  employeeDAO.employeeLogIn(username, password);

		if (Clients1.contains(username) && Clients1.contains(password)){
			System.out.print("hello employee " + username + "\n");
			LOG.trace("end employee login");
			return true;
		}
		else {
			System.out.println("username or password invalid");
			LOG.error("error logging in employee");
			System.exit(0);		
			return false;
		}
	}
	
	public static boolean CheckApprovalStatus() {
		LOG.trace("start check approval");
		EmployeeDAO employeeDAO =new EmployeeDAOImpl();
		
		System.out.println("enter account number");
		Scanner scanner = new Scanner(System.in);		
		int accountNumber = scanner.nextInt();
		
		boolean approvalCheck = employeeDAO.getApproval(accountNumber);
		System.out.println(approvalCheck);
		LOG.trace("end check approval");
		return approvalCheck;
	}
	
	public static void getClient() {
		LOG.trace("start get client");
		Scanner scanner = new Scanner(System.in);
		EmployeeDAO employeeDAO =new EmployeeDAOImpl();
		
		
		System.out.println("enter accountNumber");
		int accountNumber = scanner.nextInt();
		
		client gotClient = employeeDAO.getClient(accountNumber);
		ArrayList<client> gotClientAccount = employeeDAO.getClientAccount(accountNumber);
		int gotClientChecking = employeeDAO.getClientAccountChecking(accountNumber);
		int gotClientSavings = employeeDAO.getClientAccountSaving(accountNumber);
		boolean gotApproval = employeeDAO.getApproval(accountNumber);
		
		System.out.println("Client - " + gotClient);	
		System.out.println("Account - " + gotClientAccount);
		System.out.println("Checking account balance: " + gotClientChecking);
		System.out.println("Saving account balance:" + gotClientSavings);
		System.out.println("Approval: " + gotApproval);
		
		LOG.trace("end get client");
	}
	
	public static void getAllClients() {
		LOG.trace("start get all clients");
		EmployeeDAO employeeDAO =new EmployeeDAOImpl();
		
		ArrayList<client> Clients =  employeeDAO.getAllClients();
		
		for (client client : Clients) {
			System.out.println(client);
		}
		LOG.trace("end get all clients");
	}
	
	public static void getAllClientAccounts() {
		LOG.trace("start get all client accounts");
		EmployeeDAO employeeDAO =new EmployeeDAOImpl();
		
		ArrayList<client> Clients =  employeeDAO.getAllClientAccounts();
		
		for (client client : Clients) {
			System.out.println(client);
		}
		LOG.trace("end get all client accounts");
	}
	
	public static void getAllClientTransactions() {
		LOG.trace("start get all client transactons");
		EmployeeDAO employeeDAO =new EmployeeDAOImpl();
		
		ArrayList<client> Clients =  employeeDAO.getAllTransactions();
		
		for (client client : Clients) {
			System.out.println(client);
		}
		LOG.trace("end get all client transactions");
	}
	
	public static void setApproval() {
		LOG.trace("start set approval");
		Scanner scanner = new Scanner(System.in);
		EmployeeDAO employeeDAO =new EmployeeDAOImpl();
		
		System.out.println("Enter accountNumber");
		int accountNumber = scanner.nextInt();
		
		System.out.println("Enter 'true' too approve account");
		System.out.println("Enter 'false' too reject account");
		
		boolean approval = scanner.nextBoolean();
		
		ArrayList<client> Clients =  employeeDAO.accountApproval(accountNumber, approval);
		
		for (client client : Clients) {
			System.out.println(client);
		}
		LOG.trace("end set approval");
	}
}
	




