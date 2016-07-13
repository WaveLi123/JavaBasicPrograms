package Homework_3_inbook_7_8;

import java.util.Scanner;

/**
 * @description information of bicycle
 * @author jkd
 * @time 17st Oct in 2014
 * @version 1.0
 */

public class Bicycle {
	//data
	int number;
	String brand;
	float time;
	float money;		
	
	//method
	//construct function
	Bicycle (String str){
		String sub_str[] = str.split("\t");
		int i = 0;//used as a loop value		
		this.number = Integer.parseInt(sub_str[0]);  
		this.brand = sub_str[1];
		this.time = Float.parseFloat(sub_str[2]);
		this.money = Float.parseFloat(sub_str[3]);
	}
	//show the user's information
	void user_show(){
		System.out.println("*******Bicycle's Information*******");
		System.out.println("*1.Number: "+this.number);
		System.out.println("*2.Brand: "+this.brand);
		System.out.println("*3.Time: "+this.time);
		System.out.println("*4.Money: "+this.money);			
		System.out.println("*******************************");
	}
	
	//insert the user's information
	void user_insert(){
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Bicycle's type: ");
				this.number = in.nextInt();				
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}			
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Bicycle's engine_number: ");		 
				this.brand = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}		
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Bicycle's seating_capacity: ");
				this.time = in.nextFloat();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
		valid = false;
		
		while(!valid){
			try{
				System.out.println("Please input the Bicycle's route: ");
				this.money = in.nextFloat();
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
			case 1:	this.number = Integer.parseInt(information_get);
					break;
					
			case 2:	this.brand = information_get;
					break;
			
			case 3:	this.time = Float.parseFloat(information_get);
					break;
			
			case 4:	this.money = Float.parseFloat(information_get);
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
				System.out.println("Choose the one you want to delete(like£ºname...input 'All' to delete All): ");
				information = in.next();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
				
		switch(information){
			case "Type":		this.number = 0;
								break;
							
			case "Engine_Number":			
								this.brand = null;		//to be continued...(check input)
								break;
							
			case "Seating_Capacity":
								this.time = 0;
								break;
			
			case "Route":		this.money = 0;
								break;										
								
			case "All":			this.number = 0;	//to be continued...(how to free the space)
								this.brand = null;
								this.time = 0;
								this.money = 0;								
								break;
			
			default:			System.out.println("Your input is wrong!");
								System.exit(0);
		}
		System.out.println("Congratulations! your operation is successful!");
	}			
}
