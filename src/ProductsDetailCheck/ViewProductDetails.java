package ProductsDetailCheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Com.DataBaseConnection.DBCon;
import Com.LoginSignUp.loginForm;

public class ViewProductDetails extends loginForm {
	PreparedStatement prs = null;
	Connection con = null;

	public void getProductDetails() {

		try {
			System.out.println(
					"--------------------------------------------------------------------------------------------");
			System.out
					.println("*************************WELCOME TO ONLINE SHOPPING STORE..!***************************");

			System.out.println(
					"===============================================================================================");
			
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();

			prs = con.prepareStatement("select * from products");
			ResultSet rs2 = prs.executeQuery();
			while (rs2.next()) {
				System.out.print("Product_Id:" + rs2.getString("Product_Id")+"\t");
				System.out.print("Product_Name:" + rs2.getString("Product_Name")+"\t");
				System.out.print("Product_Des:" + rs2.getString("Product_Des")+"\t");
				System.out.print("Price:" + rs2.getString("Price"));
				System.out.println(
						"\n--------------------------------------------------------------------------------------------");
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

	public void getOperationProduct() {
		AddToCart pt = new AddToCart();
		pt.getAddToCart();
	}

	public static void main(String[] args) {
		ViewProductDetails obj4 = new ViewProductDetails();
		obj4.getProductDetails();

	}

}
