package com.gowthamrajk.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomerInterceptor implements HandlerInterceptor {
	
	private static final Logger logger = Logger.getLogger(CustomerInterceptor.class);
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		logger.trace("Prehandler Method of interceptor is running");
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
 
    	logger.trace("Posthandler Method of interceptor is running");
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
 
    	logger.trace("AfterCompletion Method of interceptor is running");
    }

}
