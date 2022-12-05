package com.ensamvol.web;
import com.ensamvol.entities.AppRole;
import com.ensamvol.entities.AppUser;
import com.ensamvol.service.AccountService;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @GetMapping("/users")
    @PostAuthorize("hasAuthority('ADMIN')")
    public String appUsers(Model model){
        model.addAttribute("listUsers",accountService.listUsers());
        return "users";
    }
    @GetMapping("/roles")
    public String roles(Model model){
        AppRole appRole = new AppRole();
        model.addAttribute("AppRole",appRole);
        model.addAttribute("listRoles",accountService.listRoles());
        return "roles";
    }
    @PostMapping("/addRole")
    public String addRole(@ModelAttribute("AppRole") AppRole role,Model model){
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
    public String SuccesfullEdit(@ModelAttribute("AppUser") AppUser user,Model model){


        accountService.saveUser(user);;
        model.addAttribute("listUsers",accountService.listUsers());

        return "users";


    }
    @PostMapping("/addUser")
    public String addUser(Model model){
        AppUser appUser = new AppUser();
        model.addAttribute("AppUser",appUser);
        return "addUser";


    }
}
