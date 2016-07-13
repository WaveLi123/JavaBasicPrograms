package character_change;

import java.io.IOException;

public class Deal_B implements Runnable{
	Resource resource;
	
	public Deal_B(Resource resource_t){
		this.resource = resource_t; 
	}

	public void run(){
		try {
			try {
				resource.deal_B();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
