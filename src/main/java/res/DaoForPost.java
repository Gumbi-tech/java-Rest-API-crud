package res;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DaoForPost {
	
	

	public List<Post> getDBPost(int page, int size) {
		// TODO Auto-generated method stub
		List<Post> Posts = new ArrayList<>(); 
		int offset =(page - 1) * size;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			 Statement stmt;
				try {
					stmt = con.createStatement();
					stmt.execute("select * from post limit "+ size+" offset "+offset);
			        ResultSet rs = stmt.getResultSet();
			        
			        // adding the product to the arrayList
			        while (rs.next()) {
			        	Post comment = new Post();  
		                comment.setId(rs.getInt("Id"));
		                comment.setUserId(rs.getInt("userId"));
		                comment.setTitle(rs.getString("title"));
		                comment.setBody(rs.getString("body"));
		                
		                Posts.add(comment);
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
		
		
		return Posts;
		
	}
	
//ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
	
	
	
	
	
	public Post getPost(String Id) {
		
		
		
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			 Statement stmt;
				try {
					stmt = con.createStatement();
					stmt.execute("select * from post WHERE id = "+Id);
			        ResultSet rs = stmt.getResultSet();
			        
			        // adding the product to the arrayList
			        while (rs.next()) {
			        	Post comment = new Post();  
			        	comment.setId(rs.getInt("Id"));
		                comment.setUserId(rs.getInt("userId"));
		                comment.setTitle(rs.getString("title"));
		                comment.setBody(rs.getString("body"));
		                return comment;
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
	
	
	
	
	
//sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
	
	
	
public String createPost(Post comment ) {
	
		System.out.println("dddddddddddddddddddddddddddddddddd");
		
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			try {
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO post (userId, title, body) VALUES (?,?,?)");
                     pstmt.setInt(1,  comment.getUserId());
                     pstmt.setString(2, comment.getTitle());
                     pstmt.setString(3, comment.getBody());
                     
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
	
	
	
	
	
//sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss	
	
	

public Post updatePost(String id , Post comment  ) {
	
	
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
		
		try {
			PreparedStatement pstmt=con.prepareStatement("update post set userId=?, title=? , body=? where id="+ id);  
					pstmt.setInt(1,  comment.getUserId());
					pstmt.setString(3, comment.getTitle());
					pstmt.setString(4, comment.getBody());
                 
                 pstmt.executeUpdate();
                 
                 Post user1 =  getPost(id);
                 
                 
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




	
	
//deletesssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss



public Post deletePost(String id) {
	
	
	
	
	 
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
		
		 Statement stmt;
			try {
				Post comment =  getPost(id);
				stmt = con.createStatement();
				stmt.execute("delete from post where id= "+id);
		        return comment;
		    
		        
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
