package com.ensamvol.web;

import com.ensamvol.entities.Billet;
import com.ensamvol.entities.Client;
import com.ensamvol.entities.Personne;
import com.ensamvol.service.QRcodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Base64;

@Controller
public class BilletController {

    @RequestMapping("/billets")
    public String showBillets(@ModelAttribute("personne") Personne personne,

                              @ModelAttribute("client") Client client, Model model, HttpSession session){


        String qrCodeData = "https://store-jelsoft-chinese-old.trycloudflare.com/billets";
        model.addAttribute("qrCodeData", qrCodeData);


        return "ticket";
    }

}
