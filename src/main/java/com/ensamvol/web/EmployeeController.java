package com.ensamvol.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ensamvol.HelperClass.EmployeeHelper;
import com.ensamvol.HelperClass.VolHelper;
import com.ensamvol.entities.Company;
import com.ensamvol.entities.Employee;
import com.ensamvol.entities.Personne;
import com.ensamvol.entities.Role;
import com.ensamvol.entities.Ville;
import com.ensamvol.entities.Vol;
import com.ensamvol.repositories.AppRoleRepository;
import com.ensamvol.repositories.CompanyRepository;
import com.ensamvol.repositories.EmployeeRepository;
import com.ensamvol.repositories.VolRepository;
import com.ensamvol.service.EmployeeService;
import com.ensamvol.service.VilleService;

@Controller
public class EmployeeController {
	  @Autowired
	    private CompanyRepository companyRepository;
	@Autowired 
	private EmployeeService employeeService;
	@Autowired 
	private EmployeeRepository employeeRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;
	@Autowired 
	private VilleService villeService;
	@Autowired VolRepository volRepository;
	   @GetMapping("/deleteEmployee/{idEmployee}")
	    public String deleteEmployee(@PathVariable Integer idEmployee) {
	    	employeeService.removeEmployee(idEmployee);
	        return "redirect:/pages/table-elements";
	    }
	   @PostMapping("/addEmployee")
	   public String addEmployee(@ModelAttribute EmployeeHelper employeeHelper) {
			int CIN=employeeHelper.getCIN();
			String nom = employeeHelper.getNom();
			String prenom = employeeHelper.getPrenom();
			String dateNaissance = employeeHelper.getDateNaissance();
			String username = employeeHelper.getUsername();
			String password = employeeHelper.getPassword();
			Role role= appRoleRepository.findByRoleName(employeeHelper.getRoleName());
			List<Role> roles=new ArrayList<>();
			roles.add(role);
			Personne personne = new Personne();
			personne.setCIN(CIN);
			personne.setNom(nom);
			personne.setPrenom(prenom);
			personne.setDateNaissance(dateNaissance);
			personne.setUsername(username);
			personne.setPassword(password);
			personne.setRoles(roles);
			employeeService.addNewEmployee(new Employee(1,personne));
			return "redirect:/pages/table-elements";
	   }
	   
	      @GetMapping("/showUpdateEmployee/{idEmployee}")
	       public String showUpdateForm(@PathVariable Integer idEmployee, Model model ,ModelMap modelMap) {
	           Employee employee = employeeRepository.findByIdEmployee(idEmployee);
	           model.addAttribute("employee",employee);
	           List<Employee> employees=employeeRepository.findAll();
	           model.addAttribute("employees",employees);
	           List<Company> companies =companyRepository.findAll();
	           model.addAttribute("companies",companies);
	           model.addAttribute("company",companyRepository.getById(6));
	           model.addAttribute("roles",appRoleRepository.findAll());
	           model.addAttribute("flights",volRepository.findAll());
	           model.addAttribute("roles",appRoleRepository.findAll());
	           model.addAttribute("villes",villeService.listVille());
	           model.addAttribute("flight",volRepository.getById(46L));
	           modelMap.addAttribute("displayEmployee","block");
	           modelMap.addAttribute("displayCompany","none");

	           modelMap.addAttribute("display","none");
	           return "/pages/table-elements";
	       }   
	      @RequestMapping("/updateEmployee")
          private String updateFlight( @ModelAttribute EmployeeHelper employeeHelper,ModelMap modelMap)
          {
       	   employeeService.updateEmployee(employeeHelper);
       	   return  "redirect:/pages/table-elements";
       	   
          }
}
