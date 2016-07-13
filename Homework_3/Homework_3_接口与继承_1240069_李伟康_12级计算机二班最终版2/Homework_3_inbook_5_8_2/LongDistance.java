package Homework_3_inbook_5_8_2;

import java.util.Scanner;

public class LongDistance {
	//data
	String start_time;
	String end_time;
	Route route;
	//method
	//show the user's information
	void user_show(){
		System.out.println("******LongDistance's Information******");
		System.out.println("*1.the_Number_of_Stops: "+this.route.the_number_of_stops);
		System.out.println("*2.Starting_Station: "+this.route.starting_station);
		System.out.println("*3.Destination: "+this.route.destination);
		System.out.println("*4.Running_Time: "+this.route.running_time);
		System.out.println("*5.Start_Time: "+this.start_time);
		System.out.println("*6.End_Time: "+this.end_time);
		System.out.println("*****************************");
	}
	
	//insert the user's information
	void user_insert(){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the LongDistance's the_number_of_stops: ");
				this.route.the_number_of_stops = Integer.parseInt(in.next());				
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}			
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the LongDistance's starting_station: ");		 
				this.route.starting_station = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the LongDistance's destination: ");
				this.route.destination = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the LongDistance's running time: ");		 
				this.route.running_time = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the LongDistance's start time: ");		 
				this.start_time = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the LongDistance's end time: ");		 
				this.end_time = in.next();
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
				if(choice >= 7){
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
			case 1:	this.route.the_number_of_stops = Integer.parseInt(information_get);
					break;
					
			case 2:	this.route.starting_station = information_get;
					break;
			
			case 3:	this.route.destination = information_get;
					break;					
			
			case 4:	this.route.running_time = information_get;
					break;
					
			case 5:	this.start_time = information_get;
					break;
					
			case 6:	this.end_time = information_get;
					break;		
			
			default: 
					System.out.println("Your input is wrong!\n");
					System.exit(0);
					break;			
		}
		System.out.println("Congratulations,the LongDistance's information has been updated!");		
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
								this.route.the_number_of_stops = 0;
								break;
							
			case "Start_Station":
								this.route.starting_station = null;		//to be continued...(check input)
								break;
							
			case "Destination":
								this.route.destination = null;
								break;
						
			case "Running_Time":
								this.route.running_time = null;
								break;
								
			case "Start_Time":
								this.start_time = null;
								break;
			case "End_Time":
								this.end_time = null;
								break;
								
			case "All":			this.route.the_number_of_stops = 0;	//to be continued...(how to free the space)
								this.route.starting_station = null;
								this.route.destination = null;								
								this.route.running_time = null;
								this.start_time = null;
								this.end_time = null;
								break;
			
			default:			System.out.println("Your input is wrong!");
								System.exit(0);
		}
		System.out.println("Congratulations! your operation is successful!");
	}		
}
