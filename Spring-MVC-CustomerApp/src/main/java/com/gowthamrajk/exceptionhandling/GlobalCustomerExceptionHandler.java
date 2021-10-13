package com.gowthamrajk.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalCustomerExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView handleNullPointerException(NullPointerException exception)
	{
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("error");
	    modelAndView.addObject("message", exception.getMessage());
	    return modelAndView;
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView handleArithmeticException(ArithmeticException exception)
	{
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("error");
	    modelAndView.addObject("message", exception.getMessage());
	    return modelAndView;
	}
	
	@ExceptionHandler(StatusNotFoundException.class)
	public ModelAndView handleCustomException(StatusNotFoundException exception)
	{
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("error");
	    modelAndView.addObject("message", exception.getMessage());
	    return modelAndView;
	}

}
