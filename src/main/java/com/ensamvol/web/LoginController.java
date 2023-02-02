package com.ensamvol.web;

import com.ensamvol.entities.Personne;
import com.ensamvol.service.VolService;
import com.ensamvol.service.VolServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    private VolService volServiceImp;
    public LoginController(VolServiceImp volServiceImp){
        this.volServiceImp = volServiceImp;

    }
    @RequestMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("Personne", new Personne());
        return "login";
    }
    @RequestMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("listVols",volServiceImp.listVol());
        return "index";
    }
}