package EmployeeManageSystem;

import java.util.List;

import java.util.*;

public class View {
	Scanner sc=new Scanner(System.in);
	public void display(List<Employee>list){
	System.out.println("Id"+" "+"Name"+" "+"Age"+" "+"Department"+" "+"Designation"
			+" "+"ReportingTo");
	list.stream().forEach(System.out::println);
	}
	public void displayMenu() {
		System.out.println();
		System.out.println("Choose the Operation:-");
		System.out.println("1.Display All");
		System.out.println("2.Filter && Update");
		System.out.println("3.Exit");
	}
	public void filedMenu() {
		System.out.println("Choose the field");
		System.out.println("1.Name");
		System.out.println("2.Age");
		System.out.println("3.Department");
		System.out.println("4.Designation");
		System.out.println("5.ReportingTo");
		System.out.println("6.Exit");
	}public boolean docontinue(){
		System.out.println("do you want filter more enter yes/no");
		String s=sc.next().toLowerCase();
		if(s.equals("yes"))return true;
		return false;
	}public static void stringoperation() {
		System.out.println("Choose the operation to perform");
		System.out.println("1.Equal");
		System.out.println("2.Not Equal");
		System.out.println("3.Contains");
		System.out.println("4.Not Contains");
		System.out.println("5.Startwith");
		System.out.println("6.EndWith");
	}
	public static void stringInput(int opt){
		switch(opt) {
		case 1->{
			System.out.println("Enter the name:");
		}
		case 3->{
			System.out.println("Enter the Department:");
		}case 4->{
			System.out.println("Enter the Designation:");
		}case 5->{
			System.out.println("Enter the ReportingTo:");
		}default->{
			System.out.println("Invalid Input...");
		}
		}
	}public static void diplayEnd() {
		System.out.println("Thank You...!");
	}
}
