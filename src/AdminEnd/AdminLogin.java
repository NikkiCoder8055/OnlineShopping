package AdminEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Com.DataBaseConnection.DBCon;
import Com.LoginSignUp.loginForm;
import Com.LoginSignUp.registrationForm;
import ProductsDetailCheck.ViewProductDetails;

public class AdminLogin {
	
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
				
				ViewProductAdmin ViewProductAdmin = new ViewProductAdmin();
				ViewProductAdmin.getProductDetailsAdmin();

			} else {
				System.out.println("Wrong input Added please Check..!");
				System.out.println("You Recorrect your Password and Email press1:");
//				------------------------------------------------------
				Scanner sc1 = new Scanner(System.in);
				System.out.println("if You Don't Register Yet Then Register first for that press2:");
				int input = sc1.nextInt();

				switch (input) {
				case 1:
					AdminLogin AdminLogin =new AdminLogin();
					AdminLogin.getLoginDetail();
					break;
				case 2:
					AdminRegister AdminRegister = new AdminRegister();
					AdminRegister.getAdminRegister();
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

}
