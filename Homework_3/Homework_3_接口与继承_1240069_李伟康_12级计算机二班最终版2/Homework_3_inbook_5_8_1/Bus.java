package Homework_3_inbook_5_8_1;

import java.util.Scanner;

public class Bus {	
	
	//data
	String type;
	int engine_number;
	int seating_capacity;
	int route;
		
	//method
	//show the user's information
	void user_show(){
		System.out.println("*******Bus's Information*******");
		System.out.println("*1.Type: "+this.type);
		System.out.println("*2.Engine_Number: "+this.engine_number);
		System.out.println("*3.Seating_Capacity: "+this.seating_capacity);
		System.out.println("*4.Route: "+this.route);			
		System.out.println("*******************************");
	}
	
	//insert the user's information
	void user_insert(){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Bus's type: ");
				this.type = in.next();				
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}			
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Bus's engine_number: ");		 
				this.engine_number = Integer.parseInt(in.next());
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Bus's seating_capacity: ");
				this.seating_capacity = Integer.parseInt(in.next());
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Bus's route: ");
				this.route = Integer.parseInt(in.next());
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
			case 1:	this.type = information_get;
					break;
					
			case 2:	this.engine_number = Integer.parseInt(information_get);
					break;
			
			case 3:	this.seating_capacity = Integer.parseInt(information_get);
					break;
			
			case 4:	this.route = Integer.parseInt(information_get);
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
				System.out.println("Choose the one you want to delete(like£ºname...input All to delete All): ");
				information = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
				
		switch(information){
			case "Type":		this.type = null;
								break;
							
			case "Engine_Number":			
								this.engine_number = 0;		//to be continued...(check input)
								break;
							
			case "Seating_Capacity":
								this.seating_capacity = 0;
								break;
			
			case "Route":		this.route = 0;
								break;
										
								
			case "All":			this.type = null;	//to be continued...(how to free the space)
								this.engine_number = 0;
								this.seating_capacity = 0;
								this.route = 0;								
								break;
			
			default:			System.out.println("Your input is wrong!");
								System.exit(0);
		}
		System.out.println("Congratulations! your operation is successful!");
	}		
}

