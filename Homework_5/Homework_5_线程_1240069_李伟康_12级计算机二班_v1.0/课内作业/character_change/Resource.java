package character_change;

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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Storage.java 
public class Resource {     
	//data
	String content;								//�����ַ���		
	String PathName = "resource.txt";			//���ڴ�д��ĸ��Ϣ���ļ�·��
	int count = 0;								//��¼������Ϣ���߳���
	
	//����Դ
    Lock mylock = new ReentrantLock();
//    Lock mylock_1 = new ReentrantLock();
    Condition write = mylock.newCondition();
//    Condition empty = mylock_1.newCondition();

	//method
    public void get_info() throws InterruptedException{    	
    	mylock.lock();							//��ȡ��
    	try {  
    		while(count != 0){
    			write.await();		    			
    		}
        	//��ȡ�û�������Ϣ
        	System.out.println("���������봦�����Ϣ��");
        	Scanner in = new Scanner(System.in);
        	content = in.nextLine();
//        	empty.signalAll();
    	}finally{ 
    		mylock.unlock(); //�ͷ���
    	}
    }
    
    //�����д��ĸ
    public	void deal_B() throws IOException, InterruptedException{
    	//��������һ
    	mylock.lock();		//��ȡ��    	
    	try {    		
    		count += 1;
    		System.out.println("dealer"+count+":�����д��ĸ��ʼ");
    	}finally{ 
    		mylock.unlock(); //�ͷ���
    	}  
    	
		//������ϢΪ��
		while(content == null){
//			empty.await();
			Thread.sleep(3000);		//�ͷŴ�����������������̹���
		}      
		//������Ϣ��Ϊ��
		String t_content = "";
		for(int i = 0; i < content.length(); i ++){
			if(test_ch(content.charAt(i))){
				t_content += content.charAt(i);
			}
		}
		//write the information to the file
        FileWriter writer = new FileWriter(PathName);                     
        writer.write(t_content);
        writer.close(); 
        Thread.sleep(3000);		//�ͷŴ�����������������̹���
        
    	//��������һ
    	mylock.lock();		//��ȡ��    	
    	try {    		
    		System.out.println("dealer"+count+":�����д��ĸ���");
    		count -= 1;    		
    		if(count == 0){
    			write.signal();//���ѵȴ���д����
    		}
    	}finally{ 
    		mylock.unlock(); //�ͷ���
    	}  
    }   
   
    //����Сд��ĸ
    public	void deal_S() throws IOException, InterruptedException{
    	//��������һ
    	mylock.lock();		//��ȡ��    	
    	try {    		
    		count += 1;
    		System.out.println("dealer"+count+":����Сд��ĸ��ʼ");
    	}finally{ 
    		mylock.unlock(); //�ͷ���
    	}  
    	
		//������ϢΪ��
		while(content == null){
//			empty.await();
			Thread.sleep(3000);		//�ͷŴ�����������������̹���
		}      
		//������Ϣ��Ϊ��
		String t_content = "";
		for(int i = 0; i < content.length(); i ++){
			if(!test_ch(content.charAt(i))){
				t_content += content.charAt(i);
			}
		}
		//��ӡ��������Ϣ����Ļ
        System.out.println("��������Ϣ��"+t_content);        
        Thread.sleep(3000);		//�ͷŴ�����������������̹���
        
    	//��������һ
    	mylock.lock();		//��ȡ��    	
    	try {    		
    		System.out.println("dealer"+count+":����Сд��ĸ���");
    		count -= 1;
    		if(count == 0){
    			write.signal();//���ѵȴ���д����
    		}
    	}finally{ 
    		mylock.unlock(); //�ͷ���
    	}  
    }
    
    //�����ĸ�Ĵ�Сд
    public boolean test_ch(char ch){    	
    	//Сд��ĸ
    	if(ch > 'a' && ch < 'z'){
    		return false;
    	}
    	//��д��ĸ
    	else{
    		return true;
    	} 	
    }
}   
