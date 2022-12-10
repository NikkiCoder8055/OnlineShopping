package AdminEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Com.DataBaseConnection.DBCon;
import Com.LoginSignUp.loginForm;
import Com.LoginSignUp.registrationForm;

public class AdminRegister {
	
	PreparedStatement prs = null;
	Connection con = null;
	String CustomerName;
	String Email;
	String Pass;
	public void getAdminRegister() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Admin Name: ");
		CustomerName = sc.next();
		System.out.println("Enter Your Email: ");
		Email = sc.next();
		System.out.println("Enter Your Password: ");
		Pass = sc.next();

		try {
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();

			prs = con.prepareStatement("insert into LoginForm (CustomerName,Email,Pass) values(?,?,?)");
			prs.setString(1, CustomerName);
			prs.setString(2, Email);
			prs.setString(3, Pass);
			int rs = prs.executeUpdate();
			prs = con.prepareStatement("select CustomerName from LoginForm where CustomerName = ?");
			prs.setString(1, CustomerName);
			ResultSet rs1 = prs.executeQuery();
			while (rs1.next()) {
				System.out.print(rs1.getString("CustomerName")+" ");
			}
			System.out.println("Registered Successfully ");

			Scanner sc1 = new Scanner(System.in);
			System.out.println("You Have Already Registered Then Continue..for  press1:");
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
			   default:

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
