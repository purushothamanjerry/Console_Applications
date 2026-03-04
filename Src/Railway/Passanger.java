package Railway;

public class Passanger {
	
	private String name;
	private int age;
	private String gender;
	private String from;
	private String to;
	private int trainNo;
	public Passanger(String name, int age, String gender, String from, String to, int trainNo) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.from = from;
		this.to = to;
		this.trainNo = trainNo;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}
	
	

}
