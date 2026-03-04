package SuperStore2;
import java.time.*;
public abstract class User {
	static int id;
	String name;
	String password;
	LocalDateTime created_At;
	LocalDateTime modified_At;
	public int getId() {
		return id;
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		this.created_At = LocalDateTime.now();
		this.modified_At = LocalDateTime.now();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDateTime getCreated_At() {
		return created_At;
	}
	public void setCreated_At(LocalDateTime created_At) {
		this.created_At = created_At;
	}
	public LocalDateTime getModified_At() {
		return modified_At;
	}
	public void setModified_At(LocalDateTime modified_At) {
		this.modified_At = modified_At;
	}
	
}
