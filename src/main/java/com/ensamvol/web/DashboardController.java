package com.ensamvol.web;

import com.ensamvol.repositories.BilletRepository;
import com.ensamvol.repositories.ClientRepository;
import com.ensamvol.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "pages")
public class DashboardController {

    DashboardService dashboardService;
    BilletRepository billetRepository;
    
    public DashboardController(DashboardService dashboardService,BilletRepository billetRepository){
        this.dashboardService = dashboardService;
        this.billetRepository = billetRepository;

    }

    @GetMapping(value = "dashboard")
    public ModelMap mmDashboard(Model model) {
        model.addAttribute("totalRevenue",dashboardService.totalRevenue());
        model.addAttribute("totalBillet",dashboardService.totalBillet());
        model.addAttribute("totalFlights",dashboardService.totalFlights());
        model.addAttribute("totalClients",dashboardService.totalClients());
        model.addAttribute("growthPercentage",Math.abs(5000-dashboardService.totalRevenue())/5000);
        model.addAttribute("billets",billetRepository.findAll());

        return new ModelMap();
    }


}
