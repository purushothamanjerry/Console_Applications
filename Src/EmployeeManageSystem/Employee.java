package EmployeeManageSystem;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private String department;
	private String designation;
	private String reportingTo;
	
	public Employee(int id, String name, int age, String department, String designation, String reportingTo) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
		this.designation = designation;
		this.reportingTo = reportingTo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getReportingTo() {
		return reportingTo;
	}
	public void setReportingTo(String reportingTo) {
		this.reportingTo = reportingTo;
	}
	public String toString() {
		return id+" "+name+" "+age+" "+department+" "+designation
		+" "+reportingTo;
	}

}
