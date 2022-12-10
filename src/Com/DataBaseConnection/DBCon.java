package Com.DataBaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	Connection connection = null;
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newproject", "root", "root");
//			System.out.println("Connected Successfully..!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	   public static void main(String[] args) throws Exception {
		   DBCon obj1 = new DBCon();
		   obj1.getConnection();
	}

}
