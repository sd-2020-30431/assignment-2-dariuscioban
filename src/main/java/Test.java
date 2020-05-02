import data.*;
import java.sql.Date;
import model.*;

public class Test {
	
	public static void main( String[] args ) {
		Date cons = Date.valueOf("2000-10-29");
		GroceryItemQueries.update(cons, 1);
	}
}
