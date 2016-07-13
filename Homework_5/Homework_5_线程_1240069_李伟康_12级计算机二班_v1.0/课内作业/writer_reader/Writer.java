package writer_reader;

import java.io.IOException;

class Writer implements Runnable {   
    private Storage storage;   
   
    public Writer(Storage storage) {   
        this.storage = storage;   
    }   
   
    public void run() {      
		try {
			try {
				storage.write();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		} 
    }      
}   
   
