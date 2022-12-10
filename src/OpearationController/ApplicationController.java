package OpearationController;

import Com.LoginSignUp.loginForm;
import ProductsDetailCheck.ProductController;

public class ApplicationController {
	
	public void getApplicationControlUser() {
		
		loginForm obj3 = new loginForm();
		obj3.getLoginDetail();
		
		ProductController ProductController = new ProductController();
		ProductController.getProductController();
		
		
		
	}

	public static void main(String[] args) {
		
		
		
	}

}
