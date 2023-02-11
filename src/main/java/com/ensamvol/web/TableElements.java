package com.ensamvol.web;

import com.ensamvol.entities.*;
import com.ensamvol.repositories.*;
import com.ensamvol.service.CompanyService;
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
    private ClientRepository clientRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private BilletRepository billetRepository;
    private VolService volService;
    private CompanyService companyService;

    @GetMapping(value = "table-elements")
    public String table_element(ModelMap model) {
        List<Vol> vols = volRepository.findAll();
        model.addAttribute("flights", vols);
        List<Employee> employees=employeeRepository.findAll();
        model.addAttribute("employees",employees);
        List<Company> companies =companyRepository.findAll();
        model.addAttribute("companies",companies);
        List<Billet> billets=billetRepository.findAll();
        model.addAttribute("billets",billets);





        return "pages/table-elements";

    }
    @GetMapping("/deleteFlight/{idVol}")
    public String deleteFlight(@PathVariable Long idVol) {
        volService.removeVol(idVol);
        return "redirect:/pages/table-elements";
    }
    @RequestMapping("/updateFlight")
    private String updateFlight( Long idVol, @ModelAttribute Vol vol)
    {
        volService.updateVol(idVol,vol);
        return "redirect:/pages/table-elements";
    }




}
