package Railway2;

public class Passenger {
	
	private String name;
	private int age;
	private String source;
	private String dest;
	
	
	
	public Passenger(String name, int age, String source, String dest) {
		super();
		this.name = name;
		this.age = age;
		this.source = source;
		this.dest = dest;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	

}
