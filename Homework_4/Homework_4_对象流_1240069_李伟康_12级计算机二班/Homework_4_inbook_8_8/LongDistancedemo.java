package Homework_4_inbook_8_8;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class LongDistancedemo {
	//data
	static LinkedList<LongDistance> longDistance = new LinkedList<LongDistance>();
	static LongDistance temp_longDistance;
	
	//method
	//file system of reading and writing by jkd,1st Nov in 2014
	//储存数据到文件里	
	public static void saveObj(int c,LongDistance value,String filename){
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
	public static LinkedList<LongDistance> readObj(String filename){		
		LinkedList<LongDistance> temp_value = new LinkedList<LongDistance>();
		LongDistance value = new LongDistance();		
		try{
			File file = new File(filename);
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream si = new ObjectInputStream(fi);		
			
			while((value = (LongDistance) si.readObject()) != null){		    	
				temp_value.add(value);
		    }
		    si.close();
		}
		catch(Exception e){			
			e.getStackTrace();			
		}
		return temp_value;
	}
	
	static void LongDistance_Menu(){
		System.out.println("*******Model of LongDistance Managing********");
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
		
		int longDistance_l;
		switch(choice){
		case 1:	
				//changed by jkd,3th Nov in 2014				
				temp_longDistance = new LongDistance();				
				temp_longDistance.user_insert();				
				saveObj(1,temp_longDistance,"LongDistance.dat");
				
				Clear();
				main_LongDistance();				
				
		case 2:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				longDistance = readObj("LongDistance.dat");
				
				System.out.println("There are "+longDistance.size()+" objects in this Models");
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
				longDistance.set(sub_choice - 1,temp_longDistance);
				//changed by jkd,1st Nov in 2014
				//write all the update datas to the file
				saveObj(2,longDistance.get(0),"LongDistance.dat");
				for(longDistance_l = 1; longDistance_l < longDistance.size(); longDistance_l ++){
					saveObj(1,longDistance.get(longDistance_l),"LongDistance.dat");
				}
				//delete the temp_datas from collection
				for(longDistance_l = 0; longDistance_l < longDistance.size(); longDistance_l ++){
					longDistance.remove(longDistance_l);
				}
				
				main_LongDistance();
				break;
				
		case 3:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				longDistance = readObj("LongDistance.dat");				
				
				System.out.println("There are "+longDistance.size()+" objects in this Models");
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
				//changed by jkd,1st Nov in 2014
				//write all the update datas to the file
				saveObj(3,longDistance.get(0),"LongDistance.dat");
				for(longDistance_l = 1; longDistance_l < longDistance.size(); longDistance_l ++){
					saveObj(1,longDistance.get(longDistance_l),"LongDistance.dat");
				}
				//delete the temp_datas from collection
				for(longDistance_l = 0; longDistance_l < longDistance.size(); longDistance_l ++){
					longDistance.remove(longDistance_l);
				}
				
				main_LongDistance();
				break;
				
		case 4:	
				//changed by jkd,1st Nov in 2014
				//get all the datas from the file
				longDistance = readObj("LongDistance.dat");
				
				System.out.println("There are "+longDistance.size()+" objects in this Models");
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
				//reset the datas from the collections
				for(longDistance_l = 0; longDistance_l < longDistance.size(); longDistance_l ++){
					longDistance.remove(longDistance_l);
				}
				
				main_LongDistance();
				break;
						
		case 5:	System.exit(0);		
				break;							
			
		default:System.out.println("Your input is wrong!");
				System.exit(0);
		}			
	}
}
