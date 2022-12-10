package ProductsDetailCheck;

import java.util.Scanner;

import Com.LoginSignUp.loginForm;
import MakePayment.MakePayment;

public class ProductController {

	public void getProductController() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose The Option Below: ----->");
		System.out.println("To Buys The Product You Need To Add Them Into Cart First:  ");
		System.out.println("Press 1:" + "BUY AND ADD TO CART: ");
		int choice3 = sc.nextInt();
		switch (choice3) {
		case 1:
			AddToCart AddToCart = new AddToCart();
			AddToCart.getAddToCart();
			System.out.println("Once You Added Into Cart...Successfully Then Perfrom Below Operations");
			break;

		}

		System.out.println("Press 1:" + "To View Cart Amount");
		int choice4 = sc.nextInt();
		switch (choice4) {
		case 1:
			AddToCart AddToCart = new AddToCart();
			AddToCart.viewTheCart();
			break;
		}

		System.out.println("YOU WANT TO BUY THE PRODUCTS THEN PRESS:1");
		System.out.println("YOU WANT TO EMPTY THE CART THEN PRESS:2");
		System.out.println("Press 1:" + "To View Cart Amount");
		int choice5 = sc.nextInt();
		switch (choice5) {
		case 1:
			MakePayment MakePayment = new MakePayment();
			MakePayment.MakePayment();
			break;
		case 2:
			AddToCart pt = new AddToCart();
			pt.EmptyTheCart();

		}
		
		System.out.println("YOU WANT TO LOG OUT THEN PRESS : 1");
		Scanner sc1 = new Scanner(System.in);
		int choice6 = sc1.nextInt();
		switch (choice6) {
		case 1: 
			    System.out.println("Your Logged Out SuccessFully......");
			    System.out.println("Thanks For Visiting out site..!");
			    loginForm obj3 = new loginForm();
		        obj3.getLoginDetail();
		        break;
		}

	}
	
	  

}
