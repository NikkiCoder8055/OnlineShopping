package ProductsDetailCheck;

import java.util.Scanner;

public class CartRunner {

	public void cartRunner() {
		Scanner sc = new Scanner(System.in);
		System.out.println("If Your Want To Add To Cart Then Press:1");
		System.out.println("If Your Want To Buy Directly Then Press:2");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			AddToCart AddToCart = new AddToCart();
			AddToCart.getAddToCart();
			break;

		case 2:

		}

	}
}
