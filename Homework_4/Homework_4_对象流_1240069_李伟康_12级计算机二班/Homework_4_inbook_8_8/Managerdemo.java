package Homework_4_inbook_8_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Managerdemo {
	//data
	static LinkedList<Manager> manager = new LinkedList<Manager> ();
	static Manager temp_manager;
	
	//method	
	//file system of reading and writing by jkd,1st Nov in 2014
	//储存数据到文件里	
	public static void saveObj(int c,Manager value,String filename){
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
	public static LinkedList<Manager> readObj(String filename){		
		LinkedList<Manager> temp_value = new LinkedList<Manager>();
		Manager value = new Manager();		
		try{
			File file = new File(filename);
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream si = new ObjectInputStream(fi);		
			
			while((value = (Manager) si.readObject()) != null){		    	
				temp_value.add(value);
		    }
		    si.close();
		}
		catch(Exception e){			
			e.getStackTrace();			
		}
		return temp_value;
	}
		
	static void Manager_Menu(){
		System.out.println("*********Model of Manager Managing**********");
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
	static void main_Manager(){								
		Manager_Menu();		
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
		
		int manager_l;
		switch(choice){
		case 1:	
				//changed by jkd,3th Nov in 2014				
				temp_manager = new Manager();				
				temp_manager.user_insert();				
				saveObj(1,temp_manager,"Manager.dat");
				
				Clear();
				main_Manager();				
				
		case 2:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				manager = readObj("Manager.dat");
				
				System.out.println("There are "+manager.size()+" objects in this Models");
				System.out.println("Plese input your choice:");				
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > manager.size()){
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
				temp_manager = manager.get(sub_choice - 1);
				temp_manager.user_update();
				manager.set(sub_choice - 1,temp_manager);
				//changed by jkd,1st Nov in 2014
				//write all the update datas to the file
				saveObj(2,manager.get(0),"Manager.dat");
				for(manager_l = 1; manager_l < manager.size(); manager_l ++){
					saveObj(1,manager.get(manager_l),"Manager.dat");
				}
				//delete the temp_datas from collection
				for(manager_l = 0; manager_l < manager.size(); manager_l ++){
					manager.remove(manager_l);
				}
				
				main_Manager();
				break;
				
		case 3:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				manager = readObj("Manager.dat");
				
				System.out.println("There are "+manager.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > manager.size()){
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
				temp_manager = manager.get(sub_choice - 1); 
				temp_manager.user_delete();
				manager.set(sub_choice - 1, temp_manager);
				//changed by jkd,1st Nov in 2014
				//write all the update datas to the file
				saveObj(3,manager.get(0),"Manager.dat");
				for(manager_l = 1; manager_l < manager.size(); manager_l ++){
					saveObj(1,manager.get(manager_l),"Manager.dat");
				}
				//delete the temp_datas from collection
				for(manager_l = 0; manager_l < manager.size(); manager_l ++){
					manager.remove(manager_l);
				}
				
				main_Manager();
				break;
				
		case 4:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				manager = readObj("Manager.dat");
				
				System.out.println("There are "+manager.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > manager.size()){
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
				manager.get(sub_choice - 1).user_show();
				//reset the datas from the collections
				for(manager_l = 0; manager_l < manager.size(); manager_l ++){
					manager.remove(manager_l);
				}
				
				main_Manager();
				break;
						
		case 5:	System.exit(0);		
				break;							
			
		default:System.out.println("Your input is wrong!");
				System.exit(0);
		}			
	}
}
