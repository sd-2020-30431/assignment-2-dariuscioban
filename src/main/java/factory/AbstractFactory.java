package factory;

import reports.Report;

public abstract class AbstractFactory {
	public abstract Report createReport(int userid);
}
