package bank;

import java.util.Scanner;


public class view {
	
	public static void main(String[] args) {
	
	}
	

	public static String username() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter username");
		String username = scanner.nextLine();
//		System.out.println("your username is " + username);
		return username;
	}
	
	public static String password() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter password");
		String password = scanner.nextLine();
//		System.out.println("your username is " + password);
		return password;
	}
	
	
}
