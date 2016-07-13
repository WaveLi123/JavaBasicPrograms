package Homework_3_inbook_6_8;

import java.util.Scanner;

/*
 * @description exercising_of_extending 
 * @author jkd
 * @time 15th_Oct_2014
 * @version 1.0
 */

public class Local extends Route{
	//data
	float length;
	int route_number;
	
	//method
	void user_show(){
		System.out.println("******Local's Information******");
		System.out.println("*1.the_Number_of_Stops: "+this.the_number_of_stops);
		System.out.println("*2.Starting_Station: "+this.starting_station);
		System.out.println("*3.Destination: "+this.destination);
		System.out.println("*4.Running_Time: "+this.running_time);
		System.out.println("*5.Length: "+this.length);
		System.out.println("*6.Route_Number: "+this.route_number);
		System.out.println("*****************************");
	}
		//insert the user's information
	void user_insert(){			
		
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Local's the_number_of_stops: ");
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
				System.out.println("Please input the Local's starting_station: ");		 
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
				System.out.println("Please input the Local's destination: ");
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
				System.out.println("Please input the Local's running time: ");		 
				this.running_time = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
			
		while(!valid){
			try{
				System.out.println("Please input the Local's length: ");		 
				this.length = in.nextFloat();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Local's Route number: ");		 
				this.route_number = in.nextInt();
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
			case 1:	this.the_number_of_stops = Integer.parseInt(information_get);
					break;
					
			case 2:	this.starting_station = information_get;
					break;
			
			case 3:	this.destination = information_get;
					break;					
			
			case 4:	this.running_time = information_get;
					break;
					
			case 5: this.length = Float.parseFloat(information_get);
					break;
					
			case 6:	this.route_number = Integer.parseInt(information_get);
					break;
			
			default: 
					System.out.println("Your input is wrong!\n");
					System.exit(0);
					break;			
		}
		System.out.println("Congratulations,the Local's information has been updated!");		
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
								
			case "Length":		
								this.length = 0;
								break;
								
			case "Route_Number":
								this.route_number = 0;
								break;
								
			case "All":			this.the_number_of_stops = 0;	//to be continued...(how to free the space)
								this.starting_station = null;
								this.destination = null;								
								this.running_time = null;
								this.length = 0;
								this.route_number = 0;
								break;
			
			default:			System.out.println("Your input is wrong!");
								System.exit(0);
		}
		System.out.println("Congratulations! your operation is successful!");			
	}
}
