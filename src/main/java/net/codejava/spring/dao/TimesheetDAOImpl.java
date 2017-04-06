package net.codejava.spring.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import net.codejava.spring.model.Contact;
import net.codejava.spring.model.Timesheet;
import net.codejava.spring.util.DateUtil;

public class TimesheetDAOImpl implements TimesheetDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private DateUtil dateUtil;

	public TimesheetDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Timesheet timesheet) {
		if (timesheet.getId() > 0) {
			// update
			String sql = "UPDATE timesheetdetails SET timesheet_date=?, login_time=?, logout_time=?, "
					+ "lunch_duration=?, total_worked_hours=?, total_decimated_hours=?, man_days=?, created_date=?, modified_date=?  WHERE timesheet_id=?";
			jdbcTemplate.update(sql, timesheet.getLoginDate(), timesheet.getLoginTime(), timesheet.getLogoutTime(),
					timesheet.getLunchDuration(), timesheet.getTotalHours(), timesheet.getTotalHoursDecimal(),
					timesheet.getManDays(), timesheet.getCreatedDate(), new Date(), timesheet.getId());
		} else {
			// insert
			String sql = "INSERT INTO timesheetdetails (timesheet_date, login_time, logout_time, lunch_duration, total_worked_hours, total_decimated_hours, man_days, created_date)"
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			 java.sql.Date loginDate = dateUtil.parseDateForSql(timesheet.getLoginDate());
			jdbcTemplate.update(sql, loginDate, timesheet.getLoginTime(), timesheet.getLogoutTime(),
					timesheet.getLunchDuration(), timesheet.getTotalHours(), timesheet.getTotalHoursDecimal(),
					timesheet.getManDays(), new Date());
		}

	}

	@Override
	public void delete(int timesheetId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contact get(int timesheetId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Timesheet> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
