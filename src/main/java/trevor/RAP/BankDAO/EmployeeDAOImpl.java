package trevor.RAP.BankDAO;

import trevor.RAP.Models.client;
import trevor.RAP.bank.utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private Connection connection;
	private PreparedStatement statement;
	
	@Override
	public client getClient(int accountNumber1) {
		client gotClient = new client();

		try {
			connection = utilities.getConnection();
			String sql = "SELECT * FROM client WHERE accountNumber = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, accountNumber1);
			ResultSet rs = statement.executeQuery();

			// for each record (should just be one student)
			while (rs.next()) {
				// save property values
				int accountNumber = rs.getInt("accountNumber");
				String first_Name = rs.getString("first_name");
				String last_Name = rs.getString("last_name");
				String client_username = rs.getString("client_username");
				String client_password = rs.getString("client_password");
				Boolean approval = rs.getBoolean("approval");

				// add parent to parents arraylist
				gotClient = (new client(accountNumber, first_Name, last_Name, client_username, client_password, approval));
			}
		} catch(SQLException ex) {
			System.out.println("error getting client");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return gotClient;
	}
	
	@Override
	public ArrayList<client> getClientAccount(int client_id1) {
		
		ArrayList<client> gotAccounts = new ArrayList<>();

		try {
			connection = utilities.getConnection();
			String sql = "SELECT * FROM accounts WHERE client_id = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, client_id1);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int client_id = rs.getInt("client_id");
				String checkingAccount = rs.getString("checkingAccount");
				String savingAccount = rs.getString("savingAccount");
				int id = rs.getInt("id");
				int checking_balance = rs.getInt("checking_balance");
				double saving_balance = rs.getDouble("saving_balance");

				gotAccounts.add(new client(client_id, checkingAccount, savingAccount, id, checking_balance, saving_balance));
			}
		} catch(SQLException ex) {
			System.out.println("error getting client account");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return gotAccounts;
	}
	
	public String employeeLogIn(String employee_username1, String employee_password1) {
		
		String login = "";
		

		try {
			connection = utilities.getConnection();
			String sql = "SELECT * FROM employee WHERE employee_username =? AND employee_password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, employee_username1);
			statement.setString(2, employee_password1);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				String employee_username = rs.getString("employee_username");
				String employee_password = rs.getString("employee_password");
				
				login = employee_username + employee_password;
				
			}
		} catch(SQLException ex) {
			System.out.println("error getting the client accounts username");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return login;
	}

@Override
public ArrayList<client> getAllClientAccounts() {
	
	ArrayList<client> gotAccounts = new ArrayList<>();

	try {

		connection = utilities.getConnection();
		String sql = "SELECT * From accounts ";
		statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			int client_id = rs.getInt("client_id");
			String checkingAccount = rs.getString("checkingAccount");
			String savingAccount = rs.getString("savingAccount");
			int id = rs.getInt("id");
			int checking_balance = rs.getInt("checking_balance");
			double saving_balance = rs.getDouble("saving_balance");

			gotAccounts.add(new client(client_id, checkingAccount, savingAccount, id, checking_balance, saving_balance));

		}
	} catch(SQLException ex) {
		System.out.println("Error: Cannot get all Client accounts.");
		ex.printStackTrace();
	} finally {
		closeResources();
	}

	return gotAccounts;
}

@Override
public ArrayList<client> getAllTransactions() {
	
	ArrayList<client> gotTransactions = new ArrayList<>();

	try {

		connection = utilities.getConnection();
		String sql = "SELECT * From transactions ";
		statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			int id = rs.getInt("id");
			int client_id = rs.getInt("client_id");
			int deposit = rs.getInt("deposit");
			int withdraw = rs.getInt("withdraw");

			gotTransactions.add(new client(id, client_id, deposit, withdraw));

		}
	} catch(SQLException ex) {
		System.out.println("Error: getting transactions");
		ex.printStackTrace();
	} finally {
		closeResources();
	}

	return gotTransactions;
}

@Override
public ArrayList<client> getAllClients() {
	
	ArrayList<client> Clients = new ArrayList<>();

	try {

		connection = utilities.getConnection();
		String sql = "SELECT * From client ";
		statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			int accountNumber = rs.getInt("accountNumber");
			String first_Name = rs.getString("first_name");
			String last_Name = rs.getString("last_name");
			String client_username = rs.getString("client_username");
			String client_password = rs.getString("client_password");
			boolean approval = rs.getBoolean("approval");

			Clients.add(new client(accountNumber, first_Name, last_Name, client_username, client_password, approval));

		}
	} catch(SQLException ex) {
		System.out.println("Error: Cannot get all Clients.");
		ex.printStackTrace();
	} finally {
		closeResources();
	}

	return Clients;
}
	
	public boolean getApproval(int accountNumber1) {
		
		boolean approvalCheck = false;

	try {
		connection = utilities.getConnection();
		String sql = "Select * FROM client WHERE accountNumber = ?";
		statement = connection.prepareStatement(sql);
		
		statement.setInt(1, accountNumber1);

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			boolean approval = rs.getBoolean("approval");
			
			approvalCheck = approval;

		}
	} catch(SQLException ex) {
		System.out.println("error getting approval ");
		ex.printStackTrace();
	} finally {
		closeResources();
	}

	return approvalCheck;
}

public ArrayList<client> accountApproval(int accountNumber1, boolean approval1) {
	
	boolean approvalCheck = false;
	int accountNumberCheck =0;
	ArrayList<client> gotApproval = new ArrayList<>();

	try {
		connection = utilities.getConnection();
		String sql = "UPDATE client set approval = ? WHERE accountNumber= ?";
		statement = connection.prepareStatement(sql);			
		statement.setBoolean(1,approval1);
		statement.setInt(2, accountNumber1);		

		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			boolean approval = rs.getBoolean("approval");
			int accountNumber = rs.getInt("accountNumber");

			approvalCheck = approval;
			accountNumberCheck = accountNumber;
			
			gotApproval.add(new client(accountNumberCheck, approvalCheck));
		}
	} catch(SQLException ex) {
		System.out.println("error setting approval");
		ex.printStackTrace();
	} finally {
		closeResources();
	}

	return gotApproval;
}


@Override
public ArrayList<client> removeClient(int accountNumbers) {
	
	ArrayList<client> Clients = new ArrayList<>();

	try {
		connection = utilities.getConnection();
		String sql = " DELETE FROM client WHERE accountNumber = ? ";

		statement = connection.prepareStatement(sql);
		statement.setInt(1, accountNumbers);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			int accountNumber = rs.getInt("accountNumber");
			String first_Name = rs.getString("first_name");
			String last_Name = rs.getString("last_name");
			String client_username = rs.getString("client_username");
			String client_password = rs.getString("client_password");
			boolean approval = rs.getBoolean("approval");

			Clients.remove(new client(accountNumber, first_Name, last_Name, client_username, client_password, approval));


		}
	} catch(SQLException ex) {
		System.out.println("Error removing client");
		ex.printStackTrace();
	} finally {
		closeResources();
	}

	return Clients;
}

public int getClientAccountChecking(int client_id1) {
	
	int gotAccountsChecking = 0;

	try {
		connection = utilities.getConnection();
		String sql = "SELECT * FROM accounts Where client_id = ? ";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, client_id1);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			int checking_balance = rs.getInt("checking_balance");

			gotAccountsChecking = checking_balance;
		}
	} catch(SQLException ex) {
		System.out.println("error getting the client accounts checking balance");
		ex.printStackTrace();
	} finally {
		closeResources();
	}

	return gotAccountsChecking;
}

public int getClientAccountSaving(int client_id1) {
	
	int gotAccountsSaving = 0;

	try {
		connection = utilities.getConnection();
		String sql = "SELECT * FROM accounts Where client_id = ? ";
		statement = connection.prepareStatement(sql);
		statement.setInt(1, client_id1);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {

			int saving_balance = rs.getInt("saving_balance");

			gotAccountsSaving = saving_balance;
		}
	} catch(SQLException ex) {
		System.out.println("error getting the client accounts checking balance");
		ex.printStackTrace();
	} finally {
		closeResources();
	}
	
	return gotAccountsSaving;
}

private void closeResources() {
	try {
		if (statement != null && !statement.isClosed()) {
			statement.close();
		}
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	} catch(SQLException ex) {
		System.out.println("Error: Could not close resources.");
		ex.printStackTrace();
	}
}

public static void main (String[] args) {
	
	EmployeeDAO employeeDAO =new EmployeeDAOImpl();
	
	ArrayList<client> Clients =  employeeDAO.getAllTransactions();
	
	for (client client : Clients) {
		System.out.println(client);
	}
}


}
