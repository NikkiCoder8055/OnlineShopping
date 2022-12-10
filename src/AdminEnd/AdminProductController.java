package AdminEnd;

import java.util.Scanner;

import Com.LoginSignUp.loginForm;
import MakePayment.MakePayment;
import ProductsDetailCheck.AddToCart;

public class AdminProductController {

	public void getProductController() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose The Option Below: ----->");
		System.out.println("Press 1:" + "TO VIEW THE USERS ");
		System.out.println("Press 2:" + "TO VIEW THE PRODUCT");
		System.out.println("Press 3:" + "TO ADD THE STOCK");
		System.out.println("Press 4:" + "TO REMOVE THE STOCK");
		System.out.println("Press 5:" + "TO LOG OUT");
		int choice = sc.nextInt();
		switch (choice) {

		case 1:
			viewUserAdmin viewUserAdmin = new viewUserAdmin();
			viewUserAdmin.getviewUserAdmin();
			Scanner sc1 = new Scanner(System.in);
			System.out.println("PRESS 1: BACK TO MAIN MENU");
			System.out.println("PRESS2: TO LOG OUT");
			int choice1 = sc1.nextInt();
			switch (choice1) {
			case 1:
				AdminProductController AdminProductController = new AdminProductController();
				AdminProductController.getProductController();
				break;
			case 2:
				AdminLogin AdminLogin = new AdminLogin();
				AdminLogin.getLoginDetail();
				break;

			}

		case 2:
			ViewProductAdmin ViewProductAdmin = new ViewProductAdmin();
			ViewProductAdmin.getProductDetailsAdmin();
			Scanner sc2 = new Scanner(System.in);
			System.out.println("PRESS 1: BACK TO MAIN MENU");
			System.out.println("PRESS2: TO LOG OUT");
			int choice2 = sc2.nextInt();
			switch (choice2) {
			case 1:
				AdminProductController AdminProductController = new AdminProductController();
				AdminProductController.getProductController();
				break;
			case 2:
				AdminLogin AdminLogin = new AdminLogin();
				AdminLogin.getLoginDetail();
				break;

			}

		case 3:

			AddStockAdmin AddStockAdmin = new AddStockAdmin();
			AddStockAdmin.getAddStock();
			Scanner sc3 = new Scanner(System.in);
			System.out.println("PRESS 1: BACK TO MAIN MENU");
			System.out.println("PRESS2: TO LOG OUT");
			int choice3 = sc3.nextInt();
			switch (choice3) {
			case 1:
				AdminProductController AdminProductController = new AdminProductController();
				AdminProductController.getProductController();
				break;
			case 2:
				AdminLogin AdminLogin = new AdminLogin();
				AdminLogin.getLoginDetail();
				break;

			}
	
		case 4:
			AddStockAdmin AddStockAdmin1 = new AddStockAdmin();
			AddStockAdmin1.removeStock();
			Scanner sc4 = new Scanner(System.in);
			System.out.println("PRESS 1: BACK TO MAIN MENU");
			System.out.println("PRESS2: TO LOG OUT");
			int choice4 = sc4.nextInt();
			switch (choice4) {
			case 1:
				AdminProductController AdminProductController = new AdminProductController();
				AdminProductController.getProductController();
				break;
			case 2:
				AdminLogin AdminLogin = new AdminLogin();
				AdminLogin.getLoginDetail();
				break;

			}
	
		case 5:
			 AdminLogin AdminLogin = new AdminLogin();
			 AdminLogin.getLoginDetail();
			 break;
			

		}

	}

}
