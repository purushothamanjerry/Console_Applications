package EmployeeManageSystem;
import java.util.*;
public class Service {
	private static Scanner sc=new Scanner(System.in);
	static View view=new View();
	public static List<Employee> ageFilter(List<Employee>employee){
		System.out.println("Enter the age:");
		int age=sc.nextInt();
		List<Employee>list=new ArrayList<>();
		System.out.println("Choose the operation");
		System.out.println("1.Equal");
		System.out.println("2.NotEqual");
		System.out.println("3.Greater then");
		System.out.println("4.Less then");
		int opt=getOption();
		switch(opt) {
		case 1->{
			for(Employee e:employee) {
				if(e.getAge()==age)list.add(e);
			}
		}case 2->{
			for(Employee e:employee) {
				if(e.getAge()!=age)list.add(e);
			}
		}case 3->{
			for(Employee e:employee) {
				if(e.getAge()>age)list.add(e);
			}
		}case 4->{
			for(Employee e:employee) {
				if(e.getAge()<age)list.add(e);
			}
		}
		default->{
			System.out.println("Invalid Option...");
		}
		}
		return list;
	}
	public static int getOption() {
		return sc.nextInt();
	}public static boolean controlOperation(List<Employee>employee){
		int opt=getOption();
		switch(opt) {
		case 1->{view.display(employee);}
		case 2->{filterCon(employee);}
		case 3->{
			
			return false;
		}
		}
		return true;
	}public static void filterCon(List<Employee>employee){
		while(true) {
		view.filedMenu();
		List<Employee>empl=new ArrayList<>();
		int opt=getOption();
		switch(opt) {
		case 1,3,4,5->{
			view.stringInput(opt);
			String s=sc.next().toLowerCase();
		empl=stringfilter(employee, s,opt);
		}case 2->{
		empl=ageFilter(employee);
		}
		default->{
			
			System.out.println("Invalid Options...");
		}
		}
		view.display(empl);
		if(view.docontinue()) {
			employee=empl;
			continue;
		}else {
			view.display(empl);
			System.out.print("Update"+" ");
			update(empl);
			break;
		}
	}
	}public static List<Employee>stringfilter(List<Employee>employee,String s,int t){
		List<Employee>empl=new ArrayList<>();
		view.stringoperation();
		int opt=sc.nextInt();
		for(Employee e:employee) {
			switch(opt) {
			case 1->{
				String str=stringHelper(e, t);
				if(str.equals(s))empl.add(e);
			}case 2 ->{
				String str=stringHelper(e, t);
				if(!str.equals(s))empl.add(e);
			}case 3 ->{
				String str=stringHelper(e, t);
				if(str.contains(s))empl.add(e);
			}case 4 ->{
				String str=stringHelper(e, t);
				if(!str.contains(s))empl.add(e);
			}case 5 ->{
				String str=stringHelper(e, t);
				if(str.startsWith(s))empl.add(e);
			}case 6 ->{
				String str=stringHelper(e, t);
				if(str.endsWith(s))empl.add(e);
			}
			}
		}
		return empl;
	}public static String stringHelper(Employee e,int opt) {
		switch(opt) {
		case 1->{
		return 	e.getName().toLowerCase();
		}
		case 3->{
		return 	e.getDepartment().toLowerCase();
		}case 4->{
		return	e.getDesignation().toLowerCase();
		}case 5->{
			return e.getReportingTo().toLowerCase();
		}
		}
		return "";
	}public static void update(List<Employee>empl) {
	for(Employee e:empl) {
		while(true) {
			view.filedMenu();
			System.out.println("choose the filed to update");
			int opt=getOption();
			if(opt==6)return;
			updateHelper(e, opt);
		}
	}
	}public static Employee updateHelper(Employee emp,int opt){
		switch(opt){
		case 1->{
			System.out.println("Enter the name");
			emp.setName(stringInput());
		}case 2->{
			System.out.println("Enter the Age");
			emp.setAge(getOption());
		}
		case 3->{
			System.out.println("Enter the Department");
			emp.setDepartment(stringInput());
		}case 4->{
			System.out.println("Enter the Designation");
			emp.setDesignation(stringInput());
		}case 5->{
			System.out.println("Enter the ReportingTo");
			emp.setReportingTo(stringInput());
		}
		
		}
		return emp;
	}public static String stringInput() {
		return sc.next();
	}
}
