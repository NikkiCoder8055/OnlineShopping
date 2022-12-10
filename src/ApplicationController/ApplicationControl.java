package ApplicationController;

import java.util.Scanner;

import AdminEnd.AdminEndController;
import OpearationController.ApplicationController;

public class ApplicationControl {

	public static void getApplicationcontrolHere() {

		Scanner sc = new Scanner(System.in);
		System.out.println("PRESS1: FOR USER");
		System.out.println("PRESS2: FOR ADMIN");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			ApplicationController ApplicationController = new ApplicationController();
			ApplicationController.getApplicationControlUser();
			break;

		case 2:
			AdminEndController AdminEndController = new AdminEndController();
			AdminEndController.getAdminControllerAdmin();
			break;

		}

	}

	public static void main(String[] args) {
		getApplicationcontrolHere();
	}

}
