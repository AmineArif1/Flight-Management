package com.ensamvol.web;

import com.ensamvol.HelperClass.Reservation;
import com.ensamvol.entities.*;
import com.ensamvol.repositories.AppUserRepository;
import com.ensamvol.repositories.ClientRepository;
import com.ensamvol.repositories.VolRepository;
import com.ensamvol.repositories.VIlleRepository;
import com.ensamvol.service.BilletService;
import com.ensamvol.service.VilleService;
import com.ensamvol.service.VolService;
import com.ensamvol.service.VolServiceImp;
import java.util.Random;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class VolController {
    @Autowired
    private VolRepository volRepository;
    @Autowired
    private VolService volService ;
    @Autowired

    private VilleService villeService;
    @Autowired
    private VolServiceImp volServiceImp;
    @Autowired
    private VIlleRepository villeRepository;
    @Autowired
    private BilletService billetService;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private ClientRepository clientRepository;
    
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
    public String reservation(@RequestParam("idVol") Long idVol,Model model){
        model.addAttribute("idVol",idVol);
        model.addAttribute("billet",new Billet());
        model.addAttribute("Reservation",new Reservation());
        return "reservation";
    }
    @PostMapping("reservation_save")
    public String saveReservation(Reservation reservation,@RequestParam("idVol") Long idVol,Model model){
        Personne personne= appUserRepository.findByUsername(reservation.getEmail());
        Vol vol = volRepository.getReferenceById(idVol);
        Random random = new Random();
        int randomNumber = random.nextInt(850) + 1;
        Billet billet = new Billet(null,vol.getVolPrix(),randomNumber,null,vol);
        Client client = new Client(null,reservation.getPassport(),personne,new ArrayList<>());
        billet.setClient(client);
        clientRepository.save(client);
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
       @RequestMapping("searchVille")
       private String searchVol(@RequestParam("ville") String villeSearch ,Model model){
        List<Vol> vols =volRepository.findAll();
        List<Vol> searchedVol=new ArrayList<>();
           for (Vol vol: vols
                ) {
               if(vol.getVilleArrive().getVilleName().toLowerCase().equals(villeSearch.toLowerCase()) || vol.getVilleDepart().getVilleName().toLowerCase().equals(villeSearch.toLowerCase()) )
                   searchedVol.add(vol);
           }
           model.addAttribute("flights",searchedVol);
        return "flights";
       }
}
