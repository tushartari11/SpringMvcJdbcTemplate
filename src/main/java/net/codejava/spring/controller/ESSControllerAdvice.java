package net.codejava.spring.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;	

@ControllerAdvice
public class ESSControllerAdvice {
	
	@ExceptionHandler(RuntimeException.class)
    public ModelAndView  handleResourceNotFoundException(RuntimeException ex) {
    	System.out.println("RESOURCE NOT FOUND ERROR OCCURRED");
    	 ModelAndView mav = new ModelAndView();
 	    mav.addObject("exception", ex);
 	    mav.setViewName("error");
 	    return mav;
    }
	
	@ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView  handleHandlerNotFoundException(NoHandlerFoundException ex) {
    	System.out.println("Handler NOT FOUND ERROR OCCURRED");
    	 ModelAndView mav = new ModelAndView();
 	    mav.addObject("exception", ex);
 	    mav.setViewName("error");
 	    return mav;
    }
}
