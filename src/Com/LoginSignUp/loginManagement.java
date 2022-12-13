package Com.LoginSignUp;

import java.util.Scanner;

public class loginManagement {

	public void LoginManagement() {

		Scanner sc = new Scanner(System.in);
		System.out.println("PRESS 1: FOR REGISTER");
		System.out.println("PRESS 2: FOR LOG IN");
		int choice = sc.nextInt();
		switch (choice) {

		case 1:
			
			registrationForm r1 = new registrationForm();
			r1.getRegisterForm();
			break;
		case 2:
			loginForm obj3 = new loginForm();
			obj3.getLoginDetail();
			break;

		}

	}
	public static void main(String[] args) {
		loginManagement loginManagement = new loginManagement();
		loginManagement.LoginManagement();
	}

}
