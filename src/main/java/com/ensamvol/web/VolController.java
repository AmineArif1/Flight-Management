package com.ensamvol.web;

import com.ensamvol.entities.Vol;
import com.ensamvol.repositories.VolRepository;
import com.ensamvol.service.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.ensamvol.service.villeService;

import java.util.List;
import java.util.Optional;

@Controller
public class VolController {
    @Autowired
    private VolRepository volRepository;
    private VolService volService ;
    
    @RequestMapping(value = "/flights")
    public String flights(Model model){
        List<Vol> vols=volRepository.findAll();
        model.addAttribute("flights",vols);
        return "flights";
    }
    
        @RequestMapping(value = "/flightsAdmin")
    public String flights(Model model){
        List<Vol> vols=volRepository.findAll();
        model.addAttribute("flights",vols);
        return "flightsAdmin";
    }

     @PostMapping("/addFlight")
    public String addFlight(@ModelAttribute Vol vol) {
        volService.addNewVol(vol);
        List<Ville> villes = VilleService.listVille();
        model.addAttribute("villes" , villes);
        return "addFlight";
    }
     @GetMapping("/delete/{idVol}")
    public String deleteFlight(@PathVariable Long idVol) {
        volService.removeVol(idVol);
        return "flights";
    }
   

       @GetMapping("/update/{idVol}")
    public String showUpdateForm(@PathVariable("idVol") Long idVol, Model model) {
        Optional<Vol> vol = volService.getVolById(idVol);
        model.addAttribute("vol", vol);
        List<Ville> villes = VilleService.listVille();
        model.addAttribute("villes" , villes);
        return "updateFlightAdmin";
    }
    

}
