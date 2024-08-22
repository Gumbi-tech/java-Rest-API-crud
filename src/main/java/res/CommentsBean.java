package res;

public class CommentsBean {

	 private int id;
	 private int postId; 
	 private String email; 
	 private String body;
	public CommentsBean(int postId, String email, String body) {
		super();
		this.postId = postId;
		this.email = email;
		this.body = body;
	}
	public CommentsBean(String email, String body) {
		super();
		this.email = email;
		this.body = body;
	}
	public CommentsBean() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	} 
	 	
	
}
