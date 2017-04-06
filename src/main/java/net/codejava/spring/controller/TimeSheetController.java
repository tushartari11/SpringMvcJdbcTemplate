package net.codejava.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

	// @RequestMapping(value="/")
	// public ModelAndView listTimesheet(ModelAndView model) throws IOException{
	//// List<Contact> listContact = timesheetDAO.list();
	// model.addObject("listContact", listContact);
	// model.setViewName("home");
	//
	// return model;
	// }

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
		return new ModelAndView("redirect:/");
	}
}
