package Homework_3_inbook_5_8_1;

import java.util.Scanner;

public class Manager extends Employee{
	//data
	String job;
	String m_institution;
	String duties;
	
	//method
	//show the user's information
	void user_show(){
		System.out.println("***Manager's Information***");
		System.out.println("*1.Name: "+this.name);
		System.out.println("*2.ID: "+this.ID);
		System.out.println("*3.Age: "+this.age);
		System.out.println("*4.Salary: "+this.salary);
		System.out.println("*5.Department: "+this.department);
		System.out.println("*6.Job: "+this.job);
		System.out.println("*7.M_Institution: "+this.m_institution);
		System.out.println("*8.Duties: "+this.duties);
		System.out.println("***********************");
	}
	//insert the user's information
	void user_insert(){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Manager's name: ");
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
				System.out.println("Please input the Manager's ID: ");		 
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
				System.out.println("Please input the Manager's age: ");
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
				System.out.println("Please input the Manager's salary: ");
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
				System.out.println("Please input the Manager's department: ");		 
				this.department = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Manager's job: ");		 
				this.job = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Manager's m_institution: ");		 
				this.m_institution = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Manager's duties: ");		 
				this.duties = in.next();
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
				if(choice >= 9){
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
					
			case 6: this.job = information_get;
					break;
					
			case 7: this.m_institution = information_get;
					break;
					
			case 8: this.duties = information_get;
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
			
			case "Job":
								this.job = null;
								break;
								
			case "M_Institution":
								this.m_institution = null;
								break;
								
			case "Duties":
								this.duties = null;
								break;
								
			case "all":			this.name = null;	//to be continued...(how to free the space)
								this.ID = 0;
								this.age = 0;
								this.salary = 0;
								this.department = null;
								this.job = null;
								this.m_institution = null;
								this.duties = null;
								break;
			
			default:			System.out.println("Your input is wrong!");
								System.exit(0);
		}
		System.out.println("Congratulations! your operation is successful!");
	}		
}
