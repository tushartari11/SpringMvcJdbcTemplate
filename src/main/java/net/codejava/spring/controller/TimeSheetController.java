package net.codejava.spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.spring.dao.TimesheetDAO;
import net.codejava.spring.model.Timesheet;
import net.codejava.spring.util.DateUtil;

@Controller
public class TimeSheetController {

	@Autowired
	private TimesheetDAO timesheetDAO;
	
	@Autowired
	private DateUtil dateUtil;

	 @RequestMapping(value="/timesheet")
	 public ModelAndView listTimesheet(ModelAndView model) throws IOException{
	 List<Timesheet> listTimesheetDetails = timesheetDAO.list();
	 model.addObject("listTimesheetDetails", listTimesheetDetails);
	 model.setViewName("timesheet");
	
	 return model;
	 }
	  

	@RequestMapping(value = "/newTimesheet", method = RequestMethod.GET)
	public ModelAndView newTimesheet(ModelAndView model) {
		Timesheet newTimesheet = new Timesheet();
		model.addObject("timesheet", newTimesheet);
		model.setViewName("timesheetForm");
		return model;
	}

	@RequestMapping(value = "/saveTimesheet", method = RequestMethod.POST)
	public ModelAndView saveTimesheet(@ModelAttribute Timesheet timesheet) {
		String totalHours = dateUtil.getTotalWorkedHours(timesheet.getLoginTime(), timesheet.getLogoutTime(), timesheet.getLunchDuration());
		System.out.println("totalHours: "+totalHours);
		double totalHoursDecimal = dateUtil.getTotalWorkedDecimalHours(timesheet.getLoginTime(), timesheet.getLogoutTime(), timesheet.getLunchDuration());
		System.out.println("totalHoursDecimal: "+totalHoursDecimal);
		double manDays = dateUtil.getManDays(totalHoursDecimal);
		System.out.println("manDays: "+manDays);
		timesheet.setTotalHours(totalHours);
		timesheet.setTotalHoursDecimal(totalHoursDecimal);
		timesheet.setManDays(manDays);
		timesheetDAO.saveOrUpdate(timesheet);
		return new ModelAndView("redirect:/timesheet");
	}
	
	@RequestMapping(value="/editTimeSheet")
	 public ModelAndView editTimesheet(ModelAndView model, HttpServletRequest request) throws IOException{
		int timesheetId = 0;
		if (!StringUtils.isEmpty(request.getParameter("id"))) {
			timesheetId = Integer.parseInt(request.getParameter("id"));
		}
		
	 Timesheet timesheetDetail = timesheetDAO.get(timesheetId);
	 model.addObject("timesheet", timesheetDetail);
	 model.setViewName("timesheetForm");
	
	 return model;
	 }
}
