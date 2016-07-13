package Bank;

import java.io.IOException;
import java.util.Scanner;

public class Bank_test {

	public static void main(String[] args) throws IOException, InterruptedException {
		char valid= 'y';
		Bank test = new Bank();
		while(valid == 'y' || valid == 'Y'){
			test.Test();
			Scanner in = new Scanner(System.in);
			System.out.println("*********************");
			System.out.println("Continue or Not?(y or n)");
			System.out.println("your choice:");
			valid = in.nextLine().charAt(0);
		}		
	}
}
