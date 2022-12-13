package Com.LoginSignUp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Com.DataBaseConnection.DBCon;

public class registrationForm {

	PreparedStatement prs = null;
	Connection con = null;
	String CustomerName;
	String phoneNumber;
	String Email;
	String Pass;
	int choice;
	String UserName;

	public void getRegisterForm() {
		System.out.println("=================================================================================");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter The Customer Name: ");
		CustomerName = sc.next();
		System.out.print("Enter The phoneNumber: ");
		phoneNumber = sc.next();
		System.out.print("Enter Your Email: ");
		Email = sc.next();
		System.out.print("Enter Your Password: ");
		Pass = sc.next();
		try {
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();

			prs = con.prepareStatement("insert into LoginForm (CustomerName,phoneNumber,Email,Pass) values(?,?,?,?)");
			prs.setString(1, CustomerName);
			prs.setString(2, phoneNumber);
			prs.setString(3, Email);
			prs.setString(4, Pass);
			int rs = prs.executeUpdate();
			prs = con.prepareStatement("select CustomerName from LoginForm where CustomerName = ?");
			prs.setString(1, CustomerName);
			ResultSet rs1 = prs.executeQuery();
			while (rs1.next()) {
				UserName = rs1.getString("CustomerName");
			}
			System.out.println(UserName+" Registered Successfully ");
			System.out.println("---------------------------------------------------------->");
	
			System.out.println("PRESS 1:IF YOU REGISTERED YET THEN GO FOR LOGIN");
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				loginForm obj3 = new loginForm();
				obj3.getLoginDetail();
				break;
			
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}

	public static void main(String[] args) {
		registrationForm r1 = new registrationForm();
		r1.getRegisterForm();
	}

}
