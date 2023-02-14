package com.ensamvol.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ensamvol.repositories.AppRoleRepository;
import com.ensamvol.service.EmployeeService;
import com.ensamvol.service.VilleService;

@Controller
@RequestMapping(value = "pages")
public class FormElementsController {
	@Autowired
	private VilleService villeService;
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired 
	private EmployeeService employeeService;
	
    @GetMapping(value = "form-elements")
    public ModelMap mmFormElements(ModelMap model) {
    	model.addAttribute("villes",villeService.listVille());
    	model.addAttribute("roles",appRoleRepository.findAll());
        return new ModelMap();
    }
  
}
