package net.codejava.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

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
					+ "lunch_duration=?, total_worked_hours=?, total_decimated_hours=?, man_days=?, created_date=?, modified_date=?  WHERE id=?";
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
	public Timesheet get(int timesheetId) {
		String sql = "SELECT * FROM timesheetdetails WHERE id=" + timesheetId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Timesheet>() {

			@Override
			public Timesheet extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Timesheet timesheet = new Timesheet();
					timesheet.setId(rs.getInt("id"));
					timesheet.setLoginDate(rs.getString("timesheet_date"));
					timesheet.setLoginTime(rs.getString("login_time"));
					timesheet.setLogoutTime(rs.getString("logout_time"));
					timesheet.setLunchDuration(rs.getString("lunch_duration"));
					timesheet.setTotalHours(rs.getString("total_worked_hours"));
					timesheet.setTotalHoursDecimal(rs.getDouble("total_decimated_hours"));
					timesheet.setManDays(rs.getDouble("man_days"));
					timesheet.setCreatedDate(rs.getString("created_date"));
					timesheet.setModifiedDate(rs.getString("modified_date"));
					return timesheet;
				}
				
				return null;
			}
			
		});
	}

	@Override
	public List<Timesheet> list() {
		String sql = "SELECT * FROM timesheetdetails order by timesheet_date desc";
		List<Timesheet> listTimesheetDetail = jdbcTemplate.query(sql, new RowMapper<Timesheet>() {

			@Override
			public Timesheet mapRow(ResultSet rs, int rowNum) throws SQLException {
				Timesheet timesheetDetail = new Timesheet();

				timesheetDetail.setId(rs.getInt("id"));
				timesheetDetail.setLoginDate(rs.getString("timesheet_date"));
//				timesheetDetail.setLoginDay(dateUtil.getDayFromDate(rs.getString("timesheet_date")));
				timesheetDetail.setLoginTime(rs.getString("login_time"));
				timesheetDetail.setLogoutTime(rs.getString("logout_time"));
				timesheetDetail.setLunchDuration(rs.getString("lunch_duration"));
				timesheetDetail.setTotalHours(rs.getString("total_worked_hours"));
				timesheetDetail.setTotalHoursDecimal(rs.getDouble("total_decimated_hours"));
				timesheetDetail.setManDays(rs.getDouble("man_days"));
				timesheetDetail.setCreatedDate(rs.getString("created_date"));
				timesheetDetail.setModifiedDate(rs.getString("modified_date"));
				return timesheetDetail;
			}
		});
		return listTimesheetDetail;
	}

}
