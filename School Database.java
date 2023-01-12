package pr2;

import java.util.Scanner;

//import pr1.student;

/**
 * @author Shivam Shah
 * 
 * * * NOTE * *
 */

abstract class Person
{
	public abstract void print();
	
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Person(String name, String id)
	{
		setName(name);
		setId(id);
		
	}
}

class student extends Person
{
	private int hour;
	private double gpa;
	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public student(String name, String id, int hour, double gpa)
	{
		super(name,id);
		this.hour = hour;
		this.gpa = gpa;
	}
	
	@Override
	public void print()
	{
		double total = 236.45, d = 0.15, discount = 0;
		int f = 52;
		
		total = (this.getHour()*total)+f;
		
		
		if(this.getGpa() >= 3.85)
		{
			discount = total * d;
			total -= discount;
		}
		
		System.out.println("Here is the tuition invoice for "+this.getName()+": ");
		
		System.out.println("\t---------------------------------------------------------------------------");
		
		System.out.println("\t"+this.getName()+"\t\t"+this.getId()+"");
		
		System.out.println("\tCredit Hours:"+this.getHour()+" ($236.45/credit hour)\n\tFees: $"+f+"");
		
		System.out.print("\n\n\tTotal payment(after discount): $"+String.format("%.2f", total)+"\t");
		
		if(this.getGpa() >= 3.85) System.out.println("\t($"+String.format("%.2f", discount)+" discount applied)");
		else System.out.println("\t($0 discount applied)");
		
		System.out.println("\t---------------------------------------------------------------------------");
	}
}

abstract class Employee extends Person
{
	private String dept;

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public Employee (String name, String id, String dept)
	{
		super(name, id);
		this.dept = dept;
	}
  
}

class staff extends Employee
{
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public staff(String name, String id, String dept, String status)
	{
		super(name,id,dept);
		this.status = status;
	}

	@Override
	public void print()
	{
		System.out.println("\t---------------------------------------------------------------------------");
		
		System.out.println("\t"+this.getName()+"\t\t"+this.getId()+"");
		
		System.out.println("\t"+this.getDept()+" Department, "+this.getStatus()+"");
		
		System.out.println("\t---------------------------------------------------------------------------");
	}
}

class faculty extends Employee
{
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public faculty(String name, String id, String dept, String status)
	{
		super(name,id,dept);
		this.status = status;
	}

	@Override
	public void print()
	{
		System.out.println("\t---------------------------------------------------------------------------");
		
		System.out.println("\t"+this.getName()+"\t\t"+this.getId()+"");
		
		System.out.println("\t"+this.getDept()+" Department, "+this.getStatus()+"");
		
		System.out.println("\t---------------------------------------------------------------------------");
	}
}


public class Code5 
{
	public static String check(String s1)
	{
		int c = 0;
		Scanner scan = new Scanner(System.in);
		s1 = scan.nextLine();
	 	s1 = s1.toLowerCase();
		
		
		do{
			if(s1.equals("sciences") || s1.equals("mathematics") || s1.equals("engineering"))
			{
				c = 1;
			}
			else
			{
				System.out.println("\t"+s1+" is invalid");
				System.out.print("\n\tDepartment: ");
				s1 = scan.nextLine();
				s1 = s1.toLowerCase();
			}
		}while(c == 0);
		
		
		s1 =  s1.substring(0, 1).toUpperCase() + s1.substring(1);
		return s1;
	}
	
	public static String checkRank(String s1)
	{
		int c = 0;
		Scanner scan = new Scanner(System.in);
		s1 = scan.nextLine();
	 	
		do{
			if(s1.equals("Professor") || s1.equals("Adjunct"))
			{
				c = 1;
			}
			else
			{
				System.out.println("\t\""+s1+"\" is invalid");
				System.out.print("\tRank: ");
				s1 = scan.nextLine();
			}
		}while(c == 0);
		
		return s1;
	}
	
	
	public static int menu()
	{
		Scanner scan = new Scanner(System.in);
		
		int option;
		System.out.println("\n1-Enter the information of a faculty member "
				+ "\n2-Enter the information of a student"
				+ "\n3-Print tuition invoice for a student"
				+ "\n4-Print faculty information"
				+ "\n5-Enter the information of a staff member"
				+ "\n6-Print the information of a staff member"
				+ "\n7-Exit Program");
		System.out.print("\tEnter your selection: ");
		option = scan.nextInt();
		
		return option;
	}
	
	public static int search(Person[] List,String id, int track)
	{
		for(int i = 0; i<track; i++)
		{
			if(id.equals(List[i].getId()))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	
	public static void main(String[] args) 
	{
		
		System.out.println("\t\t\t\t\tWelcome to my Personal Management Program");
		
		System.out.println("Choose one of the options:");
		
		
		Scanner scan = new Scanner(System.in);
		int option;
		int track = 0;
		int counter = 0, counter1 = 0, counter2 = 0; 
		
		Person[] List = new Person[100];
		String s1 = "NULL", s2 = "NULL ", s3 = "NULL", s4 = "NULL";
		String id; int hold;
		
		String student1 = "NULL", student2 = "NULL";
		
		String buffer = "NULL";
		
		
		do
		{
			option = menu();
			buffer = scan.nextLine();
			
			switch(option)
			{
				case 1:
						String extra;
						System.out.println("Enter faculty info:");
						
						System.out.print("\tName of the faculty: ");
						extra = scan.nextLine();						
						scan.nextLine();
						
						System.out.print("\tID: ");
						s2 = scan.nextLine(); 
						scan.nextLine();
						
						System.out.print("\tRank: ");
						s3 = checkRank(s3);
						
						System.out.print("\tDepartment: ");
						s4 = check(s4);
						
						List[track] = new faculty(extra,s2,s4,s3);
						
						System.out.println("Faculty added!");
						track++;
						break;
					
				case 2:
						
						//String s, s2;
						double g;
						int h, i;
						
						
						System.out.println("\n\nEnter student info:");
						
						System.out.print("\tName of Student: ");
						s1 = scan.nextLine();
						scan.nextLine();
						
						
						System.out.print("\tID: ");
						s2 = scan.nextLine();
						scan.nextLine();
						
						System.out.print("\tGpa: ");
						g = scan.nextDouble();
						
						System.out.print("\tCredit Hours: ");
						h = scan.nextInt();
						scan.nextLine();
						
						List[track] = new student(s1,s2,h,g);
						System.out.println("Student added!");
						
						track++;
						break;
				case 3:
						
						System.out.print("\tEnter the student's id: ");
						id = scan.nextLine();
						scan.nextLine();
		
						hold = search(List,id,track);
						
						if(hold>-1) List[hold].print();
						else System.out.println("\tNo student matched!");
						
						break;
				case 4:
	
						System.out.print("\tEnter the Faculty�s id: ");
						id = scan.nextLine();
						scan.nextLine();
						
						hold = search(List,id,track);
						
						if(hold>-1) List[hold].print();
						else System.out.println("\tNo faculty matched!");
						
						break;
					
				case 5:
						System.out.print("\tName of the staff member: ");
						s1 = scan.nextLine();
						scan.nextLine();
						
						System.out.print("\tEnter the ID: ");
						s2 = scan.nextLine(); 
						scan.nextLine();
						
						System.out.print("\tDepartment: ");
						s3 = check(s3);
						
						char c;
						
						System.out.print("\tStatus, Enter P for Part Time or Enter F for Full Time: ");
						c = scan.next().charAt(0);
						
						if(c == 'F' || c == 'f') s4 = "Full Time";
						else if(c == 'P' || c == 'p') s4 = "Part Time";
						else s4 = "Invalid entry";
						
						List[track] = new staff(s1,s2,s3,s4);
						System.out.println("\nStaff member added!");
						track++;
						
						break;
				case 6:
						System.out.print("\tEnter the Staff�s id: ");
						id = scan.nextLine();
						scan.nextLine();
						
						hold = search(List,id,track);
						
						if(hold>-1) List[hold].print();
						else System.out.println("\tNo Staff member matched!");
						
						break;
				case 7: 
						System.out.println("\n\n\nGoodbye!");
						break;
			
				default:
						System.out.println("Invalid entry-please try again");
			}
		}while(option != 7);		
	}
}