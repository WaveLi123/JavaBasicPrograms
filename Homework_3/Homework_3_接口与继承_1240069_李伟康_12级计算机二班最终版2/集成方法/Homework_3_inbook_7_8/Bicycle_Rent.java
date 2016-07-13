package Homework_3_inbook_7_8;

/**
 * @description information of bicycle
 * @author jkd
 * @time 17st Oct in 2014
 * @version 1.0
 */

public class Bicycle_Rent implements BicycleRenting{
	//data
	Bicycle bicycle;
	boolean valid = true;
	
	//method
	public void GetBicycles(Bicycle bb) {
		bb.user_show();		
	}
}
