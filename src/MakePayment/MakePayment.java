package MakePayment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Com.DataBaseConnection.DBCon;
import ProductsDetailCheck.AddToCart;

public class MakePayment extends AddToCart {
	int AmountPayble;
	PreparedStatement prs = null;
	Connection con = null;
	public void MakePayment() {
			
		try {
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();
			prs = con.prepareStatement("select Price from addtocart where Prod_Id = 1");
			ResultSet rs6 = prs.executeQuery();
			while (rs6.next()) {
				System.out.println("Your Payable Amount is: " + rs6.getInt("Price"));
		      	AmountPayble = rs6.getInt("Price");
			}
			System.out.println("Press 1 : Make Payment....");
			Scanner sc  = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice){
			   case 1 : 
				   AddToCart pt = new AddToCart();
					pt.EmptyTheCart();
					break;
			}
			
			System.out.println("Your Payment is Done Successfully...!");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		MakePayment MakePayment = new MakePayment();
		MakePayment.MakePayment();
	}
}
