package writer_reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

//Storage.java 
class Storage {     
	//data
	String PathName = "Storage.txt";		//资源文件
	int reader_c = 0;						//计数器
	
	//method
    //写者写入信息 
    public synchronized void write() throws IOException, InterruptedException {
 
    	//检测有无读者在进行读操作
    	while(reader_c != 0){
    		wait();
    	}
    	//提示信息
    	System.out.println("writer come");
    	
		InputStreamReader read = new InputStreamReader(new FileInputStream(PathName));           
		BufferedReader reader = new BufferedReader(read);	
		String temp_content = "";
		String content = "";
		while((temp_content = reader.readLine()) != null){
			content += temp_content;
		}
		reader.close();
		
		menu(content);		
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		//test input error 
		if( choice >= 1 && choice <= 3){
			switch(choice){
				case 1:	content = "";
						break;					
				
				case 2:	System.out.println("请输入您的信息：");
						content = in.next();
						content += in.nextLine();
						break;
				
				default:System.exit(0);					
			}
		}		
		//write the information to the file
        FileWriter writer = new FileWriter(PathName);                     
        writer.write(content);
        writer.close();
		System.out.println(Thread.currentThread().getName() + "【write】" + content);   
		System.out.println("writer end");
		notifyAll();//唤醒等待线程       
    }   
   
    // 读者读取信息    
    public void read() throws IOException, Exception {        	
    	//计数器加一
        synchronized (this){        		    	   
	            reader_c = reader_c + 1;
	            System.out.println("reader"+reader_c+" come");
        }
        
    	InputStreamReader read = new InputStreamReader(new FileInputStream(PathName));           
        BufferedReader reader = new BufferedReader(read);		
        String content = reader.readLine();
//		while ( content == null) {   			
//			Thread.sleep(3000);
//		} 
		//读取信息
		String temp_content = ""; 
		while( (temp_content = reader.readLine()) != null){
			content += temp_content;
		}
		reader.close();
		System.out.println(Thread.currentThread().getName() +"【read】" + content);
		Thread.sleep(3000);
		
    	//计数器减一
        synchronized (this){	            
	            System.out.println("reader"+reader_c+" end");
	            reader_c = reader_c - 1;
	            if(reader_c == 0){
	            	notifyAll();//唤醒等待线程
	            }	            
        }		
    }
    
    void menu(String content){
    	System.out.println("【Text Information】:"+content);
		System.out.println("********************MeNu********************");
		System.out.println("*1.delete all information.                  *");
		System.out.println("*2.change the information.(put all new)     *");
		System.out.println("*3.quit                                     *");
		System.out.println("*********************************************");
		System.out.println("【Your Choice】:");
    }
}   
