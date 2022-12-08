package com.ensamvol.web;
import com.ensamvol.entities.Role;
import com.ensamvol.entities.Personne;
import com.ensamvol.service.AccountService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@PostAuthorize("hasAuthority('ADMIN')")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/users")
    public String appUsers(Model model){
        model.addAttribute("listUsers",accountService.listUsers());
        return "users";
    }
    @GetMapping("/roles")
    public String roles(Model model){
        Role role = new Role();
        model.addAttribute("AppRole", role);
        model.addAttribute("listRoles",accountService.listRoles());
        return "roles";
    }
    @PostMapping("/addRole")
    public String addRole(@ModelAttribute("AppRole") Role role, Model model){
        accountService.addNewRole(role);
        model.addAttribute("listRoles",accountService.listRoles());
        return "roles";

    }

    @PostMapping("/userDelete")
    public String removeUSer(@RequestParam("username") String username,Model model){

        accountService.removeUser(username);
        model.addAttribute("listUsers",accountService.listUsers());

        return "users";


    }
    @PostMapping("/editUser")
    public String editUser(@RequestParam("id") String id,Model model){

        model.addAttribute("AppUser",accountService.OneUserById(id));
        return "editUsers";


    }
    @PostMapping("/succesfulEdit")
    public String SuccesfullEdit(@ModelAttribute("AppUser") Personne user, Model model){


        accountService.saveUser(user);;
        model.addAttribute("listUsers",accountService.listUsers());

        return "users";


    }
    @PostMapping("/addUser")
    public String addUser(Model model){
        Personne personne = new Personne();
        model.addAttribute("AppUser", personne);
        return "addUser";


    }
}
