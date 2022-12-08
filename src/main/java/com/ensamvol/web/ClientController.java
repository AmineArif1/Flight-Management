package com.ensamvol.web;

import com.ensamvol.entities.Client;
import com.ensamvol.repositories.AppRoleRepository;
import com.ensamvol.repositories.AppUserRepository;
import com.ensamvol.repositories.ClientRepository;
import com.ensamvol.service.ClientService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@PostAuthorize("hasAuthority('ADMIN')")

public class ClientController {

    private ClientService clientService;
    private AppRoleRepository appRoleRepository;
    private AppUserRepository appUserRepository;
    private ClientRepository clientRepository;

    public ClientController(ClientService clientService, AppRoleRepository appRoleRepository, AppUserRepository appUserRepository, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.appRoleRepository = appRoleRepository;
        this.appUserRepository = appUserRepository;
        this.clientRepository = clientRepository;
    }
    @GetMapping("/clients")
    public String appUsers(Model model){
        model.addAttribute("listClients",clientService.listClient());
        return "clients";
    }


    @PostMapping("/clientDelete")
    public String removeUSer(@RequestParam("numPassport") String numPassport,Model model) {

        clientService.removeClient(numPassport);
        model.addAttribute("listClients", clientService.listClient());

        return "clients";
    }
    @PostMapping("/editClient")
    public String editUser(@RequestParam("numPassport") String numPassport,Model model) {

        model.addAttribute("AppClient", clientService.findByNumPassport(numPassport));
        return "editClients";
    }
    @PostMapping("/succesfulEditClient")
    public String SuccesfullEdit(@ModelAttribute("AppClient") Client client, Model model) {

        clientService.saveClient(client);
        model.addAttribute("listClients", clientService.listClient());
        return "clients";
    }
    @PostMapping("/addClient")
    public String addClient(@ModelAttribute("AppClient") Client client, Model model) {
        clientService.addNewClient(client);
        model.addAttribute("listClients", clientService.listClient());
        return "clients";
    }
}



