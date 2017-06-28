package net.codejava.spring.dao;

import java.util.List;

import net.codejava.spring.model.Timesheet;

public interface TimesheetDAO {

	public void saveOrUpdate(Timesheet timesheet);
	
	public void delete(int timesheetId);
	
	public Timesheet get(int timesheetId);
	
	public List<Timesheet> list();
}
