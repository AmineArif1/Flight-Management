package com.ensamvol.web;

import com.ensamvol.HelperClass.EmailTemplate;
import com.ensamvol.entities.Personne;
import com.ensamvol.repositories.AppUserRepository;
import com.ensamvol.repositories.BilletRepository;
import com.ensamvol.service.DashboardService;
import com.ensamvol.service.EmailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.Context;

import java.util.Map;


@Controller

public class MailController {
    DashboardService dashboardService;
    BilletRepository billetRepository;
    AppUserRepository appUserRepository;



    private final EmailServiceImp emailServiceImp;
    @Autowired
    private SimpleMailMessage simpleMailMessage;
    public MailController(EmailServiceImp emailServiceImp, EmailTemplate emailTemplate1,DashboardService dashboardService,BilletRepository billetRepository,AppUserRepository appUserRepository) {
        this.emailServiceImp = emailServiceImp;
        this.dashboardService = dashboardService;
        this.billetRepository = billetRepository;
        this.appUserRepository = appUserRepository;
    }

    @RequestMapping("/mail")
    public String sendTest(@RequestParam("emailType") String emailType,@RequestParam("userId") String userId ,Model model){

        org.thymeleaf.context.Context context = new org.thymeleaf.context.Context();
        Personne personne = appUserRepository.findByCIN(Integer.parseInt(userId));
        context.setVariable("customerName", personne.getNom());
        if(emailType.equals("1")) {
            emailServiceImp.sendEmail(personne.getUsername(), "Thanks you!", "thanksTicketEmail", context);
        } else if (emailType.equals("2")) {


            emailServiceImp.sendEmail(personne.getUsername(), "Checkout new flights opportunity", "newFlightsTemplate", context);
        } else if (emailType.equals("3")) {
            context.setVariable("giftName","free ticket to the Bahamas");
            emailServiceImp.sendEmail(personne.getUsername(), "A GIFT FROM US", "GiftFromUsTemplate", context);


        }
        model.addAttribute("totalRevenue",dashboardService.totalRevenue());
        model.addAttribute("totalBillet",dashboardService.totalBillet());
        model.addAttribute("totalFlights",dashboardService.totalFlights());
        model.addAttribute("totalClients",dashboardService.totalClients());
        model.addAttribute("growthPercentage",Math.abs(5000-dashboardService.totalRevenue())/5000);
        model.addAttribute("billets",billetRepository.findAll());
        model.addAttribute("users",appUserRepository.findAll());
        return "pages/dashboard" ;

    }
}