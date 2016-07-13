package Homework_3_inbook_5_8_2;

import java.util.Scanner;

public class Route {
	//data
	int the_number_of_stops;
	String starting_station;
	String destination;	
	String running_time;
	
	//method
	//show the user's information
	void user_show(){
		System.out.println("******Route's Information******");
		System.out.println("*1.the_Number_of_Stops: "+this.the_number_of_stops);
		System.out.println("*2.Starting_Station: "+this.starting_station);
		System.out.println("*3.Destination: "+this.destination);
		System.out.println("*4.Running_Time: "+this.running_time);			
		System.out.println("*****************************");
	}
	
	//insert the user's information
	void user_insert(){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Route's the_number_of_stops: ");
				this.the_number_of_stops = Integer.parseInt(in.next());				
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}			
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Route's starting_station: ");		 
				this.starting_station = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Route's destination: ");
				this.destination = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Route's running time: ");		 
				this.running_time = in.next();
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
			case 1:	this.the_number_of_stops = Integer.parseInt(information_get);
					break;
					
			case 2:	this.starting_station = information_get;
					break;
			
			case 3:	this.destination = information_get;
					break;					
			
			case 4:	this.running_time = information_get;
					break;
			
			default: 
					System.out.println("Your input is wrong!\n");
					System.exit(0);
					break;			
		}
		System.out.println("Congratulations,the Route's information has been updated!");		
	}
	//delete the user's information
	void user_delete(){
		user_show();
		
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		String information = null;
		while(!valid){
			try{
				System.out.println("Choose the one you want to delete(like£ºname...input ¡°All¡± to delete all): ");
				information = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
				
		switch(information){
			case "the_Number_of_Stops":
								this.the_number_of_stops = 0;
								break;
							
			case "Start_Station":
								this.starting_station = null;		//to be continued...(check input)
								break;
							
			case "Destination":
								this.destination = null;
								break;
						
			case "Running_Time":
								this.running_time = null;
								break;
								
			case "All":			this.the_number_of_stops = 0;	//to be continued...(how to free the space)
								this.starting_station = null;
								this.destination = null;								
								this.running_time = null;
								break;
			
			default:			System.out.println("Your input is wrong!");
								System.exit(0);
		}
		System.out.println("Congratulations! your operation is successful!");
	}		
}
