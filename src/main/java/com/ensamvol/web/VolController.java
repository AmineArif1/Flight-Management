package com.ensamvol.web;

import com.ensamvol.HelperClass.Reservation;
import com.ensamvol.entities.*;
import com.ensamvol.repositories.*;
import com.ensamvol.service.BilletService;
import com.ensamvol.service.VilleService;
import com.ensamvol.service.VolService;
import com.ensamvol.service.VolServiceImp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    @Autowired
    private BilletRepository billetRepository;
    
    @RequestMapping(value = "/flights")
    public String flights(Model model){
        List<Vol> vols=volRepository.findAll();
        model.addAttribute("flights",vols);
        return "flights";
    }



    @GetMapping("/reservation")
    public String reservation(@RequestParam("idVol") Long idVol,Model model){
        model.addAttribute("idVol",idVol);
        model.addAttribute("billet",new BilletController());
        model.addAttribute("Reservation",new Reservation());
        return "reservation";
    }
   /* @PostMapping("reservation_save")
    public String saveReservation(Reservation reservation, @RequestParam("idVol") Long idVol, Model model, HttpSession session){
        Personne personne= appUserRepository.findByUsername(reservation.getEmail());
        Vol vol = volRepository.getReferenceById(idVol);
        Random random = new Random();
        int randomNumber = random.nextInt(850) + 1;
        Billet billet = new Billet(null,vol.getVolPrix(),randomNumber,null,vol);
        Client client = new Client(null,reservation.getPassport(),personne,new ArrayList<>());
        billet.setClient(client);
        clientRepository.save(client);
        billetService.saveBillet(billet);

        Billet lastBillet =billetRepository.findAll().get(billetRepository.findAll().size()-1);
        System.out.println(lastBillet.getIdBillet());
        session.setAttribute("billet", lastBillet);
        return "redirect:/billets";
    }*/

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
       
     //admin CRUD
       @RequestMapping("/showAddFlight")
       public String showAddFlight(Model model)
       {
       	  List<Ville> villes = villeService.listVille();
       	  //System.out.println(villes);
       	  model.addAttribute("villes" , villes);
            return "addFlightAdmin";
       }
       
       
       @RequestMapping(value = "/flightsAdmin")
       public String flightsAdmin(Model model){
           List<Vol> vols=volRepository.findAll();
           model.addAttribute("flights",vols);
           return "flightsAdmin";
       }
       
     
        @PostMapping("/addFlightAdmin")
       public String addFlight(@ModelAttribute Vol vol) {
           volService.addNewVol(vol);
           return "redirect:/pages/table-elements";
       }
       
        @GetMapping("/deleteFlight/{idVol}")
        public String deleteFlight(@PathVariable Long idVol) {
            volService.removeVol(idVol);
            return "redirect:/pages/table-elements";
        }
            @GetMapping("/showUpdateFlight/{idVol}")
       public String showUpdateForm(@PathVariable Long idVol, Model model ,ModelMap modelMap) {
           Vol vol = volService.getVolById(idVol).orElse(null);
           model.addAttribute("flight",vol);
           modelMap.addAttribute("flights",volService.listVol());
           List<Ville> villes = villeService.listVille();
           model.addAttribute("villes" , villes);
           modelMap.addAttribute("display","block");
           return "/pages/table-elements";
       }
          @RequestMapping("/updateFlight")
          private String updateFlight( Long idVol, @ModelAttribute Vol vol,ModelMap modelMap)
          {
       	   volService.updateVol(idVol,vol);
       	   modelMap.addAttribute("display","none");
       	   return  "redirect:/pages/table-elements";
       	   
          }
}
