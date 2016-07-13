package character_change;

public class Character_Change_test {   
    public static void main(String[] args) {   
        Resource resource = new Resource();   
        
        Thread deal_B = new Thread(new Deal_B(resource));   
        deal_B.setName("deal_B");
        Thread deal_S = new Thread(new Deal_S(resource));   
        deal_S.setName("deal_S");
        
        Thread writer = new Thread(new Read_Char(resource));   
        writer.setName("writer");
        
        writer.start(); 
        writer.setPriority(10);
        deal_B.start();         
        deal_S.start();
    }   
}   
   
