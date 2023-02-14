package com.ensamvol.web;

import com.ensamvol.entities.*;
import com.ensamvol.repositories.*;
import com.ensamvol.service.CompanyService;
import com.ensamvol.service.EmployeeService;
import com.ensamvol.service.VilleService;
import com.ensamvol.service.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "pages")
public class TableElements {
    @Autowired
    private VolRepository volRepository;
    @Autowired

    private ClientRepository clientRepository;
    @Autowired
    private VilleService villeService;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BilletRepository billetRepository;
    @Autowired

    private VolService volService;
    @Autowired
    private CompanyService companyService;
    @Autowired 
	private EmployeeService employeeService;
    
    @Autowired 
    private AppRoleRepository appRoleRepository;
    

    @GetMapping(value = "table-elements")
    public String table_element(ModelMap model) {
        List<Vol> vols = volRepository.findAll();
        model.addAttribute("flights", vols);
        List<Employee> employees=employeeRepository.findAll();
        model.addAttribute("employees",employees);
        //les valeurs initales lorsque udpdate form is hidden
        model.addAttribute("flight",volRepository.getById(46L));
        model.addAttribute("employee",employeeRepository.getById(57));
        model.addAttribute("company",companyRepository.getById(6));
        model.addAttribute("roles",appRoleRepository.findAll());
        model.addAttribute("villes",villeService.listVille());
        model.addAttribute("display","none");
        model.addAttribute("displayEmployee","none");
        model.addAttribute("displayCompany","none");

        List<Company> companies =companyRepository.findAll();
        model.addAttribute("companies",companies);
        /* List<Billet> billets=billetRepository.findAll();
        model.addAttribute("billets",billets);*/

        return "pages/table-elements";

    }
    




}
