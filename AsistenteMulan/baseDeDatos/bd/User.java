package bd;

public class User {
	
	private String user;
	private String pass;
	
	public User(String u, String p) {
		this.user = u;
		this.pass = p;
	}
	
	public User() {
		this(null,null);
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "[user=" + user + ", pass=" + pass + "]";
	}
	
	

}
