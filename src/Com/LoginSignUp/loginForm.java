package Com.LoginSignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Com.DataBaseConnection.DBCon;
import ExceptionClass.Message;
import ProductsDetailCheck.ViewProductDetails;

public class loginForm {
	PreparedStatement prs = null;
	Connection con = null;
	public String Email;
	String PassNew;

	public void getLoginDetail() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Email: ");
		Email = sc.next();
		System.out.println("Enter Your Password: ");
		PassNew = sc.next();
		try {
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();
			prs = con.prepareStatement("select * from LoginForm where Email=? and Pass=?");
			prs.setString(1, Email);
			prs.setString(2, PassNew);
			ResultSet rs = prs.executeQuery();
			if (rs.next()) {
				rs.getString("Email");
				rs.getString("Pass");
				System.out.println("Login Successful...!");
				ViewProductDetails obj4 = new ViewProductDetails();
				obj4.getProductDetails();

			} else {
				
				System.out.println("Wrong input..!");

				System.out.println("PRESS 1:IF YOU WANT TO RE-ENTER EMAIL AND PASSWORD ");
				Scanner sc1 = new Scanner(System.in);
				System.out.println("PRESS 2:IF YOU NOT REGISTERED YET THEN GO AND REGISTER FIRST");
				int input = sc1.nextInt();

				switch (input) {
				case 1:
					loginForm obj3 = new loginForm();
					obj3.getLoginDetail();
					break;
				case 2:
					registrationForm r1 = new registrationForm();
					r1.getRegisterForm();
					break;
				}
			}

			con.close();
			prs.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		loginForm obj3 = new loginForm();
		obj3.getLoginDetail();

	}

}
