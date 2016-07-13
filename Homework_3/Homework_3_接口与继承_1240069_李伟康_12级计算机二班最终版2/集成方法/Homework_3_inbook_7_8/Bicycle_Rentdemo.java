package Homework_3_inbook_7_8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Bicycle_Rentdemo {
	//data
	static LinkedList<Bicycle_Rent> bicycles = new LinkedList<Bicycle_Rent> ();
	static Bicycle_Rent temp_bicycle;
	
	//method
	static void Get_data() throws IOException{		
		String line;
		BufferedReader reader = new BufferedReader(new FileReader("Record.txt"));		
        //get data of bicycles		
		while ((line = reader.readLine()) != null) {     
			//changed by jkd,25th Oct in 2014
			temp_bicycle = new Bicycle_Rent();		
			temp_bicycle.bicycle = new Bicycle(line);
			bicycles.add(temp_bicycle);
        }			
	}
	
	static void main_Bicycle_Rent(){
		Scanner in = new Scanner(System.in);
		//show the number of bicycles in our system
		if(bicycles.size() == 1){
			System.out.println("There are "+bicycles.size()+" bicycle in our system!" );
		}		
		if(bicycles.size() == 0){
			System.out.println("Sorry,There are no bicycles in our system!" );
		}
		if(bicycles.size() >= 2){
			System.out.println("There are "+bicycles.size()+" bicycles in our system!" );
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
		//changed by jkd, 25th Oct  in 2014
		bicycles.get(choice - 1).GetBicycles(bicycles.get(choice - 1).bicycle);
		
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
			if(bicycles.get(choice - 1).valid == false){
				System.out.println("Sorry, the bicycle you want to rent has been rented by others!");
			}
			else{
				bicycles.get(choice - 1).valid = false;
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
