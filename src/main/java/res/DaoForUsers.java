package res;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DaoForUsers {
	
	
	

	public List<User> getDBusers(int page, int size) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<>(); 
		int offset =(page - 1) * size;
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			 Statement stmt;
				try {
					stmt = con.createStatement();
					stmt.execute("select * from users limit "+ size+" offset "+offset);
					
			        ResultSet rs = stmt.getResultSet();
			        
			        // adding the product to the arrayList
			        while (rs.next()) {
			        	User user = new User();  
		                user.setId(rs.getInt("Id"));
		                user.setName(rs.getString("name"));
		                user.setUsername(rs.getString("username"));
		                user.setEmail(rs.getString("email"));
		                user.setAddress(rs.getString("address"));
		                user.setPhone(rs.getString("phone"));
		                users.add(user);
		              }
			        
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return users;
		
	}


	public User getUser(String Id) {
		
		
		
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			 Statement stmt;
				try {
					stmt = con.createStatement();
					stmt.execute("select * from users WHERE Id = "+Id);
			        ResultSet rs = stmt.getResultSet();
			        
			        // adding the product to the arrayList
			        while (rs.next()) {
			        	User user = new User();  
		                user.setId(rs.getInt("Id"));
		                user.setName(rs.getString("name"));
		                user.setUsername(rs.getString("username"));
		                user.setEmail(rs.getString("email"));
		                user.setAddress(rs.getString("address"));
		                user.setPhone(rs.getString("phone"));
		                return user;
		              }
			        
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return null;
		
	}
	
	public String createUser(User user ) {
		
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			try {
//				   PreparedStatement pstmt = con.prepareStatement("insert into users values(?,?,?,?,?)");
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO users (name, username, email, address, phone) VALUES (?,?,?,?,?)");
//                     pstmt.setInt(1, 0);
                     pstmt.setString(1,  user.getName());
                     pstmt.setString(2, user.getUsername());
                     pstmt.setString(3, user.getEmail());
                     pstmt.setString(4, user.getAddress());
                     pstmt.setString(5, user.getPhone());
                     
                     pstmt.executeUpdate();
                     return "added";
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return "failed";
		
	}
	
	
	
	
	
	
	
	
	
public User updateUser(String id ,User user ) {
		
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			try {
				PreparedStatement pstmt=con.prepareStatement("update users set name=?, username=? , email=?, address=?, phone=? where id="+ id);  
                     pstmt.setString(1,  user.getName());
                     pstmt.setString(2, user.getUsername());
                     pstmt.setString(3, user.getEmail());
                     pstmt.setString(4, user.getAddress());
                     pstmt.setString(5, user.getPhone());
                     
                     pstmt.executeUpdate();
                     
                     User user1 =  getUser(id);
                     
                     
                     return user1;
								
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	public User deleteUser(String id) {
		
		
		
		
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			 Statement stmt;
				try {
					User user =  getUser(id);
					stmt = con.createStatement();
					stmt.execute("delete from users where id= "+id);
			        return user;
			    
			        
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		return null;
		
	}


}
