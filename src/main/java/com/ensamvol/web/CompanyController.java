package com.ensamvol.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ensamvol.HelperClass.VolHelper;
import com.ensamvol.entities.Company;
import com.ensamvol.entities.Employee;
import com.ensamvol.entities.Ville;
import com.ensamvol.entities.Vol;
import com.ensamvol.repositories.AppRoleRepository;
import com.ensamvol.repositories.AppUserRepository;
import com.ensamvol.repositories.BilletRepository;
import com.ensamvol.repositories.ClientRepository;
import com.ensamvol.repositories.CompanyRepository;
import com.ensamvol.repositories.EmployeeRepository;
import com.ensamvol.repositories.VIlleRepository;
import com.ensamvol.repositories.VolRepository;
import com.ensamvol.service.BilletService;
import com.ensamvol.service.CompanyService;
import com.ensamvol.service.EmployeeService;
import com.ensamvol.service.VilleService;
import com.ensamvol.service.VolService;
import com.ensamvol.service.VolServiceImp;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private CompanyRepository companyRepository;
    @Autowired

	  private VolRepository volRepository;
	    @Autowired
	    private VolService volService ;
	    @Autowired 
		private EmployeeService employeeService;
		@Autowired 
		private EmployeeRepository employeeRepository;
		@Autowired
		private VilleService villeService;
	    @Autowired
	    private VolServiceImp volServiceImp;
	    @Autowired
	    private VIlleRepository villeRepository;
	    @Autowired
	    private BilletService billetService;
	    @Autowired
	    private AppUserRepository appUserRepository;
	    @Autowired
	    private ClientRepository clientRepository;
	    @Autowired
	    private BilletRepository billetRepository;
	    @Autowired 
	    private AppRoleRepository appRoleRepository;
	 @GetMapping("/deleteCompany/{idCompany}")
     public String deleteCompany(@PathVariable int idCompany) {
         companyService.removeCompany(idCompany);
         return "redirect:/pages/table-elements";
     }
	 @GetMapping("/showUpdateCompany/{idCompany}")
     public String showUpdateForm(@PathVariable Integer idCompany, Model model ,ModelMap modelMap) {
		 Company company =companyRepository.getById(idCompany);
		 model.addAttribute("company",company);
	     //les valeurs initales lorsque udpdate form is hidden
         modelMap.addAttribute("flights",volService.listVol());
         List<Ville> villes = villeService.listVille();
         List<Vol> vols = volRepository.findAll();
         model.addAttribute("flights", vols);
         List<Employee> employees=employeeRepository.findAll();
         model.addAttribute("employees",employees);
         model.addAttribute("flight",volRepository.getById(46L));
         model.addAttribute("employee",employeeRepository.getById(57));
         model.addAttribute("roles",appRoleRepository.findAll());
         model.addAttribute("villes",villeService.listVille());
         List<Company> companies =companyRepository.findAll();
         model.addAttribute("companies",companies);
         modelMap.addAttribute("display","none");
         modelMap.addAttribute("displayCompany","block");
         modelMap.addAttribute("displayEmployee","none");
         //
         return "/pages/table-elements";
     }
	 @RequestMapping("/updateCompany")
     private String updateFlight( @ModelAttribute Company company)
     {
  	   companyService.saveCompany(company);
  	   return  "redirect:/pages/table-elements";
  	   
     }
}
