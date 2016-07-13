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
	String content;								//内容字符串		
	String PathName = "resource.txt";			//存在大写字母信息的文件路径
	int count = 0;								//记录处理信息的线程数
	
	//锁资源
    Lock mylock = new ReentrantLock();
//    Lock mylock_1 = new ReentrantLock();
    Condition write = mylock.newCondition();
//    Condition empty = mylock_1.newCondition();

	//method
    public void get_info() throws InterruptedException{    	
    	mylock.lock();							//获取锁
    	try {  
    		while(count != 0){
    			write.await();		    			
    		}
        	//获取用户输入信息
        	System.out.println("请输入您想处理的信息：");
        	Scanner in = new Scanner(System.in);
        	content = in.nextLine();
//        	empty.signalAll();
    	}finally{ 
    		mylock.unlock(); //释放锁
    	}
    }
    
    //处理大写字母
    public	void deal_B() throws IOException, InterruptedException{
    	//计数器加一
    	mylock.lock();		//获取锁    	
    	try {    		
    		count += 1;
    		System.out.println("dealer"+count+":处理大写字母开始");
    	}finally{ 
    		mylock.unlock(); //释放锁
    	}  
    	
		//处理信息为空
		while(content == null){
//			empty.await();
			Thread.sleep(3000);		//释放处理机，允许其他进程工作
		}      
		//处理信息不为空
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
        Thread.sleep(3000);		//释放处理机，允许其他进程工作
        
    	//计数器减一
    	mylock.lock();		//获取锁    	
    	try {    		
    		System.out.println("dealer"+count+":处理大写字母完成");
    		count -= 1;    		
    		if(count == 0){
    			write.signal();//唤醒等待的写进程
    		}
    	}finally{ 
    		mylock.unlock(); //释放锁
    	}  
    }   
   
    //处理小写字母
    public	void deal_S() throws IOException, InterruptedException{
    	//计数器加一
    	mylock.lock();		//获取锁    	
    	try {    		
    		count += 1;
    		System.out.println("dealer"+count+":处理小写字母开始");
    	}finally{ 
    		mylock.unlock(); //释放锁
    	}  
    	
		//处理信息为空
		while(content == null){
//			empty.await();
			Thread.sleep(3000);		//释放处理机，允许其他进程工作
		}      
		//处理信息不为空
		String t_content = "";
		for(int i = 0; i < content.length(); i ++){
			if(!test_ch(content.charAt(i))){
				t_content += content.charAt(i);
			}
		}
		//打印处理后的信息至屏幕
        System.out.println("处理后的信息："+t_content);        
        Thread.sleep(3000);		//释放处理机，允许其他进程工作
        
    	//计数器减一
    	mylock.lock();		//获取锁    	
    	try {    		
    		System.out.println("dealer"+count+":处理小写字母完成");
    		count -= 1;
    		if(count == 0){
    			write.signal();//唤醒等待的写进程
    		}
    	}finally{ 
    		mylock.unlock(); //释放锁
    	}  
    }
    
    //检测字母的大小写
    public boolean test_ch(char ch){    	
    	//小写字母
    	if(ch > 'a' && ch < 'z'){
    		return false;
    	}
    	//大写字母
    	else{
    		return true;
    	} 	
    }
}   
