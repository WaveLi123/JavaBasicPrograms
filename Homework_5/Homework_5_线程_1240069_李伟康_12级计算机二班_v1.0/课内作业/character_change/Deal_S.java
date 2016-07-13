package character_change;

import java.io.IOException;

public class Deal_S implements Runnable{
	Resource resource;
	
	public Deal_S(Resource resource_t){
		this.resource = resource_t; 
	}

	public void run(){
		try {
			try {
				resource.deal_S();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
