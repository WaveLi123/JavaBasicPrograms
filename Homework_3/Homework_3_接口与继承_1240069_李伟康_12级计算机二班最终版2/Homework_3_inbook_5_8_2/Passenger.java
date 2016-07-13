package Homework_3_inbook_5_8_2;

import java.util.*;

public class Passenger {
	//data
	String name;
	char sex;
	int age;	
	String message;
	
	//method
	//show the user's information
	void user_show(){
		System.out.println("***User's Information***");
		System.out.println("*1.Name: "+this.name);
		System.out.println("*2.Sex: "+this.sex);
		System.out.println("*3.Age: "+this.age);
		System.out.println("*4.Message: "+this.message);			
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
				this.sex = in.next().charAt(0);
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
				System.out.println("Please input the user's department: ");		 
				this.message = in.next();
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
				if(choice >= 5){
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
					
			case 2:	this.sex = information_get.charAt(0);
					break;
			
			case 3:	this.age = Integer.parseInt(information_get);
					break;					
			
			case 4:	this.message = information_get;
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
			case "name":		this.name = null;
								break;
							
			case "sex":			this.sex = 0;		//to be continued...(check input)
								break;
							
			case "age":			this.age = 0;
								break;
						
			case "message":		this.message = null;
								break;
								
			case "all":			this.name = null;	//to be continued...(how to free the space)
								this.sex = 0;
								this.age = 0;								
								this.message = null;
								break;
			
			default:			System.out.println("Your input is wrong!");
								System.exit(0);
		}
		System.out.println("Congratulations! your operation is successful!");
	}		
}
