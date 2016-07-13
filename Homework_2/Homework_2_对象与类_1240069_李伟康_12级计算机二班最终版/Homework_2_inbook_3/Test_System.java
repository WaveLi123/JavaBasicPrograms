package Homework_2_inbook_3;

import java.util.*;

class NumberException extends Exception{
	public NumberException(){
		System.out.println("the Number is too illeal!!!");
	}
}

public class Test_System {

	static void Menu(){
		System.out.println("***Welcome to use this Transportation***");
		System.out.println("*1.Bus managing system.                *");
		System.out.println("*2.Employee managing system.           *");
		System.out.println("*3.Passenger managing system.          *");
		System.out.println("*4.Route managing system.              *");
		System.out.println("*5.Quit.                               *");
		System.out.println("****************************************");
	}
	
	//main entrance
	public static void main(String[] args) {
		
		Menu();
		Scanner in = new Scanner(System.in);
		System.out.println("Please input your choice:");
		boolean valid = false;
		int choice = 0;
		while(!valid){
			try{				
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
		switch(choice){
			case 1:	Busdemo.main_Bus();
					break;
					
			case 2: Employeedemo.main_Employee();
					break;
					
			case 3: Passengerdemo.main_Passenger();
					break;
			
			case 4: Routedemo.main_Route();
					break;
					
			case 5: System.exit(0);
					break;
					
			default: System.out.println("Warning,Wrong input!\n");
					System.exit(0);					
		}
	}
}
