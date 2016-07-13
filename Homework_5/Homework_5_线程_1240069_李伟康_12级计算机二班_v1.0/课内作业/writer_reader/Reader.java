package writer_reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Reader implements Runnable {   
    Storage storage;   
    public Reader(Storage storage) {   
        this.storage = storage;   
    }   
   
    public void run() {   
    	try {
			storage.read();
		} 
    	catch (Exception e) {
			e.printStackTrace();
		}		
    }
}   