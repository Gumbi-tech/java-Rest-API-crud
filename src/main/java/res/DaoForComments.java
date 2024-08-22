package res;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class DaoForComments {
		
	

	public List<CommentsBean> getDBCommentsBeans(int page, int size) {
		// TODO Auto-generated method stub
		List<CommentsBean> CommentsBeans = new ArrayList<>(); 
		int offset =(page - 1) * size;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			 Statement stmt;
				try {
					stmt = con.createStatement();
					stmt.execute("select * from comment limit "+ size+" offset "+offset);
			        ResultSet rs = stmt.getResultSet();
			        
			        // adding the product to the arrayList
			        while (rs.next()) {
			        	CommentsBean comment = new CommentsBean();  
		                comment.setId(rs.getInt("Id"));
		                comment.setPostId(rs.getInt("postId"));
		                comment.setEmail(rs.getString("email"));
		                comment.setBody(rs.getString("body"));
		                
		                CommentsBeans.add(comment);
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
		
		
		return CommentsBeans;
		
	}
	
//ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss
	
	
	
	
	
	public CommentsBean getComment(String Id) {
		
		
		
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			 Statement stmt;
				try {
					stmt = con.createStatement();
					stmt.execute("select * from comment WHERE id = "+Id);
			        ResultSet rs = stmt.getResultSet();
			        
			        // adding the product to the arrayList
			        while (rs.next()) {
			        	CommentsBean comment = new CommentsBean();  
		                comment.setId(rs.getInt("Id"));
		                comment.setPostId(rs.getInt("postId"));
		                comment.setEmail(rs.getString("email"));
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
	
	
	
public String createCommet(CommentsBean comment ) {
		
		
		System.out.println("333333333333333333333333333333333333");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
			
			try {
//				   PreparedStatement pstmt = con.prepareStatement("insert into users values(?,?,?,?,?)");
				PreparedStatement pstmt = con.prepareStatement("INSERT INTO comment (postId, email, body) VALUES (?,?,?)");
//                     pstmt.setInt(1, 0);
                     pstmt.setInt(1,  comment.getPostId());
                     pstmt.setString(2, comment.getEmail());
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
	
	

public CommentsBean updateComment(String id , CommentsBean comment  ) {
	
	
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
		
		try {
			PreparedStatement pstmt=con.prepareStatement("update comment set postId=?, email=? , body=? where id="+ id);  
					pstmt.setInt(1,  comment.getPostId());
					pstmt.setString(3, comment.getEmail());
					pstmt.setString(4, comment.getBody());
                 
                 pstmt.executeUpdate();
                 
                 CommentsBean user1 =  getComment(id);
                 
                 
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



public CommentsBean deleteComment(String id) {
	
	
	
	
	 
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb", "root", "");
		
		 Statement stmt;
			try {
				CommentsBean comment =  getComment(id);
				stmt = con.createStatement();
				stmt.execute("delete from comment where id= "+id);
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
