package com.ensamvol.web;

import com.ensamvol.entities.Personne;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("Personne", new Personne());
        return "login";
    }
}