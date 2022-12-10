package AdminEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Com.DataBaseConnection.DBCon;

public class viewUserAdmin {
	
	PreparedStatement prs = null;
	Connection con = null;
	String CustomerName;

	public void getviewUserAdmin() {

		try {
			System.out.println("View User List Which is Login:");
			System.out.println(
					"--------------------------------------------------------------------------------------------");
			System.out.println(
					"--------------------------------------------------------------------------------------------");
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();
			prs = con.prepareStatement("select CustomerName from LoginForm where CustomerName = ?");
			prs.setString(1, CustomerName);
			ResultSet rs1 = prs.executeQuery();
			while (rs1.next()) {
				System.out.print(rs1.getString("CustomerName") + " ");
			}
			prs = con.prepareStatement("select * from LoginForm");
			ResultSet rs2 = prs.executeQuery();
			while (rs2.next()) {
				System.out.print("LoginForm_id: " + rs2.getString("LoginForm_id") + " || ");
				System.out.print("CustomerName: " + rs2.getString("CustomerName") + " || ");
				System.out.print("Email: " + rs2.getString("Email") + " || ");
				System.out.println("Pass: " + rs2.getString("Pass"));
			}
			con.close();
			prs.close();
			rs2.close();
			System.out.println(
					"--------------------------------------------------------------------------------------------");
			System.out.println(
					"--------------------------------------------------------------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
          
	}  
	  public static void main(String[] args) {
		  viewUserAdmin viewUserAdmin = new viewUserAdmin();
		  viewUserAdmin.getviewUserAdmin();
	}

}
