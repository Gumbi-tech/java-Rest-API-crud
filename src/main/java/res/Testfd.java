//package res;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class Testfd {
//
//	public static void main(String[] args) throws SQLException {
//		// TODO Auto-generated method stub
//		
//		System.err.println("ddddddddddddddddddd");
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
//			System.err.println(con);
//			
//			 Statement stmt;
//				try {
//					stmt = con.createStatement();
//					stmt.execute("select * from users");
//			        ResultSet rs = stmt.getResultSet();
//			        
//			        // adding the product to the arrayList
//			        while (rs.next()) {
//			        	User user = new User();  
//		                user.setId(rs.getInt("Id"));
//		                user.setName(rs.getString("name"));
//		                user.setUsername(rs.getString("username"));
//		                user.setEmail(rs.getString("email"));
//		                user.setAddress(rs.getString("address"));
//		                user.setPhone(rs.getString("phone"));
//		                System.err.println(user.toString());
//		               
//		              }
//			        
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			
//			
//			
//			
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		System.err.println("yyyyyyy");
//		
//		
//	}
//
//}
