package AdminEnd;

public class AdminEndController {
	
	public void getAdminControllerAdmin() {
		
		AdminLogin AdminLogin =new AdminLogin();
		AdminLogin.getLoginDetail();
		
		AdminProductController AdminProductController = new AdminProductController();
		AdminProductController.getProductController();
		
	
	}

	public static void main(String[] args) {
		AdminEndController AdminEndController = new AdminEndController();
		AdminEndController.getAdminControllerAdmin();

	}

}
