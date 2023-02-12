package com.ensamvol.web;

import com.ensamvol.entities.*;
import com.ensamvol.repositories.*;
import com.ensamvol.service.CompanyService;
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

    @GetMapping(value = "table-elements")
    public String table_element(ModelMap model) {
        List<Vol> vols = volRepository.findAll();
        model.addAttribute("flights", vols);
        model.addAttribute("flight",volRepository.getById(40L));
        model.addAttribute("villes",villeService.listVille());
        model.addAttribute("display","none");
      List<Employee> employees=employeeRepository.findAll();
      System.out.println("zaabey" +employees);
        model.addAttribute("employees",employees);
         /*List<Company> companies =companyRepository.findAll();
        model.addAttribute("companies",companies);
        List<Billet> billets=billetRepository.findAll();
        model.addAttribute("billets",billets);*/

        return "pages/table-elements";

    }
   



}
