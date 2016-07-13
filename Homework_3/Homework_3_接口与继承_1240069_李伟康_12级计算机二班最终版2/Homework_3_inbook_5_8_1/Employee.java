package Homework_3_inbook_5_8_1;

import java.util.*;

public class Employee {
	//data
	String name;
	int ID;
	int age;
	double salary;
	String department;
	
	//method
	//show the user's information
	void user_show(){
		System.out.println("***User's Information***");
		System.out.println("*1.Name: "+this.name);
		System.out.println("*2.ID: "+this.ID);
		System.out.println("*3.Age: "+this.age);
		System.out.println("*4.Salary: "+this.salary);
		System.out.println("*5.Department: "+this.department);
		System.out.println("***********************");
	}
	//insert the user's information
	void user_insert(){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the user's name: ");
				this.name = in.next();				
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}			
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the user's ID: ");		 
				this.ID = Integer.parseInt(in.next());
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the user's age: ");
				this.age = Integer.parseInt(in.next());
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the user's salary: ");
				this.salary = Double.parseDouble(in.next());
				valid = true;
			}catch(Exception e){
				e.printStackTrace();				
				System.out.println("Warning,Your input is wrong,Please input again:");
			}			
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the user's department: ");		 
				this.department = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
	}

	//change the user's information
	void user_update(){
		//show the user's information
		user_show();
		
		boolean valid = false;
		Scanner in = new Scanner(System.in);
		int choice = 0;
		String information_get = null; 
		
		while(!valid){
			try{
				System.out.println("Please input the number you want to change:");		 
				choice = in.nextInt();
				if(choice >= 6){
					throw new NumberException();
				}
				valid = true;				
			}
			catch(NumberException e){
				e.getMessage();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}			
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the information :");		 
				information_get = in.next();
				valid = true;				
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
												
		switch(choice){		
			case 1:	this.name = information_get;
					break;
					
			case 2:	this.ID = Integer.parseInt(information_get);
					break;
			
			case 3:	this.age = Integer.parseInt(information_get);
					break;
			
			case 4:	this.salary = Double.parseDouble(information_get);
					break;
			
			case 5:	this.department = information_get;
					break;
			
			default: 
					System.out.println("Your input is wrong!\n");
					System.exit(0);
					break;			
		}
		System.out.println("Congratulations,the user's information has been updated!");		
	}
	//delete the user's information
	void user_delete(){
		user_show();
		
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		String information = null;
		while(!valid){
			try{
				System.out.println("Choose the one you want to delete(like£ºname...input all to delete all): ");
				information = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
				
		switch(information){
			case "Name":		this.name = null;
								break;
							
			case "ID":			this.ID = 0;		//to be continued...(check input)
								break;
							
			case "Age":			this.age = 0;
								break;
			
			case "Salary":		this.salary = 0;
								break;
							
			case "Department":	this.department = null;
								break;
								
			case "All":			this.name = null;	//to be continued...(how to free the space)
								this.ID = 0;
								this.age = 0;
								this.salary = 0;
								this.department = null;
								break;
			
			default:			System.out.println("Your input is wrong!");
								System.exit(0);
		}
		System.out.println("Congratulations! your operation is successful!");
	}		
}
