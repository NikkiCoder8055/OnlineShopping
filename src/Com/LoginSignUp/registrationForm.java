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
	String Email;
	String Pass;
	public void getRegisterForm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Customer Name: ");
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
				loginForm obj3 = new loginForm();
				obj3.getLoginDetail();
				break;
			case 2:
				registrationForm r1 = new registrationForm();
				r1.getRegisterForm();
				break;
			   default:

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
