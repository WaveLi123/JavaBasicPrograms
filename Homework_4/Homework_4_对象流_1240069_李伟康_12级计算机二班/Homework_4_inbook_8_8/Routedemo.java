package Homework_4_inbook_8_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Routedemo {
	//data
	static LinkedList<Route> route = new LinkedList<Route> ();
	static Route temp_route;
	
	//method
	//file system of reading and writing by jkd,1st Nov in 2014
	//储存数据到文件里	
	public static void saveObj(int c,Route value,String filename){
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
	public static LinkedList<Route> readObj(String filename){		
		LinkedList<Route> temp_value = new LinkedList<Route>();
		Route value = new Route();		
		try{
			File file = new File(filename);
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream si = new ObjectInputStream(fi);		
			
			while((value = (Route) si.readObject()) != null){		    	
				temp_value.add(value);
		    }
		    si.close();
		}
		catch(Exception e){			
			e.getStackTrace();			
		}
		return temp_value;
	}
	
	
	static void Route_Menu(){
		System.out.println("**********Model of Route Managing************");
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
	static void main_Route(){								
		Route_Menu();		
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
		
		int route_l;
		switch(choice){
		case 1:	
				//changed by jkd,3th Nov in 2014				
				temp_route = new Route();				
				temp_route.user_insert();				
				saveObj(1,temp_route,"Route.dat");
				
				Clear();
				main_Route();				
				
		case 2:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				route = readObj("Route.dat");
				
				System.out.println("There are "+route.size()+" objects in this Models");
				System.out.println("Plese input your choice:");				
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > route.size()){
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
				temp_route = route.get(sub_choice - 1);
				temp_route.user_update();
				route.set(sub_choice - 1,temp_route);
				//changed by jkd,1st Nov in 2014
				//write all the update datas to the file
				saveObj(2,route.get(0),"Route.dat");
				for(route_l = 1; route_l < route.size(); route_l ++){
					saveObj(1,route.get(route_l),"Route.dat");
				}
				//delete the temp_datas from collection
				for(route_l = 0; route_l < route.size(); route_l ++){
					route.remove(route_l);
				}
				
				main_Route();
				break;
				
		case 3:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				route = readObj("Route.dat");
				
				System.out.println("There are "+route.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > route.size()){
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
				temp_route = route.get(sub_choice - 1); 
				temp_route.user_delete();
				route.set(sub_choice - 1, temp_route);
				//changed by jkd,1st Nov in 2014
				//write all the update datas to the file
				saveObj(3,route.get(0),"Route.dat");
				for(route_l = 1; route_l < route.size(); route_l ++){
					saveObj(1,route.get(route_l),"Route.dat");
				}
				//delete the temp_datas from collection
				for(route_l = 0; route_l < route.size(); route_l ++){
					route.remove(route_l);
				}
				
				main_Route();
				break;
				
		case 4:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				route = readObj("Route.dat");
				
				System.out.println("There are "+route.size()+" objects in this Models");
				System.out.println("Plese input your choice:");
				while(!valid){
					try{						
						sub_choice = in.nextInt();
						if(sub_choice > route.size()){
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
				route.get(sub_choice - 1).user_show();
				//reset the datas from the collections
				for(route_l = 0; route_l < route.size(); route_l ++){
					route.remove(route_l);
				}
				
				main_Route();
				break;
						
		case 5:	System.exit(0);		
				break;							
			
		default:System.out.println("Your input is wrong!");
				System.exit(0);
		}			
	}
}
