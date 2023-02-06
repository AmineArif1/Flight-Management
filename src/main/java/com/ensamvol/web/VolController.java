package com.ensamvol.web;

import com.ensamvol.entities.Billet;
import com.ensamvol.entities.Ville;
import com.ensamvol.entities.Vol;
import com.ensamvol.repositories.VolRepository;
import com.ensamvol.service.BilletService;
import com.ensamvol.service.VilleService;
import com.ensamvol.service.VolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VolController {
    @Autowired
    private VolRepository volRepository;
    private VolService volService ;
    private VilleService villeService;
    private BilletService billetService;
    
    @RequestMapping(value = "/flights")
    public String flights(Model model){
        List<Vol> vols=volRepository.findAll();
        model.addAttribute("flights",vols);
        return "flights";
    }
    
        @RequestMapping(value = "/flightsAdmin")
    public String flightsAdmin(Model model){
        List<Vol> vols=volRepository.findAll();
        model.addAttribute("flights",vols);
        return "flightsAdmin";
    }
    @GetMapping("/reservation")
    public String reservation(Model model){
        model.addAttribute("billet",new Billet());
        return "reservation";
    }
    @PostMapping("reservation_save")
    public String saveReservation( Billet billet){
        billetService.saveBillet(billet);
        return "redirect:/flights";

    }

      @RequestMapping("/showAddFlight")
    public String showAddFlight(Model model)
    {
        model.addAttribute("villes" , villeService.listVille());
         return "addFlightAdmin";
    }
     @PostMapping("/addFlight")
    public String addFlight(@ModelAttribute Vol vol) {
        volService.addNewVol(vol);
        return "flightsAdmin";
    }
     @GetMapping("/delete/{idVol}")
    public String deleteFlight(@PathVariable Long idVol) {
        volService.removeVol(idVol);
        return "flights";
    }
         @GetMapping("/showUpdateFlight/{idVol}")
    public String showUpdateForm(@PathVariable Long idVol, Model model) {
        Vol vol = volService.getVolById(idVol).orElse(null);
        model.addAttribute("flight",vol);
        return "updateFlightAdmin";
    }
       @RequestMapping("/updateFlight/{idVol}")
       private void updateFlight(@PathVariable Long idVol, @ModelAttribute Vol vol)
       {
    	   volService.updateVol(idVol,vol);
       }
    

 
}
