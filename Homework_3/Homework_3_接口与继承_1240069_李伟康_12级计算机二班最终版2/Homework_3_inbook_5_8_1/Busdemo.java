package Homework_3_inbook_5_8_1;

import java.util.*;

public class Busdemo {
	//data
	static Bus [] bus = new Bus[23];
	static int Number;
	
	//method
	static void Bus_Menu(){
		System.out.println("***********Model of Bus Managing*************");
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
		case 1:	Number ++;				
				bus[Number] = new Bus();				
				bus[Number].user_insert();		
				Clear();
				main_Bus();				
				
		case 2:	System.out.println("There are "+Number+" objects in this Models");
				System.out.println("Plese input your choice:");				
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > Number){
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
				bus[sub_choice].user_update();				
				main_Bus();
				break;
				
		case 3:	System.out.println("There are "+Number+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > Number){
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
				bus[sub_choice].user_delete();				
				main_Bus();
				break;
				
		case 4:	System.out.println("There are "+Number+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > Number){
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
				bus[sub_choice].user_show();				
				main_Bus();
				break;
						
		case 5:	System.exit(0);				
				break;							
			
		default:System.out.println("Your input is wrong!");
				System.exit(0);
		}			
	}
}
