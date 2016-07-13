package Homework_3_inbook_6_8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Bicycle_Rentdemo {
	//data
	static Bicycle_Rent bicycles[] = new Bicycle_Rent[230];
	static int length;
	
	//method
	static void Get_data() throws IOException{		
		String line;
		BufferedReader reader = new BufferedReader(new FileReader("Record.txt"));		
        //get data of bicycles		
		while ((line = reader.readLine()) != null) {     
			length ++;
			bicycles[length] = new Bicycle_Rent(); 
			bicycles[length].bicycle = new Bicycle(line);			        	  								      	         
        }			
	}
	
	static void main_Bicycle_Rent(){
		Scanner in = new Scanner(System.in);
		//show the number of bicycles in our system
		if(length == 1){
			System.out.println("There are "+length+" bicycle in our system!" );
		}		
		if(length == 0){
			System.out.println("Sorry,There are no bicycles in our system!" );
		}
		if(length >= 2){
			System.out.println("There are "+length+" bicycles in our system!" );
		}
		
		//get the choice of the user	
		int choice = 0;
		boolean valid = false;
		while(!valid){
			try{
				System.out.println("Please input the number of the bicycle that you want to view:");
				choice = in.nextInt();
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
		valid = false;
		
		//show the information of bicycle that user chooses
		bicycles[choice].GetBicycles(bicycles[choice].bicycle);	
		System.out.println("Would you like rent this?(Y or N)");
		char choice_2 = 0;
		while(!valid){
			try{
				System.out.println("Please input the number of the bicycle that you want to view:");
				choice_2 = in.next().charAt(0);
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
		valid = false;
		
		if(choice_2 == 'y' || choice_2 == 'Y'){
			//test the bicycle is valid
			if(bicycles[choice].valid == false){
				System.out.println("Sorry, the bicycle you want to rent has been rented by others!");
			}
			else{
				bicycles[choice].valid = false;
				System.out.println("Your renting is successful!");
				System.out.println("Thanks for using our System!");
			}
			
		}
		if(choice_2 == 'n' || choice_2 == 'N'){
			System.out.println("Thanks for using our System!");
		}
		
		//to form loop
		char choice_3 = 0;		
		while(!valid){
			try{
				System.out.println("Continue or not?(Y or N)");
				choice_3 = in.next().charAt(0);
				valid = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Warning,Your input is wrong,Please input again:");
			}
		}
		valid = false;
		if(choice_3 == 'y'||choice_3 == 'y'){
			main_Bicycle_Rent();
		}
	}
}
