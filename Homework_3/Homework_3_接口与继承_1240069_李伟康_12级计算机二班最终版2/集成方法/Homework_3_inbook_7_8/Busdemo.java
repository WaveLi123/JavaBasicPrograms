package Homework_3_inbook_7_8;

import java.util.*;

public class Busdemo {
	//data
	static LinkedList<Bus> bus = new LinkedList<Bus>();	//added by jkd,25th Oct in 2014
	static Bus	temp_bus;	
	
	//method
	static void Bus_Menu(){
		System.out.println("***********Model of Bus Managing*************");
		System.out.println("*1.Insert                                   *");
		System.out.println("*2.Update                                   *");
		System.out.println("*3.Delete                                   *");
		System.out.println("*4.Present                                  *");
		System.out.println("*5.Quit                                     *");
		System.out.println("*********************************************");
		System.out.println("¡¾Please insert data if you firstly use this¡¿");
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
	static void main_Bus(){								
		Bus_Menu();		
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
				temp_bus= new Bus();				
				temp_bus.user_insert();		
				bus.add(temp_bus);
				
				Clear();
				main_Bus();				
				
		case 2:	System.out.println("There are "+bus.size()+" objects in this Models");
				System.out.println("Plese input your choice:");				
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > bus.size()){
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
				temp_bus = bus.get(sub_choice - 1);
				temp_bus.user_update();
				bus.set(sub_choice - 1,temp_bus);
				
				main_Bus();
				break;
				
		case 3:	System.out.println("There are "+bus.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > bus.size()){
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
				//Q1:how to really free this source, to be continued ......
				temp_bus = bus.get(sub_choice - 1); 
				temp_bus.user_delete();
				bus.set(sub_choice - 1, temp_bus);
				
				main_Bus();
				break;
				
		case 4:	System.out.println("There are "+bus.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > bus.size()){
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
				bus.get(sub_choice - 1).user_show();
				
				main_Bus();
				break;
						
		case 5:	System.exit(0);				
				break;							
			
		default:System.out.println("Your input is wrong!");
				System.exit(0);
		}			
	}
}
