package Bank;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transaction {
//data
	//交易信息
	int id_from;
	int id_to;
	float money;	
	//通信信息
    Lock mylock = new ReentrantLock();
    Condition deposit = mylock.newCondition();
//method
	public Transaction(int id_from,int id_to,float money){
		this.id_from = id_from;
		this.id_to = id_to;
		this.money = money;
	}
	
    public void deal(ArrayList<Account> acc){
    	for(int i = 0; i < acc.size(); i ++){
        	//取钱
    		if(this.id_from == acc.get(i).id){
    			acc.get(i).money -= this.money;
    			acc.get(i).t_number ++;
    		}
    		//存钱
    		if(this.id_to == acc.get(i).id){
    			acc.get(i).money += this.money;
    			acc.get(i).t_number ++;
    		}
    	}
    }
}
