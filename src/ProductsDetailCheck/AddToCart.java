package ProductsDetailCheck;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Com.DataBaseConnection.DBCon;
import ExceptionClass.Message;

public class AddToCart {

	PreparedStatement prs = null;
	Connection con = null;
	int Price;

	public int getProduct_Id() {
		return Product_Id;
	}

	public void setProduct_Id(int product_Id) {
		Product_Id = product_Id;
	}

	int Prod_Id;
	int Product_Id;
	int input;
	static int temp;
	int result = 0;
	int AmountPayble;

	public void getAddToCart() {

		try {
			int sum = 0;
			int temp2 = 0;
			int temp3 = 0;
			int temp4 = 0;
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter the how many Products You want: ");
			int itr = sc1.nextInt();
			System.out.println("---------------------------------------------------------->");
			for (int i = 1; i <= itr; i++) { // this will iterator 4 times

				System.out.println("Enter the Product Id which you Want: ");
				Product_Id = sc1.nextInt();
				setProduct_Id(Product_Id);

				prs = con.prepareStatement("select  * from products where Product_Id = ?");
				prs.setInt(1, this.Product_Id);
				ResultSet rs1 = prs.executeQuery();
				while (rs1.next()) {
					System.out.print(rs1.getInt(1) + " ");
					System.out.print(rs1.getString(2) + " ");
					System.out.print(rs1.getString(3) + " ");
					System.out.println(rs1.getInt(4) + " ");
					System.out.println(rs1.getString(2) + " is Product Added: " + rs1.getInt(4));
					System.out.println("---------------------------------------------------------->");
					temp2 = rs1.getInt(4); // 15000
					for (int j = 1; j <= itr; j++) {
						sum = temp2; // 15000

						temp3 = sum; // 30000
					}
					result = result + temp3; // 3000
				}
			}
//			---------------------------------------------------------------------------------->
//			Scanner sc7 = new Scanner(System.in);
			prs = con.prepareStatement("update products set products.Qty = Qty-1 where Product_Id = ?");
			prs.setInt(1, this.Product_Id);
			int i = prs.executeUpdate();
//			System.out.println("Decreased succesfully: ");
			for (int a = 1; a <= itr; a++) {
				prs = con.prepareStatement("select products.Qty from products where Product_Id = ? ");
				prs.setInt(1, this.Product_Id);
				ResultSet rs9 = prs.executeQuery();
				while (rs9.next()) {
					temp4 = rs9.getInt("Qty");
					if (temp4 > 0) {
//			        	  System.out.println("stock of :"+temp4); 
					} else {
						try {
							throw new Message("Stock is Not Availabe");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			if (temp4 > 0) {
				System.out.println("The Total Purchased Product Amount is: " + (result));
				AddToCartAmount();
			} else {
				try {
					throw new Message("You Can Not Buy This...!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println("You Should Anothor Products To Continue Press:1");
				Scanner sc8 = new Scanner(System.in);
				int choice1 = sc8.nextInt();
				switch (choice1) {
				case 1:
					ViewProductDetails obj4 = new ViewProductDetails();
					obj4.getProductDetails();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	----------------------------------------------------------------------------------->
//	------------------------------------------------------------------------------------>
	public void AddToCartAmount() {
		try {
			Scanner sc5 = new Scanner(System.in);
			System.out.print("Your Products Are ");
			prs = con.prepareStatement("update AddTocart1 set AddToCart1.Price = ? where Prod_Id = 1;");
			prs.setInt(1, result);

			int i = prs.executeUpdate();
			System.out.println("Inserted succesfully In Cart: " + result);
			System.out.println("---------------------------------------------------------->");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void viewTheCart() {

		try {
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();
			prs = con.prepareStatement("select Price from AddToCart1 where Prod_Id = 1");
			ResultSet rs6 = prs.executeQuery();
			while (rs6.next()) {
				System.out.println("Your Cart Amount Is: " + rs6.getInt("Price"));
				AmountPayble = rs6.getInt("Price");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void EmptyTheCart() {
		try {
			DBCon obj2 = new DBCon();
			con = obj2.getConnection();
			prs = con.prepareStatement("update AddTocart1 set AddToCart1.Price = 0 where Prod_Id = 1");
			int i = prs.executeUpdate();
			System.out.println("Cart is Empty Successfully " + i);
			prs = con.prepareStatement("select Price from AddToCart1 where Prod_Id = 1");
			ResultSet rs6 = prs.executeQuery();
			while (rs6.next()) {
				System.out.println("Your Cart Amount Is: " + rs6.getInt("Price"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		AddToCart pt = new AddToCart();
		pt.getAddToCart();
//		pt.viewTheCart();
//		pt.EmptyTheCart();

//		pt.viewCart();
	}

}
