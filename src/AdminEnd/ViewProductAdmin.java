package AdminEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Com.DataBaseConnection.DBCon;

public class ViewProductAdmin {
	
	PreparedStatement prs = null;
	Connection con = null;
	String CustomerName;

	public void getProductDetailsAdmin() {

		try {
			System.out.println("View you Shop Stock Details");
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
			prs = con.prepareStatement("select * from products");
			ResultSet rs2 = prs.executeQuery();
			while (rs2.next()) {
				System.out.print("Product_Id: " + rs2.getString("Product_Id") + " || ");
				System.out.print("Product_Name: " + rs2.getString("Product_Name") + " || ");
				System.out.print("Product_Des: " + rs2.getString("Product_Des") + " || ");
				System.out.print("Price: " + rs2.getString("Price")+ " || ");
				System.out.println("Quantity: " + rs2.getString("Qty"));
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
		ViewProductAdmin ViewProductAdmin =  new ViewProductAdmin();
		ViewProductAdmin.getProductDetailsAdmin();
	}

}
