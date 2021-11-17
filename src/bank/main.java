package bank;

public class main {
	
	
	public static void main(String[] args) {
		costumer user = new costumer();
		user.setUsername(view.username());
		user.setPassword(view.password());
		System.out.print("hello " + user.getUsername() );
		
	}

}
