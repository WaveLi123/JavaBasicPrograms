package Homework_3_inbook_7_8;

import java.util.LinkedList;
import java.util.Scanner;

public class LongDistancedemo {
	//data
	static LinkedList<LongDistance> longDistance = new LinkedList<LongDistance>();
	static LongDistance temp_longDistance;
	
	//method
	static void LongDistance_Menu(){
		System.out.println("*******Model of LongDistance Managing********");
		System.out.println("*1.Insert                                   *");
		System.out.println("*2.Update                                   *");
		System.out.println("*3.Delete                                   *");
		System.out.println("*4.Present                                  *");
		System.out.println("*5.Quit                                     *");
		System.out.println("*********************************************");
		System.out.println("��Please insert data if you firstly use this��");
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
	static void main_LongDistance(){								
		LongDistance_Menu();		
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
		
		switch(choice){
		case 1:	//changed by jkd,25th Oct in 2014				
				temp_longDistance = new LongDistance();				
				temp_longDistance.user_insert();
				longDistance.add(temp_longDistance);
				
				Clear();
				main_LongDistance();				
				
		case 2:	System.out.println("There are "+longDistance.size()+" objects in this Models");
				System.out.println("Plese input your choice:");				
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > longDistance.size()){
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
				temp_longDistance = longDistance.get(sub_choice - 1);
				temp_longDistance.user_update();
				longDistance.set(sub_choice - 1, temp_longDistance);
				
				main_LongDistance();
				break;
				
		case 3:	System.out.println("There are "+longDistance.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > longDistance.size()){
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
				temp_longDistance = longDistance.get(sub_choice - 1);
				temp_longDistance.user_delete();
				longDistance.set(sub_choice - 1, temp_longDistance);
				
				main_LongDistance();
				break;
				
		case 4:	System.out.println("There are "+longDistance.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > longDistance.size()){
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
				longDistance.get(sub_choice - 1).user_show();				
				main_LongDistance();
				break;
						
		case 5:	System.exit(0);		
				break;							
			
		default:System.out.println("Your input is wrong!");
				System.exit(0);
		}			
	}
}
