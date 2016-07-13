package Bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Bank {
	final int MAX = 20; 
//data		
	BlockingQueue<Transaction> tran = new LinkedBlockingQueue<Transaction>();	//交易信息记录
	ArrayList<Account> acc = new ArrayList<Account>();							//账户信息记录
	ArrayList<Worker> work = new ArrayList<Worker>();
//method
	//利用构造函数对bank进行初始化
	public Bank(){
		for(int i  = 0; i < MAX; i ++ ){
			Account acc_temp = new Account(i,1000,0); 
			acc.add(acc_temp);
		}
	}
	//从文件中读取交易信息
	public void get_tran(String filename) throws IOException, InterruptedException{		
    	InputStreamReader read = new InputStreamReader(new FileInputStream(filename));           
        BufferedReader reader = new BufferedReader(read);		        
        //读取交易信息
  		String temp_content = ""; 
  		while( (temp_content = reader.readLine()) != null){
  			String [] content = temp_content.split(" "); 
//  			System.out.println(Integer.parseInt(content[0])+" "+Integer.parseInt(content[1])+" "+Float.parseFloat(content[2]));
  			Transaction tran_temp = new Transaction(Integer.parseInt(content[0]),Integer.parseInt(content[1]),Float.parseFloat(content[2]));
  			
  			tran.put(tran_temp);
  		}
  		reader.close();
	}	
	//打印出结果信息
	public void show_results(){
		int num = 0;
		for(int i = 0; i < this.acc.size(); i ++){
			System.out.println("acc:"+i+" bal:"+this.acc.get(i).money+" trans:"+this.acc.get(i).t_number);
			num += this.acc.get(i).t_number;
		}
		System.out.println("num = "+num);
	}
	public static void Test() throws IOException, InterruptedException {
		Bank bank = new Bank();
		Scanner in = new Scanner(System.in); 
		System.out.println("请输入交易所在的文件名：");
		String filename = in.nextLine();
//		System.out.println("filename = "+filename);
		bank.get_tran(filename);
		System.out.println("请输入工作进程数：");
		int number = in.nextInt();
		
		CountDownLatch end = new CountDownLatch(bank.tran.size());//主进程等待所有的子进程完成
		//创建工作进程数		
		for(int i = 0; i < number; i ++){
			Worker work_temp = new Worker(bank.tran,bank.acc,end);
			bank.work.add(work_temp);
		}
		//启动所有的工作进程
		ExecutorService service = Executors.newCachedThreadPool();
		for(int i = 0; i < bank.work.size(); i ++){
			service.execute(bank.work.get(i));			
			Thread.sleep(300);
		}			
		
		//打印出结果信息		
	     try{
             end.await();            //等待end状态变为0，即所有工作进程结束
         }catch (InterruptedException e) {
             e.printStackTrace();
         }finally{
             bank.show_results();
         }
	     
         service.shutdown();	
	}
}
