package Homework_4_inbook_8_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Employeedemo {
	//data
	//changed by jkd,25th Oct in 2014
	static LinkedList<Employee> employee = new LinkedList<Employee>();
	static Employee temp_employee;
	
	//method
	//file system of reading and writing by jkd,1st Nov in 2014
	//储存数据到文件里	
	public static void saveObj(int c,Employee value,String filename){
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
	public static LinkedList<Employee> readObj(String filename){		
		LinkedList<Employee> temp_value = new LinkedList<Employee>();
		Employee value = new Employee();		
		try{
			File file = new File(filename);
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream si = new ObjectInputStream(fi);		
			
			while((value = (Employee) si.readObject()) != null){		    	
				temp_value.add(value);
		    }
		    si.close();
		}
		catch(Exception e){			
			e.getStackTrace();			
		}
		return temp_value;
	}
	
	static void Employee_Menu(){
		System.out.println("*********Model of Employee Managing**********");
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
		
		int employee_l;
		switch(choice){
		case 1:
				//changed by jkd,3th Nov in 2014				
				temp_employee = new Employee();				
				temp_employee.user_insert();				
				saveObj(1,temp_employee,"Employee.dat");
				
				Clear();
				main_Employee();				
				
		case 2:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				employee = readObj("Employee.dat");	
				
				System.out.println("There are "+employee.size()+" objects in this Models");
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
				employee.set(sub_choice - 1,temp_employee);
				//changed by jkd,1st Nov in 2014
				//write all the update datas to the file
				saveObj(2,employee.get(0),"Employee.dat");
				for(employee_l = 1; employee_l < employee.size(); employee_l ++){
					saveObj(1,employee.get(employee_l),"Employee.dat");
				}
				//delete the temp_datas from collection
				for(employee_l = 0; employee_l < employee.size(); employee_l ++){
					employee.remove(employee_l);
				}
				
				main_Employee();
				break;
				
		case 3:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				employee = readObj("Employee.dat");
				
				System.out.println("There are "+employee.size()+" objects in this Models");
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
				//changed by jkd,1st Nov in 2014
				//write all the update datas to the file
				saveObj(3,employee.get(0),"Employee.dat");
				for(employee_l = 1; employee_l < employee.size(); employee_l ++){
					saveObj(1,employee.get(employee_l),"Employee.dat");
				}
				//delete the temp_datas from collection
				for(employee_l = 0; employee_l < employee.size(); employee_l ++){
					employee.remove(employee_l);
				}
				
				main_Employee();
				break;
				
		case 4:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				employee = readObj("Employee.dat");
			
				System.out.println("There are "+employee.size()+" objects in this Models");
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
				//reset the datas from the collections
				for(employee_l = 0; employee_l < employee.size(); employee_l ++){
					employee.remove(employee_l);
				}
				
				main_Employee();
				break;
						
		case 5:	System.exit(0);		
				break;							
			
		default:System.out.println("Your input is wrong!");
				System.exit(0);
		}			
	}
}
