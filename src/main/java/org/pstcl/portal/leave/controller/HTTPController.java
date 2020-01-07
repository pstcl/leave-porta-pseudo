package org.pstcl.portal.leave.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pstcl.portal.leave.httpclient.HTTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HTTPController {
	
//	1. Employee:                          https://hrapipstcl.pspcl.in/api/employee/504002
//		2. DDO:                                  https://hrapipstcl.pspcl.in/api/ddo/202
//		3. EmployeeAuthenticate:      https://hrapipstcl.pspcl.in/api/EmployeeAuthenticate


//	public Object getEmpl

	@Autowired
	private HTTPService httpService;
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/api/EmployeeAuthenticate") 
	public Object authorizeEmployee()
	{
		return httpService.authorizeEmployee(); 
	}
	
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/api/employee/{empid}",  produces = "application/json") 
	public  ResponseEntity<String>  getEmployee(@PathVariable("employeCode") String employeCode,HttpServletResponse response,HttpServletRequest request) {
		
		return httpService.employeeDetails(employeCode);
	}
	
	@CrossOrigin(allowCredentials="true")
	@GetMapping(value = "/api/ddo/{ddocode}",  produces = "application/json") 
	public  ResponseEntity<String>  getDdo(@PathVariable("ddoCode") String ddoCode,HttpServletResponse response,HttpServletRequest request) {
		
		return httpService.ddoDetails(ddoCode);
	}
}
