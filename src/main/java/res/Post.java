package res;

public class Post {
	 public Post() {
		super();
	}


	private int id;
	 private int userId; 
	 private String title; 
	 private String body;
	 
	 
	public Post(int userId, String title, String body) {
		super();
		this.userId = userId;
		this.title = title;
		this.body = body;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}
	 
	 
	
	

}
