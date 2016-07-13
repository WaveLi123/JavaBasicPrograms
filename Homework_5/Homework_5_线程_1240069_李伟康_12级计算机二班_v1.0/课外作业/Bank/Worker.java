package Bank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable{  
    BlockingQueue<Transaction> queue;
    ArrayList<Account> account;
    CountDownLatch end;
    
    public Worker(BlockingQueue<Transaction> queue,ArrayList<Account> acc,CountDownLatch end) {  
        this.queue = queue;
        this.account = acc;
        this.end = end;
    }  
  
    public void run(){    
    	boolean valid = true;
        while (valid) {  
			try {								
				queue.take().deal(this.account);
				end.countDown();    //使end状态减1，最终减至0
				if(this.queue.size() == 0){
					valid = false;	//结束工作进程
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			   
        }  
    }  
}
