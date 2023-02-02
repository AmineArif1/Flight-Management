package com.ensamvol.web;

import com.ensamvol.entities.Vol;
import com.ensamvol.repositories.VolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Controller
public class VolController {
    @Autowired
    private VolRepository volRepository;
    @RequestMapping(value = "/flights")
    public String flights(Model model){
        List<Vol> vols=volRepository.findAll();
        model.addAttribute("flights",vols);
        return "flights";
    }
}
