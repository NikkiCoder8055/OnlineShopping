package AdminEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Com.DataBaseConnection.DBCon;
import Com.LoginSignUp.loginForm;
import Com.LoginSignUp.registrationForm;

public class AddStockAdmin {

	PreparedStatement prs = null;
	Connection con = null;
	String CustomerName;
	String Product_Name;
	String Product_Des;
	String Price;
	String Qty;
	String Product_Id;

	public void getAddStock() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter The Product_Id: ");
		Product_Id = sc.next();
		System.out.println("Enter The Product_Name: ");
		Product_Name = sc.next();
		System.out.println("Enter Your Product_Des: ");
		Product_Des = sc.next();
		System.out.println("Enter Your Price: ");
		Price = sc.next();
		System.out.println("Enter Your Qty: ");
		Qty = sc.next();

		try {
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();

			prs = con.prepareStatement("insert into products (Product_Id,Product_Name,Product_Des,Price,Qty) values(?,?,?,?,?)");
			prs.setString(1, Product_Id);
			prs.setString(2, Product_Name);
			prs.setString(3, Product_Des);
			prs.setString(4, Price);
			prs.setString(5, Qty);
			int rs = prs.executeUpdate();
			System.out.println("Stock Inserted SuccessFully"+rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}
	
	
	public void removeStock() {
		   Scanner sc =  new Scanner(System.in);
		   System.out.println("Enter the product_Id Which You want to remove: ");
		   int Product_Id1 =sc.nextInt();
		try {
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();
			prs = con.prepareStatement("delete from products where Product_Id = ?");
			prs.setInt(1, Product_Id1);
			int rs = prs.executeUpdate();
			System.out.println("Stock Removed SuccessFully"+rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		AddStockAdmin AddStockAdmin = new AddStockAdmin();
//		AddStockAdmin.getAddStock();
		AddStockAdmin.removeStock();
		
	}

}
