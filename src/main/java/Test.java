import data.*;

import java.sql.Date;
import java.time.LocalDate;

import model.*;
import reports.*;
import factory.*;

public class Test {
	
	public static void main( String[] args ) {
		AbstractFactory f = FactoryProvider.getFactory(ReportType.WEEKLY);
		Report r = f.createReport(1);
		System.out.print(r.printReport());
	}
}
