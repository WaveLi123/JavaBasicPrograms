package character_change;

public class Read_Char implements Runnable{
	Resource resource;
	
	public Read_Char(Resource resource_t){
		this.resource = resource_t; 
	}

	public void run(){
		try {
			resource.get_info();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
