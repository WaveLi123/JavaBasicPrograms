package Homework_3_inbook_7_8;

import java.io.IOException;
import java.util.*;

public class Employeedemo {
	//data
	//changed by jkd,25th Oct in 2014
	static LinkedList<Employee> employee = new LinkedList<Employee>();
	static Employee temp_employee;
	
	//method
	static void Employee_Menu(){
		System.out.println("*********Model of Employee Managing**********");
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
	static void main_Employee(){								
		Employee_Menu();		
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
				temp_employee = new Employee();				
				temp_employee.user_insert();
				employee.add(temp_employee);
				
				Clear();
				main_Employee();				
				
		case 2:	System.out.println("There are "+employee.size()+" objects in this Models");
				System.out.println("Plese input your choice:");				
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > employee.size()){
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
				temp_employee = employee.get(sub_choice - 1);
				temp_employee.user_update();
				employee.set(sub_choice - 1, temp_employee);
				
				main_Employee();
				break;
				
		case 3:	System.out.println("There are "+employee.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > employee.size()){
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
				temp_employee = employee.get(sub_choice - 1);
				temp_employee.user_delete();
				employee.set(sub_choice - 1, temp_employee);
				
				main_Employee();
				break;
				
		case 4:	System.out.println("There are "+employee.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > employee.size()){
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
				employee.get(sub_choice - 1).user_show();
				
				main_Employee();
				break;
						
		case 5:	System.exit(0);		
				break;							
			
		default:System.out.println("Your input is wrong!");
				System.exit(0);
		}			
	}
}
