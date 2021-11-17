package trevor.RAP.BankDAO;

import trevor.RAP.Models.client;

import trevor.RAP.bank.utilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientDAOimpl implements ClientDAO1 {

	private Connection connection;
	private PreparedStatement statement;

	@Override
	public ArrayList<client> addClient(int accountNumbers,String first_Names,String last_Names,String client_usernames,String client_passwords,Boolean approvals) {
		
		ArrayList<client> addedClients = new ArrayList<>();

		try {
			connection = utilities.getConnection();
			String sql = "INSERT into client (accountNumber, first_Name, last_Name, client_username, client_password, approval)"
					+ "VALUES (?,?,?,?,?,?)";

			statement = connection.prepareStatement(sql);
			statement.setInt(1, accountNumbers);
			statement.setString(2, first_Names);
			statement.setString(3, last_Names);
			statement.setString(4, client_usernames);
			statement.setString(5, client_passwords);
			statement.setBoolean(6, approvals);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int accountNumber = rs.getInt("accountNumber");
				String first_Name = rs.getString("first_name");
				String last_Name = rs.getString("last_name");
				String client_username = rs.getString("client_username");
				String client_password = rs.getString("client_password");
				boolean approval = rs.getBoolean("approval");

				addedClients.add(new client(accountNumber, first_Name, last_Name, client_username, client_password, approval));


			}
		} catch(SQLException ex) {
			System.out.println("Error adding client");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return addedClients;
	}
	
public ArrayList<client> addClientAccount(int id1,String checkingAccount1,String savingAccount1,int client_id1,int checking_balance1,int saving_balance1) {
		
		ArrayList<client> addedClients = new ArrayList<>();

		try {
			connection = utilities.getConnection();
			String sql = "INSERT into accounts (id, checkingAccount, savingAccount, client_id, checking_balance, saving_balance)"
					+ "VALUES (?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id1);
			statement.setString(2, checkingAccount1);
			statement.setString(3, savingAccount1);
			statement.setInt(4, client_id1);
			statement.setInt(5, checking_balance1);
			statement.setInt(6, saving_balance1);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				// save property values
				int id = rs.getInt("id");
				String checkingAccount = rs.getString("checkingAccount");
				String savingAccount = rs.getString("savingAccount");
				int client_id = rs.getInt("client_id");
				int checking_balance = rs.getInt("checking_balance");
				int saving_balance = rs.getInt("saving_balance");

				addedClients.add(new client(id, checkingAccount, savingAccount, client_id, checking_balance, saving_balance));


			}
		} catch(SQLException ex) {
			System.out.println("Error adding client account");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return addedClients;
	}
	
	
	
	public String LogIn( String username1, String password1) {
		String login = "";

		try {
			connection = utilities.getConnection();
			String sql = "SELECT * FROM client WHERE client_username = ? AND client_password = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username1);
			statement.setString(2, password1);		
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				String username = rs.getString("client_username");
				String password = rs.getString("client_password");
				
				login = username + password;


			}
		} catch(SQLException ex) {
			System.out.println("Error getting account number ");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return login;
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

	@Override
	public int depositInChecking(  int client_id1, int checking_balance1) {
		
		int deposit = 0;

		try {
			connection = utilities.getConnection();
			String sql = "UPDATE accounts set checking_balance = ? WHERE client_id = ?";
			statement = connection.prepareStatement(sql);
			statement.setDouble(1,checking_balance1);
			statement.setInt(2, client_id1);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int checking_balance = rs.getInt("checking_balance");	

				deposit = checking_balance;
			}
		} catch(SQLException ex) {
			System.out.println("error making deposit in checking");
			ex.printStackTrace();
		} finally {
			closeResources();
		}
		return deposit;
	}

	public int depositInSavings(  int client_id1, int saving_balance1) {
		
		int deposit = 0;

		try {
			connection = utilities.getConnection();
			String sql = "UPDATE accounts set saving_balance = ? WHERE client_id = ?";
			statement = connection.prepareStatement(sql);
			statement.setDouble(1,saving_balance1);
			statement.setInt(2, client_id1);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int saving_balance = rs.getInt("saving_balance");

				deposit = saving_balance;
			}
		} catch(SQLException ex) {
			System.out.println("error making deposit in savings");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return deposit;
	}

	public int withdrawFromChecking(int client_id1, int checking_balance1) {
		int withdraw = 0;

		try {
			connection = utilities.getConnection();
			String sql = "UPDATE accounts set checking_balance = ? WHERE client_id = ?";
			statement = connection.prepareStatement(sql);
			statement.setDouble(1,checking_balance1);
			statement.setInt(2, client_id1);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int checking_balance = rs.getInt("checking_balance");

				withdraw = checking_balance;
			}
		} catch(SQLException ex) {
			System.out.println("error making withdrawal from checking");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return withdraw;
	}

	public int withdrawFromSavings(  int client_id1, int saving_balance1) {
		int withdraw = 0;

		try {
			connection = utilities.getConnection();
			String sql = "UPDATE accounts set saving_balance = ? WHERE client_id = ?";
			statement = connection.prepareStatement(sql);
			statement.setDouble(1,saving_balance1);
			statement.setInt(2, client_id1);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				int saving_balance = rs.getInt("saving_balance");	

				withdraw = saving_balance;
			}
		} catch(SQLException ex) {
			System.out.println("error making withdrawal from savings");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return withdraw;
	}
	
	@Override
	public ArrayList<client> addtransactions( int client_id1, int deposit1, int withdraw1) {
		
		ArrayList<client> addedtransactions = new ArrayList<>();

		try {
			connection = utilities.getConnection();
			String sql = "INSERT into transactions (client_id, deposit, withdraw) VALUES (?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, client_id1);
			statement.setInt(2, deposit1);
			statement.setInt(3, withdraw1);
			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				int client_id = rs.getInt("client_id");
				int deposit = rs.getInt("deposit");
				int withdraw = rs.getInt("withdraw");
				
				addedtransactions.add(new client(client_id, deposit, withdraw));

			}
		} catch(SQLException ex) {
			System.out.println("Error adding transaction ");
			ex.printStackTrace();
		} finally {
			closeResources();
		}

		return addedtransactions;
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

}




