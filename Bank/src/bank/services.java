package bank;

public class services extends main{

	private boolean transaction;

	public boolean isTransaction() {
		return transaction;
	}

	public void setTransaction(boolean transaction) {
		this.transaction = transaction;
	}
	
	// may just use exceptions here to stop invalid transactions
		// can't withdraw more money than you have 
		// can't deposit or withdraw negative money
}
