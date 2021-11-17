package trevor.RAP.Models;

public class employee extends user {

	public employee() {
		super(0, null, null);
	}

	private boolean reject;
	private String username;
	private String password;

	public boolean isReject() {
		return reject;
	}

	public void setReject(boolean reject) {
		this.reject = reject;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
