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
	String PathName = "Storage.txt";		//��Դ�ļ�
	int reader_c = 0;						//������
	
	//method
    //д��д����Ϣ 
    public synchronized void write() throws IOException, InterruptedException {
 
    	//������޶����ڽ��ж�����
    	while(reader_c != 0){
    		wait();
    	}
    	//��ʾ��Ϣ
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
				
				case 2:	System.out.println("������������Ϣ��");
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
		System.out.println(Thread.currentThread().getName() + "��write��" + content);   
		System.out.println("writer end");
		notifyAll();//���ѵȴ��߳�       
    }   
   
    // ���߶�ȡ��Ϣ    
    public void read() throws IOException, Exception {        	
    	//��������һ
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
		//��ȡ��Ϣ
		String temp_content = ""; 
		while( (temp_content = reader.readLine()) != null){
			content += temp_content;
		}
		reader.close();
		System.out.println(Thread.currentThread().getName() +"��read��" + content);
		Thread.sleep(3000);
		
    	//��������һ
        synchronized (this){	            
	            System.out.println("reader"+reader_c+" end");
	            reader_c = reader_c - 1;
	            if(reader_c == 0){
	            	notifyAll();//���ѵȴ��߳�
	            }	            
        }		
    }
    
    void menu(String content){
    	System.out.println("��Text Information��:"+content);
		System.out.println("********************MeNu********************");
		System.out.println("*1.delete all information.                  *");
		System.out.println("*2.change the information.(put all new)     *");
		System.out.println("*3.quit                                     *");
		System.out.println("*********************************************");
		System.out.println("��Your Choice��:");
    }
}   
