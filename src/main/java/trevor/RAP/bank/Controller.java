package trevor.RAP.bank;

import java.util.Scanner;

import trevor.RAP.BankDAO.EmployeeDAO;
import trevor.RAP.Models.client;

public class Controller {
	
	
	public static void init(){
		
		client user = new client();
		
		Scanner scanner = new Scanner(System.in);
		view.welcome();
		int logIn = scanner.nextInt();
		
		switch(logIn) {
		
		case 1:
			
			boolean isLoggedIn = view.logIn();
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
			System.out.println("Would you like to");
			System.out.println("1)Make a deposit");
			System.out.println("2)Make a withdrawal");
			System.out.println("3)View checking account");
			System.out.println("4)View savings account");
			System.out.println("5)Make a money transfer");
			
			while(isLoggedIn) {
			
				int clientActions = scanner.nextInt();
				
				switch(clientActions) {
			
				case 1:
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("Would you like to");
					System.out.println("1)deposit into checking account");
					System.out.println("2)deposit into savings account");
					
					int deposit = scanner.nextInt();
					
					switch(deposit) {
					
						case 1:
							
							view.depositInChecking();
							return;
								
						case 2:	
							
							view.depositInSaving();
							return;
					}
				
				case 2:
					
					System.out.println("Would you like to");
					System.out.println("1)Withdraw from checking account");
					System.out.println("2)Withdraw from savings account");
					
					int withdraw = scanner.nextInt();
					
					switch(withdraw) {
					
						case 1:
							
							view.withdrawFromChecking();		
							return;
							
						case 2:
							
							view.withdrawFromSavings();
							return;
					}
				case 3:
					
					view.viewClientAccountChecking();
					return;
					
				case 4:
					
					view.viewClientAccountSaving();
					return;
					
				case 5:
					
					int transferType = scanner.nextInt();
					
					System.out.println("1) checking to checking");
					System.out.println("2)checking to saving");
					System.out.println("3)saving to saving");
					System.out.println("4)saving to checking");

					switch(transferType) {
					
					case 1:
						
						view.transferCheckingToChecking();
						return;
						
					case 2:
						view.transferCheckingToSaving();
						return;
						
					case 3:
						view.transferSavingToSaving();
						return;
						
					case 4:
						view.transferSavingToChecking();
						return;
					}
				}
		}	
		case 2:
			
			boolean employeeLogIn = view.employeeLogIn();
			
			System.out.println("1)Check approval status of client");
			System.out.println("2)Get a client account");
			System.out.println("3)Get all clients");
			System.out.println("4)Approve or Reject client account");
			System.out.println("5)View all transactions");
			
			int employeeActions = scanner.nextInt();
			
			while(employeeLogIn)
									
				switch(employeeActions) {
				
				case 1:
					
					view.CheckApprovalStatus();
					return;
					
				case 2:
					
					view.getClient();
					return;
					
				case 3:
					
					System.out.println("~~~~~~~~~~~clients~~~~~~~~~~~");
					view.getAllClients();
					System.out.println("~~~~~~~~~~~accounts~~~~~~~~~~~");
					view.getAllClientAccounts();
					return;
					
				case 4:
					
					view.setApproval();
					return;
					
				case 5:
					
					view.getAllClientTransactions();
					return;
				}
				
			
			return;
			
		case 3:
			
			view.createAccount();		
			return;
			
		case 4:
			
			
		}				
	}
}
