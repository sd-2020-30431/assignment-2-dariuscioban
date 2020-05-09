import java.time.LocalDate;

import communication.GroceryItemAddBuffer;
import services.*;


public class Test {
	
	public static void main( String[] args ) {
		GroceryItemAddBuffer ar = new GroceryItemAddBuffer(3, "test item", 20, 50, LocalDate.now(), LocalDate.of(2020, 5, 15));
		GroceryItemAddBuffer ar2 = new GroceryItemAddBuffer(3, "test item", 30, 50, LocalDate.now(), LocalDate.of(2020, 5, 16));

		
	}
}
