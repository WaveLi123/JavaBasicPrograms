package Homework_4_inbook_8_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Passengerdemo {
	//data
	static LinkedList<Passenger> passenger = new LinkedList<Passenger> ();
	static Passenger temp_passenger;
	
	//method
	//file system of reading and writing by jkd,1st Nov in 2014
	//储存数据到文件里	
	public static void saveObj(int c,Passenger value,String filename){
		File file = null;
		FileOutputStream fo = null;
		ObjectOutputStream so = null;			
		
		try{
			file = new File(filename);
			if(c == 1){
				fo = new FileOutputStream(file,true);
			}
			else{
				fo = new FileOutputStream(file);
			}			
						
			if(file.length()<1){
				so = new ObjectOutputStream(fo);	             
	        }else{
	        	so = new AppendableObjectOutputStream(fo);
	        }			
			so.writeObject(value);			
			so.close();
		}
		catch(Exception e){
			System.err.println(e) ;
		}		
	}
	//从文件里读出数据
	public static LinkedList<Passenger> readObj(String filename){		
		LinkedList<Passenger> temp_value = new LinkedList<Passenger>();
		Passenger value = new Passenger();		
		try{
			File file = new File(filename);
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream si = new ObjectInputStream(fi);		
			
			while((value = (Passenger) si.readObject()) != null){		    	
				temp_value.add(value);
		    }
		    si.close();
		}
		catch(Exception e){			
			e.getStackTrace();			
		}
		return temp_value;
	}
	
	static void Passenger_Menu(){
		System.out.println("********Model of Passenger Managing**********");
		System.out.println("*1.Insert                                   *");
		System.out.println("*2.Update                                   *");
		System.out.println("*3.Delete                                   *");
		System.out.println("*4.Present                                  *");
		System.out.println("*5.Quit                                     *");
		System.out.println("*********************************************");
		System.out.println("【Please insert data if you firstly use this】");
		System.out.println("Your Input:");						
	}
	//clear mutiply lines
	static void Clear(){
		int i = 0;
		for(i = 0; i <= 23; i ++){
			System.out.println("\n");
		}
	}
	
	//main function
	static void main_Passenger(){								
		Passenger_Menu();		
		boolean valid = false;		
		Scanner in = new Scanner(System.in);				
		int choice = 0;
		int sub_choice = 0;
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
		
		int passenger_l;
		switch(choice){
		case 1:	
				//changed by jkd,3th Nov in 2014				
				temp_passenger = new Passenger();				
				temp_passenger.user_insert();				
				saveObj(1,temp_passenger,"Passenger.dat");
				
				Clear();
				main_Passenger();				
				
		case 2:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				passenger = readObj("Passenger.dat");
				
				System.out.println("There are "+passenger.size()+" objects in this Models");
				System.out.println("Plese input your choice:");				
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > passenger.size()){
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
				Clear();				
				
				//changed by jkd,25th Oct in 2014
				temp_passenger = passenger.get(sub_choice - 1);
				temp_passenger.user_update();
				passenger.set(sub_choice - 1,temp_passenger);
				//changed by jkd,1st Nov in 2014
				//write all the update datas to the file
				saveObj(2,passenger.get(0),"Passenger.dat");
				for(passenger_l = 1; passenger_l < passenger.size(); passenger_l ++){
					saveObj(1,passenger.get(passenger_l),"Passenger.dat");
				}
				//delete the temp_datas from collection
				for(passenger_l = 0; passenger_l < passenger.size(); passenger_l ++){
					passenger.remove(passenger_l);
				}
				
				main_Passenger();
				break;
				
		case 3:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				passenger = readObj("Passenger.dat");				
				
				System.out.println("There are "+passenger.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > passenger.size()){
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
				Clear();				
				
				//changed by jkd,25th Oct in 2014
				temp_passenger = passenger.get(sub_choice - 1); 
				temp_passenger.user_delete();
				passenger.set(sub_choice - 1, temp_passenger);
				//changed by jkd,1st Nov in 2014
				//write all the update datas to the file
				saveObj(3,passenger.get(0),"Passenger.dat");
				for(passenger_l = 1; passenger_l < passenger.size(); passenger_l ++){
					saveObj(1,passenger.get(passenger_l),"Passenger.dat");
				}
				//delete the temp_datas from collection
				for(passenger_l = 0; passenger_l < passenger.size(); passenger_l ++){
					passenger.remove(passenger_l);
				}
				
				main_Passenger();
				break;
				
		case 4:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				passenger = readObj("Passenger.dat");		
				
				System.out.println("There are "+passenger.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > passenger.size()){
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
				Clear();
				//changed by jkd,25th Oct in 2014
				passenger.get(sub_choice - 1).user_show();
				//reset the datas from the collections
				for(passenger_l = 0; passenger_l < passenger.size(); passenger_l ++){
					passenger.remove(passenger_l);
				}
				
				main_Passenger();
				break;
						
		case 5:	System.exit(0);		
				break;							
			
		default:System.out.println("Your input is wrong!");
				System.exit(0);
		}			
	}
}
