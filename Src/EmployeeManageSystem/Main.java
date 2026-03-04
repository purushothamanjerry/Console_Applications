package EmployeeManageSystem;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		View v=new View();
		Service service=new Service();
		List<Employee>employee=new ArrayList<>();
		employee.add(new Employee(1,"Sriram",45,"Management","CEO",""));
		employee.add(new Employee(2,"Mukund",42,"HR","HR Manager","Sriram"));
		employee.add(new Employee(3,"Sebastian",38,"Finance","Finance Manager","Sriram"));
		employee.add(new Employee(4,"Aashritha",32,"Product Management","Dev Manager","Sriram"));
		employee.add(new Employee(5,"Mohammad Rafi",35,"HR","HR Lead","Mukund"));
		employee.add(new Employee(6,"Anjali Kumar",29,"HR","HR Associate","Mohammad Rafi"));
		employee.add(new Employee(7,"Joseph",40,"Finance","Finance Associate","Sebastian"));
		employee.add(new Employee(8,"Ramachandran",27,"Product Development","Team Lead","Aashritha"));
		employee.add(new Employee(9,"Abhinaya Shankar",23,"Product Development","System Developer","Ramanchandran"));
		employee.add(new Employee(10,"Imran Khan",28,"Product Testing","QA Lead","Ramanchandran"));
		boolean check=true;
		while(check) {
		v.displayMenu();
		check=service.controlOperation(employee);
		}
		View.diplayEnd();
	}
}
