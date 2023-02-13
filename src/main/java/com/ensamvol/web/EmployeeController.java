package com.ensamvol.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ensamvol.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired 
	private EmployeeService employeeService;
	
	   @GetMapping("/deleteEmployee/{idEmployee}")
	    public String deleteEmployee(@PathVariable Integer idEmployee) {
	    	employeeService.removeEmployee(idEmployee);
	        return "redirect:/pages/table-elements";
	    }
   
}
