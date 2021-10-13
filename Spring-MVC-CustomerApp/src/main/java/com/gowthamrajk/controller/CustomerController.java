package com.gowthamrajk.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gowthamrajk.model.Customer;
import com.gowthamrajk.service.CustomerService;

@Controller
public class CustomerController {
	
	public static final Logger logger = Logger.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	@ResponseBody
	public String getActivated() {
		return "Hello, This is Customer Controller";
	}
	
	@RequestMapping(path = {"/home","/customerprofile/home"})
	public String getHomePage(HttpSession session, @ModelAttribute("customer")Customer customer, Model model) {
		
		if(session.getAttribute("currUser").equals("user"))
		    return "customerhome";
		else {
			model.addAttribute("unauthorizedRole", "Please Login with your role properly!!!");
		    return "login";
		}
	}
	
	@RequestMapping("/registration")
	public String openRegistrationPage(@ModelAttribute("customer")Customer customer) {
		return "registration";
	}
	
	@RequestMapping("/login")
	public String openLoginPage(@ModelAttribute("customer")Customer customer) {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String doLogout(HttpSession session) {
		
		session.invalidate();
		return "redirect:/login";
	}
	
	@RequestMapping("/checkerror")
	public Model checkError() {
		
		throw new ArithmeticException("Arithmetic Exception arraised...");
	}
	
	@RequestMapping(path = "/validateNewCustomer", method = RequestMethod.POST)
	public String validateCustomerRegistration(HttpSession session, @Valid @ModelAttribute("customer")Customer customer, Errors errors) {

		if(errors.hasErrors()) {		
			return "registration";
		}
		else {
			logger.trace("Error validation successfull..");
			session.setAttribute("customername", customer.getCustomerName());
			customerService.addNewCustomer(customer);
		}
		return "registrationsuccess";
	}
	
	@RequestMapping(path = "/loginCustomer", method = RequestMethod.POST)
	public String validateCustomerLogin(HttpSession session, @Valid @ModelAttribute("customer")Customer customer, Errors errors, Model model) {

		if(errors.hasErrors()) {		
			return "login";
		}
		else {
			logger.trace("Error validation successfull..");
			session.setAttribute("customeremail", customer.getEmail());
			Customer customerObj = customerService.validateCustomer(customer);
			if(customerObj.getEmail().equals(customer.getEmail()) && customerObj.getPassword().equals(customer.getPassword()) ) {
				session.setAttribute("currUser", "user");
				return "redirect:/home";
			}
			else 
				model.addAttribute("loginerror", "Login Failed !!! Invalid User Credentials...");
		}
		return "login";
	}
	
	@RequestMapping("/customerprofile/{customername}")
	public String getUserProfile(@PathVariable("customername") String customerName, Model model) {
		
		model.addAttribute("customer", customerService.getCustomerProfile(customerName));
		return "profile";
	}
	
	@RequestMapping(path = "/editcustomer/{customerId}")    
    public String edit(@ModelAttribute("customer")Customer customer, @PathVariable("customerId") int customerId, Model model) { 
		
		Customer customerObj = customerService.getCustomerById(customerId);
		customer.setCustomerId(customerObj.getCustomerId());
		customer.setCustomerName(customerObj.getCustomerName());
		customer.setEmail(customerObj.getEmail());
		customer.setMobile(customerObj.getMobile());
		customer.setPassword(customerObj.getPassword());
		customer.setConfirmPassword(customerObj.getConfirmPassword());
        model.addAttribute("command", customerObj);  
        return "customerEditForm";    
    }    
  
    @RequestMapping(path = "/editsave")    
    public String editsave(@ModelAttribute("customer")Customer customer, HttpSession session) {  
    	
//    	logger.trace(customer.getCustomerId());
//    	logger.trace(customer.getPassword());
//    	logger.trace(customer.getConfirmPassword());
    	session.setAttribute("customername", customer.getCustomerName());
    	customerService.updateCustomer(customer);    
        return "redirect:/getAllCustomers";    
    } 
	
	@RequestMapping(value="/deletecustomer/{customerId}")    
	public String delete(@PathVariable("customerId") int customerId){   
		
		customerService.deleteCustomer(customerId);    
        return "redirect:/getAllCustomers";    
    }  
	
	@RequestMapping(path = "/getAllCustomers")
	public String getAllCustomers(Model model) {
		
		model.addAttribute("customerList", customerService.getAllCustomers());
		return "viewcustomers";
	}

}
