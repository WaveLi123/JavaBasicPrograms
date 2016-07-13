package writer_reader;

public class Writer_Reader_test {   
    public static void main(String[] args) {   
        Storage storage = new Storage();   
        
        Thread reader_1 = new Thread(new Reader(storage));   
        reader_1.setName("reader_1");
        Thread reader_2 = new Thread(new Reader(storage));   
        reader_2.setName("reader_2");
        
        Thread writer = new Thread(new Writer(storage));   
        writer.setName("writer");
        
        
        reader_1.start();
        writer.start(); 
        writer.setPriority(3);
        reader_2.start();
    }   
}   
   
