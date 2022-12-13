package OpearationController;

import Com.LoginSignUp.loginForm;
import Com.LoginSignUp.loginManagement;
import ProductsDetailCheck.ProductController;

public class ApplicationController {
	
	public void getApplicationControlUser() {
		
		loginManagement loginManagement = new loginManagement();
		loginManagement.LoginManagement();
		
		ProductController ProductController = new ProductController();
		ProductController.getProductController();
		
	}

	public static void main(String[] args) {
		
		
		
	}

}
