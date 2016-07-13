package Homework_3_inbook_7_8;

import java.io.IOException;
import java.util.*;

class NumberException extends Exception{
	public NumberException(){
		System.out.println("the Number is too illeal!!!");
	}
}

public class Test_System{

	static void Menu(){
		System.out.println("***Welcome to use this Transportation***");
		System.out.println("*1.Bus Managing System.                *");
		System.out.println("*2.Employee Managing System.           *");
		System.out.println("*3.Passenger Managing System.          *");
		System.out.println("*4.Route Managing System.              *");
		System.out.println("*5.Local Managing System.              *");
		System.out.println("*6.LongDistance Managing System.       *");
		System.out.println("*7.Manager Managing System.            *");
		System.out.println("*8.Bicycles Renting System.            *");
		System.out.println("*9.Quit.                               *");
		System.out.println("****************************************");
	}
	
	//main entrance
	public static void main(String[] args) throws IOException {
		
		Menu();
		Scanner in = new Scanner(System.in);
		System.out.println("Please input your choice:");
		boolean valid = false;
		int choice = 0;
		while(!valid){
			try{				
				choice = in.nextInt();
				if(choice >= 10){
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
					
			case 5: Localdemo.main_Local();
					break;
					
			case 6: LongDistancedemo.main_LongDistance();
					break;
					
			case 7: Managerdemo.main_Manager();
					break;
			
			case 8: Bicycle_Rentdemo.Get_data();
					Bicycle_Rentdemo.main_Bicycle_Rent();
					break;
					
			case 9: System.exit(0);
					break;
					
			default: System.out.println("Warning,Wrong input!\n");
					System.exit(0);					
		}
	}
}
