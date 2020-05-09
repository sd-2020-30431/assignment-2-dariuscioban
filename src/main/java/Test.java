import java.time.LocalDate;

import services.*;


public class Test {
	
	public static void main( String[] args ) {
		UserServices us = new UserServices();
		int id = us.registerUser("test3", "pass098");
		System.out.println(id);

		
	}
}
